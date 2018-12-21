<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Product Tile View" />
</c:import>

    <section id="main-content">
		<h2>Toy Department</h2>
		 <div class="tile-list">
		 	
		 	<c:forEach var="product" items="${productList}">
		 		<div class="toy">
			 		<c:url var="productImageUrl" value="/img/${product.imageName}" />
			 		<c:url var="productDetailUrl" value="/productDetail" >
			 			<c:param name="productId" value="${product.productId}" />
			 		</c:url>
			 		<a href="${productDetailUrl}"><img class="product-image" src="${productImageUrl}" /></a>
				    <div class="details">
	                     <h3>
	                         ${product.name}
	                         <c:if test="${product.topSeller}">
	                             <span class="best-seller">BEST SELLER!</span>
	                         </c:if>
	                     </h3>
	                     <p class="manufacturer">by ${product.manufacturer}</p>
	                     <c:if test="product.remainingStock < 5" >
	                         <p class="alert-remaining">Only ${product.remainingStock} left!</p>
	                     </c:if>
	                     <p class="price"><fmt:formatNumber value="${product.price}" type="currency"/></p>
	                     <p class="weight"><span class="bold">Weight</span> ${product.weightInLbs} lbs</p>
	                     
						<fmt:formatNumber var="expiry" value="${product.averageRating}" maxFractionDigits="0" />
						<c:url var="starPath" value="img/${expiry}-star.png" />
						<img class="rating" src="${starPath}" />
	                  </div>
		 		</div>
		 	</c:forEach>
		 
		 
		 </div>
	</section>
	
<c:import url="/WEB-INF/jsp/common/footer.jsp" />