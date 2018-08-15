<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="templates/navbar.jsp"%>

<h1>Product</h1>
<hr />

<!-- TOGGLE BUTTONS -->
<c:if test="${UserClickedEdit==true }">
	<c:set var="url" value="UpdateProrduct" />
</c:if>

<c:if test="${UserClickedEdit!=true }">
	<c:set var="url" value="SaveProduct" />
</c:if>

<!--  FORM FOR ENTERING DETAILS -->
<form:form action="${pageContext.request.contextPath}/${url }"
	method="post" enctype="multipart/form-data" modelAttribute="product">

	<!-- HIDDING PRODUCT ID SO NO ONE CAN EDIT -->
	<c:if test="${UserClickedEdit==true}">
		<form:hidden path="productId" />
	</c:if>

	PRODUCT NAME: <form:input path="productName" placeholder="ProductName" /> <br/> <br/>
	PRODUCT DESCRIPTION <form:input path="productDescription" placeholder="productDescription" /> <br/> <br/>
	PRODUCT PRICE: <form:input path="productPrice" placeholder="productPrice" /> <br/><br/>
	COLOUR: <form:input path="colour" placeholder="Colour" /> <br/><br/>
	SIZE: <form:input path="size" placeholder="Size" /> <br/><br/>
	STOCK: <form:input path="stock" placeholder="Stock" /> <br/><br/>
	CATEGORY ID: <form:select path="categoryId" items="${categoryList}" itemLabel="categoryName" itemValue="categoryId" /> <br/><br/>
	SUPPLIER ID: <form:select path="supplierId" items="${supplierList}" itemLabel="supplierName" itemValue="supplierId" /> <br/><br/>
	IMAGE: <form:input path="file" type="file" /> <br/>
	
	<!-- Button -->
	<c:if test="${UserClickedEdit==true}">
		<input type="submit" value="Update Product" />
	</c:if>

	<c:if test="${UserClickedEdit!=true}">
		<input type="submit" value="Save Product" />
	</c:if>
</form:form>

<!-- DISPLAYING THE CONTENT -->

<table align="center">
	<thead>
		<tr>
			<th>ID</th>
			<th>IMAGE</th>
			<th>NAME</th>
			<th>DESCRIPTION</th>
			<th>PRICE</th>
			<th>COLOUR</th>
			<th>SIZE</th>
			<th>STOCK</th>
			<th>CATEGORY ID</th>
			<th>SUPPLIER ID</th>
			<th>ACTION</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach items="${productList}" var="product">
			<tr>
				<td>${product.productId}</td>
				<td><img src="resources/images/product/${product.code}.jpg"
							height="500px" width="300px" /></td>
				<td>${product.productName}</td>
				<td>${product.productDescription}</td>
				<td>${product.productPrice}</td>
				<td>${product.colour}</td>
				<td>${product.size}</td>
				<td>${product.stock}</td>
				<td>${product.categoryId}</td>
				<td>${product.supplierId}</td>
				<td><a
					href="${pageContext.request.contextPath}/editProduct/${product.productId}">Edit</a>
					<a
					href="${pageContext.request.contextPath}/deleteProduct/${product.productId}">Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>