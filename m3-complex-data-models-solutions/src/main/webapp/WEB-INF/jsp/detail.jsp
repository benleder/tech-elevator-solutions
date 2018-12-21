<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="pageTitle" value="Todo List - ${list.name }"/>

<%@include file="common/header.jspf"%>
<h3>Name:</h3>
<c:out value="${list.name }"/>

<h3>Tasks:</h3>
<table class="table">
<c:forEach var="todo" items="${list.todos }">
<tr>
<td><c:out value="${todo.task }"/></td>
</tr>
</c:forEach>
</table>
<a href="<c:url value="/edit?taskListId=${list.id}"/>">Edit Todo List</a>
<a href="<c:url value="/"/>">Back to All Task Lists</a>
<%@include file="common/footer.jspf"%>