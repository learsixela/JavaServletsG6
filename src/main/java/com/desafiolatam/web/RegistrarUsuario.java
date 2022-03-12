package com.desafiolatam.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.desafiolatam.DAO.UsuarioDAOImpl;
import com.desafiolatam.models.Usuario;


@WebServlet("/registrarUsuario")
public class RegistrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//capturando parametros
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String correo = request.getParameter("correo");
		String password = request.getParameter("password");
		String genero = request.getParameter("genero");
		
		System.out.println(nombre+" "+apellido+" "+correo+"" +password+" " +genero);
		//validar
		if(nombre.isBlank() || apellido.isEmpty() || correo.isEmpty() || password.isEmpty() || genero == null) {
			
			//pasar valores al jsp o servlet
			request.setAttribute("msgError","Datos faltantes, por favor verifique" );
			request.getRequestDispatcher("registro.jsp").forward(request, response);
		}else {
			//guardado de los datos (DTO)
			Usuario usuario = new Usuario(nombre,apellido, correo,password,Integer.parseInt(genero));
			
			UsuarioDAOImpl usuarioDAOImpl  = new UsuarioDAOImpl();
			Usuario usuarioExiste = usuarioDAOImpl.obtenerUsuarioEmail(correo);
			
			if(usuarioExiste == null) {//no existe, si es null
				int resultadoInsert = usuarioDAOImpl.crearUsuario(usuario);
				
				if(resultadoInsert ==1) {
					request.getRequestDispatcher("/login").forward(request, response);
				}else {
					request.setAttribute("msgError","Error al registrarse" );
					request.getRequestDispatcher("registro.jsp").forward(request, response);
				}
			}else {
				request.setAttribute("msgError","Error, Error al registrarse" );
				request.getRequestDispatcher("registro.jsp").forward(request, response);
			}

		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
