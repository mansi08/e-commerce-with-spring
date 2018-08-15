<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="templates/navbar.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:forEach items="${productList}" var="product">
		<div class="row">
			<div class="col-sm-6 col-md-4">
				<div class="thumbnail">
					<h4>
						<span data-toggle="tooltip" title="Bootstrap version">
							${product.productName }&nbsp; Rs. ${product.productPrice } </span>
					</h4>
					<img
						src="<c:url value="/resources/images/product/${product.code}.jpg"/>"
						height="250" width="200" alt="Image not supported" /> <a
						href="<c:url value="/totalProductInfo/${product.productId}"/>"
						class="btn btn-primary col-xs-12" role="button">Click To Large</a>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</c:forEach>
</body>
</html>