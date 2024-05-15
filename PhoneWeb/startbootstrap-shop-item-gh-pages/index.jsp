<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Shop Homepage - Start Bootstrap Template</title>
    <!-- Favicon -->
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
    <!-- Bootstrap icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap) -->
    <link href="css/styles.css" rel="stylesheet" />
    <!-- Swiper CSS -->
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css" />

    <style>
        .image-holder {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 400px; /* Điều chỉnh chiều cao tùy ý */
        }

        .image-holder img {
            max-width: 100%;
            max-height: 100%;
            object-fit: contain;
        }
    </style>
</head>
<body>
    <!-- Navigation -->
    <jsp:include page="Menu.jsp"></jsp:include>

 <section id="billboard" class="position-relative overflow-hidden bg-light-blue" style="height: 100vh;">
    <div class="swiper main-swiper" style="height: 100%;">
        <div class="swiper-wrapper">
            <!-- Slide 1 -->
            <div class="swiper-slide" style="height: 100%;">
                <div class="container-fluid h-100"> <!-- Full-width container -->
                    <div class="row d-flex align-items-center h-100"> <!-- Full-height row -->
                        <div class="col-12"> <!-- Full-width column -->
                            <div class="image-holder text-center" style="height: 100%;"> <!-- Full-height image holder -->
                                <img src="https://i.ytimg.com/vi/rzB9LPeCJgk/sddefault.jpg" 
                                     style="width: 60%; height: 100%; object-fit: cover;" 
                                     alt="banner" /> <!-- Ensure image covers the area -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Slide 2 -->
            <div class="swiper-slide" style="height: 100%;">
                <div class="container-fluid h-100">
                    <div class="row d-flex align-items-center h-100">
                        <div class="col-12">
                            <div class="image-holder text-center" style="height: 100%;">
                                <img src="https://e3.365dm.com/23/09/1600x900/skynews-apple-iphone-teaser_6286442.jpg?20230916085200" 
                                     style="width: 60%; height: 100%; object-fit: cover;" 
                                     alt="banner" />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


    <section class="py-5">
        <div class="container px-4 px-lg-5 mt-5">
            <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                <%-- Use JSTL forEach loop to iterate over the listP --%>
                <c:forEach var="o" items="${listP1}">
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image -->
                            <img class="card-img-top" src="${o.image}" alt="..." />
                            <!-- Product details -->
<div class="card-body p-4">
    <div class="text-center">
        <!-- Product name -->
        <h5 class="fw-bolder">
            <a href="detail?pid=${o.id}">${o.title}</a>
        </h5>
        <!-- Product price -->
        $${o.formattedPrice}
    </div>
</div>
                            <!-- Product actions -->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="cart?pid=${o.id}">Add to cart</a></div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </section>

    <!-- Footer -->
    <jsp:include page="Footer.jsp"></jsp:include>

    <!-- Swiper core JS -->
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    <!-- Bootstrap core JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- Core theme JS -->
    <script src="js/scripts.js"></script>

    <!-- Initialize Swiper with Auto-play -->
    <script>
        var swiper = new Swiper('.main-swiper', {
            autoplay: {
                delay: 1500, // Adjust this to change the auto-play speed
                disableOnInteraction: false, // Continues to auto-play even if user interacts
            },
            loop: true, // Loop through the slides
        });
    </script>
</body>
</html>