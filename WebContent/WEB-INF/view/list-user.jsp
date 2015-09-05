<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*,com.iweb.entity.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>${msg}我是JSP[JSTL-EL-读取pageScope,request, session里存储的对象]</title>
<link rel="stylesheet" href="/onlinetest/css/table.css">
<script src="/onlinetest/js/jquery-1.3.2.min.js"></script>
<script src="/onlinetest/js/calendar.js"></script>
<script src="/onlinetest/js/list-user.js"></script>
<script>
	if('${sessionScope.msg}'){
		//alert('${fn:length(users)}');		
	}
</script>
</head>
<body>
	<!-- 这个普通用户是能看到的 -->
	<%-- 这个是普通用户看不到的 --%>
	<%--set是往pageContext对象中存储信息,生命周期在一个页面的{}内 --%>
	<c:set var="className" value="fail"/>
	<c:if test="${msg=='删除成功！'}">
	<c:set var="className" value="success"/>
	</c:if>
	
	<c:if test="${!empty msg}">
	<div id="msg" class="${className}">${msg}</div>
	</c:if>
	总共${fn:length(users)}位用户<hr/>
	<table >
		<tr>
			<td>ID</td>
			<td>登录名</td>
			<td>登录密码</td>
			<td>邮箱</td>
			<td>性别</td>
			<td>联系方式</td>
			<td>姓名</td>
			<td>其他</td>
		</tr>
		<c:forEach items="${users}" var="user">
		<tr>
			<td>${user.id}</td>
			<td>${user.loginname}</td>
			<td>${user.password}</td>
			<td>${user.email}</td>
			<td>${user.sex}</td>
			<td>${user.phone}</td>
			<td>${user.uname}</td>
			<td>
				<c:if test="${user.id != sessionScope.user.id and '1'==sessionScope.user.ulevel}">
				<a href="/onlinetest/user/remove.action?id=${user.id}">删除</a>
				</c:if>
			</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>