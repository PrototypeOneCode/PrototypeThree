<%-- 
    Document   : customer-form.jsp
    Created on : 15 Feb 2024, 10:09:34
    Author     : End User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Customer Data Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="https://www.javaguides.net" class="navbar-brand"> Customer Data </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Customers</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${customer != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${customer == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${customer != null}">
            			Edit Customer
            		</c:if>
						<c:if test="${customer == null}">
            			Add New Customer
            		</c:if>
					</h2>
				</caption>

				<c:if test="${customer != null}">
					<input type="hidden" name="id" value="<c:out value='${customer.id}' />" />
				</c:if>
                                       
				<fieldset class="form-group">
					<label>Customer Name</label> <input type="text"
						value="<c:out value='${customer.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Customer Address</label> <input type="text"
						value="<c:out value='${customer.address}' />" class="form-control"
						name="address">
				</fieldset>

				<fieldset class="form-group">
					<label>Customer Date</label> <input type="text"
						value="<c:out value='${customer.date}' />" class="form-control"
						name="date">
				</fieldset>
                                                
                                <fieldset class="form-group">
					<label>Customer Invoice Number</label> <input type="text"
						value="<c:out value='${customer.invoiceNo}' />" class="form-control"
						name="invoiceNo">
				</fieldset>
                                                
                                <fieldset class="form-group">
					<label>Customer Invoice Description</label> <input type="text"
						value="<c:out value='${customer.description}' />" class="form-control"
						name="description">
				</fieldset>
                                                
                                <fieldset class="form-group">
					<label>Customer Invoice Total</label> <input type="text"
						value="<c:out value='${customer.invoiceTotal}' />" class="form-control"
						name="invoiceTotal">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>