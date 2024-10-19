<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/12/2024
  Time: 12:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/bd7b2915a7.js" crossorigin="anonymous"></script>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto+Condensed:ital,wght@0,100..900;1,100..900&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="<c:url value='addRoom.css?v=1.0'/>">
    <title>Form thêm mới</title>
</head>
<body>
<div class="container">

    <div class="form">
        <% if (request.getAttribute("errorMessage") != null) { %>
        <div class="error-message">
            <p><%= request.getAttribute("errorMessage") %></p>
        </div>
        <% } %>
        <form action="http://localhost:8080/room?action=add" method="post">
            <table border="1">
                <tr>
                    <th colspan="2">THÊM MỚI</th>
                </tr>
                <tr>
                    <td class="info">
                        <i class="fa-solid fa-gamepad"></i>
                        <label for="customerName">Tên khách hàng</label>
                    </td>
                    <td><input type="text" name="customerName" id="customerName"></td>
                </tr>
                <tr>
                    <td class="info">
                        <i class="fa-solid fa-money-bill"></i>
                        <label for="phone">Số điện thoại</label>
                    </td>
                    <td><input type="text" name="phone" id="phone"></td>
                </tr>
                <tr>
                    <td class="info">
                        <i class="fa-solid fa-layer-group"></i>
                        <label for="idPayment">Kiểu thanh toán</label>
                    </td>
                    <td><input type="text" name="idPayment" id="idPayment"></td>
                </tr>
                <tr>
                    <td class="info">
                        <i class="fa-regular fa-image"></i>
                        <label for="note">Ghi chú</label>
                    </td>
                    <td><input type="text" name="note" id="note"></td>
                </tr>


                <tr>
                    <td colspan="2" class="tdbtn">
                        <a href=""><button>Thêm sản phẩm</button></a>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
