package com.rojaware.members;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.rojaware.member.bo.CustomerHandler;
import com.rojaware.member.model.Member;
 
public class EmailTest {
 
	public static void main(String[] args) {
 
		final String username = "leesungki@gmail.com";
		final String password = "22sungki";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
 
		try {
            // 1. read email address from member object
			// 2. make long list
			// 3. build to address list
			List<String> longEmailList = new ArrayList<String>();
			
			CustomerHandler customerHandler = new CustomerHandler();
			List<Member> members = customerHandler.findExpiredMembers();
	
          
		    for(Iterator<Member> iter = members.iterator(); iter.hasNext();)
		    {  Member member = (Member)iter.next();
		       String email = member.getEmail().trim();
		      // replace space with comma
		       
		       if (email.indexOf(',') < 0 && email.indexOf(' ') > -1)
		       {
		    	    email = email.replace(' ', ',');
		       }
		       // if email has multiple entry, break down by comma.
		       if (email.contains(","))
		       {
		    	   List<String> emailList = StringUtil.seperateByDelimeter(email, ",");
		    	   Iterator<String> wordIter = emailList.iterator();
		    	   while (wordIter.hasNext())
		    	   {
		    		   email = (String) wordIter.next();
		    		   longEmailList.add(email);		    		  
		    	   }	    	   
		       }else
		       {
		    	   longEmailList.add(email);		          
		       }		       
		    }
		    // debug address list
		    int j = 0;
		    for (String s : longEmailList) 
		    { j++;
		    	System.out.println(j + "-" +s );
		    }
		    // build email list
		    InternetAddress recipientAddrs[] = new InternetAddress[longEmailList.size()];
		    int i = 0;
		    for (Iterator<String> it = longEmailList.iterator (); it.hasNext ();i++) {
		    	  String s = (String) it.next ();
		    	  recipientAddrs[i] = new InternetAddress(s.trim());
		    	  System.out.println ("add email "+s);
		    	}
		    
  		  
		    // build message
		    Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("leesungki@gmail.com"));
			
		    message.setRecipients(Message.RecipientType.CC, recipientAddrs);
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("leesungki@gmail.com"));
			message.setSubject("캐나다취업유학카폐 정회원기간이 만료되었습니다. ");
			message.setText("귀하의 정회원기간이 만료되었습니다. ,"
				+ "\n\n 제가입을 원하면, http://cafe.naver.com/rojaware/2 에 나온대로 회비를 입금하고 \n" +
				" leesungki@gmail.com 으로 메일을 보내주면 다시 등업해드리겠습니다. ");
 
			Transport.send(message);
 
			System.out.println("Done. Total "+ j +" addresses are sent");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}


