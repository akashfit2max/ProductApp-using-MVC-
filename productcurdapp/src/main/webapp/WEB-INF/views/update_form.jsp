<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">Change the Product detail</h1>
				<form action="${pageContext.request.contextPath }/handel-product" method="post">

					<input type="hidden" value="${product.id }" name="id">

					<div class="form-group mb-3">
						<label for="name">Product Name</label> <input type="text" class="form-control" id="name" name="name"
							value="${product.name }" placeholder="Enter the product name here">
					</div>

					<div class="form-group mb-3">
						<label for="description">Product Description</label>
						<textarea class="form-control" name="description" id="description" rows="5"
							placeholder="Enter the product description">${product.description }</textarea>
					</div>

					<div class="form-group mb-3">
						<label for="price">Product Price</label> <input type="text" class="form-control" id="price" name="price"
							placeholder="Enter the product price here" value="${product.price }">
					</div>

					<div class="container text-center">
						<a href="${pageContext.request.contextPath }/" class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn btn-primary">Update</button>
					</div>

				</form>
			</div>
		</div>
	</div>
</body>
</html>