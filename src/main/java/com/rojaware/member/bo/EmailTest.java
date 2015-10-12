package com.rojaware.member.bo;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.rojaware.member.bo.CustomerHandler;
import com.rojaware.member.model.Member;
import com.rojaware.members.StringUtil;
 
public class EmailTest {
 
	final String username = "leesungki@gmail.com";
	final String password = "22sungki";


	public static void main(String[] args)  {
		EmailTest test = new EmailTest();
		try {
			test.sendMail();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int sendMail() throws MessagingException {
 
 
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
//	    Transport transport = session.getTransport("smtp");  
	    
		List<Member> members = null;
		
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("leesungki@gmail.com"));
			
			CustomerHandler customerHandler = new CustomerHandler();
			 members = customerHandler.findExpiredMembers();
			
    	    System.out.println(" forward direction using ListIterator");

		    InternetAddress recipientAddrs[] = new InternetAddress[members.size()];

            int i = 0;
		    for(Iterator<Member> iter = members.iterator(); iter.hasNext() ; i++)
		    {  Member member = (Member)iter.next();
		       String email = member.getEmail().trim();
		       // if email has multiple entry, break down by comma.
		       if (email.contains(","))
		       {
		    	   List<String> emailList = StringUtil.seperateByDelimeter(email, ",");
		    	   Iterator<String> wordIter = emailList.iterator();
		    	   while (wordIter.hasNext())
		    	   {
		    		   email = (String) wordIter.next();
		    		   recipientAddrs[i] = new InternetAddress(email);
		    		   i++;
		    	   }
		    	   
		       }else
		       {
		          recipientAddrs[i] = new InternetAddress(email);
		       }
		       System.out.println("add email " + email);
		    }
		    
		    message.setRecipients(Message.RecipientType.CC, recipientAddrs);
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("leesungki@gmail.com"));
			message.setSubject("캐나다취업유학카폐 정회원기간이 만료되었습니다. ");
			message.setText("귀하의 정회원기간이 만료되었습니다. ,"
				+ "\n\n 제가입을 원하면, http://cafe.naver.com/rojaware/2 에 나온대로 회비를 입금하고 \n" +
				" leesungki@gmail.com 으로 메일을 보내주면 다시 등업해드리겠습니다. ");
 
			Transport.send(message);
 
			System.out.println("Done");
 
		
		
		return members.size();
	}
}


