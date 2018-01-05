<%@ page import="pl.put.poznan.transformer.logic.*" %>
<%@ page import="pl.put.poznan.transformer.rest.*"%>
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
    <h2>DODAWANIE POMIESZCZENIA</h2>
    <form id="myform" method="POST">
        <h3>Wybierz budynek:</h3>
        <select name="building-id"class="field">
            <c:forEach items="${myBuildingList}" var="building">
                <option value="${building.getId()}">#${building.getId()} ${building.getName()} </option>
            </c:forEach >
        </select>
        <h3>Wybierz pietro:</h3>
        <select  name="level-id" class="field">
            <!-- TO DO: trzeba wybierac to, co zaznaczone wyzej -->
            <c:forEach items="${myBuildingList.get(0).getLevels()}" var="level">
                <option value="${level.getId()}">#${level.getId()} ${level.getName()}</option>
            </c:forEach >
        </select>
        <h3>ID pomieszczenia:</h3>
        <input type="text" name="room-id" class="field">
        <h3>Nazwa pomieszczenia:</h3>
        <input type="text" name="room-name" class="field">
        <h3>Dlugosc (x):</h3>
        <input type="text" name="room-x" class="field">
        <h3>Szerokosc (y):</h3>
        <input type="text" name="room-y" class="field">
        <h3>Wysokosc (z):</h3>
        <input type="text" name="room-z" class="field">
        <h3>Liczba zarowek:</h3>
        <input type="text" name="room-bulb-count" class="field">
        <h3>Moc zarowek:</h3>
        <input type="text" name="room-bulb-power" class="field">
        <br>
        <input type="submit" id="send" value="Dodaj">
    </form>

    <% if (request.getParameter("level-id") != null){
        int levelId=Integer.parseInt(request.getParameter("level-id"));
        int roomId=Integer.parseInt(request.getParameter("room-id"));
        String roomName=request.getParameter("room-name");
        // TO DO: zmienic na float
        int x=Integer.parseInt(request.getParameter("room-x"));
        int y=Integer.parseInt(request.getParameter("room-y"));
        int z=Integer.parseInt(request.getParameter("room-z"));
        int bulbCount=Integer.parseInt(request.getParameter("room-bulb-count"));
        int bulbPower=Integer.parseInt(request.getParameter("room-bulb-power"));
        new Room(roomId, roomName, x, y, z, bulbCount, bulbPower, TextTransformerController.findLevelById(levelId));
        System.out.println("Pomieszczenie wprowadzone poprawnie"); %>
    <h2 id="complete"> Dodano poprawnie </h2>
    <%} %>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="../js/javascript.js"></script>
</body>
</html>