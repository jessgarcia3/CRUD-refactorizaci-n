package data;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import entities.Admin;
import interfaces.interfaz;

public final class gestorAdmin implements interfaz {
	
	private ArrayList<Admin> admins;
	
	public gestorAdmin() {
		admins = new ArrayList<Admin>();
	}
	@Override
	public boolean agregar() {
		String id = JOptionPane.showInputDialog(null, "Introduzca Identificador:", "Nuevo Administrador", JOptionPane.QUESTION_MESSAGE);
		String nombre = JOptionPane.showInputDialog(null, "Nombre:", "Nuevo Administrador", JOptionPane.QUESTION_MESSAGE);
		String apellidos = JOptionPane.showInputDialog(null, "Apellidos:", "Nuevo Administrador", JOptionPane.QUESTION_MESSAGE);
		String genero = JOptionPane.showInputDialog(null, "Genero:", "Nuevo Administrador", JOptionPane.QUESTION_MESSAGE);
		int edad = 0;
		try {
			edad = Integer.parseInt(JOptionPane.showInputDialog(null, "Edad:", "Nuevo administrador", JOptionPane.QUESTION_MESSAGE));
		}
		catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Solo se admite introducir numeros para la edad\nNo se ha registrado el valor introducido",
					"Error", JOptionPane.WARNING_MESSAGE);
		}
		Admin nuevoAdmin = new Admin(id, nombre, apellidos, edad, genero);
		return admins.add(nuevoAdmin);
	}
	
	@Override
	public void mostrar() {
		if (admins.isEmpty())
			JOptionPane.showMessageDialog(null, "No hay administradores registrados", "Mostrar administradores",
					JOptionPane.WARNING_MESSAGE);
		else {
			for (Admin d: admins)
				d.mostrar();
		}
	}
	@Override
	public boolean modificar() {
		String id = JOptionPane.showInputDialog(null, "Introduzca Identificador del administrador a modificar:",
				"Modificar administrador", JOptionPane.QUESTION_MESSAGE);

		Admin admin = null;
		for (int i = 0; i < admins.size(); i++){
			if (admins.get(i).getId().equals(id)) {
				admin = admins.get(i);
				break;
			}
		}
		
		if (admin == null) {
			JOptionPane.showMessageDialog(null, "No se encuentra administrador con el ID:\n" + id,
					"Administrador no encontrado", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			admin.setId(JOptionPane.showInputDialog(null, "ID actual: " + admin.getId()
				+ "\nIntroduzca nuevo identificador:", "Modificar administrador", JOptionPane.QUESTION_MESSAGE));
			admin.setNombre(JOptionPane.showInputDialog(null, "Nombre actual: " + admin.getNombre()
				+ "\nIntroduzca nuevo nombre:", "Modificar administrador", JOptionPane.QUESTION_MESSAGE));
			admin.setApellidos(JOptionPane.showInputDialog(null, "Apellidos actuales: " + admin.getApellidos()
				+ "\nIntroduzca nuevos apellidos:", "Modificar administrador", JOptionPane.QUESTION_MESSAGE));
			admin.setGenero(JOptionPane.showInputDialog(null, "Genero actual: " + admin.getGenero()
				+ "\nIntroduzca nuevo genero:", "Modificar administrador", JOptionPane.QUESTION_MESSAGE));
			try {
				admin.setEdad(Integer.parseInt(JOptionPane.showInputDialog(null, "Edad actual: " + admin.getEdad()
				+ "\nIntroduzca nueva edad:", "Modificar administrador", JOptionPane.QUESTION_MESSAGE)));
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
		String id = JOptionPane.showInputDialog(null, "Introduzca Identificador del administrador a borrar:",
				"Borrar administrador", JOptionPane.QUESTION_MESSAGE);
		
		Admin admin = null;
		for (int i = 0; i < admins.size(); i++){
			if (admins.get(i).getId().equals(id))
				admin = admins.remove(i);
		}
		
		if (admin == null) {
			JOptionPane.showMessageDialog(null, "No se encuentra administrador con el ID:\n" + id,
					"Administrador no encontrado", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			JOptionPane.showMessageDialog(null, "Se elimino el administrador con ID:\n" + id,
					"Administrador Eliminado", JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
	}

}