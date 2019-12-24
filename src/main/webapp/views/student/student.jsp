<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Student page</title>
<style>
html div {
	margin: 0 auto;
	width: 1200px;
	position: relative;
}

#bgtop {
	background-image: url('template/images/sis_topbg.png');
	padding: 10px;
	width: 100vw;
	background-size: 100% 100%;
	width: 1200px;
	margin: 0 auto;
	position: relative;
}

html body {
	padding: 20px 0px 0px 0px;
	margin: 0 auto;
	font-size: 75%;
	font-family: Verdana, Tahoma, Arial, "Helvetica Neue", Helvetica,
		Sans-Serif;
	background-color: #526D9B;
}

.logout {
	position: absolute;
	right: 10px;
	top: 5px;
	color: white;
	font-size: 15px;
}

.logout:hover {
	color: red;
}

#nav {
	margin: 0 auto;
	width: 1200px;
	position: relative;
}

.footer {
	background-color: #7D8DA9;
	height: 100px;
	margin: 0 auto;
	width: 1200px;
	position: relative;
}

.nav-item {
	width: 600px;
}

.nav-link {
	text-align: center;
	font-size: 15px;
}

.navbar-nav>li {
	border-right: 1px solid #000;
}

.navbar-nav>li:last-child {
	border: none;
}

.main-content {
	height: 1200px;
	background-color: white;
}

.title {
	font-family: 'Segoe UI';
	font-size: 16px;
	font-weight: bold;
	color: #8c1515;
	vertical-align: middle;
	line-height: 2em;
	margin-left: 50px;
}

.main-title, .dob, .address {
	float: left;
	width: 290px;
	margin-top: 30px;
	margin-right: 20px;
}

.gpa {
	margin-top: 30px;
	width: 290px;
}

.main-info {
	font-size: 16px;
}

.wrapper {
	height: 80px;
}

.table {
	font-size: 13px;
	background-color: #fff;
}

td {
	overflow: hidden;
}

.table thead th {
	text-align: center;
	position: sticky;
	top: -1px;
	background-color: #D0D2CF;
	font-weight:light;
}

.main-table {
	width: 96%;
	margin: 0 18px;
	top: 60px;
	max-height: 500px;
	/* overflow-y: scroll; */
	font-size: 11px;
}
.title-table{
	display:flex;
}
.title-table>div{
	flex:1;
}
.gpa{
	margin-top:40px;
	font-size: 15px;
	margin-left: 600px;
}
</style>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" type="text/css"
	href="template/CSS/libraries/bootstrap.min.css">

<!-- jQuery library -->
<script src="template/JS/libraries/jquery-3.4.1.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="template/JS/libraries/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<div id="bgtop">
			<table width="100%">
				<tbody>
					<tr>
						<td align="left" valign="top">
							<div
								style="width: 80px; height: 120px; left: 40px; position: relative;"></div>
						</td>
						<td align="center" valign="middle" style="width: 600px"></td>
					</tr>
				</tbody>
			</table>
			<a href="/studentmanagement/thoat?action=logout&role=student" class="logout" type="button">Log out</a>
		</div>
		<div class="main-content">
			<div class="wrapper">
				<div class="main-title">
					<span class="title">THÔNG TIN CÁ NHÂN:</span>


				</div>
				<div class="main-info">
					<div class="dob">
						<span class="info"> <strong>Họ và tên: </strong>${student.name }
							<br> <br> <strong>Ngày sinh: </strong>${student.birthday}
						</span>
					</div>
					<div class="address">
						<span class="info"> <strong>Địa chỉ: </strong>${student.address }
							<br> <br> <strong>Khoa/viện: </strong>${student.faculty }
						</span>
					</div>
				</div>
			</div>
			<hr
				style="background-color: black; text-align: left; position: relative; top: 30px;"
				noshade="noshade">
			<div class="title-table">
				<div style="margin-top: 40px;">
					<span class="title">BẢNG ĐIỂM:</span>
				</div>
				<div class="gpa">
					<c:set var="total" value="${0}"/>
					<c:set var="sumCredit" value="${0}"/>
					<c:forEach var="grade" items="${grades}">
						<c:set var="total" value="${total + ((grade.grade1+grade.grade2)/2)*grade.credit}"/>
						<c:set var="sumCredit" value="${sumCredit + grade.credit}"/>
					</c:forEach>
					<fmt:formatNumber var="gpa" type="number" maxFractionDigits="2" minFractionDigits="2" value="${(total/sumCredit)*0.4}"/>
					<span class="info"><strong>GPA: </strong>${gpa}</span>
				</div>
			</div>

			<div class="main-table">
				<table
					class="table table table-hover table-bordered table-responsive-sm">
					<thead>
						<tr>
							<th fieldname="semester">Kỳ học</th>
							<th fieldname="courseID">Mã HP</th>
							<th fieldname="courseName">Tên HP</th>
							<th fieldname="credit">Số TC</th>
							<th fieldname="grade1">Điểm quá trình</th>
							<th fieldname="grade2">Điểm thi</th>
							<th fieldname="result">Kết quả</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="grade" items="${grades}">
							<tr>

								<th>${grade.semester}</th>
								<th>${grade.courseID}</th>
								<th>${grade.courseName}</th>
								<th>${grade.credit}</th>
								<th>${grade.grade1}</th>
								<th>${grade.grade2}</th>
								<th>${(grade.grade1+grade.grade2)/2}</th>

							</tr>
						</c:forEach>
					</tbody>

				</table>

			</div>

		</div>
</body>
</html>