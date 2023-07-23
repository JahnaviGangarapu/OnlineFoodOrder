
<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="c" uri="jakarta.tags.core" %>

            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Question View</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css"
                    rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp"
                    crossorigin="anonymous">
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N"
                    crossorigin="anonymous"></script>

            </head>

            <body>
                <h1><c:out value="Welcome: ${sessionScope.userName}"/></h1>
                <h1><c:out value="You are logged in as: ${sessionScope.userRole}"/></h1>
                <h1>Items in CART</h1>

                <div align="center">
                    <table border="9px solid black" cellpadding="20">

                        <tr>
                            <!-- <th>Order Id</th> -->
                            <th>Menu Id</th>
                            <th>Menu Name</th>
                            <th>Menu Description</th>
                            <th>Menu Price</th>

                        </tr>

                        <c:forEach var="menuList" items="${itemInCart}">
                            <tr>
                                <!-- <td>
                                    <c:out value="${orderList.orderId}" />
                                </td> -->
                                <!-- <td>
                                    <c:out value="${menuList.menuId}" />
                                </td> -->
                                <td>
                                    <c:out value="${menuList.menuName}" />
                                </td>
                                <td>
                                    <c:out value="${menuList.menuDescription}" />
                                </td>
                                <td>
                                    <c:out value="${menuList.menuPrice}" />
                                </td>
                                <td><a href="deletOrder.htm?menuId=${menuList.menuId}">Click to Delete</a></td>

                            </tr>
                        </c:forEach>

                    </table>

                    <form action="customerViewRestaurant.htm" method="POST">

                        <br><input class="btn btn-primary" type="submit" value="Click to cancel">
                    </form>

                    <form:form  action="placeOrder.htm" method="POST" modelAttribute="order">

                        <br><input class="btn btn-primary" type="submit" value="Click to confirm your orders">
                    </form:form>
                </div>

            </body>

            </html>