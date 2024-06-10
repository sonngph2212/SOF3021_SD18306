<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css" integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/js/all.min.js" integrity="sha512-u3fPA7V8qQmhBPNT5quvaXVa1mnnLSXUep5PS1qo5NRzHwG19aHmNJnj1Q8hpA/nBWZtZD4r4AX6YOt5ynLN2g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<div
        style="height: 84px; background-color: #F0F2F3; display: flex; align-items: center; padding-left: 300px; padding-right: 300px;">
    <div style="height: 40px; width: 100%; display: flex; justify-content: space-between;">
        <div class="flex-concept-center" style="width: 166px; height: 40px; font-size: 28px;">
            <a href="/demo">
                <i class="fa-solid fa-house-fire me-1" style="font-size: 28px!important;"></i>
            </a>
            Comforty
        </div>
        <div class="flex-concept-center" style="width: auto; height: 40px;">
            <div id="cover">
                <div class="tb">
                    <div class="td"><input type="text" placeholder="Search here" required id="input-search">
                    </div>
                    <div class="td" id="s-cover">
                        <button type="submit" id="btn-search">
                            <i class="fa-solid fa-magnifying-glass"></i>
                        </button>
                    </div>
                </div>
            </div>
            <div class="flex-concept-center el-space" style="width: auto; height: 40px;">
                <a href="/demo/gio-hang?id=${user.id}" class="btn btn-light flex-concept-center me-2">
                    <i class="fa-solid fa-cart-shopping"></i>
                    <div style="margin-left: 5px; margin-right: 5px;">Cart</div>
                    <span class="badge text-bg-success" style="font-weight: 300;">${soLuongGh}</span>
                </a>
                <button class="btn btn-light  me-2"><i class="fa-regular fa-heart"></i></button>
                <button class="btn btn-light  me-2"><i class="fa-regular fa-user"></i></button>
            </div>
        </div>
    </div>
</div>