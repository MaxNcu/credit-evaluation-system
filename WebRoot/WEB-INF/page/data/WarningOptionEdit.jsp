<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
    <meta charset="utf-8" />
    <title>���ܲɼ�</title>
   	<link rel="stylesheet" type="text/css" href="Styles/bootstrap-new.min.css" />
  	<script type="text/javascript" src="Scripts/jquery-2.1.1.min.js"></script>
  	<script type="text/javascript" src="Scripts/bootstrap.min.js"></script>

</head>
  <body>
    <s:form action="WarningAction_update.action" method="post" cssClass="form-horizontal" onsubmit="return check();" role="form" value="#request.warning">
    	<s:hidden name = "warning.id" value = "%{#request.warning.id}" theme="simple"></s:hidden>
    	<s:hidden name = "warning.warning_time" value = "%{#request.warning.warning_time}" theme="simple"></s:hidden>
    	<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="ʱ��"></s:label>
    		<div class="col-sm-10">
    			<s:label name="warning.warning_time" cssClass="form-control"  theme="simple" value ="%{#request.warning.warning_time}" ></s:label>
    		</div>
    	</div>
    		<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="����"></s:label>
    		<div class="col-sm-10">
    			<s:select name="warning.warning_type" cssClass="form-control"  list="{'ң����澯','ң����澯','������澯'}" theme="simple"></s:select>
    		</div>
    	</div>
    	<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="������"></s:label>
    		<div class="col-sm-10">
    			<s:textfield name="warning.warning_subtype" cssClass="form-control"  theme="simple" value = "%{#request.warning.warning_subtype}" ></s:textfield>
      		</div>
    	</div>
    	<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="�澯�ȼ�"></s:label>
    		<div class="col-sm-10">
    			<s:select name="warning.warning_level"  cssClass="form-control" list="{'��Ҫ','��Ҫ','һ��'}" theme="simple">				
    			</s:select>
    		</div>
    	</div>
    	<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="��վ��"></s:label>
    		<div class="col-sm-10">
    			<s:select name="warning.station"  cssClass="form-control" list="{'���Գ�վ01','���Գ�վ02','���Գ�վ03','���Գ�վ04','���Գ�վ05','���Գ�վ06','���Գ�վ07','���Գ�վ08','���Գ�վ09','���Գ�վ10','���Գ�վ11','���Գ�վ12'}" theme="simple">				
    			</s:select>
    		</div>
    	</div>
    	<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="װ����"></s:label>
    		<div class="col-sm-10">
    			<s:textfield name="warning.device" cssClass="form-control"  theme="simple" value = "%{#request.warning.device}" ></s:textfield>
    			
    		</div>
    	</div>
    	<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="������"></s:label>
    		<div class="col-sm-10">
    			<s:textfield name="warning.warning_obj" cssClass="form-control"  theme="simple" value = "%{#request.warning.warning_obj}" ></s:textfield> 		
   		</div>
    	</div>
    	<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="�澯��Ϣ"></s:label>
    		<div class="col-sm-10">
    			<s:textfield name="warning.warning_info" cssClass="form-control"  theme="simple" value = "%{#request.warning.warning_info}" ></s:textfield> 	
    		</div>
    	</div>
    	<div class="form-group">
      		<div class="col-sm-offset-2 col-sm-10">
      			<s:submit cssClass="btn btn-default" value="�޸�" theme="simple"/>
      		</div>
   		</div>     	
      	
    </s:form>
     <script type="text/javascript">
	    function check(){
	        if(confirm("��ȷ���޸���")){
	            return true;
	        }
	        return false;
	     }
	</script>
  </body>
</html>
