package com.desafiolatam.DAO;

import java.util.ArrayList;

import com.desafiolatam.models.Auto;

public interface AutoDAO {

	public int crearAuto(Auto auto);
	
	public Auto obtenerAuto(Integer id);

	public int actualizar(Auto auto);
	
	public int eliminarAuto(Integer id);
	
	public ArrayList<Auto> obtenerListaAutos();
}
