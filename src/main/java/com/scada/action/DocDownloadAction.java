package com.scada.action;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
public class DocDownloadAction extends ActionSupport {
	private String downPath;//�����ļ����ļ�λ��
	private String fileName;  
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		 try {  
	            fileName = new String(fileName.getBytes("ISO-8859-1"),"UTF-8");  
	        } catch (UnsupportedEncodingException e) {  
	            e.printStackTrace();  
	        }  
	        //System.out.println("----"+fileName);  
	        this.fileName = fileName;  
	}
	public InputStream getInputStream() throws Exception{//����InputStream������
		System.out.println("�ļ���"+downPath);
		 String name=this.getDownloadFileName();
		//  String realPath=ServletActionContext.getServletContext().getRealPath("/uploadImages")+ "/"+name; ·������
		   String realPath="upload/"+name;
		   System.out.println("1:"+name);
		   InputStream in=ServletActionContext.getServletContext().getResourceAsStream(realPath);
		   System.out.println(in);
		   if(null==in){
		    System.out.println("Can not find a java.io.InputStream with the name [inputStream] in the invocation stack. Check the <param name=\"inputName\"> tag specified for this action.���action���ļ�����·���Ƿ���ȷ.");   
		   }
		return ServletActionContext.getServletContext().getResourceAsStream(realPath);
	}
	public String getDownPath() {
		return downPath;
	}
	public void setDownPath(String downPath) {
		this.downPath = downPath;
	}
	/** �ļ��� ת������ ��ֹ��������*/
	public String getDownloadFileName() {
	   String downFileName = downPath.substring(7);
	   System.out.println("�ļ���1:"+downFileName);
	   try {
	    //downFileName = new String(downFileName.getBytes(), "ISO8859-1");
		   downFileName = new String(downFileName.getBytes("ISO8859-1"), "utf-8");
	    System.out.println("�ļ���2:"+downFileName);
	   } catch (Exception e) {
	    e.printStackTrace();
	   }
	   return downFileName;

	
	}
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
}