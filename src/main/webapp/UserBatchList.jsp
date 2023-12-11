<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Batch User List</title>
<style> p {
  font-size: 2rem;
  text-align: center;
  
}
 td,  th {
  border: 1px solid #ddd;
  padding: 8px;
}

 tr:nth-child(even){background-color: #f2f2f2;}

 tr:hover {background-color: #ddd;}

th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
  </style>
</head>
<body>

<p><a href="addUserBatch" target ="_self" >User Batches</a></p><br><br> 
 <table border="1" cellpadding="5">
            <caption><h2>List of Batches</h2></caption>
            <tr>
				
				<th>BatchUserId</th>
				<th>Email</th>
                <th>Batch Name</th>
                <th>Delete</th>
               

            </tr>
            <c:forEach var="batchesusers" items="${listBatchesUsers}">
                <tr style="text-align:center">
                	
                     <td><c:out value="${batchesusers.id}" /></td>
                    <td><c:out value="${batchesusers.userName}" /></td>
                    <td><c:out value="${batchesusers.batchName}" /></td>
                    <td><a href="deleteBatchUser?id=${batchesusers.id}" target="_self"><input  type="button" value="Delete" /></a></td>
                    
                </tr>
            </c:forEach>
        </table>

</body>
</html>