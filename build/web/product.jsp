<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cara</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css"
              integrity="sha512-SnH5WK+bZxgPHs44uWIX+LLJAJ9/2PkPKZ5QiAj6Ta86w+fsb2TkcmfRyVX3pBnMFcV7oQPJkl9QevSCWr3W6A=="
              crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="./assets/css/style.css">
    </head>

    <body>

        <%@include file="./inc/header.jsp" %>
        <section id="prodetails" class="section-p1">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <div class="single-pro-img">
                            <img src="${product.thumbnail}" alt="" id="MainImg" width="100%">
                            <div class="small-img-group">
                                <div class="col-sm-3">
                                    <img src="./assets/img/products/f1.jpg" alt="" class="small-img" width="100%">
                                </div>
                                <div class="col-sm-3">
                                    <img src="./assets/img/products/f2.jpg" alt="" class="small-img" width="100%">
                                </div>
                                <div class="col-sm-3">
                                    <img src="./assets/img/products/f3.jpg" alt="" class="small-img" width="100%">
                                </div>
                                <div class="col-sm-3">
                                    <img src="./assets/img/products/f4.jpg" alt="" class="small-img" width="100%">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <form action="CartServlet" method="post" class="single-pro-details">
                            <input type="hidden" name="action" value="create"/>
                            <input type="hidden" name="productId" value="${product.id}"/>
                            <input type="hidden" name="price" value="${product.price}"/>
                            <h6>Home / T-Shirt</h6>
                            <h4>${product.name}</h4>
                            <h2>$${product.price}</h2>
                            <select>
                                <option>Select Size</option>
                                <option>S</option>
                                <option>M</option>
                                <option>L</option>
                                <option>XL</option>
                                <option>XXL</option>
                            </select>
                            <input name="quantity" type="number" value="1">
                            <button class="normal">Add To Cart</button>
                            <h4>Product Details</h4>
                            <span>${product.description}</span>
                        </form>
                    </div>
                </div>
            </div>
        </section>

        <section id="product1" class="section-p1">
            <h2>New Arrivals</h2>
            <p>Summer Collection New Morden Design</p>

            <div class="prod-cont">
                <c:forEach items="${newsProductList}" var="product">
                    <div class="prod">
                        <a href="ProductServlet?productId=${product.id}" ><img src="${product.thumbnail}" alt=""></a>
                        <div class="des">
                            <span>adidas</span>
                            <h5>${product.name}</h5>
                            <div class="star">
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                                <i class="fas fa-star"></i>
                            </div>
                            <h4>$${product.price}</h4>
                        </div>
                        <a href="#"><i class="fa-solid fa-cart-shopping cart"></i></a>
                    </div>
                </c:forEach>
            </div>
        </section>

        <section id="newsletter" class="section-p1 section-m1">
            <div class="newstext">
                <h4>Sign Up For Newsletters</h4>
                <p>Get E-mail updates about our latest shop and <span>special offers</span></p>
            </div>
            <div class="form">
                <input type="text" placeholder="Your email address">
                <button class="normal">Sign up</button>
            </div>
        </section>

        <footer class="section-p1">
            <div class="col">
                <img class="logo" src="./assets/img/logo.png" alt="">
                <h4>Contact</h4>
                <p><strong>Address:</strong> Cao Dang Cong Nghiep - Hueic</p>
                <p><strong>Phone:</strong> +84000111222</p>
                <p><strong>Hours:</strong> 8AM - 21PM, Mon - Sat</p>
                <div class="follow">
                    <h4>Follow us</h4>
                    <div class="icon">
                        <i class="fa-brands fa-facebook-f"></i>
                        <i class="fa-brands fa-twitter"></i>
                        <i class="fa-brands fa-instagram"></i>
                        <i class="fa-brands fa-pinterest-p"></i>
                        <i class="fa-brands fa-youtube"></i>
                    </div>
                </div>
            </div>
            <div class="col">
                <h4>About</h4>
                <a href="#">About us</a>
                <a href="#">Delivery Information</a>
                <a href="#">Privacy Policy</a>
                <a href="#">Terms & Conditions</a>
                <a href="#">Contact Us</a>
            </div>
            <div class="col">
                <h4>My Account</h4>
                <a href="#">Sign In</a>
                <a href="#">View Cart</a>
                <a href="#">My Wishlist</a>
                <a href="#">Track My Oder</a>
                <a href="#">Help</a>
            </div>
            <div class="col install">
                <h4>Install App</h4>
                <p>From App Store or Google Play</p>
                <div class="row">
                    <img src="./assets/img/pay/app.jpg" alt="">
                    <img src="./assets/img/pay/play.jpg" alt="">
                </div>
                <p>Secured Payment Gateaways</p>
                <img src="./assets/img/pay/pay.png" alt="">
            </div>
        </footer>

    </body>

</html>
