<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="templates/navbar.jsp"%>

<h1>Supplier</h1>
<hr />

<!-- TOGGLE BUTTONS -->
<c:if test="${UserClickedEdit==true }">
	<c:set var="url" value="UpdateSupplier" />
</c:if>

<c:if test="${UserClickedEdit!=true }">
	<c:set var="url" value="SaveSupplier" />
</c:if>

<!--  FORM FOR ENTERING DETAILS -->
<form:form action="${pageContext.request.contextPath}/${url }"
	method="post" modelAttribute="supplier">

	<!-- HIDDING supplier SO NO ONE CAN EDIT -->
	<c:if test="${UserClickedEdit==true}">
		<form:hidden path="supplierId" />
	</c:if>

	<form:input path="supplierName" placeholder="SupplierName" />
	<form:input path="panNo" placeholder="panNo" />
	<form:input path="aadharNo" placeholder="aadharNo" />
	<form:input path="email" placeholder="email" />
	<form:input path="mobile" placeholder="mobile" />
	<form:input path="gstinNo" placeholder="gstin_No" />
	<form:input path="supplierCompanyName" placeholder="supplierCompanyName" />
	<form:input path="quantity" placeholder="quantity" />
	<!-- Button -->
	<c:if test="${UserClickedEdit==true}">
		<input type="submit" value="Update supplier" />
	</c:if>

	<c:if test="${UserClickedEdit!=true}">
		<input type="submit" value="Save supplier" />
	</c:if>
</form:form>

<!-- DISPLAYING THE CONTENT -->

<table align="center">
	<thead>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>PAN NO</th>
			<th>AADHAR NO</th>
			<th>EMAIL</th>
			<th>MOBILE</th>
			<th>GSTIN NO</th>
			<th>SUPPIER COMPANY NAME</th>
			<th>QUANTITY</th>
			<th>ACTION</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach items="${supplierList}" var="supplier">
			<tr>
				<td>${supplier.supplierId}</td>
				<td>${supplier.supplierName}</td>
				<td>${supplier.panNo}</td>
				<td>${supplier.aadharNo}</td>
				<td>${supplier.email}</td>
				<td>${supplier.mobile}</td>
				<td>${supplier.gstinNo}</td>
				<td>${supplier.supplierCompanyName}</td>
				<td>${supplier.quantity}</td>
				<td><a
					href="${pageContext.request.contextPath}/editSupplier/${supplier.supplierId}">Edit</a>
					<a
					href="${pageContext.request.contextPath}/deleteSupplier/${supplier.supplierId}">Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>

</body>
</html>