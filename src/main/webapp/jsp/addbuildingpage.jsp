<%@ page import="java.util.ArrayList" %>
<%@ page import="pl.put.poznan.transformer.logic.*" %>
<%@ page import="pl.put.poznan.transformer.rest.*"%>
<%@ page import="pl.put.poznan.transformer.app.TextTransformerApplication" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>

<html lang="pl">
<head>
    <meta charset="utf-8" />
    <title>Building Info</title>
    <link rel="Stylesheet" type="text/css" href="../css/style.css" />
</head>
<body>
    <h1>Building Info</h1>
    <div id="navigation">
        <a href="/" class="button">Back</a>
        <a href="/addbuilding" class="button selected">Add building</a>
        <a href="/addlevel" class="button">Add level</a>
        <a href="/addroom" class="button">Add room</a>
    </div>
    <h2 id="title">Adding a building</h2>
    <form id="myform" method="POST">
        <h3>Building ID:</h3>
        <input type="text" name="building-id" class="field" pattern="\d*" title="Cyfry" required>
        <h3>Building name:</h3>
        <input type="text" name="building-name" class="field" pattern="[a-zA-Z\s]*" title="Litery" required>
        <h3>Alert value:</h3>
        <input type="text" name="building-alert-point" class="field" pattern="[0-9]+([\.,][0-9]+)?" title="Liczba dziesietna" required>
        <br>
        <input type="submit" id="send" value="Add">
    </form>

    <% if (request.getParameter("building-name") != null){
        String buildingName=request.getParameter("building-name");
        int buildingId=Integer.parseInt(request.getParameter("building-id"));
        float buildingAlertPoint=Float.parseFloat(request.getParameter("building-alert-point").replace(',','.'));
        TextTransformerApplication.addToMyList(new Building(buildingId, buildingName, buildingAlertPoint));
        System.out.println("Building inserted correctly"); %>
    <h2 id="complete"> Added correctly </h2>
    <%} %>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="../js/javascript.js"></script>
</body>
</html>