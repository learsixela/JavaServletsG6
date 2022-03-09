package com.desafiolatam.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/registrarUsuario")
public class RegistrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher vista = null;
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
			request.setAttribute("msjError","Datos faltantes, por favor verifique" );
			
			vista = request.getRequestDispatcher("registro.jsp");
		}else {
			//guardado de los datos
			
			vista =  request.getRequestDispatcher("/login");
		}
		System.out.println(vista);
		vista.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
