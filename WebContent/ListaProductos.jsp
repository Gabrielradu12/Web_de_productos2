<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">

.cabecera{
	
	font-size:1.2em;
	font-weight:bold;
	color:#FFFFFF;
	background-color: #08088A;
}

.filas{
	
	
	text-align:center;
	background-color:#5882FA;
}

table{
	
	floate:left;
}

#contendorBoton{
	
	margin-left:1000px;
	
	}

</style>
</head>


<body>
	<div id="contendorBoton">
		<input type ="button"value="Insertar Registro" onclick="window.location.href='inserta_producto.jsp'"/>
	</div>

	<table  >
	
	<tr>
	
	<th class="cabecera">Codigo Articulo</th>
	<th class="cabecera">Seccion</th>
	<th class="cabecera">Nombre Articulo</th>
	<th class="cabecera">Fecha</th>
	<th class="cabecera">Precio</th>
	<th class="cabecera">Importado</th>
	<th class="cabecera">Pais de origen</th>
	</tr>
	
	<c:forEach var="tempProd" items="${LISTAPRODUCTOS}">
	
		<!--  Link para cada producto con su campo clave -->
	
	<c:url var="linkTemp" value="ControladorProductos">
	
	<c:param name="instruccion" value="cargar"></c:param>
	<c:param name="CArticulo" value="${tempProd.cArt}"></c:param>
	
	</c:url>
	
	
	<!--  Link para eliminar cada registro con su campo clave -->
	<c:url var="linkTempEliminar" value="ControladorProductos">
	
	<c:param name="instruccion" value="eliminar"></c:param>
	<c:param name="CArticulo" value="${tempProd.cArt}"></c:param>
	
	</c:url>
	
	
	
	<tr>
	
	<td class="filas">${tempProd.cArt }</td> 
	<td class="filas">${tempProd.seccion } </td>
	<td class="filas">${tempProd.nArt } </td>
	<td class="filas">${tempProd.fecha } </td>
	<td class="filas">${tempProd.precio } </td>
	<td class="filas">${tempProd.importado } </td>
	<td class="filas">${tempProd.pOrig } </td>
	<td class="filas"><a href="${linkTemp}">Actualizar</a>&nbsp;&nbsp;<a href="${linkTempEliminar}">Eliminar</a></td>
	
	</tr>
	
	
	</c:forEach>
	

	
	
	</table>
	


</body>
</html>