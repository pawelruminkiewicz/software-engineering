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
        <a href="/addbuilding" class="button">Add building</a>
        <a href="/addlevel" class="button">Add level</a>
        <a href="/addroom" class="button selected">Add room</a>
    </div>
    <h2 id="title">Adding a room</h2>
    <form id="myform" method="POST">
        <h3>Select level:</h3>
        <select  name="level-id" class="field">
            <c:forEach items="${myBuildingList}" var="building">
                <optgroup label="#${building.getId()} ${building.getName()} ">
                    <c:forEach items="${building.getLevels()}" var="level">
                        <option value="${level.getId()}">#${level.getId()} ${level.getName()}</option>
                    </c:forEach >
                </optgroup>
            </c:forEach >
        </select>
        <h3>Room ID:</h3>
        <input type="text" name="room-id" class="field" pattern="\d*" title="Cyfry" required>
        <h3>Room name:</h3>
        <input type="text" name="room-name" class="field" pattern="[a-zA-Z\s]*" title="Litery" required>
        <h3>Length (x):</h3>
        <input type="text" name="room-x" class="field" pattern="[0-9]+([\.,][0-9]+)?" title="Liczba dziesietna" required>
        <h3>Width (y):</h3>
        <input type="text" name="room-y" class="field" pattern="[0-9]+([\.,][0-9]+)?" title="Liczba dziesietna" required>
        <h3>Height (z):</h3>
        <input type="text" name="room-z" class="field" pattern="[0-9]+([\.,][0-9]+)?" title="Liczba dziesietna" required>
        <h3>Bulb count:</h3>
        <input type="text" name="room-bulb-count" class="field" pattern="\d*" title="Cyfry" required>
        <h3>Bulb power:</h3>
        <input type="text" name="room-bulb-power" class="field" pattern="[0-9]+([\.,][0-9]+)?" title="Liczba dziesietna" required>
        <br>
        <input type="submit" id="send" value="Add">
    </form>

    <% if (request.getParameter("level-id") != null){
        int levelId=Integer.parseInt(request.getParameter("level-id"));
        int roomId=Integer.parseInt(request.getParameter("room-id"));
        String roomName=request.getParameter("room-name");
        float x=Float.parseFloat(request.getParameter("room-x").replace(',','.'));
        float y=Float.parseFloat(request.getParameter("room-y").replace(',','.'));
        float z=Float.parseFloat(request.getParameter("room-z").replace(',','.'));
        int bulbCount=Integer.parseInt(request.getParameter("room-bulb-count"));
        float bulbPower=Float.parseFloat(request.getParameter("room-bulb-power").replace(',','.'));
        Level myLevel = TextTransformerApplication.findLevelById(levelId);
        Room myRoom = new Room(roomId, roomName, x, y, z, bulbCount, bulbPower, myLevel);
        Building myBuilding = TextTransformerApplication.findBuildingByLevelId(myLevel.getId());
        TextTransformerApplication.calculateAllAttributes(myRoom);
        TextTransformerApplication.calculateAllAttributes(myLevel);
        TextTransformerApplication.calculateAllAttributes(myBuilding);
        System.out.println("Room inserted correctly"); %>
    <h2 id="complete"> Added correctly </h2>
    <%} %>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="../js/javascript.js"></script>
</body>
</html>