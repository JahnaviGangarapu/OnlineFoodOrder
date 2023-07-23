
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

                 
                    <div
                        class="container min-vh-100 d-flex flex-row bd-highlight mb-1 justify-content-center align-items-center">

                        <div>

                            <form action="viewRestaurantsByAdmin.htm" method="POST">
                                <input class="btn btn-primary" type="submit" value="View All restaurants">
                            </form> <br> <br>

                        </div>

                        <div>

                            <form action="viewCustomersByAdmin.htm" method="POST">
                                <input class="btn btn-primary" type="submit" value="View All Customers">
                            </form> <br> <br>
                        </div>

                        <div>

                            <form action="logout.htm" method="GET">
                                <input class="btn btn-primary" type="submit" value="Back">
                            </form>
                        </div>


                    </div>

            </body>

            </html>