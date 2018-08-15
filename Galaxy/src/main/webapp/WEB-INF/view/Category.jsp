<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="templates/navbar.jsp"%>

<h1>Category</h1>
<hr />

<!-- SIR METHOD -->
<%-- <form action="" method="post">
		<table><tr><td>Category Name</td><td><input type="text" name="cname" /></tr>
		<tr><td>Category Description</td><td><input type="text" name="cdesc" />
		</tr><tr><td><input type="submit" value="submit" /></tr></table></form>
<table><tr><td>Category Id</td><td>Category Name</td><td>Category Description</td></tr></table>
<c:forEach items="${categoryList}" var="category"><tr><td>${category.categoryId}</td><td>${category.categoryName}</td>
<td>${category.categoryDesc}</td></tr></c:forEach> --%>

<!-- TOGGLE BUTTONS -->
<c:if test="${UserClickedEdit==true }">
	<c:set var="url" value="UpdateCategory" />
</c:if>

<c:if test="${UserClickedEdit!=true }">
	<c:set var="url" value="SaveCategory" />
</c:if>

<!--  FORM FOR ENTERING DETAILS -->
<form:form action="${pageContext.request.contextPath}/${url }"
	method="post" modelAttribute="category">

	<!-- HIDDING CATEGORY ID SO NO ONE CAN EDIT -->
	<c:if test="${UserClickedEdit==true}">
		<form:hidden path="categoryId" />
	</c:if>

	<form:input path="categoryName" placeholder="CategoryName" />
	<form:input path="categoryDesc" placeholder="CategoryDescription" />

	<!-- Button -->
	<c:if test="${UserClickedEdit==true}">
		<input type="submit" value="Update Category" />
	</c:if>

	<c:if test="${UserClickedEdit!=true}">
		<input type="submit" value="Save Category" />
	</c:if>
</form:form>

<!-- DISPLAYING THE CONTENT -->

<table align="center">
	<thead>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>DESCRIPTION</th>
			<th>ACTION</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach items="${categoryList}" var="category">
			<tr>
				<td>${category.categoryId}</td>
				<td>${category.categoryName}</td>
				<td>${category.categoryDesc}</td>
				<td><a
					href="${pageContext.request.contextPath}/editCategory/${category.categoryId}">Edit</a>
					<a
					href="${pageContext.request.contextPath}/deleteCategory/${category.categoryId}">Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>