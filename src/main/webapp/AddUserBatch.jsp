<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
p {
  font-size: 2rem;
  text-align: center;
  
}
 td,  th {
  border: 1px solid #ddd;
  padding: 8px;
}
</style>
</head>
<body>
<form action="submitBatchUser" method="post">
    <!-- Select for listBatches -->
    <label for="batchSelect">Select Batch:</label>
    <select name="batchSelect" id="batchSelect">
        <c:forEach var="batch" items="${listBatches}">
            <option value="${batch.id}">${batch.name}</option>
        </c:forEach>
    </select>
    <br>

    <!-- Select for listUser -->
    <label for="userSelect">Select User:</label>
    <select name="userSelect" id="userSelect">
        <c:forEach var="user" items="${listUser}">
            <option value="${user.customerid}">${user.email}</option>
        </c:forEach>
    </select>
    <br>

    <!-- Add your submit button or other form elements here -->
    <input type="submit" value="Submit">
</form>
</body>
</html>