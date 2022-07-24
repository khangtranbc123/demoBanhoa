<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Hóa đơn</title>
</head>
<body>
	<a href="/shop/cart" class="btn btn-primary">back</a> <hr>
	<table class="table">
	            <thead>
	                <tr>
	                	<th>Tên sản phẩm</th>
	                    <th>Số lượng</th>
	                  	<th>Tổng tiền</th>
	                  	<th>Ngày mua</th>
	                  	<th>Trạng thái</th>
	                  	<th>Thao tác</th>
	                </tr>
	            </thead>
	            <tbody>
	                <c:forEach items="${hd}" var="x">
	                	<form action="/shop/update" method="POST">
	                    <tr>
	                    	<td>${x.hoas.ten}</td>
	                    	<td>${x.purchasedQuantity}</td>	
	                    	<td>${x.hoas.gia * x.purchasedQuantity}</td>   
	                    	<td>${x.orders.createDate}</td>   
	                    	<td>
	                         <c:if test="${x.orders.role==1}">Đang xử lý</c:if>
	                         <c:if test="${x.orders.role==2}">Đã xác nhận</c:if>
	                         <c:if test="${x.orders.role==3}">Đã hủy</c:if>	                          
	                        </td> 
	                        <td>
	                        <%-- <c:if test="${sessionScope.user.role==1}">
	                			<a href="/hoa/edit?id=${hoa.id}" class="btn btn-info" style="width: 100px">Xác nhận đơn</a>	                   
	                        </c:if>	 --%>                          	                        
	                        <a href="/shop/delete?id=${x.orders.orderId}" class="btn btn-info" style="width: 100px">Hủy đơn</a>
	                        </td>             
	                    </tr>	                   	             
	                   </form>
	                </c:forEach>
	            </tbody>
        	</table>
    	
<script src="/js/jquery.min.js"></script>
<script src="/js/popper.min.js"></script>
<script src="/js/bootstrap.min.js"></script>        	
</body>
</html>