<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<section class="centeredPanel">

	<H2>Product Detail</H2>

	<div class="product">
		<div class="product-data">
			<c:url value="/img/${product.imageName}" var="productImageUrl"/>
			<img src="${productImageUrl}"/>
			<p class="title">${product.name}</p>
			<p class="price"><fmt:formatNumber type = "number" maxFractionDigits = "2" value = "${product.price}" /></p>
			<p class="description">${product.description}</p>
			<c:url value="/shoppingCart" var="shoppingCartUrl"/>
			<form action="${shoppingCartUrl}" method="POST">
				<input type="hidden" name="id" value="${product.id}">
				<label for="name">Quantity</label>
				<input type="text" name="quantity">
				<button>Add to Cart</button>
			</form>
		</div>
	</div>
 
 </section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
