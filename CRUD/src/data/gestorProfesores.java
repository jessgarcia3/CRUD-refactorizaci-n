package data;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import entities.Profesor;
import interfaces.interfaz;

public final class gestorProfesores implements interfaz {
	
	private ArrayList<Profesor> profesores;
	
	public gestorProfesores() {
		profesores = new ArrayList<Profesor>();
	}
	
	@Override
	public boolean agregar() {
		String id = JOptionPane.showInputDialog(null, "Introduzca profesor:", "Nuevo profesor", JOptionPane.QUESTION_MESSAGE);
		String nombre = JOptionPane.showInputDialog(null, "Nombre:", "Nuevo profesor", JOptionPane.QUESTION_MESSAGE);
		String apellidos = JOptionPane.showInputDialog(null, "Apellidos:", "Nuevo profesor", JOptionPane.QUESTION_MESSAGE);
		String genero = JOptionPane.showInputDialog(null, "Genero:", "Nuevo profesor", JOptionPane.QUESTION_MESSAGE);
		int edad = 0;
		try {
			edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Edad:", "Nuevo profesor", JOptionPane.QUESTION_MESSAGE));
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Solo se admite introducir numeros para la edad\nNo se ha registrado el valor introducido",
					"Error", JOptionPane.WARNING_MESSAGE);
		}
		Profesor nuevoProfesor = new Profesor(id, nombre, apellidos, edad, genero);
		return profesores.add(nuevoProfesor);
	}
	
	@Override
	public void mostrar() {
		if (profesores.isEmpty())
			JOptionPane.showMessageDialog(null, "No hay profesores registrados", "Mostrar profesores",
					JOptionPane.WARNING_MESSAGE);
		else {
			for (Profesor p: profesores)
				p.mostrar();
		}
	}
	@Override
	public boolean modificar() {
		String id = JOptionPane.showInputDialog(null, "Introduzca Identificador del profesor a modificar:",
				"Modificar profesor", JOptionPane.QUESTION_MESSAGE);

		Profesor profesor = null;
		for (int i = 0; i < profesores.size(); i++){
			if (profesores.get(i).getId().equals(id)) {
				profesor = profesores.get(i);
				break;
			}
		}
		
		if (profesor == null) {
			JOptionPane.showMessageDialog(null, "No se encuentra profesor con el ID:\n" + id,
					"profesor no encontrado", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			profesor.setId(JOptionPane.showInputDialog(null, "ID actual: " + profesor.getId()
				+ "\nIntroduzca nuevo identificador:", "Modificar profesor", JOptionPane.QUESTION_MESSAGE));
			profesor.setNombre(JOptionPane.showInputDialog(null, "Nombre actual: " + profesor.getNombre()
				+ "\nIntroduzca nuevo nombre:", "Modificar profesor", JOptionPane.QUESTION_MESSAGE));
			profesor.setApellidos(JOptionPane.showInputDialog(null, "Apellidos actuales: " + profesor.getApellidos()
				+ "\nIntroduzca nuevos apellidos:", "Modificar profesor", JOptionPane.QUESTION_MESSAGE));
			profesor.setGenero(JOptionPane.showInputDialog(null, "Genero actual: " + profesor.getGenero()
				+ "\nIntroduzca nuevo genero:", "Modificar profesor", JOptionPane.QUESTION_MESSAGE));
			try {
				profesor.setEdad(Integer.parseInt(JOptionPane.showInputDialog(null, "Edad actual: " + profesor.getEdad()
				+ "\nIntroduzca nueva edad:", "Modificar profesor", JOptionPane.QUESTION_MESSAGE)));
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
		String id = JOptionPane.showInputDialog(null, "Introduzca Identificador del profesor a borrar:",
				"Borrar profesor", JOptionPane.QUESTION_MESSAGE);
		
		Profesor profesor = null;
		for (int i = 0; i < profesores.size(); i++){
			if (profesores.get(i).getId().equals(id))
				profesor = profesores.remove(i);
		}
		
		if (profesor == null) {
			JOptionPane.showMessageDialog(null, "No se encuentra profesor con el ID:\n" + id,
					"Profesor no encontrado", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			JOptionPane.showMessageDialog(null, "Se elimino el profesor con ID:\n" + id,
					"Profesor Eliminado", JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
	}

}