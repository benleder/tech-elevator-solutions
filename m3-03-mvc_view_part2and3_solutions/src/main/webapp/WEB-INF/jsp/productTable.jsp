<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Product Table View" />
</c:import>

    <section id="main-content">
		<h2>Toy Department</h2>
 
        <table>
            <tr>
                <td></td>
                <c:forEach var="product" items="${productList}">
                	<c:url var="productImageUrl" value="/img/${product.imageName}" />
                	<c:url var="productDetailUrl" value="/productDetail" >
			 			<c:param name="productId" value="${product.productId}" />
			 		</c:url>
                    <td>
                        <a href="${productDetailUrl}"><img class="product-image" src="${productImageUrl}" /></a>
                         <c:if test="${product.topSeller}">
                             <span class="best-seller">BEST SELLER!</span>
                         </c:if>
                    </td>
                </c:forEach>
            </tr>
            <tr>
                <td>Name</td>
                <c:forEach var="product" items="${productList}">
                    <c:url var="productDetailUrl" value="/productDetail" >
			 			<c:param name="productId" value="${product.productId}" />
			 		</c:url>
                    <td>
                    	<a href="${productDetailUrl}">${product.name}</a>     
                    </td>
                </c:forEach>
            </tr>
            <tr>
                <td>Rating</td>
                <c:forEach var="product" items="${productList}">
                    <td>
                    	<fmt:formatNumber var="expiry" value="${product.averageRating}" maxFractionDigits="0" />
						<c:url var="starPath" value="img/${expiry}-star.png" />
						<img class="rating" src="${starPath}" />
                    </td>
                </c:forEach>
            </tr>
            <tr>
                <td>Mfr</td>
                <c:forEach var="product" items="${productList}">
                    <td>${product.manufacturer}</td>
                </c:forEach>
            </tr>
            <tr>
                <td>Price</td>
                <c:forEach var="product" items="${productList}">
                    <td class="price"><fmt:formatNumber value="${product.price}" type="currency"/></td>
                </c:forEach>
            </tr>
            <tr>
                <td>wt. (in lbs)</td>
                <c:forEach var="product" items="${productList}">
                    <td>${product.weightInLbs}</td>
                </c:forEach>
            </tr>
        </table>
                
	</section>
	
<c:import url="/WEB-INF/jsp/common/footer.jsp" />