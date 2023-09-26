package com.scada.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.scada.utils.MailDBOperation;
import com.sun.mail.pop3.POP3Folder;
import com.sun.mail.pop3.POP3Store;

public class MaiLoginlAction extends ActionSupport implements
		ServletRequestAware, ServletResponseAware {

	private String username;
	private String password;
	private String host;

	private HttpServletRequest request = null;
	private HttpServletResponse response = null;

	public String execute() throws Exception {
		// ����
		//��׽��¼�쳣�������¼ʧ�ܣ����ص�¼ҳ��
		try {
			 connect();
		} catch (MessagingException e) {
			 this.addFieldError("loginError", "�û��������벻��ȷ����");
		 	return "login";
		}
		setBaseMessage();
		return super.execute();
	}

	public String show() {
		return "show";
	}

	// -------����Ļ�������------
	public static Folder folder = null;
	public static Folder sendFolder = null;
	public static Store store = null;
	public static Store sendStore = null;
	Message[] messages = null;
	Message[] sendMessages = null;
	List<Message> normalMail;
	List<Message> spam;
	List<Message> sendMail;

	// ��������
	public void connect() throws Exception {
		Properties props = new Properties();// ׼�����ӷ������ĻỰ��Ϣ
		/*-----------------�ɵ����ӷ�ʽ--------------------------------*/
		// props.setProperty("mail.store.protocol", "pop3"); // Э��
		// props.setProperty("mail.pop3.port", "110"); // �˿�
		// props.setProperty("mail.pop3.host", this.getHost()); // pop3������
		/*-----------------------------------------------------------*/
		/*------------------�µ����ӷ�ʽ---------------------------------*/
		props.put("mail.smtp.host", "localhost"); // smtp������
		props.put("mail.smtp.auth", "true"); // �Ƿ�smtp��֤
		props.put("mail.smtp.port", "25"); // ����smtp�˿�
		props.put("mail.transport.protocol", "smtp"); // ���ʼ�Э��
		props.put("mail.store.protocol", "pop3"); // ���ʼ�Э��
		props.put("mail.store.host", "localhost");
		/*-----------------------------------------------------------*/
		// ����Sessionʵ������
		Session session = Session.getInstance(props);
		store = session.getStore();
		//sendStore = session.getStore();
		store.connect("scada.com",username, password);
		//sendStore.connect("scada.com", username, password);
		//Folder[] folders = store.getDefaultFolder().list();
		// ����ռ���
		folder = store.getFolder("INBOX");
		// ��÷�����
		//sendFolder = store.getFolder("SENDED");
		/*
		 * Folder.READ_ONLY��ֻ��Ȩ�� Folder.READ_WRITE���ɶ���д�������޸��ʼ���״̬��
		 */
		folder.open(Folder.READ_WRITE); //���ռ���
		//sendFolder.open(POP3Folder.READ_WRITE);// ���ռ���
		// �õ��ռ����е������ʼ�,������
		messages = folder.getMessages();
		//sendMessages = sendFolder.getMessages();
	}

	// ����ʼ��Ļ�����Ϣ
	public void setBaseMessage() throws Exception {
		// ����ռ����е��ʼ�����
		request.setAttribute("allMailCount", folder.getMessageCount());
		// ����ʼ�����Ϣ
		request.setAttribute("mailMessages", messages);
		// request.setAttribute("sendMailMessages", sendMessages);
	}

	// �������ݱ�Ĳ�ѯ����
	ResultSet rs = null;

	public void identifyMailType() throws SQLException {
		rs = MailDBOperation.getAll();
		while (rs.next()) {
			if (rs.getString(5).equals(username + "@scada.com")) {
				// sendMail.add(rs);
			}
		}
		for (Message message : messages) {
			MimeMessage msg = (MimeMessage) message;
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	class UserAuthenticator extends Authenticator {
		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
	}

}
