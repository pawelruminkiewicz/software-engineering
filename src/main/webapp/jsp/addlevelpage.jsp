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
	<h2>DODAWANIE POZIOMU</h2>
	<form id="myform">
		<h3>Wybierz budynek:</h3>
		<select name="building" class="field">
			<c:forEach items="${myBuildingList}" var="building">
				<option value="${building.getId()}">#${building.getId()} ${building.getName()}</option>
			</c:forEach >
			<option value="1" ${item.quantity == 1 ? "selected" : ""}>1</option>

		</select>


		<h3>ID poziomu:</h3>
		<input type="text" name="level-id" class="field">
		<h3>Nazwa poziomu:</h3>
		<input type="text" name="level-name" class="field">
		<br>
		<input type="submit" id="send" value="Dodaj">
	</form>
	<script src="../js/javascript.js"></script>
</body>
</html>