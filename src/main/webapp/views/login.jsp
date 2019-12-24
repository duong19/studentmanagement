<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <style>
        .login-page {
            width: 800px;
            padding: 8% 0 0;
            margin: auto;
        }
        
        .form {
            font-family: "Roboto", sans-serif;
            position: relative;
            z-index: 1;
            background: #FFFFFF;
            max-width: 500px;
            margin: 0 auto 100px;
            padding: 45px;
            text-align: center;
            box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
        }
        
        .input1 {
            font-family: "Roboto", sans-serif;
            outline: 0;
            background: #f2f2f2;
            width: 100%;
            border: 0;
            margin: 0 0 15px;
            padding: 15px;
            font-size: 14px;
        }
        
        .form button {
            font-family: "Roboto", sans-serif;
            text-transform: uppercase;
            outline: 0;
            background: #4CAF50;
            width: 100%;
            border: 0;
            padding: 15px;
            color: #FFFFFF;
            font-size: 14px;
            -webkit-transition: all 0.3 ease;
            transition: all 0.3 ease;
            cursor: pointer;
        }
        
        body {
            background: #76b852;
            /* fallback for old browsers */
            background: -webkit-linear-gradient(right, #76b852, #8DC26F);
            background: -moz-linear-gradient(right, #76b852, #8DC26F);
            background: -o-linear-gradient(right, #76b852, #8DC26F);
            background: linear-gradient(to left, #76b852, #8DC26F);
            font-family: "Roboto", sans-serif;
            -webkit-font-smoothing: antialiased;
            -moz-osx-font-smoothing: grayscale;
        }
    </style>
</head>

<body>
    <div class="login-page">

        <div class="form">
            <h2 style="text-align: center;margin-bottom: 50px;">Student Grade Management</h2>
            <form class="login-form" action="/studentmanagement/dang-nhap?action=login" method="post">
                <div>
                    <input class="input1" type="text" placeholder="username" name="username" property="login" />
                    <input class="input1" placeholder="password"  name="password" property="login" type="password"/>
                    <input name="role" id="role" value="" type="hidden"/>
                </div>
                <div class="login-type">
                    <div class="form-check-inline">
                        <label class="form-check-label">
                      <input type="radio" class="form-check-input" name="type"
                      id="student" value="student">Student
                    </label>
                    </div>

                    <div class="form-check-inline">
                        <label class="form-check-label">
                      <input type="radio" class="form-check-input" name="type" id="teacher" value="teacher" /><label
                      for="teacher">Teacher
                    </label>
                    </div>
                </div>

                <button>login</button>
            </form>
        </div>
    </div>
    <script type="text/javascript">
		$('.login-type').change(function() {
			var s = $("input[name='type']:checked").val();
			$('input#role').val(s);
		});
	</script>
</body>