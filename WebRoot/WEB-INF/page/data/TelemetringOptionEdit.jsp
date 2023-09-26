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
    <s:form action="TelemetringAction_update.action" method="post" cssClass="form-horizontal" onsubmit="return check();" role="form" value="#request.telemetring">
    	<s:hidden name = "telemetring.id" value = "%{#request.telemetring.id}" theme="simple"></s:hidden>
    	<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="ң�����"></s:label>
    		<div class="col-sm-10">
    			<s:textfield name="telemetring.tele_code" cssClass="form-control"  theme="simple" value = "%{#request.telemetring.tele_code}" ></s:textfield>
    		</div>
    	</div>
    		<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="ң������"></s:label>
    		<div class="col-sm-10">
    			<s:textfield name="telemetring.tele_name" cssClass="form-control"  theme="simple" value = "%{#request.telemetring.tele_name}" ></s:textfield>
    		</div>
    	</div>
    	<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="������վ"></s:label>
    		<div class="col-sm-10">
    			<s:select name="telemetring.tele_station"  cssClass="form-control" list="{'���Գ�վ01','���Գ�վ02','���Գ�վ03','���Գ�վ04','���Գ�վ05','���Գ�վ06','���Գ�վ07','���Գ�վ08','���Գ�վ09','���Գ�վ10','���Գ�վ11','���Գ�վ12'}" theme="simple">				
    			</s:select>
    		</div>
    	</div>
    	<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="װ��"></s:label>
    		<div class="col-sm-10">
    			<s:textfield name="telemetring.tele_device" cssClass="form-control"  theme="simple" value = "%{#request.telemetring.tele_device}" ></s:textfield>
    		</div>   		
    	</div>
    	<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="ң������"></s:label>
    		<div class="col-sm-10">
    			<s:select name="telemetring.tele_type"  cssClass="form-control" list="{'A���ѹ','B���ѹ','C���ѹ','AB�ߵ�ѹ','BC�ߵ�ѹ','CA�ߵ�ѹ','A�����','B�����','C�����','�׶��й�','�׶��޹�','ĩ���й�','ĩ���޹�','�׶�A�����','�׶�B�����','�׶�C�����','ĩ��A�����',	'ĩ��B�����','ĩ��C�����','�߶��й�','�߶��޹�','�ж��й�','�ж��޹�','�Ͷ��й�','�Ͷ��޹�','�߶�A�����','�߶�B�����','�߶�C�����','�ж�A�����','�ж�B�����','�ж�C�����','�Ͷ�A�����','�Ͷ�B�����','�Ͷ�C�����','�й�����','�޹�����','�й�����','�޹�����','A���й�','B���й�','C���й�','A���޹�','B���޹�','C���޹�','����ֵ'}" theme="simple">				
    			</s:select>
    		</div>
    	</div>
    	<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="����ֵ"></s:label>
    		<div class="col-sm-10">
    			<s:textfield name="telemetring.tele_int" cssClass="form-control"  theme="simple" value = "%{#request.telemetring.tele_int}" ></s:textfield>
    		</div>
    		
    	</div>
    	<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="������"></s:label>
    	
    		<div class="col-sm-10">
    			<s:textfield name="telemetring.tele_float" cssClass="form-control"  theme="simple" value = "%{#request.telemetring.tele_float}" ></s:textfield>
    		</div>
    			
    	</div>
    	<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="״̬"></s:label>
    		<div class="col-sm-10">
    			<s:select name="telemetring.tele_state"  cssClass="form-control" list="{'����','�澯'}" theme="simple">				
    			</s:select>
    		</div>
    	</div>
    	<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="��ֵ"></s:label>
    		<div class="col-sm-10">
    			<s:textfield name="telemetring.tele_basicvalue" cssClass="form-control"  theme="simple" value = "%{#request.telemetring.tele_basicvalue}" ></s:textfield>
    		</div>
    	</div>
    	<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="ϵ��"></s:label>
    		<div class="col-sm-10">
    			<s:textfield name="telemetring.tele_factor" cssClass="form-control"  theme="simple" value = "%{#request.telemetring.tele_factor}" ></s:textfield>
    		</div>
    	</div>
    	<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="��ֵ"></s:label>
    		<div class="col-sm-10">
    			<s:textfield name="telemetring.tele_threshold" cssClass="form-control"  theme="simple" value = "%{#request.telemetring.tele_threshold}" ></s:textfield>
    		</div>
    	</div>
    	<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="����ֵ"></s:label>
    		<div class="col-sm-10">
    			<s:textfield name="telemetring.tele_deadvalue" cssClass="form-control"  theme="simple" value = "%{#request.telemetring.tele_deadvalue}" ></s:textfield>
    		</div>
    	</div>
    	<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="�˲�����"></s:label>
    		<div class="col-sm-10">
    			<s:textfield name="telemetring.tele_filtering" cssClass="form-control"  theme="simple" value = "%{#request.telemetring.tele_filtering}" ></s:textfield>
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
