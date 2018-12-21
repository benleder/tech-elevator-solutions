<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Exercise 2 - Fibonacci 25</title>
		<style>
			li {
				list-style-type: none;
			}
		</style>
	</head>
	<body>
		<h1>Exercise 2 - Fibonacci 25</h1>
		<ul>
			<%--
				Add a list item (i.e. <li>) for each of the first 25 numbers in the Fibonacci sequence
				
				See exercise2-fibonacci.png for example output
			 --%>
			<c:set var="fib" value="1"/>
			<c:set var="prevFib" value="0"/>
			<c:forEach begin="1" end="25">
				<c:set var="temp" value="${fib}"/>
				<c:set var="fib" value="${prevFib+fib}"/>
				<c:set var="prevFib" value="${temp}"/>
				<li>${fib}</li>
			</c:forEach>
		</ul>
	</body>
</html>