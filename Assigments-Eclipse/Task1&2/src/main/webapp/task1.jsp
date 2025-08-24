<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
int id =100;
String name ="john";

String result = concatenation(id,name);

out.println("<h2>Result is : "+result+"</h2>");

%>

<%!
 String concatenation(int id,String name){
	return "Id: "+id+",Name:"+name;
}
%>
</body>
</html>