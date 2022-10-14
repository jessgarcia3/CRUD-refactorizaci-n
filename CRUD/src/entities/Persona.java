package entities;
import javax.swing.JOptionPane;

public final class Persona {
	
	private String id;
	private String nombre;
    private String apellidos;
    private String genero;
    private int edad;
    
    public Persona(String id, String nombre, String apellidos, int edad, String genero){
        this.id = id;
    	this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.genero = genero;
    }
    public String getId() {
    	return id;
    }
    public void setId(String id) {
    	this.id = id;
    }
	public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getApellidos(){
        return apellidos;
    }
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    public int getEdad(){
        return edad;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    public String getGenero(){
        return genero;
    }
    public void setGenero(String genero){
        this.genero = genero;
    }
    
    public void mostrar(){
        String mensaje = "\nID administrativo"+ id +"\nNombre: " + nombre + "\nApellidos: " + apellidos + 
        		"\nEdad: " + edad + "\nGenero: " + genero;
	JOptionPane.showMessageDialog(null, mensaje, "Mostrar personas", JOptionPane.INFORMATION_MESSAGE);
	}
	
}