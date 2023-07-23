<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Add Menu</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>

    </head>
    <body>
        <h1><c:out value="Welcome: ${sessionScope.userName}"/></h1>
            <h1><c:out value="You are logged in as:  ${sessionScope.userRole}"/></h1>

        <h1>Add menu</h1>

        <!--<div class="container d-md-flex justify-content-center align-items-center">-->
        <div class="container min-vh-100 d-flex flex-row bd-highlight mb-1 justify-content-center align-items-center">
            
            <form:form action="updateMenuSubmit.htm" method="POST" modelAttribute="menu">
                <div class="col-md-12">
                    <form:hidden path = "menuId" value = "${menu.menuId}" />
                </div> 
                
                <div class="col-md-12">
                    <label class="form-label" for="menuName">menuName</label>
                    <form:input class="form-control" path="menuName" value="${menu.menuName}"/>
                    <form:errors path="menuName" style="color:red;"/><br>
                </div>
                <div class="col-md-12">
                    <label class="form-label" for="menuPrice">menuPrice</label>
                    <form:input class="form-control" path="menuPrice" value="${menu.menuPrice}"/>
                </div>
                <div class="col-md-12">
                    <label class="form-label" for="menuDescription">menuDescription</label>
                    <form:input class="form-control" path="menuDescription" value="${menu.menuDescription}"/>
                </div>
                <br><input class="btn btn-primary" type="submit" value="Update">
            </form:form>

            </body>
            </html>