<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insertar Nuevo Paciente</title>
</head>
<body>
	<c:if test="${paciente != null}">
		<form action="update" method="post">
	</c:if>
	<c:if test="${paciente == null}">
		<form action="insert" method="post">
	</c:if>
	<caption>
		<h2>
			<c:if test="${paciente != null}">
            	Editar Paciente
            </c:if>
			<c:if test="${paciente == null}">
                Agregar Nuevo Paciente
            </c:if>
		</h2>
	</caption>
	<c:if test="${paciente != null}">
		<input type="hidden" name="id"
			value="<c:out value='${paciente.id}' />" />
	</c:if>

	<fieldset class="form-group">
		<label>Documento</label> <input type="text"
			value="<c:out value='${paciente.documento}' />" class="form-control"
			name="documento">
	</fieldset>

	<fieldset class="form-group">
		<label>Nombre de Paciente</label> <input type="text"
			value="<c:out value='${estudiante.nombre}' />" class="form-control"
			name="nombre" required="required">
	</fieldset>

	<fieldset class="form-group">
		<label>Apellido del Paciente</label> <input type="text"
			value="<c:out value='${paciente.apellido}' />" class="form-control"
			name="apellido">
	</fieldset>

	<fieldset class="form-group">
		<label>Email</label> <input type="text"
			value="<c:out value='${paciente.email}' />" class="form-control"
			name="email">
	</fieldset>

	<fieldset class="form-group">
		<label>Genero</label> <input type="text"
			value="<c:out value='${paciente.genero}' />" class="form-control"
			name="genero">
	</fieldset>

	<fieldset class="form-group">
		<label>Fecha de Nacimiento</label> <input type="date"
			value="<c:out value='${paciente.fechanacimiento}' />"
			class="form-control" name="fechanacimiento">
	</fieldset>

	<fieldset class="form-group">
		<label>Telefono</label> <input type="text"
			value="<c:out value='${paciente.telefono}' />" class="form-control"
			name="telefono">
	</fieldset>

	<fieldset class="form-group">
		<label>Direccion</label> <input type="text"
			value="<c:out value='${paciente.direccion}' />" class="form-control"
			name="direccion">
	</fieldset>

	<fieldset class="form-group">
		<label>Peso</label> <input type="text"
			value="<c:out value='${paciente.peso}' />" class="form-control"
			name="peso">
	</fieldset>

	<fieldset class="form-group">
		<label>Estatura</label> <input type="text"
			value="<c:out value='${paciente.estatura}' />" class="form-control"
			name="estatura">
	</fieldset>

	<button type="submit" class="btn btn-success">Guardar</button>
</body>
</html>