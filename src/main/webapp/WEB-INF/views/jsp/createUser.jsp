<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>Spring MVC. CreateUser</title>
<style>.error {	color: red;}</style>
</head>
<body>
	<h1>Crear un usuario</h1>
	<form:form action="create-user" modelAttribute="user">
		<p>Id:
			<form:input path="id" placeholder="Id" required="required" />
			<form:errors path="id" cssClass="error" />
		</p>
		<p>UserName:
			<form:input path="username" placeholder="UserName" required="required" />
			<form:errors path="username" cssClass="error" />
		</p>
		<p>Email:
			<form:input path="email" placeholder="Email" required="required" />
		</p>
		<p>Password:
			<form:password path="password" placeholder="Password" required="required" showPassword="true" />
		</p>
		<p>birthDate:
			<form:input path="birthdate" placeholder="BirthDate" required="required" />
		</p>
		<p><input type="submit" value="Crear"></p>
	</form:form>

	<a href="<c:url value="/home"/>">Home</a>

	<p>UPM-MIW --- ${now}</p>

</body>
</html>