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
		<h1 class="mb-3 text-center">Detail Page</h1>

		<!-- 표현식 -->
		<!-- Getter 이름 : 메서드에서 get을 제외하고 첫 번째 글자를 소문자로 바꾼 것 -->
		<!-- Setter 이름 : 메서드에서 set을 제외하고 첫 번째 글자를 소문자로 바꾼 것 -->
		<!-- requestScope 자동형변환(생략가능).dto.여기 들어가는 bookName는 원래 getBookName 이지만 위에로 인해  -->
		<table class="table table-success table-sm">
			<link
				href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
				rel="stylesheet">	
			<tbody>
				<span style="margin: 0px 42px 0 0;">no : </span>
				<input type="text" id="" name="" value="${requestScope.dto.boardNo}" readonly>
				<br>
				<span style="margin: 0 22px 0 0;">name : </span>
				<input type="text" id="" name="" value="${requestScope.dto.subject}" readonly>
				<br>
				<span>contents : </span>
				<input type="text" id="" name="" value="${requestScope.dto.contents}" readonly>
				<br>
				<span style="margin: 0 20px 0 0;">writer : </span>
				<input type="text" id="" name="" value="${requestScope.dto.name}" readonly>
				<br>
				<span style="margin: 0 28px 0 0;">date : </span>
				<input type="text" id="" name="" value="${requestScope.dto.boardDate}" readonly>
				<br>
				<span style="margin: 0 41px 0 0;">hit : </span>
				<input type="text" id="" name="" value="${requestScope.dto.hit}" readonly>
				<br>
				<br>
				<a href="./update?boardNo=${requestScope.dto.boardNo}">수정</a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="./delete?boardNo=${requestScope.dto.boardNo}">삭제</a>
			</tbody>
		</table>
	</section>

</body>
</html>