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
    <s:form action="DeviceAction_update.action" method="post" cssClass="form-horizontal" onsubmit="return check();" role="form" value="#request.device">
    	<s:hidden name = "device.id" value = "%{#request.device.id}" theme="simple"></s:hidden>
    	<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="װ��ID"></s:label>
    		<div class="col-sm-10">
    			<s:textfield name="device.device_id" cssClass="form-control"  theme="simple" value = "%{#request.device.device_id}" ></s:textfield>
    		</div>
    	</div>
    		<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="װ������"></s:label>
    		<div class="col-sm-10">
    			<s:textfield name="device.device_name" cssClass="form-control"  theme="simple" value = "%{#request.device.device_name}" ></s:textfield>
    		</div>
    	</div>
    	<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="װ������"></s:label>
    		<div class="col-sm-10">
    			<s:select name="device.device_type"  cssClass="form-control" list="{'�Ǳ�','ͨ�Ź����','����װ��'}" theme="simple">				
    			</s:select>
    		</div>
    	</div>
    	<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="������վ"></s:label>
    		<div class="col-sm-10">
    			<s:select name="device.device_station"  cssClass="form-control" list="{'���Գ�վ01','���Գ�վ02','���Գ�վ03','���Գ�վ04','���Գ�վ05','���Գ�վ06','���Գ�վ07','���Գ�վ08','���Գ�վ09','���Գ�վ10','���Գ�վ11','���Գ�վ12'}" theme="simple">				
    			</s:select>
    		</div>
    	</div>
    	<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="��Լ����"></s:label>
    		<div class="col-sm-10">
    			<s:select name="device.device_ruletype"  cssClass="form-control" list="{'MODBUS','60870','61850','��������'}" theme="simple">				
    			</s:select>
    		</div>
    	</div>
    	<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="��Լѡ��"></s:label>
    		<div class="col-sm-10">
    			<s:select name="device.device_rulename"  cssClass="form-control" list="{'MODBUS(CRP_Modbus.dll)','101(CRP_101.dll)','103(CRP_103_Net.dll)','103(CRP_103_Net_NZ.dll)','104(CRP_104.dll)','CDT(CRP_CDT.dll)','MODBUS(CRP_Modbus_TR.dll)'}" theme="simple">				
    			</s:select>
    		</div>
    	</div>
    	<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="ͨ������"></s:label>
    		<div class="col-sm-10">
    			<s:select name="device.device_pipletype"  cssClass="form-control" list="{'����','����'}" theme="simple">				
    			</s:select>
    		</div>
    	</div>
    	<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="��ǰ״̬"></s:label>
    		<div class="col-sm-10">
    			<s:select name="device.device_state"  cssClass="form-control" list="{'Ͷ��','ά��','����'}" theme="simple">				
    			</s:select>
    		</div>
    	</div>
    	<div class="form-group">
    		<s:label cssClass="col-sm-2 control-label" theme="simple" value="��ѹ�ȼ�"></s:label>
    		<div class="col-sm-10">
    			<s:select name="device.device_elec"  cssClass="form-control" list="{'0.1ǧ��','0.23ǧ��','0.38ǧ��','3ǧ��','6ǧ��','10ǧ��','13.8ǧ��','15.75ǧ��','18ǧ��','20ǧ��','35ǧ��','63ǧ��','110ǧ��','154ǧ��','220ǧ��','330ǧ��','500ǧ��','1100ǧ��','ֱ��','ֱ��500'}" theme="simple">				
    			</s:select>
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
