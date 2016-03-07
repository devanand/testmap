package com.mylocation;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class EmailServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("In this servlet");
		resp.setContentType("text/plain");
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		String message = req.getParameter("message");
		String from = req.getParameter("from");
		String subject = req.getParameter("subject");
		String name = req.getParameter("name");
		String msgBody = "from:" +from+"\n"+
						 "Name"+name+"\n"+
						 message;

		try {
		    Message msg = new MimeMessage(session);
		    msg.setFrom(new InternetAddress("anand.dev.1985@gmail.com"));
		    msg.addRecipient(Message.RecipientType.TO,
		     new InternetAddress("anand.dev.1985@gmail.com", "Mr. Dev"));
		    msg.setSubject(subject);
		    msg.setText(msgBody);
		    Transport.send(msg);
		    resp.setStatus(200);
			resp.getWriter().write("OK");
			System.out.println("After setting the values");
		} catch (AddressException e) {
			resp.setStatus(404);
			e.printStackTrace();
		} catch (MessagingException e) {
			resp.setStatus(404);
		    e.printStackTrace();
		}
		
	}
}
