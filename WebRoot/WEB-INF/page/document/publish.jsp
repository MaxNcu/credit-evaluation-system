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
    
</head>
  <body>
 
    <!-- <form action="PublishAction_p.action" method="post" class="form-control">
     <table cellspacing="1"  class="table table-striped table-hover">
      <tr>
      	<td>��Ϣ����: </td>
      	<td><input type="text" name="publish.title"/></td>
      </tr>
      <tr>
      	<td>���ͣ�</td>
      	<td><select class="form-control" style="display: inline; width: 200px" name="publish.type">
			<option value ="��������">��������</option> 
			<option value ="��Ӫ����">��Ӫ����</option>	
			<option value ="������������">������������</option>	
			<option value ="�������">�������</option>	
			<option value ="��������">��������</option>	
					
		</select></td>
		</tr>
		<tr>
      	<td>��Ϣ����</td>
      	<td><textarea name="publish.context"  cols="100" rows="10"></textarea></td>
      	</tr>
      	<tr><td></td>
      	<td><input type="submit" value="����" class="btn btn-primary" style="margin-top: 8px"/></td>
      	</tr>
      	</table>
     </form> -->
     <body>
    <form action="PublishAction_p.action" method="post" class="form-horizontal">
    	 
    	<div class="form-group">
    		<label class="col-sm-2 control-label"  >��Ϣ����</label>
    		<div class="col-sm-10">
    			<input type="text" name="publish.title" class="form-control" placeholder="�������������"/>
    		</div>
    	</div>
      	<div class="form-group">
    		<label class="col-sm-2 control-label"  >��         ��</label>
    		<div class="col-sm-10">
    			<select name="publish.type"  class="form-control">
    				<option>��Ⱥ����</option>
    				<option>��������</option>
    				<option>��Ӫ����</option>
    				<option>������������</option>
    				<option>�������</option>
    				<option>��������</option>
    			</select>
    		</div>
    	</div>
    	<div class="form-group">
    		<label class="col-sm-2 control-label" >��Ϣ����</label>
    		<div class="col-sm-10">
    			<textarea name="publish.context" class="form-control" rows="3"  rows="10" placeholder="����������"></textarea>
    		</div>
    	</div>
    	<div class="form-group">
      		<div class="col-sm-offset-2 col-sm-10">
         		<button type="submit" class="btn btn-default" onclick="return check();">����</button>
      		</div>
   		</div>     	
    </form>
    <script type="text/javascript">
	    function check(){
	        if(confirm("��ȷ��������")){
	            return true;
	        }
	        return false;
	     }
	</script>
  </body>
    
  </body>
</html>
