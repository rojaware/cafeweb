package com.rojaware.member.test;
import java.util.*;

import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

import com.rojaware.member.model.Member;

// deprecated
public class ExpiryMailSender
{

	private static   String host = "smtp.gmail.com";
	private static    String from = "leesungki@gmail.com";
	private static    String password = "22sungki";

   public int sendMail(List<Member> members) throws AddressException, MessagingException
   {
	   Properties props = System.getProperties();
	   props.put("mail.smtp.host", host);
	   props.put("mail.smtp.user", from);
	   props.put("mail.smtp.password", password);
	   props.put("mail.smtp.port", "465"); // 587 is the port number of yahoo mail
	   props.put("mail.smtp.auth", "true");

	   Session session = Session.getDefaultInstance(props, null);
	   MimeMessage message = new MimeMessage(session);
	   message.setFrom(new InternetAddress(from));

	   // extract email list from members
	   String[] to = extractEmailList (members);
	   
	   InternetAddress[] to_address = new InternetAddress[to.length];
	   int i = 0;
	   // To get the array of addresses
	   while (to[i] != null) {
	       to_address[i] = new InternetAddress(to[i]);
	       i++;
	   }
	   System.out.println(Message.RecipientType.TO);
	   i = 0;
	   while (to_address[i] != null) {

	       message.addRecipient(Message.RecipientType.TO, to_address[i]);
	       i++;
	   }
	   message.setSubject("sending in a group");
	   message.setText("Welcome to JavaMail");
	   // alternately, to send HTML mail:
	   // message.setContent("<p>Welcome to JavaMail</p>", "text/html");
	   Transport transport = session.getTransport("smtp");
	
	   
	   transport.connect(host, from, password);
	   transport.sendMessage(message, message.getAllRecipients());
	   transport.close();
	   return 0; // sucess
}

private String[] extractEmailList(List<Member> members) {
	
	 ArrayList<String> emailStringArray = new ArrayList<String>();
     
	Iterator iter = members.iterator();
	while (iter.hasNext())
	{
		Member member = (Member)iter.next();
		String email = member.getEmail();
		emailStringArray.add(email);
		System.out.println("******* current email is "+email);
	}
	// add scott lee for verification
	emailStringArray.add(from);
	
	return (String[]) emailStringArray.toArray();
}
}