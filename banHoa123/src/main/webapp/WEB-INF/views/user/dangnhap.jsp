<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>dang nhap</title>
<link rel="stylesheet" href="/css/bootstrap.min.css">

</head>
<body>
<hr> <hr> <hr>
 	<c:if test="${!empty sessionScope.error }">
	<div class="alert  alert-danger">${sessionScope.error} </div>
	</c:if>
	<c:remove var="error" scope="session"/>
	
	<h2 style="text-align: center;">Đăng nhập</h2>
		<div class="container"> 
			<div class="row">
				<div class="col-5">
				</div>
				<div class="col-3">
					
					<form:form method="Get" action="/user/kiemtra">
					
					<label>Email:</label> <br>
					<input type="text" value="khang@fpt.com" name="email"> <br> <br>
					<label>Password:</label> <br>
					<input type="password" name="passWord" value="123"> <br> <br> <br>
					<input type="submit" value="Login" class="btn btn-primary"/>
					</form:form>
				</div>
				<div class="col-4">
				</div>
			</div>
		</div>

	 <script src="/js/jquery.min.js"></script>
	<script src="/js/popper.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
</body>
</html>