<%@ page import="java.util.List" %>
<%@ page import="hospital.integration.database.DepartmentRepositoryImpl" %>
<%@ page import="hospital.domain.Department" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Get list department</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>
    <body class="w3-light-grey">
        <div class="w3-container w3-blue-grey w3-opacity w3-right-align">
            <h1>Hospital !</h1>
        </div>

        <div class="w3-container w3-padding">
            <div class="w3-card-4">
                <div class="w3-container w3-center w3-green">
                    <h2>List Department</h2>
                </div>
                <form action="listD" method="get" class="w3-selection w3-light-grey w3-padding">
                        <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Скачать список отделений</button>
                </form>

            </div>
        </div>
    </body>
</html>