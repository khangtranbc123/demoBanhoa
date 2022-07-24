<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<meta charset="UTF-8">
<title>Giỏ hàng</title>
</head>
<body>


	<h2>Giỏ hàng của bạn</h2> 
    	<a href="/shop" class="btn btn-primary">back</a>
    	<a href="/shop/hoadon" class="btn btn-info">Xem hóa đơn</a> <hr>
    	
    		
    <c:if test="${!empty sessionScope.error }">
	<div class="alert  alert-danger">${sessionScope.error} </div>
	</c:if>
	<c:remove var="error" scope="session"/>
	
	<c:if test="${!empty sessionScope.message }">
		<div class="alert  alert-primary">${sessionScope.message} </div>
	</c:if>
	
	
	<c:remove var="message" scope="session"/>
    		<table class="table">
	            <thead>
	                <tr>
	                    <th>Tên sản phẩm</th>
	                    <th>Số lượng</th>
	                    <th>Giá</th>
	                    <th>Tổng tiền</th>
	                    <th>Tồn kho</th>
	                    <th>Thao tác</th>
	                </tr>
	            </thead>
	            <tbody>
	                <c:forEach items="${billHoas}" var="x">
	                	<form action="/shop/update" method="POST">
	                    <tr>
	                        <td>${x.hoa.ten}</td>
	                        <td>
	                        	<input type="hidden" name="hoaId" value="${x.hoaId}"> 
	                        	<input type="number" value="${x.soLuong}" name="soLuong" onblur="this.form.submit()">
	                        </td>
	                        <td>${x.hoa.gia} vnd</td>
	                        
	                        <td>
	                        	<input type="hidden" name="purchaedMoney" value="${x.hoa.gia * x.soLuong}">
	                       		 ${x.hoa.gia * x.soLuong} vnd
	                        </td>
	                        <td>${x.hoa.soLuong}</td>
	                        <td>
	                        	<a href="/shop/mua/${x.hoaId}" class="btn btn-warning">Đặt hàng</a>
	                            <a href="/shop/delete/${x.hoaId}" class="btn btn-primary">Xóa</a>
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