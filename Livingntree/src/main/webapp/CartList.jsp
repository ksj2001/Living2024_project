<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="c" items="${cList}">
		${c.p_code }<br/>
		${c.p_code }<br/>
		${c.p_name }<br/>
		${c.p_mainimg }<br/>
		${c.p_price }<br/>
		${c.p_delivfee }<br/>
		${c.c_qty }<br/>
		${c.c_total }<br/>
		${c.m_id }<br/>
		<br/>
	</c:forEach>
	
</body>
</html>