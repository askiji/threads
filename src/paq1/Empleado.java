package paq1;

public class Empleado  {
	private String nomEmpleado;
	private String nombre;
	private String apellido;
	private String dni;
	private String puesto;
	
	public Empleado(String nomEmpleado, String nombre, String apellido, String dni, String puesto) {
		super();
		this.nomEmpleado = nomEmpleado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.puesto = puesto;
	}
	public String getNomEmpleado() {
		return nomEmpleado;
	}
	public void setNomEmpleado(String nomEmpleado) {
		this.nomEmpleado = nomEmpleado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public void run() {
		// TODO Auto-generated method stub
		
	} 
}
