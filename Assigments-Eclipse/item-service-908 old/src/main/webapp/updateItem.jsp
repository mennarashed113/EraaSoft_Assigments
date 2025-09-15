<%@ page import="com.item.model.Item" %>
<%@ page import="com.item.service.ItemService" %>
<%@ page import="com.item.service.impl.ItemServiceImpl" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String idStr = request.getParameter("id");
    Item item = null;
    if (idStr != null) {
        Long id = Long.parseLong(idStr);
        InitialContext ctx = new InitialContext();
        DataSource dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/item");
        ItemService itemService = new ItemServiceImpl(dataSource);
        item = itemService.loadItem(id);
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Item</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f6f9; padding: 20px; }
        .form-container { max-width: 500px; margin: auto; background: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 4px 10px rgba(0,0,0,0.1); }
        input[type=text], input[type=number] { width: 100%; padding: 10px; margin: 8px 0; border-radius: 4px; border: 1px solid #ccc; }
        button { background-color: #007bff; color: white; padding: 10px 20px; border: none; border-radius: 5px; cursor: pointer; }
        button:hover { background-color: #0056b3; }
        a { display: block; margin-top: 15px; text-align: center; color: #007bff; text-decoration: none; }
        a:hover { color: #0056b3; }
    </style>
</head>
<body>
<div class="form-container">
    <h2>Update Item</h2>
    <form action="<%=request.getContextPath()%>/ItemController?action=editItem" method="post">
        <input type="hidden" name="action" value="editItem">
        <input type="hidden" name="id" value="<%= item != null ? item.getId() : "" %>">

        Name:<br>
        <input type="text" name="name" value="<%= item != null ? item.getName() : "" %>" required><br>

        Price:<br>
        <input type="number" step="0.01" name="price" value="<%= item != null ? item.getPrice() : "" %>" required><br>

        Total Number:<br>
        <input type="number" name="totalNumber" value="<%= item != null ? item.getTotalNumber() : "" %>" required><br>

        <button type="submit">Update Item</button>
    </form>
    <a href="<%=request.getContextPath()%>/ItemController">Back to Items</a>
</div>
</body>
</html>
