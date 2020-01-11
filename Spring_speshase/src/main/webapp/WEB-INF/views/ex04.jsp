<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<!--  -->
<%
	out.println("<script>");
	out.println("alert('zzzzz')");
	out.println("</script>");
	 %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${msg}
</body>
</html>