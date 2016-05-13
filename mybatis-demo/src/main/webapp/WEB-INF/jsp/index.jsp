<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mybatis demo</title>
<style>
table, tr, td { border:1px solid #aaa; }
</style>
</head>
<body>
<table>
  <thead>
    <tr><td>id</td><td>name</td><td>age</td></tr>
  </thead>
  <tbody>
    <c:forEach var="user" items="${users }">
      <tr><td>${user.id }</td><td>${user.name }</td><td>${user.age }</td></tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>