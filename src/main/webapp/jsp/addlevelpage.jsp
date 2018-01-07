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
		<a href="/addlevel" class="button selected">Add level</a>
		<a href="/addroom" class="button">Add room</a>
	</div>
	<h2 id="title">Adding a level</h2>
	<form id="myform" method="POST">
		<h3>Select building:</h3>
		<select name="building-id" class="field">
			<c:forEach items="${myBuildingList}" var="building">
				<option value="${building.getId()}">#${building.getId()} ${building.getName()}</option>
			</c:forEach >
		</select>
		<h3>Level ID:</h3>
		<input type="text" name="level-id" class="field" pattern="\d*" title="Cyfry" required>
		<h3>Level name:</h3>
		<input type="text" name="level-name" class="field" pattern="[a-zA-Z\s]*" title="Litery" required>
		<br>
		<input type="submit" id="send" value="Add">
	</form>

	<% if (request.getParameter("building-id") != null){
		int buildingId=Integer.parseInt(request.getParameter("building-id"));
		int levelId=Integer.parseInt(request.getParameter("level-id"));
		String levelName=request.getParameter("level-name");
		System.out.println("Level inserted correctly");
		new Level(levelId, levelName, TextTransformerApplication.findBuildingById(buildingId)); %>
	<h2 id="complete"> Added correctly </h2>
	<%} %>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="../js/javascript.js"></script>
</body>
</html>