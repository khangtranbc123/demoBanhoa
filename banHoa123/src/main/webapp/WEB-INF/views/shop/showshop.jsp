<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
        
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<link rel="stylesheet" href="/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 	<h2 style="text-align: center;">Danh sách Hoa đang bán</h2> 
	 	<a href="/shop/cart" class="btn btn-warning"> Kiểm tra giỏ hàng</a> <hr>
		        <table class="table">
            <thead>
                <tr>
                    <th>Ten Hoa</th>
                    <th>Hình ảnh</th> 
                    <th>Chủ đề</th>
                    <th>Số lượng bông</th>
                    <th>Tồn kho</th>
                    <th>Giá</th>
                    <th>Ngay sản xuất</th>
                    <th>Hạn sử dụng</th>
                    <th>Thao tác</th>
                </tr>
            </thead>
            <tbody>
            
                <c:forEach items="${page.getContent()}" var="hoa">
                    <tr>
                 
                        <td>${hoa.ten}</td>
                        <td><img src="/img/${hoa.img}" height="50px"></td>
      					<td>${hoa.chuDeHoa.tenChuDeHoa}</td>
                        <td>${hoa.soBong}</td>
                        <td>${hoa.soLuong}</td>
                        <td>${hoa.gia}</td>
         				<td>${hoa.createDate}</td>
                        <td>${hoa.hanSD}</td>
                        <td>
                        	<a href="/shop/add/${hoa.id}" class="btn btn-primary">Thêm vào giỏ hàng</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
            
        </table>
        <p>
        	<c:if test="${page.getNumber()>0}">
        		<a href="/hoa?pageNumber=${page.getNumber()-1}">Previous</a>
        	</c:if>
        	${page.getNumber()+1} / ${page.getTotalPages()}
        	<a href="/hoa?pageNumber=${page.getNumber()+1}">Next</a>
        </p>
    <script src="/js/jquery.min.js"></script>
	<script src="/js/popper.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
</body>
</html>