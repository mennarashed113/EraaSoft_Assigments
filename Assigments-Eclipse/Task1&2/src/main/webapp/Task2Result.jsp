<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Result</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #eaf0f6;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .result-container {
            background: #fff;
            padding: 20px 30px;
            border-radius: 10px;
            box-shadow: 0px 4px 8px rgba(0,0,0,0.1);
            width: 400px;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #007BFF;
        }
        p {
            font-size: 16px;
            margin: 8px 0;
            color: #333;
        }
        b {
            color: #555;
        }
    </style>
</head>
<body>
    <div class="result-container">
        <h2>Form Submitted Data</h2>
<%
    String fullName = request.getParameter("fullName");
    String password = request.getParameter("password");
    String age = request.getParameter("age");
    String addressRadio = request.getParameter("addressRadio");
    String addressSelect = request.getParameter("addressSelect");
%>
        <p><b>Full Name:</b> <%= fullName %></p>
        <p><b>Password:</b> <%= password %></p>
        <p><b>Age:</b> <%= age %></p>
        <p><b>Address (Radio):</b> <%= addressRadio %></p>
        <p><b>Address (Select):</b> <%= addressSelect %></p>
    </div>
</body>
</html>
