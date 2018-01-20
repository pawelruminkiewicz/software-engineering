<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<div class="div-table">
		<div class="div-row">
			<div class="div-header">Location</div>
			<div class="div-header">Area</div>
			<div class="div-header">Cube</div>
			<div class="div-header">Light</div>
			<div class="div-header">Heating</div>
		</div>
		<c:forEach items="${myBuildingList}" var="building">
			<div class="div-building"> <div class="div-row"> <div class="div-data">#${building.getId()} ${building.getName()} </div> <div class="div-data"> ${building.getArea()} </div> <div class="div-data"> ${building.getCube()} </div> <div class="div-data"> ${building.getLight()}</div> <div class="div-data"> ${building.getHeating()}</div> </div>
				<c:forEach items="${building.getLevels()}" var="level">
					<div class="div-level"> <div class="div-row"> <div class="div-data"> #${level.getId()} ${level.getName()} </div> <div class="div-data"> ${level.getArea()} </div> <div class="div-data"> ${level.getCube()} </div> <div class="div-data"> ${level.getLight()}</div> <div class="div-data"> ${level.getHeating()}</div> </div>
						<c:forEach items="${level.getRooms()}" var="room">
							<div class="div-room"> <div class="div-row"> <div class="div-data">#${room.getId()} ${room.getName()} </div> <div class="div-data"> ${room.getArea()} </div> <div class="div-data"> ${room.getCube()} </div> <div class="div-data"> ${room.getLight()}</div> <div class="div-data"> ${room.getHeating()}</div> </div> </div>
						</c:forEach >
					</div>
				</c:forEach >
			</div>
		</c:forEach >
	</div>
</body>
</html>