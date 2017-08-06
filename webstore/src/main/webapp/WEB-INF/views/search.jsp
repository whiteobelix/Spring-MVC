<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Add Book</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Search</h1> <%--tytuł duzy na stronie search --%>
				<p>Find book</p> <%--tytuł mały na stronie search --%>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form modelAttribute="search" class="form-horizontal">
			<fieldset>
				<legend>Type author name or book title for book searching</legend>

				<!-- Sample template for some fields in Book Entity -->
				<div class="form-group"> <%--Pole wyszukiwania po TYTULE --%>
					<label class="control-label col-lg-2" for="name">Title</label>
					<div class="col-lg-10">
						<form:input id="title" path="title" type="text"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group"> 								<%--Pole wyszukiwania po AUTORZE --%>
					<label class="control-label col-lg-2" for="name">Author</label>
					<div class="col-lg-10">
						<form:input id="authors" path="authors" type="text"   		
							class="form:input-large" /> <%--Pole zwraca id="authors" --%>
					</div>
				</div>
			</fieldset>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class="btn btn-primary"
						value="Search" /> <%--Napis na przycisku, wykonuje SUBMIT, czyli POST'uje --%>
				</div>
			</div>
		</form:form>
		<p>
					<a href="<spring:url value="/"/>" class="btn btn-default">
						<span class="glyphicon-hand-left glyphicon"></span> back
					</a>
		</p>
		<a href="/webstore/logout" class="btn btn-info btn-lg">
        <span class="glyphicon glyphicon-log-out"></span> Log out
       	</a>
	</section>
</body>
</html>
