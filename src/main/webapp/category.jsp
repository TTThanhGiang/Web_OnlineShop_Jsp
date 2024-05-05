<%-- 
    Document   : category
    Created on : Apr 30, 2023, 8:27:05 AM
    Author     : MSII
--%>

<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="entity.*"%>
<%@page import="context.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	SQLSEVERDataAccess conn = new SQLSEVERDataAccess();
	String categoryID = (String) request.getAttribute("categoryID");
	if(categoryID == null) categoryID = "";
%>

<!DOCTYPE html>
<html>
    <head>
        <!-- Mobile Specific Meta -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Favicon-->
        <link rel="shortcut icon" href="img/fav.png">
        <!-- Author Meta -->
        <meta name="author" content="CodePixar">
        <!-- Meta Description -->
        <meta name="description" content="">
        <!-- Meta Keyword -->
        <meta name="keywords" content="">
        <!-- meta character set -->
        <meta charset="UTF-8">
        <!-- Site Title -->
        <title>Karma Shop</title>

        <!--
            CSS
            ============================================= -->
        <link rel="stylesheet" href="css/linearicons.css">
        <link rel="stylesheet" href="css/owl.carousel.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/themify-icons.css">
        <link rel="stylesheet" href="css/nice-select.css">
        <link rel="stylesheet" href="css/nouislider.min.css">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/main.css">
    </head>

    <body id="category">
         
        <!-- Start Header Area -->
        <header class="header_area sticky-header">
            <div class="main_menu">
                <nav class="navbar navbar-expand-lg navbar-light main_box">

                    <div class="container" >
                        <!-- Brand and toggle get grouped for better mobile display -->
                        <a class="navbar-brand logo_h" href='Home'><img src="img/logo.png" alt=""></a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <ul class="nav navbar-nav menu_nav ml-auto" >
                                <li class="nav-item"><a class="nav-link" href="Home">Home</a></li>
                                <li class="nav-item active submenu dropdown">
                                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                                       aria-expanded="false">Shop</a>
                                    <ul class="dropdown-menu">
                                        <li class="nav-item active"><a class="nav-link" href="category">Shop Category</a></li>
                                        <li class="nav-item"><a class="nav-link" href='cart.jsp'>Shopping Cart</a></li>
                                    </ul>
                                </li>
                                <li class="nav-item submenu dropdown">
                                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                                       aria-expanded="false">Blog</a>
                                    <ul class="dropdown-menu">
                                        <li class="nav-item"><a class="nav-link" href="#">Blog</a></li>
                                        <li class="nav-item"><a class="nav-link" href="#">Blog Details</a></li>
                                    </ul>
                                </li>
                                <li class="nav-item submenu dropdown">
                                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Pages</a>
                                    <ul class="dropdown-menu">

                                        <li class="nav-item"><a class="nav-link" href="#">Tracking</a></li>
                                        <li class="nav-item"><a class="nav-link" href='#'>Elements</a></li>
                                    </ul>
                                </li>
                                <li class="nav-item submenu dropdown" id="p-ul" onmouseover="check()"   >                                   
                                    <a class="nav-link dropdown-toggle" href="#" id="login-out"  >
                                        <%
                                            String user = (String) session.getAttribute("user");
                                            if (user == null ) {
                                                user = "Sign in";
                                            }
                                        %> 
                                        <%=user%>
                                    </a>
                                    <ul class="dropdown-menu" id="hide-ul"  >
                                        <li class="nav-item"  onclick="checksign()"><a href="SignOutController" class="nav-link" > 
                                                  Sign Out </a></li>
                                                  <li class="nav-item"><a class="nav-link" href="#" id="check-admin">Blog Details</a></li>
                                    </ul>
                                </li>
                                <li class="nav-item"><a class="nav-link" href='#'>Contact</a></li>
                            </ul>

                            <ul class="nav navbar-nav navbar-right">
                                <li class="nav-item"><a href="cart.jsp" class="cart"><span class="ti-bag"></span></a></li>
                                <li class="nav-item">
                                    <button class="search"><span class="lnr lnr-magnifier" id="search"></span></button>
                                </li>
                            </ul>
                        </div>

                    </div>

                </nav>
            </div>
            <div class="search_input" id="search_input_box">
                <div class="container">
                    <form class="d-flex justify-content-between">
                        <input type="text" class="form-control" id="search_input" placeholder="Search Here">
                        <button type="submit" class="btn"></button>
                        <span class="lnr lnr-cross" id="close_search" title="Close Search"></span>
                    </form>
                </div>
            </div>
        </header>
        <!-- End Header Area -->

        <!-- Start Banner Area -->
        <section class="banner-area organic-breadcrumb">
            <div class="container">
                <div class="breadcrumb-banner d-flex flex-wrap align-items-center justify-content-end">
                    <div class="col-first">
                        <h1>Shop Category page</h1>
                        <nav class="d-flex align-items-center">
                            <a href='Home'>Home<span class="lnr lnr-arrow-right"></span></a>
                            <a style="pointer-events: none">Shop<span class="lnr lnr-arrow-right"></span></a>
                            <a href='category'>Category</a>
                        </nav>
                    </div>
                </div>
            </div>
        </section>
        <!-- End Banner Area -->
        <div class="container">
            <div class="row">
                <div class="col-xl-3 col-lg-4 col-md-5">
                    <div class="sidebar-categories">
                        <div class="head">Browse Categories</div>
                        <ul class="main-categories">
                        <c:forEach items="${category_list}" var = "o" begin="0">
                            <li class="main-nav-list"><a href="category?categoryID=${o.id}&toview=1">
                            	<span class="lnr lnr-arrow-right"></span>${o.name}<span class="number">(${o.totalProduct})</span></a>
                            </li>
						</c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="col-xl-9 col-lg-8 col-md-7">
                    <!-- Start Filter Bar -->
                    <div class="filter-bar d-flex flex-wrap align-items-center">
                        <div style="height: 50px"></div>
                    </div>
                    <!-- End Filter Bar -->
                    <!-- Start Best Seller -->
                    <section class="lattest-product-area pb-40 category-list">
                        <div class="row">
                            <!-- single product -->
                            <c:forEach items="${product_list}" var = "p" begin="0">
                            <div class="col-lg-4 col-md-6">
                                <div class="single-product">
                                    <a href="DetailController?pid=${p.id}"><img class="img-fluid" src="img/product/${p.images}" alt=""></a>
                                    <div class="product-details">
                                        <h6>${p.name}</h6>
                                        <div class="price">
                                            <h6>$ ${p.price}</h6>
                                        </div>
                                        <div class="prd-bottom">

                                            <a href="AddCartController?ID=${p.id}&QUANTITY=1" class="social-info">
                                                <span class="ti-bag"></span>
                                                <p class="hover-text">add to bag</p>
                                            </a>
                                            <a href="" class="social-info">
                                                <span class="lnr lnr-heart"></span>
                                                <p class="hover-text">Wishlist</p>
                                            </a>
                                            <a href="" class="social-info">
                                                <span class="lnr lnr-sync"></span>
                                                <p class="hover-text">compare</p>
                                            </a>
                                            <a href="" class="social-info">
                                                <span class="lnr lnr-move"></span>
                                                <p class="hover-text">view more</p>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                           	</c:forEach>
                        </div>
                    </section>
                    <!-- End Best Seller -->
                    <!-- Start Filter Bar -->
                    <div class="filter-bar d-flex flex-wrap align-items-center">
                    	<div class="sorting mr-auto"></div>
                        <div class="pagination">
							<%
	                        	int totalPage = (int) request.getAttribute("total_page");
	                        	int currentPage = (int) request.getAttribute("page");
	                        	int prePage = 1, nextPage = totalPage;
	                        	if(currentPage != 1) prePage = currentPage - 1;
	                        	if(currentPage != totalPage) nextPage = currentPage + 1;
	                        %>
	                        <a href="category?page=<%=prePage%>&categoryID=<%=categoryID%>&toview=1" class="prev-arrow"><i class="fa fa-long-arrow-left" aria-hidden="true"></i></a>
	                        <%	
	                        	if(totalPage <= 5) {
	                        		for(int i = 1; i <= totalPage; i++) {
	                        %>
	                        			<a href="category?page=<%=i%>&categoryID=<%=categoryID%>&toview=1" class=<%=currentPage==i? "active" : ""%>><%=i%></a>
	                        <%
	                        		}
	                        	} else {
	                        		int page1 = 1, page2 = 2, page3 = 3;
		                        	if(currentPage > totalPage-2) {
		                        		page1 = totalPage - 2;
										page2 = totalPage - 1;
										page3 = totalPage;
		                        	} else if(currentPage > 2) {
		                        		page1 = currentPage - 1;
										page2 = currentPage;
										page3 = currentPage + 1;
		                        	}
	                       	%>
							<%		if(currentPage > 2) { %>		
										<a href="category?page=1&categoryID=<%=categoryID%>&toview=1">1</a>
							<%		} %>
                            <%		if(currentPage > 3) { %>		
                            			<a class="dot-dot" style="pointer-events: none"><i class="fa fa-ellipsis-h" aria-hidden="true"></i></a>
							<%		} %>
							
			                           	<a href="category?page=<%=page1%>&categoryID=<%=categoryID%>&toview=1" class=<%=currentPage==page1? "active" : ""%>><%=page1%></a>
			                            <a href="category?page=<%=page2%>&categoryID=<%=categoryID%>&toview=1" class=<%=currentPage==page2? "active" : ""%>><%=page2%></a>
			                            <a href="category?page=<%=page3%>&categoryID=<%=categoryID%>&toview=1" class=<%=currentPage==page3? "active" : ""%>><%=page3%></a>
                            
                            <%		if(currentPage < totalPage-2) { %>		
										<a class="dot-dot" style="pointer-events: none"><i class="fa fa-ellipsis-h" aria-hidden="true"></i></a>
							<%		} %>
                            <%		if(currentPage <= totalPage-2) { %>		
                            			<a href="category?page=<%=totalPage%>&categoryID=<%=categoryID%>&toview=1"><%=totalPage%></a>
							<%		}
                           		}
                           	%>
                           	<a href="category?page=<%=nextPage%>&categoryID=<%=categoryID%>&toview=1" class="next-arrow"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></a>
                        </div>
                    </div>
                    <!-- End Filter Bar -->
                </div>
            </div>
        </div>

        <!-- Start related-product Area -->
        <section style="height: 100px"></section>
        <!-- End related-product Area -->

        <!-- start footer Area -->
        <footer class="footer-area section_gap">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3  col-md-6 col-sm-6">
                        <div class="single-footer-widget">
                            <h6>About Us</h6>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore dolore
                                magna aliqua.
                            </p>
                        </div>
                    </div>
                    <div class="col-lg-4  col-md-6 col-sm-6">
                        <div class="single-footer-widget">
                            <h6>Newsletter</h6>
                            <p>Stay update with our latest</p>
                            <div class="" id="mc_embed_signup">

                                <form target="_blank" novalidate="true" action="https://spondonit.us12.list-manage.com/subscribe/post?u=1462626880ade1ac87bd9c93a&amp;id=92a4423d01"
                                      method="get" class="form-inline">

                                    <div class="d-flex flex-row">

                                        <input class="form-control" name="EMAIL" placeholder="Enter Email" onfocus="this.placeholder = ''" onblur="this.placeholder = 'Enter Email '"
                                               required="" type="email">


                                        <button class="click-btn btn btn-default"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></button>
                                        <div style="position: absolute; left: -5000px;">
                                            <input name="b_36c4fd991d266f23781ded980_aefe40901a" tabindex="-1" value="" type="text">
                                        </div>

                                        <!-- <div class="col-lg-4 col-md-4">
                                                                        <button class="bb-btn btn"><span class="lnr lnr-arrow-right"></span></button>
                                                                </div>  -->
                                    </div>
                                    <div class="info"></div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3  col-md-6 col-sm-6">
                        <div class="single-footer-widget mail-chimp">
                            <h6 class="mb-20">Instragram Feed</h6>
                            <ul class="instafeed d-flex flex-wrap">
                                <li><img src="img/i1.jpg" alt=""></li>
                                <li><img src="img/i2.jpg" alt=""></li>
                                <li><img src="img/i3.jpg" alt=""></li>
                                <li><img src="img/i4.jpg" alt=""></li>
                                <li><img src="img/i5.jpg" alt=""></li>
                                <li><img src="img/i6.jpg" alt=""></li>
                                <li><img src="img/i7.jpg" alt=""></li>
                                <li><img src="img/i8.jpg" alt=""></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-lg-2 col-md-6 col-sm-6">
                        <div class="single-footer-widget">
                            <h6>Follow Us</h6>
                            <p>Let us be social</p>
                            <div class="footer-social d-flex align-items-center">
                                <a href="#"><i class="fa fa-facebook"></i></a>
                                <a href="#"><i class="fa fa-twitter"></i></a>
                                <a href="#"><i class="fa fa-dribbble"></i></a>
                                <a href="#"><i class="fa fa-behance"></i></a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="footer-bottom d-flex justify-content-center align-items-center flex-wrap">
                    <p class="footer-text m-0"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </p>
                </div>
            </div>
        </footer>
        <!-- End footer Area -->
         
        <!-- Modal Quick Product View -->
        <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="container relative">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <div class="product-quick-view">
                        <div class="row align-items-center">
                            <div class="col-lg-6">
                                <div class="quick-view-carousel">
                                    <div class="item" style="background: url(img/organic-food/q1.jpg);">

                                    </div>
                                    <div class="item" style="background: url(img/organic-food/q1.jpg);">

                                    </div>
                                    <div class="item" style="background: url(img/organic-food/q1.jpg);">

                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="quick-view-content">
                                    <div class="top">
                                        <h3 class="head">Mill Oil 1000W Heater, White</h3>
                                        <div class="price d-flex align-items-center"><span class="lnr lnr-tag"></span> <span class="ml-10">$149.99</span></div>
                                        <div class="category">Category: <span>Household</span></div>
                                        <div class="available">Availibility: <span>In Stock</span></div>
                                    </div>
                                    <div class="middle">
                                        <p class="content">Mill Oil is an innovative oil filled radiator with the most modern technology. If you are
                                            looking for something that can make your interior look awesome, and at the same time give you the pleasant
                                            warm feeling during the winter.</p>
                                        <a href="#" class="view-full">View full Details <span class="lnr lnr-arrow-right"></span></a>
                                    </div>
                                    <div class="bottom">
                                        <div class="color-picker d-flex align-items-center">Color:
                                            <span class="single-pick"></span>
                                            <span class="single-pick"></span>
                                            <span class="single-pick"></span>
                                            <span class="single-pick"></span>
                                            <span class="single-pick"></span>
                                        </div>
                                        <div class="quantity-container d-flex align-items-center mt-15">
                                            Quantity:
                                            <input type="text" class="quantity-amount ml-15" value="1" />
                                            <div class="arrow-btn d-inline-flex flex-column">
                                                <button class="increase arrow" type="button" title="Increase Quantity"><span class="lnr lnr-chevron-up"></span></button>
                                                <button class="decrease arrow" type="button" title="Decrease Quantity"><span class="lnr lnr-chevron-down"></span></button>
                                            </div>

                                        </div>
                                        <div class="d-flex mt-20">
                                            <a href="#" class="view-btn color-2"><span>Add to Cart</span></a>
                                            <a href="#" class="like-btn"><span class="lnr lnr-layers"></span></a>
                                            <a href="#" class="like-btn"><span class="lnr lnr-heart"></span></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


		<script>
			window.onload = function() {
				let queryString = window.location.search;
				let urlParams = new URLSearchParams(queryString);
				let toview = urlParams.has('toview');
				if(toview) {
					window.scrollTo(0, 400);
				}
			}
		</script>
        <script src="js/vendor/jquery-2.2.4.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
        crossorigin="anonymous"></script>
        <script src="js/vendor/bootstrap.min.js"></script>
        <script src="js/jquery.ajaxchimp.min.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/jquery.sticky.js"></script>
        <script src="js/nouislider.min.js"></script>
        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/vendor/checksign.js"></script>
        <!--gmaps Js-->
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjCGmQ0Uq4exrzdcL6rvxywDDOvfAu6eE"></script>
        <script src="js/gmaps.min.js"></script>
        <script src="js/main.js"></script>
    </body>

</html>
