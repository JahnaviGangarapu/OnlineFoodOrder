<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="c" uri="jakarta.tags.core" %>
            <!DOCTYPE html>
            <html>

            <head>
                <title>Restaurant</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css"
                    rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp"
                    crossorigin="anonymous">
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N"
                    crossorigin="anonymous"></script>

            </head>

            <body>

                    <h1>
                        <c:out value="Welcome: ${sessionScope.userName}" />
                    </h1>
                    <h1>
                        <c:out value="You are logged in as:  ${sessionScope.userRole}" />
                    </h1>
                    <div
                        class="container min-vh-100 d-flex flex-row bd-highlight mb-1 justify-content-center align-items-center">

                        <div>

                            <form action="addMenu.htm" method="POST">
                                <input class="btn btn-primary" type="submit" value="Add Menu">
                            </form> <br> <br>

                        </div>

                        <div>

                            <form action="viewMenu.htm" method="POST">
                                <input class="btn btn-primary" type="submit" value="View Menu">
                            </form> <br> <br>
                        </div>

                        <!-- <div>

                    <form action="viewOrders.htm" method="GET">
                        <input class="btn btn-primary" type="submit" value="View Orders">
                    </form>
                </div> -->


                        <div>

                            <form action="logout.htm" method="GET">
                                <input class="btn btn-primary" type="submit" value="logout">
                            </form>
                        </div>


                    </div>

            </body>

            </html>