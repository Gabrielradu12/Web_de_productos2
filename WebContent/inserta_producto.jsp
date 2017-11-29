<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<H1 style="text-align: center;">Insertar Registros</H1>

<form name="form1" method="get" action="ControladorProductos">
<input type="hidden" name="instruccion" value="insertarBBDD">

<table style="width: 400px;">
 
  <tr>
   <td width="27%">CODIGO ARTICULO</td>
   <td width="73%"><label for="CArt"></label>
   <td><input type="text" name="CArt" id="CArt"></td>
  </tr>
 
    <tr>
   <td width="27%"> Seccion</td>
   <td width="73%"><label for="seccion"></label>
   <td><input type="text" name="seccion" id="seccion"></td>
  </tr>
 
    <tr>
   <td width="27%">Nombre Articulo</td>
   <td width="73%"><label for="NArt"></label>
   <td><input type="text" name="NArt" id="NArt"></td>
  </tr>
 
   <tr>
   <td width="27%"> Precio</td>
   <td width="73%"><label for="precio"></label>
   <td><input type="text" name="precio" id="precio"></td>
  </tr>
 
   <tr>
   <td width="27%"> Fecha</td>
   <td width="73%"><label for="fecha"></label>
   <td><input type="text" name="fecha" id="fecha"></td>
  </tr>
 
   <tr>
   <td width="27%"> Importado</td>
   <td width="73%"><label for="importado"></label>
   <td><input type="text" name="importado" id="importado"></td>
  </tr>
 
   <tr>
   <td width="27%"> Pais de Origen</td>
   <td width="73%"><label for="POrig"></label>
   <td><input type="text" name="POrig" id="POrig"></td>
  </tr>
 
  <tr>
   <td><input type="submit" name="envio" id="envio" value="Enviar"></td>
   <td><input type="reset" name="borrar" id="borrar" value="Restablecer"></td>
  </tr>
  
 
 
</table>

</form>

</body>﻿

</html>