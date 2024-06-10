<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</head>
<body>
<div style="display: flex">
    <div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style="width: 280px; height: 100vh; position: sticky; top: 0">
        <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
            <svg class="bi me-2" width="40" height="32">Logo</svg>
            <span class="fs-4">Sidebar</span>
        </a>
        <hr>
        <ul class="nav nav-pills flex-column mb-auto">
            <li class="nav-item">
                <a href="#" class="nav-link active" aria-current="page">
                    <svg class="bi me-2" width="16" height="16">Logo</svg>
                    Home
                </a>
            </li>
            <li>
                <a href="/san-pham/index" class="nav-link text-white">
                    <svg class="bi me-2" width="16" height="16">Logo</svg>
                    Sản phẩm
                </a>
            </li>
            <li>
                <a href="/san-pham-ct/index" class="nav-link text-white">
                    <svg class="bi me-2" width="16" height="16">Logo</svg>
                    Sản phẩm chi tiết
                </a>
            </li>
            <li>
                <a href="/hoa-don/index" class="nav-link text-white">
                    <svg class="bi me-2" width="16" height="16">Logo</svg>
                    Hóa đơn
                </a>
            </li>
            <li>
                <a href="/hoa-don-ct/index" class="nav-link text-white">
                    <svg class="bi me-2" width="16" height="16">Logo</svg>
                    Hóa đơn chi tiết
                </a>
            </li>
            <li>
                <a href="/khach-hang/index" class="nav-link text-white">
                    <svg class="bi me-2" width="16" height="16">Logo</svg>
                    Khách hàng
                </a>
            </li>
            <li>
                <a href="/danh-muc/index" class="nav-link text-white">
                    <svg class="bi me-2" width="16" height="16">Logo</svg>
                    Danh mục
                </a>
            </li
            <li class="mb-1">
                <button class="btn btn-toggle align-items-center rounded collapsed text-white" data-bs-toggle="collapse" data-bs-target="#home-collapse" aria-expanded="true">
                    Home
                </button>
                <div class="collapse show" id="home-collapse">
                    <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                        <li><a href="#" class="text-white rounded">Overview</a></li>
                        <li><a href="#" class="text-white rounded">Updates</a></li>
                    </ul>
                </div>
            </li>
            <li class="mb-1">
                <button class="btn btn-toggle align-items-center rounded collapsed text-white" data-bs-toggle="collapse" data-bs-target="#dashboard-collapse" aria-expanded="false">
                    Thuộc tính
                </button>
                <div class="collapse show" id="dashboard-collapse">
                    <ul class="btn-toggle-nav list-unstyled fw-normal pb-1 small">
                        <li><a href="/mau-sac/index" class="link-dark rounded">Màu sắc</a></li>
                        <li><a href="/kich-co/index" class="link-dark rounded">Kích cỡ</a></li>
                    </ul>
                </div>
            </li>
        </ul>
        <hr>
        <div class="dropdown">
            <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                <img src="https://github.com/mdo.png" alt="" width="32" height="32" class="rounded-circle me-2">
                <strong>mdo</strong>
            </a>
            <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
                <li><a class="dropdown-item" href="#">New project...</a></li>
                <li><a class="dropdown-item" href="#">Settings</a></li>
                <li><a class="dropdown-item" href="#">Profile</a></li>
                <li><hr class="dropdown-divider"></li>
                <li><a class="dropdown-item" href="#">Sign out</a></li>
            </ul>
        </div>
    </div>
    <div style="width: 100%; height: 100%; background-color: red">

    </div>
</div>
</body>
</html>