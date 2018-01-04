<%@ page import="java.util.ArrayList" %>
<%@ page import="pl.put.poznan.transformer.logic.*" %>
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
    <h2>DODAWANIE BUDYNKU</h2>
    <form id="myform">
        <h3>ID budynku:</h3>
        <input type="text" name="building-id" class="field">
        <h3>Nazwa budynku:</h3>
        <input type="text" name="building-name" class="field">
        <br>
        <input type="submit" id="send" value="Dodaj">
    </form>
    <script src="../js/javascript.js"></script>
</body>
</html>