<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html>
<head>
    <meta charset='utf-8'>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <title>Shopping Cart with Checkout Modal</title>
    <link href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' rel='stylesheet'>
    <link href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css' rel='stylesheet'>
    <script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <style>
        /* Các kiểu CSS */
        ::-webkit-scrollbar {
            width: 8px;
        }
        ::-webkit-scrollbar-track {
            background: #f1f1f1;
        }
        ::-webkit-scrollbar-thumb {
            background: #888;
        }
        ::-webkit-scrollbar-thumb:hover {
            background: #555;
        }
        body {
            background: #ddd;
            min-height: 100vh;
            vertical-align: middle;
            display: flex;
            font-family: sans-serif;
            font-size: 0.8rem;
            font-weight: bold;
        }
        .title {
            margin-bottom: 5vh;
        }
        .card {
            margin: auto;
            max-width: 950px;
            width: 90%;
            box-shadow: 0 6px 20px 0 rgba(0, 0, 0, 0.19);
            border-radius: 1rem;
            border: transparent;
        }
        @media (max-width: 767px) {
            .card {
                margin: 3vh auto;
            }
        }
        .cart {
            background-color: #fff;
            padding: 4vh 5vh;
            border-bottom-left-radius: 1rem;
            border-top-left-radius: 1rem;
        }
        @media (max-width: 767px) {
            .cart {
                padding: 4vh;
                border-bottom-left-radius: unset;
                border-top-right-radius: 1rem;
            }
        }
        .summary {
            background-color: #ddd;
            border-top-right-radius: 1rem;
            border-bottom-right-radius: 1rem;
            padding: 4vh;
            color: rgb(65, 65, 65);
        }
        @media (max-width: 767px) {
            .summary {
                border-top-right-radius: unset;
                border-bottom-left-radius: 1rem;
            }
        }
        .summary .col-2 {
            padding: 0;
        }
        .summary .col-10 {
            padding: 0;
        }
        .row {
            margin: 0;
        }
        .title b {
            font-size: 1.5rem;
        }
        .main {
            margin: 0;
            padding: 2vh 0;
            width: 100%;
        }
        .col-2, .col {
            padding: 0 1vh;
        }
        a {
            padding: 0 1vh;
        }
        .close {
            margin-left: auto;
            font-size: 0.7rem;
        }
        img {
            width: 3.5rem;
        }
        .back-to-shop {
            margin-top: 4.5rem;
        }
        h5 {
            margin-top: 4vh;
        }
        hr {
            margin-top: 1.25rem;
        }
        form {
            padding: 2vh 0;
        }
        select {
            border: 1px solid rgba(0, 0, 0, 0.137);
            padding: 1.5vh 1vh;
            margin-bottom: 4vh;
            outline: none;
            width: 100%;
            background-color: rgb(247, 247, 247);
        }
        input {
            border: 1px solid rgba(0, 0, 0, 0.137);
            padding: 1vh;
            margin-bottom: 4vh;
            outline: none;
            width: 100%;
            background-color: rgb(247, 247, 247);
        }
        .btn {
            background-color: #000;
            border-color: #000;
            color: white;
            width: 100%;
            font-size: 0.7rem;
            margin-top: 4vh;
            padding: 1vh;
            border-radius: 0;
        }
        .btn:focus {
            box-shadow: none;
            outline: none;
        }
        a {
            color: black;
        }
        a:hover {
            color: black;
            text-decoration: none;
        }
    </style>
</head>
<body className='snippet-body'>
    <div class="card">
        <div class="row">
            <div class="col-md-8 cart">
                <div class="title">
                    <div class="row">
                        <div class="col">
                            <h4><b>Shopping Cart</b></h4>
                        </div>
                        <div class="col align-self-center text-right text-muted">
                            <c:out value="${fn:length(cart)}" /> items
                        </div>
                    </div>
                </div>
                <c:forEach var="entry" items="${cart}">
                    <div class="row border-top border-bottom">
                        <div class="row main align-items-center">
                            <div class="col-2">
                                <img class="img-fluid" src="${entry.key.image}">
                            </div>
                            <div class="col">
                                <strong><c:out value="${entry.key.title}"/></strong>
                                <p>Quantity: <c:out value="${entry.value}"/></p>
                            </div>
                            <div class="col text-right">
                                ${entry.key.formattedPrice}
                                <a href="remove?pid=${entry.key.id}" class="remove-item">&#10005;</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>

                <div class="back-to-shop">
                    <a href="list">&leftarrow;</a> 
                    <span class="text-muted">Back to shop</span>
                </div>
            </div>
            <div class="col-md-4 summary">
                <h5><b>Summary</b></h5>
                <hr>
                <div class="row">
                </div>

                <div class="row" style="border-top: 1px solid rgba(0, 0, 0, .1); padding: 2vh 0;">
                    <div class="col">TOTAL PRICE</div>
                    <div class="col text-right">
                        <fmt:formatNumber value="${price}" type="number" minFractionDigits="0" maxFractionDigits="0"/>  VNĐ
                    </div>
                    <button class="btn" data-toggle="modal" data-target="#checkoutModal">CHECKOUT</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal hiển thị chi tiết khi nhấp vào CHECKOUT -->
    <div class="modal fade" id="checkoutModal" tabindex="-1" role="dialog" aria-labelledby="checkoutModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="checkoutModalLabel">Order Summary</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <h6>Products in Your Cart</h6>
                    <ul>
                        <!-- Loop qua từng mục trong giỏ hàng -->
                        <c:forEach var="entry" items="${cart}">
                            <li>
                                <img src="<c:out value="${entry.key.image}"/>" style="width: 50px; height: auto;" alt="<c:out value="${entry.key.title}"/>">
                                <strong><c:out value="${entry.key.title}"/></strong> 
                                - Quantity: <c:out value="${entry.value}"/>
                                -  <fmt:formatNumber value="${entry.key.price}" type="number" minFractionDigits="0" maxFractionDigits="0"/>  VNĐ
                            </li>
                        </c:forEach>
                    </ul>
                    <hr>
                    <strong>Total Price: <fmt:formatNumber value="${price}" type="number" minFractionDigits="0" maxFractionDigits="0"/>  VNĐ</strong>
                </div>
                <div class="modal-footer">
                    <!-- Nút đóng modal -->
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <!-- Nút tiến hành thanh toán -->
<button type="button" class="btn btn-primary" id="addButton" data-product-id="${productId}" data-account-id="${accountId}" data-quantity="1">THÊM</button>
                </div>
            </div>
        </div>
    </div>

    <script type='text/javascript' src='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js'></script>
    <script type='text/javascript'>
        document.getElementById("addButton").addEventListener("click", function() {
            Swal.fire({
                title: 'Chúc mừng!',
                text: 'Bạn đã thêm thành công vào giỏ hàng!',
                icon: 'success',
                confirmButtonText: 'OK'
            });
        });
    </script>
</body>
</html>
