package com.desafiolatam.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.desafiolatam.basedatos.BaseDatos;
import com.desafiolatam.models.Auto;

public class AutoDAOImpl implements AutoDAO {

	BaseDatos conexionBD = new BaseDatos();// mysql
	Connection conexion = null;
	Statement stmt = null;
	ResultSet resultado = null;

	@Override
	public int crearAuto(Auto auto) {
		int resultado = 0;
		String query = "INSERT INTO AUTOS (marca, modelo, color , velocidad) values ('" + auto.getMarca() + "','"
				+ auto.getModelo() + "','" + auto.getColor() + "','" + auto.getVelocidad() + "')";
		System.out.println("query: " + query);

		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(query); // int -> 1, 0 o true o false

			if (resultado == 1) {
				System.out.println("Inserción correcta");
			} else {
				System.out.println("Error al insertar");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return resultado;
	}

	@Override
	public Auto obtenerAuto(Integer id) {
		Auto auto = null;
		String query = "SELECT * FROM AUTOS WHERE ID = " + id;

		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeQuery(query);

			while (resultado.next()) {
				// recorrer para captura los datos
				Integer autoId = resultado.getInt(1);// resultado.getInt("id");
				String marca = resultado.getString(2);
				String modelo = resultado.getString(3);
				String color = resultado.getString(4);
				Float velocidad = resultado.getFloat(5);

				// llenar el objeto
				auto = new Auto(autoId, marca, modelo, color, velocidad);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return auto;
	}

	@Override
	public int actualizar(Auto auto) {
		int resultado = 0;
		String query = "UPDATE AUTOS " + "SET marca = '" + auto.getMarca() + "', modelo= '" + auto.getModelo()
				+ "', color= '" + auto.getColor() + "', velocidad = '" + auto.getVelocidad() + "' WHERE ID = "
				+ auto.getId();
		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(query); // int -> 1, 0 o true o false

			if (resultado == 1) {
				System.out.println("Actualizacion correcta");
			} else {
				System.out.println("Error al actualizar");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return resultado;

	}

	@Override
	public int eliminarAuto(Integer id) {
		int resultado = 0;
		String query = "DELETE FROM AUTOS WHERE ID = " + id;
		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeUpdate(query); // int -> 1, 0 o true o false

			if (resultado == 1) {
				System.out.println("Eliminacion correcta");
			} else {
				System.out.println("Error al eliminar");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return resultado;
	}

	@Override
	public ArrayList<Auto> obtenerListaAutos() {
		ArrayList<Auto> listaAutos = new ArrayList<Auto>();
		String query = "SELECT * FROM AUTOS ";

		try {
			conexion = conexionBD.datos();
			stmt = conexion.createStatement();
			resultado = stmt.executeQuery(query);

			while (resultado.next()) {
				// recorrer para captura los datos
				Integer autoId = resultado.getInt(1);// resultado.getInt("id");
				String marca = resultado.getString(2);
				String modelo = resultado.getString(3);
				String color = resultado.getString(4);
				Float velocidad = resultado.getFloat(5);

				// llenar el objeto nuevo por cada registro
				Auto auto = new Auto(autoId, marca, modelo, color, velocidad);

				listaAutos.add(auto);// llenando la lista
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return listaAutos;
	}

}
