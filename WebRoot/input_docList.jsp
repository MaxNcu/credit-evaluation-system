<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

  <div id=sm style="margin-left: -650px;"><span>�ϴ��ĵ�</span></div>

  	<s:form action="docList" namespace="/" method="post" enctype="multipart/form-data">
  		<s:textfield name="name" label="����" size="20"/>
  		<s:file name="upload" label="ѡ���ĵ�" size="20"/>
  		<s:file name="upload" label="ѡ���ĵ�" size="20"/>
  		<s:file name="upload" label="ѡ���ĵ�" size="20"/>
  		<s:submit value="ȷ���ϴ�" align="center"/>
  	</s:form>

</body>
</html>