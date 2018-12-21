<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Product Detail View" />
</c:import>

    <section id="main-content">
		 <div class="toy-detail">
			<div class="toy">
				<c:url var="productImageUrl" value="/img/${product.imageName}" />
				<img class="product-image" src="${productImageUrl}" />
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
                     
                     <fmt:formatNumber var="expiry" value="${product.averageRating}" maxFractionDigits="0" />
					 <c:url var="starPath" value="img/${expiry}-star.png" />
					 <img class="rating" src="${starPath}" />
					 
					 <p class="price">Price: <fmt:formatNumber value="${product.price}" type="currency"/></p>
                     <p class="weight"><span class="bold">Weight</span> ${product.weightInLbs} lbs</p>
                     
                      <p class="description"><span class="bold">Description:</span> ${product.description}</p>
				</div>
			</div>	 
		 </div>
	</section>
	
<c:import url="/WEB-INF/jsp/common/footer.jsp" />