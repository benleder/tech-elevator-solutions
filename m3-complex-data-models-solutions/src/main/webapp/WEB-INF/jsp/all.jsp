<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="All Todo Lists"/>

<%@include file="common/header.jspf"%>
<table class="table">
<tr>
<th>Name</th>
</tr>
<c:forEach items="${lists}" var="list">
<tr>
<c:url var="listDetailUrl" value="/detail">
<c:param name="taskListId" value="${list.id}"/>
</c:url>
<td><a href="${listDetailUrl}"><c:out value="${list.name}"/></a></td>
</tr>
</c:forEach>
</table>
<c:url var="newListUrl" value="/new"/>
<a href="${newListUrl }">Add a Todo List</a>
<%@include file="common/footer.jspf"%>