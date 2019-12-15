<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Student page</title>
</head>
<body>
	<div class="main-content">
		<div class="content-title">
			<span>Thông tin sinh viên</span>
		</div>
		<div class="main-studentinfo">
			<div class="name">
				<span>Họ tên</span> <input fieldname='studentname'
					value="${student.name}" />
			</div>
			<div class="studentID">
				<span>MSSV</span> <input fieldname='studentID'
					value="${student.studentID}" />
			</div>
			<div class="address">
				<span>Địa chỉ</span> <input fieldname='address'
					value="${student.address}" />
			</div>
			<div class="birthday">
				<span>Địa chỉ</span> <input fieldname='birthday'
					value="${student.birthday}" />
			</div>
		</div>

	</div>



</body>
</html>