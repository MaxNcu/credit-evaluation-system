package com.scada.action;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionSupport;
import com.scada.domain.DocumentURL;
import com.scada.domain.User;
import com.scada.service.DocumentURLService;
public class DocListAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	private List<File> upload;//��װ�ϴ��ļ��������
	private List<String> uploadContentType;//��װ�ϴ��ļ�������
	private List<String> uploadFileName;//��װ�ϴ��ļ���
	private String savePath;//��װ�ϴ��ļ��ı���·�� 
	private Date createTime;//�ϴ�ʱ��
	private HttpServletRequest request =null;
	private HttpServletResponse response =null;
	private DocumentURLService duService;
	
	public DocumentURLService getDuService() {
		return duService;
	}
	public void setDuService(DocumentURLService duService) {
		this.duService = duService;
	}
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
	public void doubleselect(){
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		String t1 = "��Ⱥ����";
		List<String> stList1 = new ArrayList<String>();
		String st1 = "��Ⱥ�����ۺ�";
		String st2 = "�������ۺ�";
		String st3 = "��֯����";
		String st4 = "�ͼ칤��";
		String st5 = "������ͳս����";
		String st6 = "���Ṥ��";
		String st7 = "�����š����깤��";
		String st8 = "Э�ᡢѧ�Ṥ��";
		stList1.add(st1);
		stList1.add(st2);
		stList1.add(st3);
		stList1.add(st4);
		stList1.add(st5);
		stList1.add(st6);
		stList1.add(st7);
		stList1.add(st8);
		map.put(t1,stList1);
		
		String t2 = "��������";
		List<String> stList2 = new ArrayList<String>();
		String st9 = "���������ۺ�";
		String st10 = "��������";
		String st11 = "��װ����";
		String st12 = "���";
		String st13 = "ҽ������";
		String st14 = "���ڸ���";
		String st15 = "���¹���";	
		stList2.add(st9);
		stList2.add(st10);
		stList2.add(st11);
		stList2.add(st12);
		stList2.add(st13);
		stList2.add(st14);
		stList2.add(st15);		
		map.put(t2,stList2);
		
		String t3 = "��Ӫ����";
		List<String> stList3 = new ArrayList<String>();
		String st16 = "��Ӫ�����ۺ�";
		String st17 = "�ƻ�ͳ��";
		String st18 = "���ʹ���";
		String st19 = "�õ硢����Ӫҵ";
		String st20 = "ũ�������ũ�����";
		String st21 = "��Ʒ����";
		String st22 = "���־�Ӫ";	
		stList3.add(st16);
		stList3.add(st17);
		stList3.add(st18);
		stList3.add(st19);
		stList3.add(st20);
		stList3.add(st21);
		stList3.add(st22);		
		map.put(t3,stList3);		
		
		List<String> stList4 = new ArrayList<String>();
		stList4.add("�������������ۺ�");
		stList4.add("�滮����������");
		stList4.add("��������");
		stList4.add("ʩ������");
		stList4.add("��ȫ����");
		stList4.add("�Ƽ�����");
		stList4.add("��������");
		stList4.add("��׼����");
		stList4.add("��Ϣ����");		
		map.put("������������",stList4);
		
		List<String> stList5 = new ArrayList<String>();
		stList5.add("��������ۺ�");
		stList5.add("�������");
		stList5.add("�������");
		stList5.add("��ƹ���");
		map.put("�������",stList5);
		
		List<String> stList6 = new ArrayList<String>();
		stList6.add("���������ۺ�");
		stList6.add("����������");
		stList6.add("���¹���");
		stList6.add("�Ͷ�����");
		stList6.add("���ʹ���");
		stList6.add("������ѵ");	
		map.put("��������",stList6);
		request.setAttribute("map", map); 		
		
		
	}
	public String show(){		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DocumentURLService documentURLService = (DocumentURLService) context.getBean("documentURLService");
		request.setAttribute("documents", documentURLService.getAll());
		doubleselect();
		return "show";
	}
	public String delete(){		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DocumentURLService documentURLService = (DocumentURLService) context.getBean("documentURLService");
		int id = Integer.parseInt(request.getParameter("id"));
		//System.out.println(id);
		documentURLService.delInfoById(id);//ִ��ɾ������
		show();
		
		return "delete";
	}
	public String save() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		DocumentURLService documentURLService = (DocumentURLService) context.getBean("documentURLService");
		for (int i = 0; i < upload.size(); i++) {
			DocumentURL documentURL = new DocumentURL();
			//���ݷ��������ļ������ַ��Դ�ļ�������Ŀ¼�ļ�ȫ·��
			String name = this.uploadFileName.get(i);
			String type = request.getParameter("type");
			String subtype = request.getParameter("subtype");
			String path=ServletActionContext.getServletContext().getRealPath(this.getSavePath())+"\\"+name;
			File target=new File(path);			//����Ŀ���ļ�����
		//	System.out.println("path:"+path+"/tname:"+name);
			documentURL.setDoc_url(path);
			documentURL.setDoc_name(name);
			User user = (User) request.getSession().getAttribute("global_user");
			documentURL.setDoc_author(user.getUsername());
			documentURL.setDoc_type(type);
			documentURL.setDoc_subtype(subtype);
			documentURLService.saveDocumentURL(documentURL);
			copy(this.upload.get(i), target);		//����copy()������ʵ���ļ���д��
		}
		show();
		return "show";
	}
	
	public List<File> getUpload() {
		return upload;
	}
	public void setUpload(List<File> upload) {
		this.upload = upload;
	}
	public List<String> getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(List<String> uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public List<String> getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getSavePath() {
		return savePath;
	}
	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}
	@Override
	public void setServletRequest(HttpServletRequest resquest) {
		// TODO Auto-generated method stub
		this.request = resquest;
	}
}
