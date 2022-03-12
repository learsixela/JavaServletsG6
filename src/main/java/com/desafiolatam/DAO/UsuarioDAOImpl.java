package com.desafiolatam.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.desafiolatam.basedatos.BaseDatos;
import com.desafiolatam.models.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO{

	BaseDatos conexionBD = new BaseDatos();// mysql
	Connection conexion = null;
	Statement stmt = null;
	ResultSet resultado = null;
	
	@Override
	public int crearUsuario(Usuario usuario) {
		int resultado = 0;
		String query = "INSERT INTO usuarios(nombre,apellido,correo,password,genero) values('"+usuario.getNombre()+
				"','"+usuario.getApellido()+"','"+usuario.getEmail()+"','"+usuario.getPassword()+"','"+usuario.getGenero()+"')";
		
		System.out.println("query: "+query);
		
		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(query); //int -> 1, 0 o true o false
			
			if(resultado == 1) {
				System.out.println("Inserción correcta");
			}else {
				System.out.println("Error al insertar");
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return resultado;
		
	}

	@Override
	public Usuario obtenerUsuario(Integer id) {
		
		Usuario usuario = null;
		String query = "SELECT * FROM USUARIOS WHERE ID = " +id;
		
		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeQuery(query);
			
			while(resultado.next()) {
				//recorrer para captura los datos
				Integer usuarioId = resultado.getInt(1);//resultado.getInt("id");
				String nombre = resultado.getString(2);//resultado.getString("nombre");
				String apellido = resultado.getString(3);
				String email = resultado.getString(4);
				String password = resultado.getString(5);
				int genero = resultado.getInt(6);
				
				//llenar el objeto
				usuario = new Usuario(usuarioId,nombre, apellido,email,password, genero);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return usuario;
	}

	@Override
	public void actualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarUsuario(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Usuario> obtenerListaUsuarios() {
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		String query = "SELECT * FROM USUARIOS ";
		
		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeQuery(query);
			
			while(resultado.next()) {
				//recorrer para captura los datos
				Integer usuarioId = resultado.getInt(1);//resultado.getInt("id");
				String nombre = resultado.getString(2);//resultado.getString("nombre");
				String apellido = resultado.getString(3);
				String email = resultado.getString(4);
				String password = resultado.getString(5);
				int genero = resultado.getInt(6);
				
				//llenar el objeto
				Usuario usuario = new Usuario(usuarioId,nombre, apellido,email,password, genero);
				listaUsuarios.add(usuario);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return listaUsuarios;
	}

	@Override
	public Usuario obtenerUsuarioEmail(String email) {
		Usuario usuario = null;
		String query = "SELECT * FROM USUARIOS WHERE correo = '" + email +"'";
		//SELECT * FROM USUARIOS WHERE correo = 'a@a.cl'
		//SELECT * FROM USUARIOS WHERE id = 1
		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeQuery(query);
			
			while(resultado.next()) {
				//recorrer para captura los datos
				Integer usuarioId = resultado.getInt(1);//resultado.getInt("id");
				String nombre = resultado.getString(2);//resultado.getString("nombre");
				String apellido = resultado.getString(3);
				email = resultado.getString(4);
				String password = resultado.getString(5);
				int genero = resultado.getInt(6);
				
				//llenar el objeto
				usuario = new Usuario(usuarioId,nombre, apellido,email,password, genero);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return usuario;
	}

}
