package com.scada.action;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
public class DocArrayAction extends ActionSupport {
	private String name;//�ϴ���
	private File[] upload;//��װ�ϴ��ļ��������
	private String[] uploadContentType;//��װ�ϴ��ļ�������
	private String[] uploadFileName;//��װ�ϴ��ļ���
	private String savePath;//��װ�ϴ��ļ��ı���·�� 
	private Date createTime;//�ϴ�ʱ��
	
	
	public Date getCreateTime() {
		createTime=new Date();//ʵ��������
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * ��Դ�ļ����Ƴ�Ŀ���ļ�
	 * @param source	Դ�ļ�����
	 * @param target	Ŀ���ļ�����
	 */
	private static void copy(File source,File target){
		InputStream inputStream=null;						//����һ��������
		OutputStream outputStream=null;						//����һ�������
		try {
			inputStream=new BufferedInputStream(new FileInputStream(source)); //ʵ����������
			outputStream=new BufferedOutputStream(new FileOutputStream(target));//ʵ���������
			byte[] buffer=new byte[1024];			//�����ֽ�����buffer
			int length=0;									//������ʱ��������
			while ((length=inputStream.read(buffer))>0) {	//����ϴ����ļ��ֽ�������0
				outputStream.write(buffer,0,length);		//���������ֽ���ʽд��
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if (null!=inputStream) {
				try {
					inputStream.close();				//�ر�������
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			if (null!=outputStream) {
				try {
					outputStream.close();				//�ر������
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}
	public String execute() throws Exception {
		for (int i = 0; i < upload.length; i++) {
			//���ݷ��������ļ������ַ��Դ�ļ�������Ŀ¼�ļ�ȫ·��
			String path=ServletActionContext.getServletContext().getRealPath(this.getSavePath())+"\\"+
			this.uploadFileName[i];
			File target=new File(path);			//����Ŀ���ļ�����
			System.out.println("path:"+path+"/tname:"+name);
			copy(this.upload[i], target);		//����copy()������ʵ���ļ���д��
		}
		return SUCCESS;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public File[] getUpload() {
		return upload;
	}
	public void setUpload(File[] upload) {
		this.upload = upload;
	}
	public String[] getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String[] uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String[] getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String[] uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	
	

}