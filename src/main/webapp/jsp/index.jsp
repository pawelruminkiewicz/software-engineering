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
	<c:forEach items="${myBuildingList}" var="building">
		<div class="div-building">#${building.getId()} ${building.getName()}
			<c:forEach items="${building.getLevels()}" var="level">
				<div class="div-level">#${level.getId()} ${level.getName()}
					<c:forEach items="${level.getRooms()}" var="room">
						<div class="div-room">#${room.getId()} ${room.getName()}</div>
					</c:forEach >
				</div>
			</c:forEach >
		</div>
	</c:forEach >
	<script src="../js/javascript.js"></script>
</body>
</html>