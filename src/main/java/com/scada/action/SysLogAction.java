package com.scada.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;
import com.scada.domain.SysLog;
import com.scada.service.SysConfigService;
import com.scada.service.SysLogService;

public class SysLogAction extends ActionSupport implements ServletRequestAware,ServletResponseAware {

	private SysLogService sysLogService;
	private SysConfigService sysConfigService;
	protected HttpServletRequest request =null;
	protected HttpServletResponse response =null;
	private String result;
	private Integer pageNo;//��ǰҳ��
	private Integer pageSize;//ҳ����Ϣ����
	private Integer pageWidth;//�ɼ���ҳ����
	private Integer pageTotal;//��ҳ��
	private Integer msgTotal;//����Ϣ��
	//��ӡ��ϵͳ����־��Ϣ
	public String show(){
//		List<SysLog> sysLogList = sysLogService.getAll();
		//�״ν���ҳ�棬pageno����Ĭ��ֵΪ1
		String a =request.getParameter("pageNo");
		if(request.getParameter("pageNo")==null){
			pageNo = 1;
		}else{
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}
		//����ñ����е��и���
		msgTotal = sysLogService.getAll().size();
		pageSize = sysConfigService.get(1).getPageSize();
		//������ҳ��
		pageTotal = msgTotal%pageSize==0 ? msgTotal/pageSize : msgTotal/pageSize + 1;
		//����ɼ���ҳ����
		pageWidth = pageTotal > sysConfigService.get(1).getPageWidth() ? sysConfigService.get(1).getPageWidth() : pageTotal;
		List<SysLog> sysLogList = sysLogService.findByPage(pageNo, pageSize);
		//ҳ��
		List<Integer> pagesWide = new ArrayList<>();
		for(int i=0,j=pageNo > pageWidth/2 ? (pageNo-pageWidth/2) +1:1;i<pageWidth;i++,j++){
			if(j>pageTotal)
				break;
			pagesWide.add(j);
		}
		if(pageNo+4>pageTotal){
			pagesWide.clear();
			for(int i=0,j=pageTotal-pageWidth+1;i<pageWidth;i++,j++){
				pagesWide.add(j);
			}
		}
		request.setAttribute("sysLogList", sysLogList);
		request.setAttribute("pageTotal", pageTotal);
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("pageWidth", pageWidth);
		request.setAttribute("pagesWide", pagesWide);
		return "show";
	}

	//ɾ��ָ������־��Ϣ
	public String delete(){
		Integer sysLogId = Integer.parseInt(request.getParameter("sysLogId"));
		sysLogService.delete(sysLogId);
		return "delete";
	}
	
	//ɾ��������־
	public String deleteAll(){
		sysLogService.deleteAll();
		return "deleteAll";
	}
	
	
	public String sysStart(){
		return "sysStart";
	}
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public SysLogService getSysLogService() {
		return sysLogService;
	}

	public void setSysLogService(SysLogService sysLogService) {
		this.sysLogService = sysLogService;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public SysConfigService getSysConfigService() {
		return sysConfigService;
	}

	public void setSysConfigService(SysConfigService sysConfigService) {
		this.sysConfigService = sysConfigService;
	}
	
}
