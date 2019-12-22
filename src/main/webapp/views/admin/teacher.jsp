<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Admin home</title>
<link rel="stylesheet" type="text/css"
	href="template/CSS/libraries/bootstrap.min.css">
<link rel="stylesheet" href="template/CSS/libraries/jquery-ui.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="template/JS/libraries/jquery-3.4.1.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->

<script src="template/JS/libraries/jquery-ui.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<!-- jQuery library -->
<!--<script src="jquery-ui-1.12.1.custom/jquery-ui.min"></script>
    <script src="jquery-ui-1.12.1.custom/external/jquery.js"></script>-->
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

html body {
	padding: 20px 0px 0px 0px;
	margin: 0 auto;
	font-size: 75%;
	font-family: Verdana, Tahoma, Arial, "Helvetica Neue", Helvetica,
		Sans-Serif;
	background-color: #526D9B;
}

#nav {
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

.main-table {
	width: 96%;
	top: 10px;
	max-height: 500px;
	/* overflow-y: scroll; */
	font-size: 11px;
}

.type-find {
	float: left;
	width: 500px;
	margin-top: 50px;
	margin-left: 50px;
}
/*
        .show {
            float: right;
            width: 300px;
            margin-top: 100px;
        }*/
.show {
	margin-left: 1000px;
	width: fit-content;
}

.button-link {
	margin-left: 1050px;
	width: fit-content;
}

.add-grade, .form-add, .form-add, .add, .add-table, .add-label1,
	.ui-dialog-titlebar, .ui-dialog {
	width: 600px;
}

.add-label1 span {
	position: relative;
	width: 100px;
	display: inline-block;
}

.btn-add {
	position: absolute;
	bottom: 20px;
	left: 200px;
	width: fit-content;
}

.btn-add>button {
	width: 60px;
}

.add {
	display: flex;
}

.add-label1 {
	width: 100%;
	margin-bottom: 20px;
}
</style>
</head>
<body>
	<div class="alert alert-success alert-add-success" role="alert" hidden>
		<strong>Chúc mừng !</strong> Bạn đã thêm thành công
	</div>
	<div class="alert alert-success alert-edit-success" role="alert" hidden>
		<strong>Chúc mừng !</strong> Bạn đã sửa thành công
	</div>
	<div class="alert alert-success alert-delete-success" role="alert"
		hidden>
		<strong>Chúc mừng !</strong> Bạn đã xóa thành công
	</div>
	<div class="alert alert-danger" role="alert" hidden>Lỗi không
		thêm được sinh viên!</div>
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
			<a href="#" class="logout" type="button">Log out</a>
		</div>
		<div id="nav">
			<nav class="navbar navbar-expand-sm"
				style="background-color: #D3E4A6;">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="#">Students</a>
					</li>

					<li class="nav-item"><a class="nav-link" href="#">Student
							Grade</a></li>
				</ul>
			</nav>
		</div>
		<div class="main-content">
			<div class="button-link">
				<button type="button" class="btn btn-danger" disabled>
					<i class="fa fa-trash"></i>
				</button>
				<button id="add-new-grade" type="button" class="btn btn-primary">
					<i class="fa fa-plus"></i>
				</button>
				<button type="button" class="btn btn-success" disabled>
					<i class="fa fa-pencil"></i>
				</button>
			</div>
			<div id="addgrade" hidden>
				<form class="form-add">

					<div class="add">
						<div class="add-label1">
							<span>Học kỳ</span> <input fieldname="semester" />
						</div>
						<div class="add-label1">
							<span>Mã môn học</span> <input fieldname="courseID" />
						</div>
					</div>
					<div class="add">
						<div class="add-label1">
							<span>MSSV</span> <input fieldname="studentID" />
						</div>

					</div>
					<div class="add">
						<div class="add-label1">
							<span>Điểm QT</span> <input fieldname="grade1" />
						</div>
						<div class="add-label1">
							<span>Điểm cuối kì</span> <input fieldname="grade2" />
						</div>
					</div>
				</form>
				<div class="btn-add">
					<button class="save">Lưu</button>
					<button class="cancel">Hủy</button>
				</div>
			</div>
			<div class="button-find">
				<div class="type-find">
					<div style="float: left; width: 200px;">
						<label for="sel1">Môn học:</label> <select class="form-control"
							id="course" name="sellist1">
							<option></option>
							<c:forEach var="course" items="${courses}">
								<option value="${course.courseID}">${course.courseName}</option>
							</c:forEach>
						</select>
					</div>
					<div style="float: right; width: 200px;">
						<label for="sel2">Học kì:</label> <select class="form-control"
							id="semester" name="sellist2">
							<c:forEach var="semester" items="${semesters}">
								<option value="${semester}">${semesters}</option>
							</c:forEach>
						</select>
					</div>

				</div>
				<div class="show">
					<button type="button" class="btn btn-primary show-list-grade"
						style="margin-top: 100px;">Hiện danh sách</button>
				</div>
			</div>
			<div class="main-table">
				<table
					class="table table table-hover table-bordered table-responsive-sm">
					<thead>
						<tr>
							<th fieldname="semester">Học kỳ</th>
							<th fieldname="studentID">MSSV</th>
							<th fieldname="studentName">Họ tên SV</th>
							<th fieldname="courseID">Mã HP</th>
							<th fieldname="courseName">Tên HP</th>
							<th fieldname="credit">Số TC</th>
							<th fieldname="grade1">Điểm QT</th>
							<th fieldname="grade2">Điểm thi</th>
							<th fieldname="result">Kết quả</th>
						</tr>
					</thead>
					<tbody id="mytable">
					</tbody>
				</table>

			</div>
		</div>
		<div id="addgrade" style="width: 700px;" hidden>
			<form class="form-add">

				<div class="add">
					<div class="add-label1">
						<span>Học kỳ</span> <input fieldname="semester" />
					</div>
					<div class="add-label1">
						<span>Mã môn học</span> <input fieldname="subjectid" />
					</div>
				</div>
				<div class="add">
					<div class="add-label1">
						<span>MSSV</span> <input fieldname="studentid" />
					</div>

				</div>
				<div class="add">
					<div class="add-label1">
						<span>Điểm QT</span> <input fieldname="grade1" />
					</div>
					<div class="add-label1">
						<span>Điểm cuối kì</span> <input fieldname="grade2" />
					</div>
				</div>
			</form>
			<div class="btn-add">
				<button class="save">Lưu</button>
				<button class="cancel">Hủy</button>
			</div>
		</div>

	</div>
	<script type="text/javascript" src="template/JS/Script/teacher.js">
		
	</script>
</body>
</html>