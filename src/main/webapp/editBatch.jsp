<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%
    String id = (String) request.getAttribute("id");
    String name = (String) request.getAttribute("name");
%>
    

    <form action="editBatch" method="post">
      

        

        <label for="id">BatchId:</label>
        <input type="text" name="id" id="id"   value="<%= id %>" type="hidden" readonly/><br>
        
        
        
        
        
         <label for="batchname">Name:</label>
        <input type="text" name="batchname" id="batchname" value="<%= name %>" required/><br>
        

 
        
      

        <input type="submit" value="Submit Value">
    </form>
</body>
</html>