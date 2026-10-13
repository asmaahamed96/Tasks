<%@page import="com.servlet.model.Task1"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task 1</title>
</head>
<body>
<%

Task1 task1=new Task1();
task1.concatIdWithName(5, "Ahmed");
out.print("<h2>"+task1.concatIdWithName(5, "Ahmed") + "</h2>");

%>

</body>
</html>