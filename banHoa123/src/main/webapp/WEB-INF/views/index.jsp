<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>      
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
  <link rel="stylesheet" href="/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.1.3/assets/owl.carousel.min.css" />
  <!-- fonts style -->
  <link href="https://fonts.googleapis.com/css?family=Baloo+Chettan|Poppins:400,600,700&display=swap" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />
<title>Ban hoa 123</title>
</head>

<body>
	


	<div class="hero_area" style="background-image: url('/img/hero.png');" >
    <!-- header section strats -->
    <header class="header_section">
      <div class="container">
        <nav class="navbar navbar-expand-lg custom_nav-container ">
        	<a style="color: white;">
        		---
        	</a>
          <a class="navbar-brand" href="index.html">
            <span>
              BanHoa.pro
            </span>
          </a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <div class="d-flex mx-auto flex-column flex-lg-row align-items-center">
              <ul class="navbar-nav  ">
                <li class="nav-item active">
                  <a class="nav-link" href="/shop">Trang chủ<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/shop"> Giới thiệu</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/shop"> Sản phẩm </a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="/shop">Liên hệ</a>
                </li>
                <c:choose>
                <c:when test="${sessionScope.user.role==1}">
                	<li class="nav-item">
                  <a class="nav-link" href="/hoa">Quản lý SP</a>
                  <a class="nav-link" href="/shop/qlhoadon">Quản Lý Đơn hàng</a>
                </c:when>                                                 
                <c:otherwise></c:otherwise>                              
                </c:choose>           
              </ul>
            </div>
                       	 
            
            <div class="quote_btn-container ">
             <c:if test="${empty sessionScope.user }">
				<a href="/user/dangnhap">
                Đăng nhập
              	</a>
			 </c:if>
              <c:if test="${!empty sessionScope.user }">
			 	<a href="/user/out">Đăng xuất</a>
			 </c:if>
              <form class="form-inline">
                <button class="btn  my-2 my-sm-0 nav_search-btn" type="submit"></button>
              </form>
            </div>
          </div>
        </nav>
        <nav class="navbar bg-light fixed-top" style="width: 60px" >
		  <div>		  
		    <a href="/shop/cart" style="margin-right: 0px; float: left; color: black;">
              <b>cart</b> <img src="img/giohang.jpg" width="30px" >
            </a>		    		   
		  </div>
		</nav>
        
      </div>
    </header>
    <!-- end header section -->
    <!-- slider section -->
    <section class=" slider_section position-relative">
      <div class="container">
        <div class="row">
          <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
              <div class="carousel-item active">
                <div class="col-lg-6 col-md-8">
                  <div class="detail_box">
                    <h2>
                      Welcome
                    </h2>
                    <h1>
                      Bán Hoa Shop
                    </h1>
                    <p>
                      Shop bán hoa 123 với những bông hoa đẹp nhất sẽ làm hài lòng bạn 
                      
                      với những đóa hoa đẹp nhất được nhập khẩu từ Hoa Kì và Pháp 
                    </p>
                    
                     <c:if test="${empty sessionScope.user }">
			 			<div>
                      <a href="/user/showdangky">Đăng ký</a>
                    </div>
			 		</c:if>
                    <c:if test="${!empty sessionScope.error }">
						<div class="alert  alert-danger">${sessionScope.error} </div>
					</c:if>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>


 
  <!-- noi dung -->

  <div class="container">
	  <div class="row">
	  	<jsp:include page="${view}"></jsp:include> 
	   </div> 					
  </div>

  


 

  <!-- map section -->

  <div class="map_section">
    <div class="map_container">
      <div class="map">
        <div id="googleMap"></div>
      </div>
    </div>
  </div>

  <!-- end map section -->

  <!-- info section -->
  <section class="info_section layout_padding">
    <div class="container">
      <div class="row">
        <div class="col-md-3">
          <div class="info_logo">
            <h5>
              Fior
            </h5>
            <p>
              There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration
            </p>
          </div>
        </div>
        <div class="col-md-3">
          <div class="info_links pl-lg-5">
            <h5>
              Useful Link
            </h5>
            <ul>
              <li class="active">
                <a href="index.html">
                  Home
                </a>
              </li>
              <li>
                <a href="about.html">
                  About
                </a>
              </li>
              <li>
                <a href="gallery.html">
                  Gallery
                </a>
              </li>
              <li>
                <a href="contact.html">
                  Contact Us
                </a>
              </li>
            </ul>
          </div>
        </div>
        <div class="col-md-3">
          <div class="info_insta">
            <h5>
              Instagram
            </h5>
            <div class="insta_container">
              <div>
                <a href="">
                  <div class="insta-box b-1">
                    <img src="img/insta-1.png" alt="">
                  </div>
                </a>
                <a href="">
                  <div class="insta-box b-2">
                    <img src="img/insta-2.png" alt="">
                  </div>
                </a>
              </div>
              <div>
                <a href="">
                  <div class="insta-box b-3">
                    <img src="img/insta-3.png" alt="">
                  </div>
                </a>
                <a href="">
                  <div class="insta-box b-4">
                    <img src="img/insta-4.png" alt="">
                  </div>
                </a>
              </div>
              <div>
                <a href="">
                  <div class="insta-box b-3">
                    <img src="img/insta-5.png" alt="">
                  </div>
                </a>
                <a href="">
                  <div class="insta-box b-4">
                    <img src="img/insta-6.png" alt="">
                  </div>
                </a>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="info_contact">
            <h5>
              Contact
            </h5>
            <div>
              <img src="img/location-white.png" alt="">
              <p>
                It is a long
                fact that a reader
              </p>
            </div>
            <div>
              <img src="img/telephone-white.png" alt="">
              <p>
                +01 1234567890
              </p>
            </div>
            <div>
              <img src="img/envelope-white.png" alt="">
              <p>
                demo@gmail.com
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>

  <!-- end info_section -->

  <!-- footer section -->
  <footer class="container-fluid footer_section">
    <p>
      &copy; <span id="displayYear"></span> All Rights Reserved By
      <a href="https://html.design/">Free Html Templates</a>
    </p>
  </footer>
  <!-- footer section -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
     <script src="/js/jquery.min.js"></script>
	<script src="/js/popper.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
  <!-- End Google Map -->
</body>
</html>

