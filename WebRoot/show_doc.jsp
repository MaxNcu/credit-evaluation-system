<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 
<font style="font-size: 12px;color: red">�ϴ��ߣ�<s:property value="name"/></font>
<table cellpadding="0" cellspacing="0">
	<tr>
		<th>�ļ�����</th>
		<th>�ϴ�ʱ��</th>
	</tr>
	<s:iterator value="uploadFileName" status="st">
	<tr>
		<td><s:property value="uploadFileName[#st.getIndex()]"/></td>
		<td><s:date name="createTime" format="yyyy-MM-dd HH:mm:ss"/></td>
	</tr>
	</s:iterator>
</table>

</html>