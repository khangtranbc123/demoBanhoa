<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>    
<html>
    <head>
    <!-- CSS only -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    	<link rel="stylesheet" href="/css/bootstrap.min.css">
        <title>Danh sách Hoa đang bán</title>
    </head>
    <body>
    
    <div class="container">
		<!-- Button trigger modal -->
		
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		 <form:form method="POST" action="/hoa/save">   	
	    		<h2>Thêm mới Hoa</h2>	
	    			
				<p> Ten hoa: <br> 
					<input type="text" name="ten"/> 
				</p>				
				<p>
					<input type="file" name="img">
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
					<input type="number" name="soBong"/> 
				</p>
				
				<p> Số lượng: <br>
					<input type="number" name="soLuong"/> 
				</p>
				<p> Hạn sử dụng: <br>
					<input type="text" name="hanSD"/> 
				</p>
				<p> Giá: <br>
					<input type="number" name="gia"/> 
				</p>	    	    
	       <input type="submit" value="Submit" class="btn btn-primary"/>
       </form:form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
		        
		      </div>
		    </div>
		  </div>
		</div>


    	   		

    <h2 style="text-align: center;" >Danh sách Hoa đang bán</h2> <br>
    <a href="/shop" class="btn btn-info"><--Về trang chủ</a> <br>
    
    <div class="row">
    	<div class="col-9">
		    <form action="/hoa/fin" class="float-start ">
				<div class="row">
					<div class="col-7">
						<label class="form-label fw-bold">Tìm hoa theo tên hoặc chủ đề</label>
						<input type="text" name="tenChuDeHoa" value="${keyWord}" class="form-control "  >
					</div>
					
					<div class="col-5 " >
						<div style="padding-top: 9px">
						
							<div class="row mt-4">
								<div class="col-6">
									<button type="submit"  class="btn btn-primary ps-2 pe-2 mx-auto" >Search</button>
								</div>
								
								<div class="col-6" >
									<a href="/hoa" class="btn btn-danger  ps-2 pe-2 mx-auto" >Reset</a>
								</div>
				
							</div>
						</div>
					</div>
				</div>
			</form>
    	</div>
    	<div class="col-3" style="padding-top: 30px">
		    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">
				  Thêm mới hoa
			</button>
    	</div>
    </div>
	 <br>
		   <table class="table">
            <thead>
                <tr>
                    
                    <th>Ten Hoa</th>
                    <th>Ảnh</th>
                    <th>Chủ đề</th>
                    <th>Số lượng bông</th>
                    <th>Tồn kho</th>
                    <th>Giá</th>
                    <th>Ngay sản xuất</th>
                    <th>Hạn sử dụng</th>
                    <th>Trạng thái</th>
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
	         				<td><fmt:formatDate pattern="dd-MM-yyyy" value="${hoa.createDate}"/></td>
	                        <td>${hoa.hanSD}</td>
	                        <td>
	                         <c:if test="${hoa.trangThai==1}">Đang bán</c:if>
	                          <c:if test="${hoa.trangThai!=1}">Ngừng bán</c:if>
	                        </td> 
	                        <td>
	                        	<a href="/hoa/edit?id=${hoa.id}" class="btn btn-info" style="width: 100px">Sửa</a>
	                        	<a href="/hoa/delete?id=${hoa.id}" class="btn btn-danger">Ngừng bán</a>
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
        	<c:if test="${page.getNumber() < page.getTotalPages()-1 }">
        		<a href="/hoa?pageNumber=${page.getNumber()+1}">Next</a>
        	</c:if>        	
        </p>
    
    </div>
 	<!-- JavaScript Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
     <script src="/js/jquery.min.js"></script>
	<script src="/js/popper.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
    </body>
</html>