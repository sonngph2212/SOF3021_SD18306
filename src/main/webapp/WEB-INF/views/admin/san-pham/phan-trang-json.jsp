<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Paginating</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container mt-5">
    <div class="accordion" id="accordionFlushExample">
        <div class="accordion-item">
            <h2 class="accordion-header">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                        data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne">
                    Table have Pagination 10 record/page
                </button>
            </h2>
            <div id="flush-collapseOne" class="accordion-collapse collapse show" data-bs-parent="#accordionFlushExample">
                <div style="display: flex; justify-content: end; gap: 10px; margin-bottom: 10px">
                    <a class="btn btn-success" href="phan-trang?pageNo=0"> |&lt; </a>
                    <a class="btn btn-success" href="phan-trang?pageNo=${result.number-1}"
                        <c:if test="${result.number-1 < 0}">
                            style="pointer-events: none; color: #ccc"
                        </c:if>
                    > &lt;&lt; </a>
                    <a class="btn btn-success" href="phan-trang?pageNo=${result.number+1}"
                            <c:if test="${result.number+1 >= result.totalPages}">
                                style="pointer-events: none; color: #ccc"
                            </c:if>
                    > &gt; &gt; </a>
                    <a class="btn btn-success" href="/san-pham/phan-trang?pageNo=${result.totalPages-1}"> &gt;| </a>
                </div>
                <table class="table table-light">
                    <thead>
                    <tr class="table-dark">
                        <th>STT</th>
                        <th>Tên sản phẩm</th>
                        <th>Thao tác</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="el" items="${result.content}" varStatus="st">
                        <tr>
                            <td>${st.index + 1}</td>
                            <td>${el.tenSanPham}</td>
                            <td>
                                <button class="btn btn-outline-warning">Edit</button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="accordion-item">
            <h2 class="accordion-header">
                <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse"
                        data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo">
                    JSON page
                </button>
            </h2>
            <div id="flush-collapseTwo" class="accordion-collapse collapse" data-bs-parent="#accordionFlushExample">
                <div class="accordion-body">Placeholder content for this accordion, which is intended to demonstrate the
                    <textarea name="" id="" cols="30" rows="10" class="w-100">${pageJson}</textarea>
                </div>
            </div>
        </div>
    </div>
</div>


<%--<div>--%>
<%--    <c:forEach items="${result.content}" var="el">--%>
<%--        <div>--%>
<%--                ${el.toString()}--%>
<%--        </div>--%>
<%--    </c:forEach>--%>
<%--    <div>--%>
<%--        ❖Trang số: ${page.number}--%>
<%--        ❖Kích thước trang: ${page.size}--%>
<%--        ❖Tổng số trang: ${page.totalPages}--%>
<%--        ❖Số phần tử hiện tại: ${page.numberOfElements}--%>
<%--        ❖Tổng số phần tử: ${page.totalElements}--%>
<%--    </div>--%>
<%--</div>--%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>