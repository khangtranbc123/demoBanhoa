<%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>    
   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>xem chi tiet</title>
<link rel="stylesheet" href="/demo_web/css/bootstrap.min.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

</head>
<body>
	<div class="modal  position-static d-block" tabindex="-1" >
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header bg-light" >
	        <h5 class="modal-title" >${hoa.ten}</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body bg-light">
	        <p> Giá bán: ${hoa.gia}</p>
	        <p>Chủ đề: ${hoa.chuDeHoa.tenChuDeHoa}</p>
	        <p> Số bông: ${hoa.soBong}</p>
	        <p> Ngày hái: ${hoa.createDate}</p>
	        <p> Hạn sử dụng: ${hoa.hanSD}</p>
	        <p> Tồn kho ${hoa.soLuong}</p>
	        
	      </div>
	      <div class="modal-footer bg-light">
	      <c:if test="${hoa.trangThai!=1}">
					<p style="color: red;">Sản phẩm đã ngừng bán!</p> 
		  </c:if>
		  <c:if test="${hoa.trangThai==1}">
	        <a href="/shop/add/${hoa.id}" class="btn btn-info">add to cart </a>		  
		 </c:if>		
	        <a href="/shop" class="btn btn-danger">cancel</a>
	      </div>
	    </div>
	  </div>
	</div>
	
</body>
 <script src="/js/jquery.min.js"></script>
	<script src="/js/popper.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
</html>