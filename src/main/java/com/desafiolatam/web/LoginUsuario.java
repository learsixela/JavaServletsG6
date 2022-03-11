package com.desafiolatam.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.desafiolatam.DAO.UsuarioDAOImpl;
import com.desafiolatam.models.Usuario;

@WebServlet("/loginUsuario")
public class LoginUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String correo = request.getParameter("correo");
		String password = request.getParameter("password");
		//Validar los parametros
		if(correo.isEmpty() || correo == null || password.equals("") || password == null) {
			request.setAttribute("msgError","Datos faltantes, por favor verifique" );
			request.getRequestDispatcher("/login").forward(request, response);
		}else {
			UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
			Usuario usuario = usuarioDAOImpl.obtenerUsuarioEmail(correo);
			
			if(usuario != null){
				//usuarios existe
				//comparar los password
				if(password.equals(usuario.getPassword())) {
					//SESSION guardar
					HttpSession session = request.getSession();
					session.setAttribute("emailUsuario",usuario.getEmail());
					session.setAttribute("idUsuario",usuario.getId());
					
					request.getRequestDispatcher("/home").forward(request, response);
				}else {
					request.setAttribute("msgError","Datos incorrectos" );
					request.getRequestDispatcher("/login").forward(request, response);
				}
				
				
			}else {
				//con ese correo no existe el usuario
				request.setAttribute("msgError","Usuario no existe" );
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
