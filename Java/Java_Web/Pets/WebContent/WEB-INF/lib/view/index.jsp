<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create A Pet</title>
</head>
<body>

	<form action="/Pets/Dogs">
		<h1>Create a Dog</h1>
		<label>Name:</label>
		<input type="text" name="name">
		<label>Breed:</label>
		<input type="text" name="breed">
		<label>Weight:</label>
		<input type="text" name="weight">
		<button type="submit">Create a Dog</button>
	</form>
	
	<form action="/Pets/Cats">
		<h1>Create a Cat</h1>
		<label>Name:</label>
		<input type="text" name="name">
		<label>Breed:</label>
		<input type="text" name="breed">
		<label>Weight:</label>
		<input type="text" name="weight">
		<button type="submit">Create a Cat</button>
	</form>
</body>
</html>