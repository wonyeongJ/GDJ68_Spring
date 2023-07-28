<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/bootStrap.jsp"></c:import>
</head>
<body>
	<c:import url="../temp/header.jsp"></c:import>
	
	<section class="container mt-5">
		<h1 class="mb-3 text-center">UPDATE Page</h1>
		<table class="table table-success table-sm">
			<link
				href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
				rel="stylesheet">	
			<tbody>
				<form action="./update" method="post">
					<span style="margin: 0px 54px 0 0;">no : </span>
					<input type="text" id="boardNo" name="boardNo" value="${requestScope.dto.boardNo}" readonly>
					<br>
					<span style="margin: 0 22px 0 0;">subject : </span>
					<input type="text" id="subject" name="subject" value="${requestScope.dto.subject}">
					<br>
					<br>
					<span>contents : </span>
					<textarea id="contents" name="contents">${requestScope.dto.contents}</textarea>
					<br>
					<span style="margin: 0 20px 0 0;">writer : </span>
					<input type="text" id="name" name="name" value="${requestScope.dto.name}" readonly>
					<br>
					<span style="margin: 0 28px 0 0;">date : </span>
					<input type="text" id="boardDate" name="boardDate" value="${requestScope.dto.boardDate}" readonly>
					<br>
					<span style="margin: 0 41px 0 0;">hit : </span>
					<input type="text" id="hit" name="hit" value="${requestScope.dto.hit}" readonly>
					<br>
					<br>
					<br>
					<button type="submit">수정</button>&nbsp;&nbsp;&nbsp;&nbsp;
					<button type="reset">다시입력</button>
				</form>
			</tbody>
		</table>
	</section>
</body>
</html>