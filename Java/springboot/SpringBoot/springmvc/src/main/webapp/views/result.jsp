<%@page language="java" %>

<html>
<head>
    <title>Spring JSP Project</title>
    <link href="result.css" rel="stylesheet">
</head>

<body>
    <div class="resultClass">
    <!-- <h2>Result is : <%= session.getAttribute("result") %> </h2> -->
     <h1>Result - Practice ${course}</h1>
    <h2>Addition is : ${result}</h2> <!--  jstl way -->
    <h2>User is : ${user}</h2>
    </div>
</body>
</html>