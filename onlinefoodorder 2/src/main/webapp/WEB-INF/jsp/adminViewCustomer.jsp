
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Question View</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/js/bootstrap.bundle.min.js" integrity="sha384-qKXV1j0HvMUeCBQ+QVp7JcfGl760yU08IQ+GpUo5hlbpg51QRiuqHAJz8+BrxE/N" crossorigin="anonymous"></script>

    </head>
    <body>
        <!-- <h1><c:out value="Welcome: ${sessionScope.userName}"/></h1>
            <h1><c:out value="You are logged in as: ${sessionScope.userRole}"/></h1>
        <h1>View your restaurants</h1> -->

        <div align="center">
            <table border="9px solid black" cellpadding="20">

                <tr>
                    <th>Customer Id</th>
                    <th>Customer Name</th>
                </tr>
                
             <c:forEach var="cus" items="${displayAllRestaurantsToAdmin}">
                    <tr>
                        <td><c:out value="${cus.userId}" /></td>
                        <td><c:out value="${cus.userName}" /></td>
                        
                    </tr>
                </c:forEach>

            </table>

            <form action="returnAdminDashboard.htm" method="POST">

                <br><input class="btn btn-primary" type="submit" value="Return to Dashboard">
            </form>

            
        </div>	

    </body>
</html>
