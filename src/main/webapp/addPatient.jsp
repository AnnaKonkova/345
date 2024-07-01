<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Add new patient</title>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>

    <body class="w3-light-grey">
        <div class="w3-container w3-blue-grey w3-opacity w3-right-align">
            <h1>Hospital !</h1>
        </div>

        <div class="w3-container w3-padding">
            <div class="w3-card-4">
                <div class="w3-container w3-center w3-green">
                    <h2>Add patient</h2>
                </div>
                <form action="addPatient" method="get" class="w3-selection w3-light-grey w3-padding">
                        <input name="title" type="text" placeholder="Название отделения"  class="w3-input w3-animate-input w3-border w3-round-large"  style="width: 30%"><br />
                        <input name="patientName" type="text" placeholder=" Имя"  class="w3-input w3-animate-input w3-border w3-round-large"  style="width: 30%"><br />
                        <input name="patientAge" type="number" min="1" max="100" placeholder="Возраст"  class="w3-input w3-animate-input w3-border w3-round-large"  style="width: 30%"><br />
                        <input name="patientGender" type="text" placeholder="Пол"  class="w3-input w3-animate-input w3-border w3-round-large"  style="width: 7%"><br />
                        <button type="submit" class="w3-btn w3-green w3-round-large w3-margin-bottom">Добавить</button>
                </form>
            </div>
        </div>
    </body>
</html>