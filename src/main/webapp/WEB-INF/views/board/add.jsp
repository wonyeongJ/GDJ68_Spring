<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
		<h1 class="mb-3">Add Page</h1>
		
		<form class="col-md-4 ms-auto" action="./add" method="post">
			<div class="row g-3 align-items-center">
				<label for="subject" class="col-form-label">제목</label>
				<input type="text" class="form-control" id="subject"  name="subject"><br> <!-- 파라미터의 이름은 세터의 이름(set을 빼고 첫글자소문자) -->
			</div>
			
			<div class="row g-3 align-items-center">
				<label for="contents" class="col-form-label">내용</label>
				<input type="text" class="form-control" id="contents"  name="contents"><br> <!-- 파라미터의 이름은 세터의 이름(set을 빼고 첫글자소문자) -->
			</div>
			
			<div class="row g-3 align-items-center">
				<label for="name" class="col-form-label">작성자</label>
				<input type="text" class="form-control" id="name"  name="name"><br> <!-- 파라미터의 이름은 세터의 이름(set을 빼고 첫글자소문자) -->
			</div>
			
			<button type="submit" class="btn btn-success mt-5 me-3">등록</button>
			<button type="reset" class="btn btn-success mt-5">다시입력</button>
			
			
		</form>
	</section>
</body>
</html>