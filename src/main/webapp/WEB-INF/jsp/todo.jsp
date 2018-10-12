<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>

<head>
<title>First Web Application</title>

<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>
	ADD Todo Page for ${name}

	<form:form method="post" modelAttribute="todo">
		<form:hidden path="id" />
		<fieldset class="form-group">
			<form:label path="desc">Description</form:label>
			<form:input path="desc" type="text" value="${todo.desc}"
				class="form-control" required="required" />
			<form:errors path="desc" cssClass="text-warning" />
		</fieldset>


		<fieldset class="form-group">
			<form:label path="targetDate">Date</form:label>
			<form:input path="targetDate" type="text" value="${todo.targetDate}"
				class="form-control" required="required" />
			<form:errors path="targetDate" cssClass="text-warning" />
		</fieldset>




		<button type="submit" class="btn btn-success">Add</button>

	</form:form>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script
		src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
	<script>
		$('#targetDate').datepicker({
			format : 'mm/dd/yyyy'
		});
	</script>


</body>

</html>