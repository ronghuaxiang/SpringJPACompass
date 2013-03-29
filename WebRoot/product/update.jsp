<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="logic" uri="http://jakarta.apache.org/struts/tags-logic" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>save product jsp page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="/sjc/css/styles.css"/>
  </head>
  
  <body>
    <html:form action="/productAction.do?method=update">
    	<html:hidden property="product.id"/>
    	产品名称:<html:text property="product.productname"></html:text><br>
    	产品价格:<html:text property="product.price"></html:text><br>
    	产品描述:<html:text property="product.descption"></html:text><br>
    	产品类别:<html:select property="product.category.id">
    		<html:optionsCollection name="categorys" label="categoryname" value="id"/>
    	</html:select>
    	<html:submit value="提交"></html:submit>
    </html:form>
  </body>
</html>
