<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <%@ taglib prefix="c" uri="jakarta.tags.core" %>


            <!DOCTYPE html>
            <html>

            <head>
                <title>Login Form</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css"
                    rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp"
                    crossorigin="anonymous">
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N"
                    crossorigin="anonymous"></script>

            </head>

            <body>
                <div style="background:#6DB3F2;">
                <h1>Food Licious</h1>
                <div
                    class="container min-vh-100 d-flex flex-row bd-highlight mb-1 justify-content-center align-items-center">


                    <form:form action="login.htm" method="POST" modelAttribute="login">
                        <div class="col-md-12">
                            <label class="form-label" for="userName">userName:</label>
                            <form:input path="userName" class="form-control" />
                            <form:errors path="userName" style="color:red;" /><br>
                        </div>
                        <div class="col-md-12">
                            <label class="form-label" for="password">Password:</label>
                            <form:password path="password" class="form-control" />
                            <form:errors path="password" style="color:red;" /><br>
                        </div>
                        <input class="btn" type="submit" value="Login" style="background: linear-gradient(to right, #fc5c7d, #6a82fb);">

                    </form:form>


                    <div class="p-5 bd-highlight">
                        <br><a href="aboutUs.htm">To Know More About Us Click Here</a><br>

                        <form action="userRegistration.htm" method="GET">
                            <div class="btn-group">
                                <button type="submit" class="btn" style="background: linear-gradient(to right, #fc5c7d, #6a82fb);">
                                    Register
                                </button>

                        </form>


                        <form action="adminLogin.htm" method="POST">
                            <div class="btn-group">
                                <button type="submit" class="btn" style="background: linear-gradient(to right, #fc5c7d, #6a82fb);">
                                    Admin Login
                                </button>

                        </form>


                    </div>
                </div>

                </div>

            </div>
            </body>

            </html>