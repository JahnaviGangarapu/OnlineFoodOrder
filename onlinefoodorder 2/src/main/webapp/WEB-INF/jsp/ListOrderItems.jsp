<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="c" uri="jakarta.tags.core" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Menu List</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css"
                    rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp"
                    crossorigin="anonymous">
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N"
                    crossorigin="anonymous"></script>

            </head>

            <body>

                <div align="center">



                    <h1>
                        <c:out value="Welcome: ${sessionScope.userName}" />
                    </h1>
                    <h1>
                        <c:out value="You are logged in as:  ${sessionScope.userRole}" />
                    </h1>
                    <h1>Your Ordered Items are List</h1>



                    <table border="9px solid black" cellpadding="20">

                        <tr>
                            <th> Items</th>
                        </tr>
                        <c:forEach var="menu" items="${requestScope.orderList}">
                            <tr>
                                <td>
                                    <c:out value="${menu}" />
                                </td>

                            </tr>
                        </c:forEach>
                    </table>

                    <form action="pdf.htm" method="POST">

                        <br><input class="btn btn-primary" type="submit" value="Click to generate invoice">
                    </form>

                    <form action="returnToCustomerMainPage.htm" method="POST">

                        <br><input class="btn btn-primary" type="submit" value="Return to Main Page">
                    </form>
                </div>

            </body>

            </html>