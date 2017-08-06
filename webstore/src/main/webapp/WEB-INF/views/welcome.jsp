<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Hello</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>${greeting}</h1>
				<p>${info}</p>
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
				<div class="thumbnail">
					<div class="caption">
						<h3>Books</h3>
						<p>Display all books</p>
						<p>
							<a href="/webstore/books" class="btn btn-default"> <span
								class="glyphicon-info-sign glyphicon" /></span> Show all books
							</a>
						</p>
					</div>
				</div>
				
			</div>
		</div>
	</section>
	<section class="container">
		<div class="row">
			<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
				<div class="thumbnail">
					<div class="caption">
						<h3>Search</h3>
						<p>Find book</p>
						<p>
							<a href="/webstore/books/search" class="btn btn-default"> <span
								class="glyphicon-info-sign glyphicon" /></span> Search book
							</a>
						</p>
					</div>
				</div>
			</div>
		</div>				
        		<a href="/webstore/logout" class="btn btn-info btn-lg">
         		 <span class="glyphicon glyphicon-log-out"></span> Log out
       			</a>    			
	</section>
</body>
</html>
