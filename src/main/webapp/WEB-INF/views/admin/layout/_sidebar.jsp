<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="d-flex flex-column flex-shrink-0 p-3 text-white bg-dark" style="width: 280px; height: 100vh; position: sticky; top: 0">
    <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
        <svg class="bi me-2" width="40" height="32">Logo</svg>
        <span class="fs-4">Sidebar</span>
    </a>
    <hr>
    <ul class="nav nav-pills flex-column mb-auto">
        <li class="nav-item">
            <a href="#" class="nav-link text-white ${param.isHome ? 'active' : ''}" aria-current="page">
                <svg class="bi me-2" width="16" height="16">Logo</svg>
                Home
            </a>
        </li>
        <li>
            <a href="/admin/san-pham/index" class="nav-link text-white ${param.isSp ? 'active' : ''}">
                <svg class="bi me-2" width="16" height="16">Logo</svg>
                Sản phẩm
            </a>
        </li>
        <li>
            <a href="/admin/san-pham-ct/index" class="nav-link text-white ${param.isSpct ? 'active' : ''}">
                <svg class="bi me-2" width="16" height="16">Logo</svg>
                Sản phẩm chi tiết
            </a>
        </li>
        <li>
            <a href="/admin/hoa-don/index" class="nav-link text-white ${param.isHd ? 'active' : ''}">
                <svg class="bi me-2" width="16" height="16">Logo</svg>
                Hóa đơn
            </a>
        </li>
        <li>
            <a href="/admin/hoa-don-ct/index" class="nav-link text-white ${param.isHdct ? 'active' : ''}">
                <svg class="bi me-2" width="16" height="16">Logo</svg>
                Hóa đơn chi tiết
            </a>
        </li>
        <li>
            <a href="/admin/khach-hang/index" class="nav-link text-white ${param.isKh ? 'active' : ''}">
                <svg class="bi me-2" width="16" height="16">Logo</svg>
                Khách hàng
            </a>
        </li>
        <li>
            <a href="/admin/danh-muc/index" class="nav-link text-white ${param.isDm ? 'active' : ''}">
                <svg class="bi me-2" width="16" height="16">Logo</svg>
                Danh mục
            </a>
        </li>
        <li>
            <a href="/admin/mau-sac/index" class="nav-link text-white ${param.isMs ? 'active' : ''}">
                <svg class="bi me-2" width="16" height="16">Logo</svg>
                Màu sắc
            </a>
        </li>
        <li>
            <a href="/admin/kich-co/index" class="nav-link text-white ${param.isKichCo ? 'active' : ''}">
                <svg class="bi me-2" width="16" height="16">Logo</svg>
                Kích cỡ
            </a>
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