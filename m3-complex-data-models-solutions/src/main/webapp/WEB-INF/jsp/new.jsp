<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:set var="pageTitle" value="Todo List - New"/>

<%@include file="common/header.jspf"%>

<c:url value="/new" var="newListUrl"/>
<form:form action="${newListUrl}" method="POST" modelAttribute="taskList">

	<div class="form-group">
       		<form:label path="name">List Name</form:label>
       		<form:input path="name" class="form-control"/>
       		<form:errors path="name" cssClass="error"/>
       		
       </div>

<h2>Tasks</h2>

	<div class="form-group">
       		<form:input path="todos[0].task" class="form-control"/>
       		<form:errors path="todos[0].task" cssClass="error"/>
       		
       </div>
       	<div class="form-group">
       		<form:input path="todos[1].task" class="form-control"/>
       		<form:errors path="todos[1].task" cssClass="error"/>
       		
       </div>
       	<div class="form-group">
       		<form:input path="todos[2].task" class="form-control"/>
       		<form:errors path="todos[2].task" cssClass="error"/>
       		
       </div>
       	<div class="form-group">
       		<form:input path="todos[3].task" class="form-control"/>
       		<form:errors path="todos[3].task" cssClass="error"/>
       		
       </div>
       	<div class="form-group">
       		<form:input path="todos[4].task" class="form-control"/>
       		<form:errors path="todos[4].task" cssClass="error"/>
       		
       </div>
       <input type="submit" value="Create List" class="btn btn-primary"/>
</form:form>

<%@include file="common/footer.jspf"%>