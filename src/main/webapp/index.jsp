<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome!</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
      <div class="w3-container w3-blue-grey w3-opacity w3-right-align">
          <h1>Hospital!</h1>
      </div>
      <div class="w3-container w3-center">
          <div class="w3-bar w3-padding-large w3-padding-24">
                  <form action="addDep.jsp">
                      <button class="w3-btn w3-hover-light-blue w3-round-large" onclick="location.href='/addDep'">Add Department</button>
                  </form>
                  <form action="removeDep.jsp">
                        <button class="w3-btn w3-hover-red w3-round-large"  onclick="location.href='/removeDep'">Remove Department</button>
                  </form>
                  <form action="listD.jsp">
                        <button class="w3-btn w3-hover-green w3-round-large"  onclick="location.href='/listD'">List Department</button>
                  </form>
                  <form action="addPatient.jsp">
                      <button class="w3-btn w3-hover-green w3-round-large"  onclick="location.href='/addPatient'">Add New Patient</button>
                  </form>
          </div>
      </div>
</body>
</html>