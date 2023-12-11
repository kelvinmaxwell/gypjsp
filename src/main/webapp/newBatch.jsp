<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New batch</title>
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
<form action="newBatch">
			<table border="1" cellpadding="5">
				<tr>
					<th>Batch Name: </th>
					<td align="center" colspan="3">
						<input type="text" name="name" size="45"  placeholder="morning batch" onfocus="this.value=''">
					</td>
				</tr>
				
				<tr>
					<td align="center" colspan="5">
						<input type="submit" value="save batch"/>
					</td>
				</tr>
			</table>
			<p><a href="list" target="_self">Return to Home</a></p>
		</form>
</body>
</html>