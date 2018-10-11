<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>

<head>
<title>First Web Application</title>

<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
	ADD Todo Page for ${name}

	<form:form method="post" action="add-todo" modelAttribute="todo">


		<fieldset class="form-group">
			<form:label path="desc">Description</form:label>
			<form:input path="desc" name="desc" type="text" value="${todo.desc}" class="form-control"
				required="required" />
			<form:errors path="desc" cssClass="text-warning" />
		</fieldset>
		<button type="submit" class="btn btn-success">Add</button>
	</form:form>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>