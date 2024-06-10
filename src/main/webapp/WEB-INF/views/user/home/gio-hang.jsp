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
            <div class="div-card w-100">
                <div class="card-header">
                    <h2>Giỏ hàng</h2>
                </div>
                <div style="display: flex; gap: 20px; width: 100%;">
                    <div style="width: 100%">
                        <table class="table table-striped">
                            <thead>
                            <tr class="table-dark">
                                <th scope="col">STT</th>
                                <th scope="col">Tên sản phẩm</th>
                                <th scope="col">Số lượng</th>
                                <th scope="col">hình ảnh</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${listData}" var="el" varStatus="st">
                                <tr>
                                    <th>${st.index + 1}</th>
                                    <td>${el.sanPhamCtDto.sanPhamDto.tenSanPham}</td>
                                    <td>${el.soLuong}</td>
                                    <td>
                                        <img style="width: 100px;height: 140px;object-fit: cover;" src="
                                <c:if test="${el.sanPhamCtDto.dirImg == null}">
                                    <%= request.getContextPath() %>/img/icon-not-found.jpg
                                </c:if>
                                <c:if test="${el.sanPhamCtDto.dirImg != null}" >
                                    ${el.sanPhamCtDto.dirImg}
                                </c:if>
                            " class="img-thumbnail" alt="...">
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
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