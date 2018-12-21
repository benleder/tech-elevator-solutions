<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:set var="pageTitle" value="Todo List - Edit ${taskList.name}"/>

<%@include file="common/header.jspf"%>

<c:url value="/new" var="newListUrl"/>
<form:form action="${newListUrl}" method="POST" modelAttribute="taskList">
	<form:hidden path="id"/>
	<div class="form-group">
       		<form:label path="name">List Name</form:label>
       		<form:input path="name" class="form-control"/>
       		<form:errors path="name" cssClass="error"/>
       		
       </div>

<h2>Tasks</h2>

	<c:forEach items="${ taskList.todos}" varStatus="loopStatus" var="todo">
	<div class="form-group">
       		<form:input path="todos[${loopStatus.index }].task" class="form-control"/>
       		<form:errors path="todos[${loopStatus.index }].task" cssClass="error"/>
       		
       </div>
       </c:forEach>
       <c:set var="startingNewIndex" value="${taskList.todos.size()}" />
       	<div class="form-group">
       		<form:input path="todos[${startingNewIndex }].task" class="form-control"/>
       		<form:errors path="todos[${startingNewIndex }].task" cssClass="error"/>
       		
       </div>
       	<div class="form-group">
       		<form:input path="todos[${startingNewIndex + 1}].task" class="form-control"/>
       		<form:errors path="todos[${startingNewIndex + 1}].task" cssClass="error"/>
       		
       </div>
       	<div class="form-group">
       		<form:input path="todos[${startingNewIndex + 2}].task" class="form-control"/>
       		<form:errors path="todos[${startingNewIndex + 2}].task" cssClass="error"/>
       		
       </div>
       	<div class="form-group">
       		<form:input path="todos[${startingNewIndex + 3}].task" class="form-control"/>
       		<form:errors path="todos[${startingNewIndex + 3}].task" cssClass="error"/>
       		
       </div>
       <input type="submit" value="Update List" class="btn btn-primary"/>
</form:form>

<%@include file="common/footer.jspf"%>