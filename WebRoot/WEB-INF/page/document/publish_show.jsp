<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="utf-8" />
    <title>���ܲɼ�</title>
   	<link rel="stylesheet" type="text/css" href="Styles/bootstrap-new.min.css" />
  	<script type="text/javascript" src="Scripts/jquery-2.1.1.min.js"></script>
  	<script type="text/javascript" src="Scripts/bootstrap.min.js"></script>
  	<style>
    	.tip {
    	  height: 0;
    	  margin: 0 8px;
     	  border: 4px solid transparent;
    	  border-left-color: #000;
    	  display: inline-block;
   	 	}
   	 	table{  
   			width:100px;  
    		table-layout:fixed;/* ֻ�ж����˱��Ĳ����㷨Ϊfixed������td�Ķ�����������á� */  
		}  
		td{  
    		width:100%;  
    		word-break:keep-all;/* ������ */  
    		white-space:nowrap;/* ������ */  
    		overflow:hidden;/* ���ݳ������ʱ���س������ֵ����� */  
    		text-overflow:ellipsis;/* ���������ı����ʱ��ʾʡ�Ա��(...) ������overflow:hidden;һ��ʹ��*/  
		}  
    </style>
</head>
  <body>
  <div class="content">
   <table width="1000" cellspacing="1"  class="table table-striped table-hover">
	<tr>
		<th>����</th>
		<th>ʱ��</th>
		<th>����</th>
		<th>���</th>
		<th>������</th>
		<th>��������</th>		
	</tr>
	 <s:iterator value="#request.Publishes">
	  		<tr>
              	
              	<td >${title}</td>
              	<td >${date}</td>
              	<td>${context}</td>
              	<td >${type}</td>
              	<td >${user}</td>
              	<td height="20"><div align="center">
            		<a href="PublishAction_edit.action?id=${id}"><img src="images/edt.gif" width="16" height="16" border="0"/>�༭</a> 
           			 &nbsp; &nbsp;
            		<a href="PublishAction_delete.action?id=${id}" onclick="return checkdel();"><img src="images/del.gif" width="16" height="16" border="0"/>ɾ��</a>
           		</div></td>
              </tr>
	</s:iterator>
</table>
 <script type="text/javascript">
    function checkdel(){
        if(confirm("��ȷ��ɾ����")){
            return true;
        }
        return false;
     }
</script>
<br>
<form action="PublishAction_publish.action" method="post">		
		<input type="submit" value="��������Ϣ" class="btn btn-default" />
</form>
</div>
  </body>
</html>