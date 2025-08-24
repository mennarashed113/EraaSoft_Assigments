<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .form-container {
            background: #fff;
            padding: 20px 30px;
            border-radius: 10px;
            box-shadow: 0px 4px 8px rgba(0,0,0,0.1);
            width: 350px;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }
        label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
            color: #444;
        }
        input[type="text"],
        input[type="password"],
        input[type="number"],
        select {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        .radio-group {
            margin-top: 5px;
        }
        input[type="radio"] {
            margin-right: 5px;
        }
        input[type="submit"] {
            width: 100%;
            margin-top: 20px;
            padding: 10px;
            background: #007BFF;
            color: white;
            font-weight: bold;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background: #0056b3;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>User Registration</h2>
        <form action="Task2Result.jsp" method="post">
            <label>Full Name:</label>
            <input type="text" name="fullName" required>

            <label>Password:</label>
            <input type="password" name="password" required>

            <label>Age:</label>
            <input type="number" name="age" required>

            <label>Address (Radio):</label>
            <div class="radio-group">
                <input type="radio" name="addressRadio" value="Cairo"> Cairo <br>
                <input type="radio" name="addressRadio" value="Alex"> Alex <br>
                <input type="radio" name="addressRadio" value="Menofia"> Menofia <br>
            </div>

            <label>Address (Select):</label>
            <select name="addressSelect">
                <option value="Cairo">Cairo</option>
                <option value="Alex">Alex</option>
                <option value="Menofia">Menofia</option>
            </select>

            <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>
