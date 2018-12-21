<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section class="centeredPanel">

	<H2>Space Store</H2>

	<c:url value="/shoppingCart" var="shoppingCartUrl"/>
	<a href="${shoppingCartUrl}">View Shopping Cart</a>

	<div class="products">
		<c:forEach var="product" items="${products}">
			<div class="product">
				<div class="product-image">
					<c:url value="/productDetail?id=${product.id}" var="productDetailUrl"/>
					<c:url value="/img/${product.imageName}" var="productImageUrl"/>
					<a href="${productDetailUrl}">
						<img src="${productImageUrl}"/>
					</a>
				</div>
				<div class="product-data">
					<p class="title">${product.name}</p>
					<p class="price"><fmt:formatNumber type = "number" maxFractionDigits = "2" value = "${product.price}" /></p>
				</div>
			</div>
		</c:forEach>
	</div>
 
 </section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
