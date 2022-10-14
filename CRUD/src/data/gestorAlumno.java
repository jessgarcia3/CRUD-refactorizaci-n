package data;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import entities.Alumno;
import interfaces.interfaz;

public final class gestorAlumno implements interfaz {
	
	private ArrayList<Alumno> alumnos;
	
	public gestorAlumno() {
		alumnos = new ArrayList<Alumno>();
	}
	
	@Override
	public boolean agregar() {
		String id = JOptionPane.showInputDialog(null, "Introduzca Identificador:", "Nuevo alumno", JOptionPane.QUESTION_MESSAGE);
		String nombre = JOptionPane.showInputDialog(null, "Nombre:", "Nuevo alumno", JOptionPane.QUESTION_MESSAGE);
		String apellidos = JOptionPane.showInputDialog(null, "Apellidos:", "Nuevo alumno", JOptionPane.QUESTION_MESSAGE);
		String genero = JOptionPane.showInputDialog(null, "Genero:", "Nuevo alumno", JOptionPane.QUESTION_MESSAGE);
		int edad = 0;
		try {
			edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Edad:", "Nuevo alumno", JOptionPane.QUESTION_MESSAGE));
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Solo se admite introducir numeros para la edad\nNo se ha registrado el valor introducido",
					"Error", JOptionPane.WARNING_MESSAGE);
		}
		Alumno nuevoAlumno = new Alumno(id, nombre, apellidos, edad, genero);
		return alumnos.add(nuevoAlumno);
	}
	
	@Override
	public void mostrar() {
		if (alumnos.isEmpty())
			JOptionPane.showMessageDialog(null, "No hay alumnos registrados", "Mostrar alumnos",
					JOptionPane.WARNING_MESSAGE);
		else {
			for (Alumno a: alumnos)
				a.mostrar();
		}
	}
	@Override
	public boolean modificar() {
		String id = JOptionPane.showInputDialog(null, "Introduzca Identificador del alumno a modificar:",
				"Modificar alumno", JOptionPane.QUESTION_MESSAGE);

		Alumno alumno = null;
		for (int i = 0; i < alumnos.size(); i++){
			if (alumnos.get(i).getId().equals(id)) {
				alumno = alumnos.get(i);
				break;
			}
		}
		
		if (alumno == null) {
			JOptionPane.showMessageDialog(null, "No se encuentra alumno con el ID:\n" + id,
					"Alumno no encontrado", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			alumno.setId(JOptionPane.showInputDialog(null, "ID actual: " + alumno.getId()
				+ "\nIntroduzca nuevo identificador:", "Modificar alumno", JOptionPane.QUESTION_MESSAGE));
			alumno.setNombre(JOptionPane.showInputDialog(null, "Nombre actual: " + alumno.getNombre()
				+ "\nIntroduzca nuevo nombre:", "Modificar alumno", JOptionPane.QUESTION_MESSAGE));
			alumno.setApellidos(JOptionPane.showInputDialog(null, "Apellidos actuales: " + alumno.getApellidos()
				+ "\nIntroduzca nuevos apellidos:", "Modificar alumno", JOptionPane.QUESTION_MESSAGE));
			alumno.setGenero(JOptionPane.showInputDialog(null, "Genero actual: " + alumno.getGenero()
				+ "\nIntroduzca nuevo genero:", "Modificar alumno", JOptionPane.QUESTION_MESSAGE));
			try {
				alumno.setEdad(Integer.parseInt(JOptionPane.showInputDialog(null, "Edad actual: " + alumno.getEdad()
				+ "\nIntroduzca nueva edad:", "Modificar alumno", JOptionPane.QUESTION_MESSAGE)));
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Solo se admite introducir numeros para la edad\nNo se ha registrado el valor introducido",
						"Error", JOptionPane.WARNING_MESSAGE);
			}
			return true;
		}
	}
	@Override
	public boolean eliminar() {
		String id = JOptionPane.showInputDialog(null, "Introduzca Identificador del alumno a borrar:",
				"Borrar alumno", JOptionPane.QUESTION_MESSAGE);
		
		Alumno alumno = null;
		for (int i = 0; i < alumnos.size(); i++){
			if (alumnos.get(i).getId().equals(id))
				alumno = alumnos.remove(i);
		}
		
		if (alumno == null) {
			JOptionPane.showMessageDialog(null, "No se encuentra alumno con el ID:\n" + id,
					"Alumno no encontrado", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			JOptionPane.showMessageDialog(null, "Se elimino el alumno con ID:\n" + id,
					"Alumno Eliminado", JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
	}
}