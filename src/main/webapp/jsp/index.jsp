<%@ page import="java.util.ArrayList" %>
<%@ page import="pl.put.poznan.transformer.logic.Room" %>
<%@ page import="pl.put.poznan.transformer.logic.Level" %>
<%@ page import="pl.put.poznan.transformer.logic.Building" %>

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
		<a href="/addbuilding" class="button">Add building</a>
		<a href="/addlevel" class="button">Add level</a>
		<a href="/addroom" class="button">Add room</a>
	</div>
	<h2>Dynamic Content:</h2>
	<%
		Building myBuilding = new Building(66,"foo");
		Level myLevel = new Level(33, "bar", myBuilding);
		ArrayList<Room> myRooms = new ArrayList<Room>();
		myRooms.add(new Room(1,"Denali",1,2,3,4,5, myLevel));
		myRooms.add(new Room(2,"Annapurna",6,7,8,9,10, myLevel));
		myRooms.add(new Room(3,"Elbrus",15,14,13,12,11, myLevel));
		myRooms.add(new Room(4,"Kilimanjaro",16,17,18,19,20, myLevel));
		for (Room xxx : myRooms ) {
	%>
	<h3> X: <%= xxx.getX()  %>  Moc:  <%= xxx.getBulbPower()  %></h3>
	<%
		}
	%>
	<script src=”js/javascript.js”></script>
</body>
</html>