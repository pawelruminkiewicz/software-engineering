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
    <form id="myform">
        <h3>Wybierz budynek:</h3>
        <select name="building"class="field">
            <c:forEach items="${myBuildingList}" var="building">
                <option value="${building.getId()}">#${building.getId()} ${building.getName()} </option>
            </c:forEach >
        </select>
        <h3>Wybierz pietro:</h3>
        <select  name="level" class="field">
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
        <input type="text" name="room-bulp-count" class="field">
        <h3>Moc zarowek:</h3>
        <input type="text" name="room-bulp-power" class="field">
        <br>
        <input type="submit" id="send" value="Dodaj">
    </form>
    <script src="../js/javascript.js"></script>
</body>
</html>