<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
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
<meta charset="UTF-8">
<title>Batch List</title>
</head>
<body>

 <table border="1" cellpadding="5">
            <caption><h2>List of Batches</h2></caption>
            <tr>
				
				<th>BatchId</th>
				<th>Name</th>
                <th>Edit</th>
                <th>Delete</th>
               

            </tr>
            <c:forEach var="batches" items="${listBatches}">
                <tr style="text-align:center">
                	
                     <td><c:out value="${batches.id}" /></td>
                    <td><c:out value="${batches.name}" /></td>
                    <td><a href="openeditBatch?id=${batches.id}&name=${batches.name}" target="_self"><input  type="button" value="Edit" /></a></td>
                    <td><a href="deleteBatch?id=${batches.id}" target="_self"><input  type="button" value="Delete" /></a></td>
                    
                </tr>
            </c:forEach>
        </table>




</body>
</html>