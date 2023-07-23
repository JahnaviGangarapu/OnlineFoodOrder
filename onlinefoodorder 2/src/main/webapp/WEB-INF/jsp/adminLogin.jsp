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
                <h1>Food Licious</h1>
                <div
                    class="container min-vh-100 d-flex flex-row bd-highlight mb-1 justify-content-center align-items-center">


                    <form action="adminDashboard.htm" method="POST">
                        <label for="fname">First name:</label><br>
                        <input type="text" id="fname" name="fname"><br>
                        <label for="lname">Password:</label><br>
                        <input type="password" id="lname" name="pass">
                        <input type="submit" value="Submit">
                      </form>


                    </div>
                </div>

                </div>


            </body>

            </html>