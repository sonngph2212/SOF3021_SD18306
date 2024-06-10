<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/user.css" crossorigin="anonymous">
</head>
<body>
<div class="w-100">
    <jsp:include page="../layout/_header.jsp">
        <jsp:param name="isKichCo" value="true"/>
    </jsp:include>
    <div
            style="height: 75px; background-color: #FFFFFF; display: flex; justify-content: space-between; align-items: center; padding-left: 300px; padding-right: 300px;">
        <div style="height: 47px; display: flex; justify-content: space-between; align-items: center;">
            <div class="dropdown me-2">
                <button class="btn btn-light dropdown-toggle" type="button" data-bs-toggle="dropdown"
                        aria-expanded="false">
                    All category
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="#">Action</a></li>
                    <li><a class="dropdown-item" href="#">Another action</a></li>
                    <li><a class="dropdown-item" href="#">Something else here</a></li>
                </ul>
            </div>
            <div class="me-2" style="font-size: 14px;">
                Home
            </div>
            <div class="me-2" style="font-size: 14px;">
                Shop
            </div>
            <div class="me-2" style="font-size: 14px;">
                Product
            </div>
            <div class="me-2" style="font-size: 14px;">
                Pages
            </div>
        </div>
        <div class="flex-concept-center" style="height: 47px; font-size: 14px;">
            Concat: (808) 555-0111
        </div>
    </div>
    <div style="width: 100%; position: relative; margin-bottom: 100px;" class="px-5">
        <div id="carouselExample" class="carousel slide">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="<%= request.getContextPath() %>/img/background.jpg" class="d-block w-100"
                         style="height: 600px; object-fit: cover;"
                         alt="...">
                </div>
                <div class="carousel-item">
                    <img src="<%= request.getContextPath() %>/img/background.jpg" class="d-block w-100"
                         style="height: 600px; object-fit: cover;"
                         alt="...">
                </div>
                <div class="carousel-item">
                    <img src="<%= request.getContextPath() %>/img/background.jpg" class="d-block w-100"
                         style="height: 600px; object-fit: cover;"
                         alt="...">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample"
                    data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExample"
                    data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
        <div style="background-color: #fff; box-shadow: rgba(17, 12, 46, 0.15) 0px 48px 100px 0px;" id="demo">
            <div style="display: flex;">
                <img src="<%= request.getContextPath() %>/img/box.png" alt="">
                <div style="margin-left: 10px; height: 48px; display: block; overflow: hidden;">
                    <div style="font-size: 18px;">Discount</div>
                    <div style="font-size: 15px; color: #9A9CAA;">Every week new sales</div>
                </div>
            </div>
            <div style="display: flex;">
                <img src="<%= request.getContextPath() %>/img/delivery-truck.png" alt="">
                <div style="margin-left: 10px; height: 48px; display: block; overflow: hidden;">
                    <div style="font-size: 18px;">Free Delivery</div>
                    <div style="font-size: 15px; color: #9A9CAA;">100% Free for all orders</div>
                </div>
            </div>
            <div style="display: flex;">
                <img src="<%= request.getContextPath() %>/img/24-hours.png" alt="">
                <div style="margin-left: 10px; height: 48px; display: block; overflow: hidden;">
                    <div style="font-size: 18px;">Great Support 24/7</div>
                    <div style="font-size: 15px; color: #9A9CAA;">We care your experiences</div>
                </div>
            </div>
            <div style="display: flex;">
                <img src="<%= request.getContextPath() %>/img/shield.png" alt="">
                <div style="margin-left: 10px; height: 48px; display: block; overflow: hidden;">
                    <div style="font-size: 18px;">secure Payment</div>
                    <div style="font-size: 15px; color: #9A9CAA;">100% Secure Payment Method</div>
                </div>
            </div>
        </div>
    </div>
    <div style="display: flex; justify-content: center; flex-direction: column;" class="container">
        <div style="display: flex; justify-content: center;">
            <div
                    style="height: 140px; width: 1320px; display: flex; justify-content: space-around; margin-bottom: 32px;">
                <img src="<%= request.getContextPath() %>/img/Logo.png" alt="">
                <img src="<%= request.getContextPath() %>/img/Logo (1).png" alt="" style="transform: scale(0.5);">
                <img src="<%= request.getContextPath() %>/img/Logo (2).png" alt="" style="transform: scale(0.5);">
                <img src="<%= request.getContextPath() %>/img/Logo (3).png" alt="" style="transform: scale(0.5);">
                <img src="<%= request.getContextPath() %>/img/Logo (4).png" alt="" style="transform: scale(0.5);">
                <img src="<%= request.getContextPath() %>/img/Logo (5).png" alt="" style="transform: scale(0.5);">
            </div>
        </div>
        <div style="margin-bottom: 80px;">
            <div class="div-card">
                <div class="card-header">
                    <h2>Featured Products</h2>
                </div>
                <div style="display: flex; justify-content: space-between;">
                    <c:forEach items="${listRandom}" var="el">
                        <div class="my-card">
                            <div class="my-card-img">
                                    <%--                                <img src="<%= request.getContextPath() %>/img/Image.png" alt="">--%>
                                <img style="width: 312px;height: 312px;object-fit: cover;" src="
                                <c:if test="${el.dirImg == null}">
                                    <%= request.getContextPath() %>/img/icon-not-found.jpg
                                </c:if>
                                <c:if test="${el.dirImg != null}" >
                                    ${el.dirImg}
                                </c:if>
                            " class="img-thumbnail" alt="...">
                            </div>
                            <div class="my-card-concept">
                                <div style="display: flex; justify-content: space-between;">
                                    <div>
                                        <a href="/demo/detail?id=${el.id}"
                                           class="link-underline link-underline-opacity-0 ">${el.sanPhamDto.tenSanPham}</a>
                                        <div style="font-weight: 500;">$${el.giaBan}</div>
                                    </div>
                                    <div>
                                    <span class="badge btn-shop">
                                        <img src="<%= request.getContextPath() %>/img/Buy 3.png" alt="">
                                    </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <div style="margin-bottom: 80px;">
            <div class="text-center" style="margin-bottom: 16px;">
                <h2>Our Products</h2>
            </div>
            <div style="display: flex; justify-content: center; gap: 30px; margin-bottom: 40px;">
                <div>ALL</div>
                <div>NEWEST</div>
                <div>TRENDING</div>
                <div>
                    BEST SELLERS
                </div>
            </div>
            <div class="position-relative">
                <a class="btn btn-outline-primary carousel-control-prev-icon btn-prev" href="/demo?page=${ourProducts.number-1}"
                        <c:if test="${ourProducts.number-1 < 0}">
                            style="pointer-events: none; color: #ccc"
                        </c:if>
                >
                </a>
                <div style="display: flex; justify-content: space-between; flex-wrap: wrap;">
                    <c:forEach items="${ourProducts.content}" var="el">
                        <div class="my-card">
                            <div class="my-card-img">
                                    <%--                                <img src="<%= request.getContextPath() %>/img/Image.png" alt="">--%>
                                <img style="width: 312px;height: 312px;object-fit: cover;" src="
                                <c:if test="${el.dirImg == null}">
                                    <%= request.getContextPath() %>/img/icon-not-found.jpg
                                </c:if>
                                <c:if test="${el.dirImg != null}" >
                                    ${el.dirImg}
                                </c:if>
                            " class="img-thumbnail" alt="...">
                            </div>
                            <div class="my-card-concept">
                                <div style="display: flex; justify-content: space-between;">
                                    <div>
                                        <a href="/demo/detail?id=${el.id}"
                                           class="link-underline link-underline-opacity-0 ">${el.sanPhamDto.tenSanPham}</a>
                                        <div style="font-weight: 500;">$${el.giaBan}</div>
                                    </div>
                                    <div>
                                    <span class="badge btn-shop">
                                        <img src="<%= request.getContextPath() %>/img/Buy 3.png" alt="">
                                    </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <a class="btn btn-outline-primary carousel-control-next-icon btn-next" href="/demo?page=${ourProducts.number+1}"
                        <c:if test="${ourProducts.number+1 >= ourProducts.totalPages}">
                            style="pointer-events: none; color: #ccc"
                        </c:if>
                >
                </a>
            </div>
        </div>
    </div>
    <jsp:include page="../layout/_footer.jsp">
        <jsp:param name="isKichCo" value="true"/>
    </jsp:include>
</div>
</body>
</html>