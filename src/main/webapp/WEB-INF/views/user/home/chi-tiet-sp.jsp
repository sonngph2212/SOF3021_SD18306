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
    <div style="display: flex; justify-content: center; flex-direction: column;" class="container">
        <div style="margin-bottom: 80px; margin-top: 80px;">
            <div class="div-card">
                <div class="card-header">
                    <h2>Chi tiết sản phẩm</h2>
                </div>
                <div style="display: flex; gap: 20px;">
                    <div style="width: 412px; height: 412px;">
                        <div class="my-card-img">
                            <img style="width: 412px;height: 412px;object-fit: cover;" src="
                                <c:if test="${objDetail.dirImg == null}">
                                    <%= request.getContextPath() %>/img/icon-not-found.jpg
                                </c:if>
                                <c:if test="${objDetail.dirImg != null}" >
                                    ${objDetail.dirImg}
                                </c:if>
                            " class="img-thumbnail" alt="...">
                        </div>
                    </div>
                    <div class="my-card-concept" style="display: flex; flex-direction: column; gap: 50px;">
                        <div style="display: flex; justify-content: space-between;">
                            <div>
                                    <span style="font-size: 22px;">
                                        ${objDetail.sanPhamDto.tenSanPham}
                                    </span>
                                <div style="font-weight: 500;">Giá bán: $${objDetail.giaBan}</div>
                            </div>
                        </div>
                        <div>
                            <button class="btn btn-warning">Mua ngay</button>
                            <button class="btn btn-danger">Thêm vào giỏ</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <jsp:include page="../layout/_footer.jsp">
        <jsp:param name="isKichCo" value="true"/>
    </jsp:include>
</div>
</body>
</html>