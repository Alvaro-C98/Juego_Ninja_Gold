<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Ninja Gold</title>
</head>
<body>
	<div class="container p-2">
		<div class="row">
			<div class="col">
				<h1>Ninja Gold</h1>
			</div>
			<a class="col text-right" href="/reset"><button class="btn btn-secondary">Reset</button></a>
		</div>
		<p>
			Your Gold: <span class="text-succcess"><c:out value="${gold}" /></span>
		</p>
		<div class="row">
			<div class="card col mx-2">
				<form action="/gold" method="post">
					<h2>Farm</h2>
					<p>(earns 10-20 gold)</p>
					<input type="hidden" name="site" value="farm" />
					<button type="submit" class="btn-info w-50">Find Gold!</button>
				</form>
			</div>
			<div class="card col mx-2">
				<form action="/gold" method="post">
					<h2>Cave</h2>
					<p>(earns 5-10 gold)</p>
					<input type="hidden" name="site" value="cave" />
					<button type="submit" class="btn-info w-50">Find Gold!</button>
				</form>
			</div>
			<div class="card col mx-2">
				<form action="/gold" method="post">
					<h2>House</h2>
					<p>(earns 2-5 gold)</p>
					<input type="hidden" name="site" value="house" />
					<button type="submit" class="btn-info w-50">Find Gold!</button>
				</form>
			</div>
			<div class="card col mx-2">
				<form action="/gold" method="post">
					<h2>Casino!</h2>
					<p>(earns/takes 0-50 gold)</p>
					<input type="hidden" name="site" value="casino" />
					<button type="submit" class="btn-info w-50">Find Gold!</button>
				</form>
			</div>
		</div>
		<div class="row">
			<h4 class="col mt-4">Activities:</h4>
		</div>
			<div class="scroll">
				<c:forEach items="${activity}" var="activities">
				<c:choose>
					<c:when test="${activities.contains('earned')}">
						<p class="text-success"><c:out value="${activities}" /></p>
					</c:when>
					<c:otherwise>
						<p class="text-danger"><c:out value="${activities}" /></p>
					</c:otherwise>
				</c:choose>
				</c:forEach>
			</div>
		</div>
</body>
</html>