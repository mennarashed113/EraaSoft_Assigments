<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #74ABE2, #5563DE);
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .form-container {
            max-width: 400px;
            width: 100%;
            background: #fff;
            padding: 30px 25px;
            border-radius: 12px;
            box-shadow: 0 6px 20px rgba(0, 0, 0, 0.15);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        input[type=text],
        input[type=password] {
            width: 100%;
            padding: 12px 14px;
            margin: 10px 0;
            border-radius: 6px;
            border: 1px solid #ccc;
            box-sizing: border-box;
            transition: 0.3s;
        }

        input[type=text]:focus,
        input[type=password]:focus {
            border-color: #5563DE;
            outline: none;
        }

        button,
        input[type=submit] {
            background-color: #5563DE;
            color: white;
            padding: 12px;
            margin-top: 10px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            width: 100%;
            font-size: 16px;
            transition: background-color 0.3s;
        }

        button:hover,
        input[type=submit]:hover {
            background-color: #3846b8;
        }

        a {
            display: block;
            margin-top: 15px;
            text-align: center;
            color: #5563DE;
            text-decoration: none;
            font-weight: bold;
            transition: 0.3s;
        }

        a:hover {
            color: #3846b8;
        }

        .error-message {
            color: #e74c3c;
            text-align: center;
            margin-top: 10px;
            font-size: 14px;
        }

        .logo {
            text-align: center;
            margin-bottom: 15px;
        }

        .logo img {
            width: 60px;
            height: 60px;
        }
    </style>
</head>
<body>
<div class="form-container">
    <div class="logo">
       
    </div>
    <h2>Login</h2>
    <form action="<%=request.getContextPath()%>/AuthController?action=login" method="post">
        <input type="text" name="username" placeholder="Enter Username" required>
        <input type="password" name="password" placeholder="Enter Password" required>
        <input type="submit" value="Login">
    </form>

    <p class="error-message">
        <%=request.getAttribute("error") != null ? request.getAttribute("error") : ""%>
    </p>

    <a href="<%=request.getContextPath()%>/AuthController?action=signupPage">Create an account</a>
</div>
</body>
</html>
