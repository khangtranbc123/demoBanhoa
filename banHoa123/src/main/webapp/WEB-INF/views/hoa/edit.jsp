<%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns:th="http://www.springframework.org/schema/data/jaxb">

<head>
 <link rel="stylesheet" href="/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Update Hoa</title>
</head>
<body>

	<h2>Update Hoa</h2>
	<div class="container">
			<form:form method="POST"
		action="/hoa/save?id=${hoa.id }">
		<p> Ten hoa: <br>
			<input type="text" name="ten" value="${hoa.ten}"/> 
		</p>
		
		
		
		<p> Chủ đề hoa: <br>
			<select name="chuDeHoa">
				<c:forEach items="${chuDeHoa}" var="x">
					<option value="${x.id}">
					${x.tenChuDeHoa}
				</c:forEach>
			</select>
		</p>
		
		<p> Số bông: <br> 
			<input type="number" name="soBong" value="${hoa.soBong}"/> 
		</p>
		
		<p> Số lượng: <br>
			<input type="number" name="soLuong" value="${hoa.soLuong}"/> 
		</p>
		<p> Hạn sử dụng: <br>
			<input type="text" name="hanSD" value="${hoa.hanSD}"/> 
		</p>
		<p> Giá: <br>
			<input type="number" name="gia" value="${hoa.gia}"/> 
		</p>
		
		
		<input type="submit" value="Submit" class="btn btn-primary"/>
	</form:form>
	
	</div>
	

	 <script src="/js/jquery.min.js"></script>
	<script src="/js/popper.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
</body>
</html>