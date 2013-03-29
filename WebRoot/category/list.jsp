<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>商品类别查询页面</title>
<link rel="stylesheet" type="text/css" href="/sjc/css/styles.css"/>
</head>
<body>
<table width="100%" border="1" style="border-collapse: collapse;">
	<tr align="center">
		<th>编号</th>
		<th>商品类别</th>
		<th>操作</th>
	</tr>
	<c:forEach items="${categorys}" var="category">
		<tr align="center">
			<td><c:out value="${category.id}" escapeXml="false"></c:out></td>
			<td><c:out value="${category.categoryname}" escapeXml="false"></c:out></td>
			<td>
				<a href="/sjc/categoryAction.do?method=toupdate&category.id=${category.id}">修改</a>
				<a href="/sjc/categoryAction.do?method=delete&category.id=${category.id}">删除</a>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>