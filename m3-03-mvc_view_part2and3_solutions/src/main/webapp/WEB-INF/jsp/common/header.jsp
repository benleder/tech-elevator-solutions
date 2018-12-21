<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
    <meta name="viewport" content="width=device-width" />
    <title><c:out value="${param.pageTitle }" /></title>
    <c:url var="sitesCssUrl" value="/css/site.css" />
    <link rel="stylesheet" type="text/css" href="${sitesCssUrl}" />
</head>
<body>
    <header>
        <h1>MVC Exercises - Views Part 2: Models</h1>        
    </header>
    <nav>
        <ul>
        	<c:url var="listLayoutUrl" value="/productList" />
        	<c:url var="tileLayoutUrl" value="/productTiles" />
        	<c:url var="tableLayoutUrl" value="/productTable" />
        	<li><a href="${tileLayoutUrl}">Tile Layout</a></li>
            <li><a href="${listLayoutUrl}">List Layout</a></li>
            <li><a href="${tableLayoutUrl}">Table Layout</a></li>
        </ul>
        
    </nav>