<%@ page import="fpt.com.assignment.service.CommonService" %>
<%@ page import="fpt.com.assignment.utils.EnumCommon" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
</head>
<body>
<div style="display: flex">
    <jsp:include page="../layout/_sidebar.jsp">
        <jsp:param name="isSpct" value="true"/>
    </jsp:include>
    <div class="container">
        <h3 class="text-center mb-5 mt-5">
            SẢN PHẨM CHI TIẾT
        </h3>
        <div>
            <div style="display: flex; justify-content: space-between">
                <div>
                    <a href="/admin/san-pham-ct/them-moi">
                        <button class="btn btn-outline-success">Thêm mới</button>
                    </a>
                </div>
                <div style="display: flex; justify-content: end; gap: 10px; margin-bottom: 10px">
                    <a class="btn btn-outline-primary" href="index?page=0"> << </a>
                    <a class="btn btn-outline-primary" href="index?page=${pages.number-1}"
                            <c:if test="${pages.number-1 < 0}">
                                style="pointer-events: none; color: #ccc"
                            </c:if>
                    > < </a>
                    <a class="btn btn-outline-primary" href="index?page=${pages.number+1}"
                            <c:if test="${pages.number+1 >= pages.totalPages}">
                                style="pointer-events: none; color: #ccc"
                            </c:if>
                    > > </a>
                    <a class="btn btn-outline-primary" href="index?page=${pages.totalPages-1}"> >> </a>
                </div>
            </div>
            <table class="table table-sm table-striped">
                <thead>
                <tr class="table-dark">
                    <th>STT</th>
                    <th>Tên sản phẩm</th>
                    <th>Tên màu</th>
                    <th>Tên kích cỡ</th>
                    <th>Giá bán</th>
                    <th>Số lượng tồn</th>
                    <th>Trạng thái</th>
                    <th>Ngày nhập</th>
                    <td>Ảnh</td>
                    <th>Thao tác</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pages.content}" var="el" varStatus="st">
                    <tr>
                        <td>${st.index + 1}</td>
                        <td>${el.sanPhamDto.maSanPham}</td>
                        <td>${el.mauSacDto.tenMau}</td>
                        <td>${el.kichCoDto.tenSize}</td>
                        <td>${el.giaBan}</td>
                        <td>${el.soLuongTon}</td>
                        <td>${el.getStatus()}</td>
                        <td>${el.ngayTao}</td>
                        <td>
                            <img style="width: 100px;height: 140px;object-fit: cover;" src="
                                <c:if test="${el.dirImg == null}">
                                    <%= request.getContextPath() %>/img/icon-not-found.jpg
                                </c:if>
                                <c:if test="${el.dirImg != null}" >
                                    ${el.dirImg}
                                </c:if>
                            " class="img-thumbnail" alt="...">
                        </td>
                        <td>
                            <div style="display: flex; gap: 10px">
                                <a href="/admin/san-pham-ct/chi-tiet?id=${el.id}" class="btn btn-outline-success">Detail</a>
                                <a href="/admin/san-pham-ct/cap-nhat?id=${el.id}" class="btn btn-outline-warning">
                                    Edit
                                </a>
                                <a href="/admin/san-pham-ct/delete?id=${el.id}">
                                    <button class="btn btn-outline-danger"
                                            onclick="return confirm('bạn có chắc muốn xóa không?')">Delete
                                    </button>
                                </a>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script>
    window.onload = function () {
        let errorMessage = '<%= request.getAttribute("errMess") %>'; // Lấy giá trị của attribute "errorMessage"
        console.log(errorMessage)
        if (errorMessage + '' !== 'null') {
            alert(errorMessage); // Hiển thị thông báo lỗi
        }
    };
</script>
</body>
</html>