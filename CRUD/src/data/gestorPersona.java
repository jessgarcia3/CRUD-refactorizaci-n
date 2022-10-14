package data;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import entities.Persona;
import interfaces.interfaz;

public final class gestorPersona implements interfaz {
	
	private ArrayList<Persona> personas;
	
	public gestorPersona() {
		personas = new ArrayList<Persona>();
	}
	
	@Override
	public boolean agregar() {
		String id = JOptionPane.showInputDialog(null, "Introduzca Identificador:", "Nueva persona", JOptionPane.QUESTION_MESSAGE);
		String nombre = JOptionPane.showInputDialog(null, "Nombre:", "Nueva persona", JOptionPane.QUESTION_MESSAGE);
		String apellidos = JOptionPane.showInputDialog(null, "Apellidos:", "Nueva persona", JOptionPane.QUESTION_MESSAGE);
		String genero = JOptionPane.showInputDialog(null, "Genero:", "Nueva persona", JOptionPane.QUESTION_MESSAGE);
		int edad = 0;
		try {
			edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Edad:", "Nueva persona", JOptionPane.QUESTION_MESSAGE));
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Solo se admite introducir numeros para la edad\nNo se ha registrado el valor introducido",
					"Error", JOptionPane.WARNING_MESSAGE);
		}
		Persona nuevoPersona = new Persona(id, nombre, apellidos, edad, genero);
		return personas.add(nuevoPersona);
	}
	
	@Override
	public void mostrar() {
		if (personas.isEmpty())
			JOptionPane.showMessageDialog(null, "No hay personas registrados", "Mostrar personas",
					JOptionPane.WARNING_MESSAGE);
		else {
			for (Persona s: personas)
				s.mostrar();
		}
	}
	@Override
	public boolean modificar() {
		String id = JOptionPane.showInputDialog(null, "Introduzca Identificador de la persona a modificar:",
				"Modificar persona", JOptionPane.QUESTION_MESSAGE); 

		Persona persona = null;
		for (int i = 0; i < personas.size(); i++){
			if (personas.get(i).getId().equals(id)) {
				persona = personas.get(i);
				break;
			}
		}
		
		if (persona == null) {
			JOptionPane.showMessageDialog(null, "No se encuentra persona con el ID:\n" + id,
					"Persona no encontrado", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			persona.setId(JOptionPane.showInputDialog(null, "ID actual: " + persona.getId()
				+ "\nIntroduzca nuevo identificador:", "Modificar persona", JOptionPane.QUESTION_MESSAGE));
			persona.setNombre(JOptionPane.showInputDialog(null, "Nombre actual: " + persona.getNombre()
				+ "\nIntroduzca nuevo nombre:", "Modificar persona", JOptionPane.QUESTION_MESSAGE));
			persona.setApellidos(JOptionPane.showInputDialog(null, "Apellidos actuales: " + persona.getApellidos()
				+ "\nIntroduzca nuevos apellidos:", "Modificar persona", JOptionPane.QUESTION_MESSAGE));
			persona.setGenero(JOptionPane.showInputDialog(null, "Genero actual: " + persona.getGenero()
				+ "\nIntroduzca nuevo genero:", "Modificar persona", JOptionPane.QUESTION_MESSAGE));
			try {
				persona.setEdad(Integer.parseInt(JOptionPane.showInputDialog(null, "Edad actual: " + persona.getEdad()
				+ "\nIntroduzca nueva edad:", "Modificar persona", JOptionPane.QUESTION_MESSAGE)));
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
		String id = JOptionPane.showInputDialog(null, "Introduzca Identificador de la persona a borrar:",
				"Borrar persona", JOptionPane.QUESTION_MESSAGE);
		
		Persona persona = null;
		for (int i = 0; i < personas.size(); i++){
			if (personas.get(i).getId().equals(id))
				persona = personas.remove(i);
		}
		
		if (persona == null) {
			JOptionPane.showMessageDialog(null, "No se encuentra persona con el ID:\n" + id,
					"Persona no encontrada", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			JOptionPane.showMessageDialog(null, "Se elimino la persona con ID:\n" + id,
					"Persona Eliminada", JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
	}
}