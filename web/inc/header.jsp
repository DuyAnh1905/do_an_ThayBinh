
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%-- 
    Document   : header
    Created on : Sep 18, 2024, 2:28:05 PM
    Author     : Admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<header id="header">
    <a href="HomeServlet"><img src="./assets/img/logo.png" class="logo" alt=""></a>
    <ul id="navbar">
        <li><a  href="HomeServlet">Home</a></li>
        <li>
            <a href="ShopServlet?page=1">Shop</a>
            <ul class="sub-menu">
                <c:forEach items="${categoryList}" var="category">
                    <li class="menu-item">
                        <a href="CategoryServlet?categoryId=${category.id}">${category.name}</a>
                    </li>
                </c:forEach>
            </ul>
        </li>
        <li><a href="BlogServlet">Blog</a></li>
        <li><a href="AboutServlet">About</a></li>
        <li><a href="ContactServlet">Contact</a></li>
        <li><a href="CartServlet"><i class="fa-solid fa-bag-shopping"></i></a></li>
        <li><c:if test="${sessionScope.user == null}">
            <a href="LoginServlet">Login</a>
             </c:if>
            <c:if test="${sessionScope.user != null}">
            <a href="LogoultServlet">Logout</a>
            </c:if>
        </li>
    </ul>
</header>
