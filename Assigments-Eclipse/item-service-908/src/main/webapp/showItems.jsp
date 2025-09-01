<%@ page import="com.item.model.Item" %>
<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    // Redirect if JSP is accessed directly
    if (request.getAttribute("allItems") == null) {
        response.sendRedirect(request.getContextPath() + "/ItemController");
        return;
    }

    List<Item> items = (List<Item>) request.getAttribute("allItems");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Show Items</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
            margin: 0;
            padding: 20px;
        }
        .layer {
            max-width: 900px;
            margin: auto;
            background: #fff;
            padding: 25px;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        }
        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 25px;
        }
        thead {
            background-color: #007bff;
            color: #fff;
        }
        th, td {
            padding: 12px 15px;
            text-align: center;
            border: 1px solid #ddd;
        }
        tbody tr:nth-child(even) { background: #f9f9f9; }
        tbody tr:hover { background: #f1f1f1; }
        a {
            text-decoration: none;
            color: #007bff;
            font-weight: bold;
            margin: 0 8px;
            transition: 0.3s;
        }
        a:hover { color: #0056b3; }
        .f {
            display: block;
            margin: auto;
            padding: 12px 20px;
            border: none;
            border-radius: 8px;
            background: #218838; /* blue button */
            cursor: pointer;
            transition: 0.3s;
        }
       .f:hover {
    background-color: #0056b3; /* darker blue on hover */
}
        .f a {
            color: #0056b3;
            font-size: 16px;
            font-weight: bold;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="layer">
    <h1>Items</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>PRICE</th>
                <th>TOTAL_NUMBER</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
        <% if (items.isEmpty()) { %>
            <tr>
                <td colspan="5" style="text-align:center;">No items found.</td>
            </tr>
        <% } else { 
            for (Item item : items) { %>
            <tr>
                <td><%= item.getId() %></td>
                <td><%= item.getName() %></td>
                <td><%= item.getPrice() %></td>
                <td><%= item.getTotalNumber() %></td>
                <td>
                     <a href="<%=request.getContextPath()%>/viewItem.jsp?id=<%= item.getId() %>">Show</a>
                     
                    <a href="<%=request.getContextPath()%>/updateItem.jsp?id=<%= item.getId() %>">Update</a>
                    
                    <a href="<%=request.getContextPath()%>/ItemController?action=deleteItem&id=<%= item.getId() %>">Delete</a>
                </td>
            </tr>
        <% } } %>
        </tbody>
    </table>

    <button class="f" onclick="location.href='<%=request.getContextPath()%>/addItem.jsp'">Add Item</button>
    
</div>
</body>
</html>
