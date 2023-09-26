package com.scada.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

public class SystemLog {

	public static String systemGlobalUser = "";
	
	public SystemLog(){}
	
	/**
	 * ����ϵͳ��־���� =
	 * @param username ������Ա
	 * @param object �漰����
	 * @param msg �漰�ĺ���
	 * @param isSuccessed �Ƿ�ɹ�
	 */
	public static void setSystemLog(String username,Object object,String msg){
		MDC.put("username", username);
		Logger.getLogger(object.getClass()).info(msg);
	}
	
	/**
	 * ʹ��spring��aop��Ϊϵͳ���������ӡ�ɾ���Լ����²��������־��¼
	 * @param joinPoint ���Ի�ñ����õķ�������Ϣ
	 */
	public void afterReturnLog(JoinPoint joinPoint){
		//���õķ�������
		String methodName = joinPoint.getSignature().getName();
		//���õ�������
		String className = joinPoint.getTarget().getClass().toString();
		setSystemLog(systemGlobalUser,this,"������"+className+"��"+methodName+"����");
	}
	
}
