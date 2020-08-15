<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<title>LBJ CASE STUDY-2</title></head>
<style>


input[type=submit] {
    padding:5px 15px; 
    background:#ccc; 
    left:200px;
    border:0 none;
    cursor:pointer;
    -webkit-border-radius: 5px;
    border-radius: 5px; 
}</style>
<body>

<form action="/College/search" method="post" class="form-inline">
	
	<div class="form-group">
      <label >Student ID  </label>
      <input class="form-control" id="focusedInput" type="text" name="sid" size="20">
    </div>   
   </br></br></br>
   &nbsp; &nbsp;<input type="submit" value="search">
   
   </br></br> ${error } </form>
</body>
</html>