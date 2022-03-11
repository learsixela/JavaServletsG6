package com.desafiolatam.DAO;

import java.util.ArrayList;

import com.desafiolatam.models.Usuario;

public interface UsuarioDAO {
	//CRUD
	public int crearUsuario(Usuario usuario);
	public Usuario obtenerUsuario(Integer id);
	public void actualizarUsuario(Usuario usuario);
	public void eliminarUsuario(Integer id);
	
	public ArrayList<Usuario> obtenerListaUsuarios();
	public Usuario obtenerUsuarioEmail(String email);
}
