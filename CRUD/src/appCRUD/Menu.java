package appCRUD;

import javax.swing.JOptionPane;
import java.util.Scanner;
import data.gestorAdmin;
import data.gestorAlumno;
import data.gestorProfesores;
import data.gestorPersona;

public final class Menu {
	 static String pedir;
	 static Scanner scanner = new Scanner(System.in);
	 
	 static gestorAdmin d = new gestorAdmin();
	 static gestorAlumno a = new gestorAlumno();
	 static gestorProfesores p = new gestorProfesores();
	 static gestorPersona s = new gestorPersona();
	 
	 public static void main(String[] args) {
		 int menu = 0; //menu 1
		 do {
	                String main = JOptionPane.showInputDialog(null,"***********************\nElige opción:\n" + 
	                                                "\n1.- Administrativos\n" +
	                                                "\n2.- Alumnos\n" +
	                                                "\n3.- Profesores\n" +
	                                                "\n4.- Persona\n"+
													"\n5.- Salir\n************************");
	                menu = Integer.parseInt(main);
	                switch(menu){
					
					case 1:
						int admin = 0; //menu 2
						do {
								String adminmenu = JOptionPane.showInputDialog(null,"***********************\nElige opción:\n" + 
                                "\n1.- Agregar nuevo administrador\n" +
                                "\n2.- Mostrar administradores\n" +
                                "\n3.- Modificar administrador\n" +
                                "\n4.- Eliminar administrador\n"+
								"\n0.- Volver atrás\n************************");
								admin = Integer.parseInt(adminmenu);
								switch(admin){
								
								case 1:
									d.agregar();
									break;
									
								case 2:
									d.mostrar();
									break;
									
								case 3:
									d.modificar();
									break;
									
								case 4:
									d.eliminar();
									break;
									
								default: 
									JOptionPane.showMessageDialog(null,"Volver atrás");
																	
								}
								
						}while (admin<4);
						break;
						
					case 2: 
						int alumno = 0; //menu 3
						do {
								String alumnomenu = JOptionPane.showInputDialog(null,"***********************\nElige opción:\n" + 
                                "\n1.- Agregar nuevo alumno\n" +
                                "\n2.- Mostrar alumnos\n" +
                                "\n3.- Modificar alumno\n" +
                                "\n4.- Eliminar alumno\n"+
								"\n0.- Volver atrás\n************************");
								alumno = Integer.parseInt(alumnomenu);
								switch(alumno){
								
								case 1:
									a.agregar();
									break;
									
								case 2:
									a.mostrar();
									break;
									
								case 3:
									a.modificar();
									break;
									
								case 4:
									a.eliminar();
									break;
									
								default: 
									JOptionPane.showMessageDialog(null,"Volver atrás");
																	
								}
								
						}while (alumno<4);
						break;
						
					case 3:
						int profesor = 0; //menu 3
						do {
								String profesormenu = JOptionPane.showInputDialog(null,"***********************\nElige opción:\n" + 
                                "\n1.- Agregar nuevo administrador\n" +
                                "\n2.- Mostrar administradores\n" +
                                "\n3.- Modificar administrador\n" +
                                "\n4.- Eliminar administrador\n"+
								"\n0.- Volver atrás\n************************");
								profesor = Integer.parseInt(profesormenu);
								switch(profesor){
								
								case 1:
									p.agregar();
									break;
									
								case 2:
									p.mostrar();
									break;
									
								case 3:
									p.modificar();
									break;
									
								case 4:
									p.eliminar();
									break;
									
								default: 
									JOptionPane.showMessageDialog(null,"Volver atrás");
																	
								}
								
						}while (profesor<4);
						break;
						
					case 4:
						int persona = 0; //menu 4
						do {
								String personamenu = JOptionPane.showInputDialog(null,"***********************\nElige opción:\n" + 
                                "\n1.- Agregar nuevo administrador\n" +
                                "\n2.- Mostrar administradores\n" +
                                "\n3.- Modificar administrador\n" +
                                "\n4.- Eliminar administrador\n"+
								"\n0.- Volver atrás\n************************");
								persona = Integer.parseInt(personamenu);
								switch(persona){
								
								case 1:
									s.agregar();
									break;
									
								case 2:
									s.mostrar();
									break;
									
								case 3:
									s.modificar();
									break;
									
								case 4:
									s.eliminar();
									break;
									
								default: 
									JOptionPane.showMessageDialog(null,"Volver atrás");
													
								}						
						}while (persona<4);
						break;
	                }
	 }while (menu<5);
}
}

