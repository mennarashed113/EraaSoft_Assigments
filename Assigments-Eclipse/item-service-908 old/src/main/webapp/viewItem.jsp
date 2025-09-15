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
    <title>View Item</title>
    <style>
        body { font-family: Arial, sans-serif; background: #f4f6f9; padding: 20px; }
        .container { max-width: 500px; margin: auto; background: #fff; padding: 25px; border-radius: 12px; box-shadow: 0 4px 15px rgba(0,0,0,0.1); }
        h2 { text-align: center; color: #333; margin-bottom: 20px; }
        table { width: 100%; border-collapse: collapse; }
        th, td { padding: 12px; text-align: left; border-bottom: 1px solid #ddd; }
        .back-btn { display: inline-block; margin-top: 20px; padding: 10px 20px; border-radius: 8px; background-color: #007bff; color: white; text-decoration: none; font-weight: bold; }
        .back-btn:hover { background-color: #0056b3; }
    </style>
</head>
<body>
<div class="container">
    <h2>Item Details</h2>
    <% if (item != null) { %>
        <table>
            <tr>
                <th>ID:</th>
                <td><%= item.getId() %></td>
            </tr>
            <tr>
                <th>Name:</th>
                <td><%= item.getName() %></td>
            </tr>
            <tr>
                <th>Price:</th>
                <td><%= item.getPrice() %></td>
            </tr>
            <tr>
                <th>Total Number:</th>
                <td><%= item.getTotalNumber() %></td>
            </tr>
        </table>
    <% } else { %>
        <p style="text-align:center; color:red;">Item not found.</p>
    <% } %>
    <a class="back-btn" href="<%=request.getContextPath()%>/ItemController?action=getItems">Back to Items</a>
</div>
</body>
</html>
