<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pacientes</title>
</head>
<body>
	<h3 class="text-center">Listado de Pacientes</h3>
	<table>
		<jsp:useBean id="pDao" class="co.primerprevio.dao.PacienteDao"
			scope="request">
		</jsp:useBean>
		<div class="container text-left">
			<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Agregar
				Nuevo Paciente</a>
		</div>
		</div>
		<tr>
			<th>Id</th>
			<th>Documento</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Email</th>
			<th>Genero</th>
			<th>Fecha de Nacimiento</th>
			<th>Telefono</th>
			<th>Direccion</th>
			<th>Peso</th>
			<th>Estatura</th>
			<th>IMC</th>
		</tr>
		<c:forEach var="listPacientes" items="${listPacientes}">
			<tr>
				<td><c:out value="${paciente.id}" /></td>
				<td><c:out value="${paciente.documento}" /></td>
				<td><c:out value="${paciente.nombre}" /></td>
				<td><c:out value="${paciente.apellido}" /></td>
				<td><c:out value="${paciente.email}" /></td>
				<td><c:out value="${paciente.genero}" /></td>
				<td><c:out value="${paciente.fechanacimiento}" /></td>
				<td><c:out value="${paciente.telefono}" /></td>
				<td><c:out value="${paciente.direccion}" /></td>
				<td><c:out value="${paciente.peso}" /></td>
				<td><c:out value="${paciente.estatura}" /></td>
				<td><a href="edit?id=<c:out value='${paciente.id}' />">Editar</a>
					&nbsp;&nbsp;&nbsp;&nbsp; <a
					href="delete?id=<c:out value='${paciente.id}' />">Elimnar</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>