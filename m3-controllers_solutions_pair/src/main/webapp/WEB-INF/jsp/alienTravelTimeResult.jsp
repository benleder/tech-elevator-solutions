<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<c:import url="/WEB-INF/jsp/common/header.jsp" />

<div id="main-content">
	<section id="calculatorResult" class="centeredPanel">    
	    	<c:url value="/img/${fn:toLowerCase(planetName)}.jpg" var="planetSrc" />
    		<img src="${planetSrc}" alt="Image of ${planetName}" />
    		<h2>It will take approximately ${alienTravelTime} years to travel from Earth to ${planetName} by ${modeName}. You will be ${yourAge} years old when you arrive.</h2>
	</section>
</div>


<c:import url="/WEB-INF/jsp/common/footer.jsp" />
