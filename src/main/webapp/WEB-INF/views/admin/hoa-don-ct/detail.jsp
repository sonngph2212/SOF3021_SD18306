<%@page language="java" contentType="text/html;charset=utf-8" %>
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
        <jsp:param name="isHdct" value="true" />
    </jsp:include>
    <div class="container mt-5">
        <div>
            <h3>
                ${title}
            </h3>
        </div>
        <div class="card card-body">
            <form:form method="post" action="${isUpdate ? 'cap-nhat' : 'them-moi'}" class="row g-3 needs-validation"
                       novalidate=""
                       modelAttribute="objInput">

                <div class="col-md-6" style="display: none">
                    <label for="id" class="form-label">ID</label>
                    <form:input path="id" type="text" class="form-control" />
                </div>

                <div class="col-md-6">
                    <label for="idHoaDon" class="form-label">ID hóa đơn</label>
                    <form:select path="idHoaDon" type="text" class="form-select" disabled="${isDetail}">
                        <form:options items="${lstHd}" itemValue="id" itemLabel="id"/>
                    </form:select>
                </div>
                <div class="col-md-6">
                    <label for="sanPhamCtDto" class="form-label">Sản phẩm</label>
                    <form:select path="sanPhamCtDto" type="text" class="form-select" disabled="${isDetail}">
                        <form:options items="${lstSp}" itemValue="id" itemLabel="sanPhamDto.tenSanPham"/>
                    </form:select>
                </div>
                <div class="col-md-6">
                    <label for="soLuongMua" class="form-label">Số lượng mua</label>
                    <form:input path="soLuongMua" type="text" class="form-control" disabled="${isDetail}"/>
                    <form:errors path="soLuongMua" class="text-danger"/>
                </div>
                <div class="col-md-6">
                    <label for="giaBan" class="form-label">Giá bán</label>
                    <form:input path="giaBan" type="text" class="form-control" disabled="${isDetail}"/>
                    <form:errors path="giaBan" class="text-danger"/>
                </div>
                <div class="col-md-6">
                    <label for="tongTien" class="form-label">Tổng tiền</label>
                    <form:input path="tongTien" type="text" class="form-control" disabled="${isDetail}"/>
                    <form:errors path="tongTien" class="text-danger"/>
                </div>
                <div class="col-md-6">
                    <label for="trangThai" class="form-label">Trạng thái</label>
                    <form:select path="trangThai" type="text" class="form-select" disabled="${isDetail}">
                        <form:options items="${lstStatus}" itemValue="value" itemLabel="tenDm"/>
                    </form:select>
                    <form:errors path="trangThai" class="text-danger"/>
                </div>
                <div class="col-12" style="display: flex; gap: 10px">
                    <c:if test="${!isDetail}">
                        <button class="btn btn-primary" type="submit">Submit</button>
                    </c:if>
                    <a class="btn btn-secondary" href="/admin/hoa-don-ct/index">
                        Cancel
                    </a>
                </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>