package com.pildorasinformaticas.productos;

import java.sql.*;
import java.util.*;
import java.util.Date;

import javax.sql.DataSource;
public class ModeloProductos {
	
	private DataSource origenDatos;
	
	public ModeloProductos(DataSource origenDatos) {
		
		this.origenDatos=origenDatos;
		
		
	}
	
	public List<Productos> getProductos()throws Exception{
		
		
		List<Productos>productos=new ArrayList<>();
		
		Connection miConexion=null;
		
		Statement miStatement=null;
		
		ResultSet miResultset=null;
		
		//-------establecer la conexion--------------
		miConexion=origenDatos.getConnection();
		
		//---------crear la sentencia SQL y statement------------
		String sentenciaSQL="SELECT * FROM PRODUCTOS";
		
		miStatement=miConexion.createStatement();
		//-------------ejecutar sentencia SQL----------
		
		miResultset=miStatement.executeQuery(sentenciaSQL);
		
		//------------recorrer el resultSet obtenido---------
		
		while(miResultset.next()) {
			
			String c_art=miResultset.getString("CODIGOARTICULO");
			String seccion=miResultset.getString("SECCION");
			String n_art=miResultset.getString("NOMBREARTICULO");
			double precio=miResultset.getDouble("PRECIO");
			Date fecha=miResultset.getDate("FECHA");
			String importado=miResultset.getString("IMPORTADO");
			String p_orig=miResultset.getString("PAISDEORIGEN");
			
			
			Productos tempProd=new Productos(c_art,seccion,n_art,precio,fecha,importado,p_orig);
			
			productos.add(tempProd);
			
		}
		
		return productos;
		
	}

	public void agregarElNuevoProducto(Productos nuevoProducto) throws Exception {
		// TODO Auto-generated method stub
		Connection miConexion=null;
		
		PreparedStatement miStatement=null;
		// Obetener la conexion con la BBDD
		try {
			
			miConexion=origenDatos.getConnection();
			
		
		
		//Crear la instruccion SQL que inserte el producto.Crear la consulta preparada (statement)
		
		String sql="INSERT INTO PRODUCTOS (CODIGOARTICULO,SECCION,NOMBREARTICULO,PRECIO,FECHA,IMPORTADO,PAISDEORIGEN)"+
		"VALUES(?,?,?,?,?,?,?)";
		
		miStatement=miConexion.prepareStatement(sql);
		
		//establecer los parametros para el producto
		
		miStatement.setString(1, nuevoProducto.getcArt());
		
		miStatement.setString(2, nuevoProducto.getSeccion());
		
		miStatement.setString(3, nuevoProducto.getnArt());
		
		miStatement.setDouble(4, nuevoProducto.getPrecio());
		
		java.util.Date utilDate=nuevoProducto.getFecha();
		
		java.sql.Date fechaConvertida=new java.sql.Date(utilDate.getTime());
		
		miStatement.setDate(5, fechaConvertida 	);
		
		miStatement.setString(6, nuevoProducto.getImportado());
		
		miStatement.setString(7, nuevoProducto.getpOrig());
		
		//ejecutar la instruccion SQL
		
		miStatement.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			miStatement.close();
			miConexion.close();
		}
		
	}

	public Productos getProducto(String codigoArticulo) throws Exception {
		// TODO Auto-generated method stub
		
		Productos elProducto=null;
		Connection miConexion=null;
		
		PreparedStatement miStatement=null;
		
		ResultSet miResultset=null;
		
		String cArticulo=codigoArticulo;
		// Establecer la conexion con la BBDD
		try {
			miConexion=origenDatos.getConnection();
		
		
		//  Crear sql que busque el producto
		
			String sql="SELECT * FROM PRODUCTOS WHERE CODIGOARTICULO=? ";
			
			
		
		//  Crear la consulta preparada
			
			miStatement=miConexion.prepareStatement(sql);
		
		
		//   Establecer los parametros
			
			miStatement.setString(1, cArticulo);
		
		
		//   ejecutar la consulta
			
			miResultset=miStatement.executeQuery();
			
		
		//   Obtener los datos de respuesta 
			
			if(miResultset.next()) {
				
				String c_art=miResultset.getString("CODIGOARTICULO");
				String seccion=miResultset.getString("SECCION");
				String nArt=miResultset.getString("NOMBREARTICULO");
				double precio=miResultset.getDouble("PRECIO");
				Date fecha=miResultset.getDate("FECHA");
				String importado=miResultset.getString("IMPORTADO");
				String pOrig=miResultset.getString("PAISDEORIGEN");
				
				
				elProducto=new Productos(c_art,seccion,nArt,precio,fecha,importado,pOrig);
				
				
			}else {
				throw new Exception("No se ha encontrado el producto con el codigo articulo = "+cArticulo);
			
			}
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		return elProducto;
	}
public void actualizarProductos(Productos productoActualizado)throws Exception{
	
	Connection miConexion=null;
	PreparedStatement miStatement=null;
		
	//Establecer la conexion 
	try {
	miConexion=origenDatos.getConnection();
	
	
	//Crear sentencia SQL
	
	String sql="UPDATE PRODUCTOS SET SECCION=?, NOMBREARTICULO=?, PRECIO=?, "+
	"FECHA =?, IMPORTADO=? , PAISDEORIGEN=? WHERE CODIGOARTICULO=?";
	
	//CREAR CONSULTA PREPARADA
	
	miStatement=miConexion.prepareStatement(sql);
	
	//Establecer los parametros
	
	miStatement.setString(1, productoActualizado.getSeccion());
	miStatement.setString(2, productoActualizado.getnArt());
	miStatement.setDouble(3, productoActualizado.getPrecio());
	java.util.Date utilDate=productoActualizado.getFecha();
	
	java.sql.Date fechaConvertida=new java.sql.Date(utilDate.getTime());
	
	miStatement.setDate(4, fechaConvertida);
	miStatement.setString(5, productoActualizado.getImportado());
	miStatement.setString(6, productoActualizado.getpOrig());
	miStatement.setString(7, productoActualizado.getcArt());
	
	//ejecutar la instruccion sql
	
	miStatement.execute();
	}finally {
		
		miStatement.close();
		miConexion.close();
	}
	
	

	}

public void eliminarProducto(String codArticulo) throws Exception{
	// TODO Auto-generated method stub
	Connection miConexion=null;
	PreparedStatement miStatement=null;
	// Establecer la conexion con la BBDD
	
	try {
	miConexion=origenDatos.getConnection();
	
	// Crear instruccion sql de eliminacion
			
	String sql="DELETE FROM PRODUCTOS WHERE CODIGOARTICULO=?";
	
	
	// Preparar la consulta
	
	miStatement=miConexion.prepareStatement(sql);
	
	// Establecer los parametros de consulta
	
	
	miStatement.setString(1, codArticulo);
	
	// Ejecutar la sentencia Sql
	miStatement.execute();
}finally {
	
	miStatement.close();
	miConexion.close();
}


}
}

	