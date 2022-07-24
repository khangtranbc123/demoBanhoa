<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>	

	
 <h2> <strong style="text-align: center;">Danh sách hoa đang bán</strong></h2> 
		<br>
		<div class="col-9">
		    <form action="/hoa/finten" class="float-start ">
				<div class="row">
					<div class="col-7">
						<label class="form-label fw-bold">Tìm hoa theo tên</label>
						<input type="text" name="ten" value="${keyWord}" class="form-control "  >
					</div>
					
					<div class="col-5 " >
						<div style="padding-top: 9px">
						
							<div class="row mt-4">
								<div class="col-6">
									<button type="submit"  class="btn btn-primary ps-2 pe-2 mx-auto" >Search</button>
								</div>
								
								<div class="col-6" >
									<a href="/shop" class="btn btn-danger  ps-2 pe-2 mx-auto" >Reset</a>
								</div>
				
							</div>
						</div>
					</div>
				</div>
			</form>
    	</div>
    	
    	
		<c:forEach var="hoa" items="${page.getContent()}"  >			 				  		
			<div class="card" style="width: 18rem; margin: 40px;">
			  <img src="/img/${hoa.img}" class="card-img-top" alt="...">
			  <div class="card-body">
			    <h5 class="card-title">${hoa.ten}</h5>
			    <p class="card-text">
					Giá: ${hoa.gia } vnd				
				</p>
				<p class="card-text">	
			     	Tồn kho: ${hoa.soLuong } <br>
				</p>
				<c:if test="${hoa.trangThai!=1}">
					<p style="color: red;">Sản phẩm đã ngừng bán!</p> 
				</c:if>		                
				<c:if test="${hoa.trangThai==1}">
					<a href="/shop/add/${hoa.id}" class="btn btn-primary">Mua</a>				
				</c:if>				
				<a href="/shop/xem/${hoa.id}" class="btn btn-info">Xem chi tiết</a>
			  </div>
			</div>				 				  			
  	   </c:forEach> 
		 <p style="text-align: center;">
        	<c:if test="${page.getNumber()>0}">
        		<a href="/shop?pageNumber=${page.getNumber()-1}">Sau</a>
        	</c:if>
        	${page.getNumber()+1} / ${page.getTotalPages()}
        	<c:if test="${page.getNumber() < page.getTotalPages()-1 }">
        		<a href="/shop?pageNumber=${page.getNumber()+1}">Trước</a>
        	</c:if>
        	
        </p>
	
	
		
	
</body>
</html>