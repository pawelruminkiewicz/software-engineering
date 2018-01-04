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
		<select class="field">
			<!-- tutaj dynamicznie generowac HTML z danych serwera -->
			<option value="x">Nazwa budynku 1</option>
			<option value="y">Nazwa budynku 2</option>
			<option value="z">Nazwa budynku 3</option>
		</select>
		<h3>ID poziomu:</h3>
		<input type="text" name="level-id" class="field">
		<h3>Nazwa poziomu:</h3>
		<input type="text" name="level-name" class="field">
		<br>
		<input type="submit" id="send" value="Dodaj">
	</form>
	<script src=”js/javascript.js”></script>
</body>
</html>