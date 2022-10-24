package paq1;

public class CajeraCC extends Empleado implements Runnable{

	private Cliente c;
	private int precision;
	private static int contador;
	private static double tiempoMax = Long.MIN_VALUE;
	private static String[] informe = { "", "", "" };
	private static double unaCajera = 0;
	private int id = 0;
	
	public CajeraCC(int id, String nombre, String apellido, String puesto, String dni, String nomEmpleado, int precision1) {

		super(nombre, apellido, puesto, dni, nomEmpleado);
		contador++;
		this.id = id;
		this.precision= precision1;
	}

	@Override
	public void run() {
		super.run();
		try {
			pasarCompra();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}

	public static String[] getInforme() {
		return informe;
	}

	public static void setInforme(String[] informe) {
		CajeraCC.informe = informe;
	}

	public static double getTiempoMax() {
		return tiempoMax;
	}

	public static void setTiempoMax(double tiempoMax) {
		CajeraCC.tiempoMax = tiempoMax;
	}

	public Cliente getC() {
		return c;
	}

	public void setC(Cliente c) {
		this.c = c;
	}

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}
	public static double getUnaCajera() {
		return unaCajera;
	}

	public static void setUnaCajera(double unaCajera) {
		CajeraCC.unaCajera = unaCajera;
	}

	public void pasarCompra() throws InterruptedException {
		int compraParaPasar[] = this.c.getCompra(); // Le pasa la compra a la cajera
		double tiempo = 0;
		double aux = 0;
		double screen = 0;
		String auxScreen = "";
		if (this.precision == 1)
			aux = 1;
		if (this.precision == 2)
			aux = 10.0;
		if (this.precision == 3)
			aux = 100.0;
		for (int i = 0; i < 4; i++) {
			if (compraParaPasar[i] == 0)
				break;
			for (int j = 0; j < compraParaPasar[i]; j++) {
				tiempo += 1100;
			}
			screen = Math.round((tiempo / 1000) * aux) / aux;
			auxScreen = Double.toString(screen);
			if (precision == 1) {
				auxScreen = String.format("%.0f", screen);
			}
			System.out.println("\nLa cajera " + super.getNombre() + " acaba de pasar el producto " + (i + 1) + " del cliente "
					+ c.getId() + " en el segundo " + auxScreen);
		}
		if (tiempoMax < screen && id != 99) {
			tiempoMax = screen;
			
		}
		if (id == 99) {
			unaCajera+= screen;
		}
		System.out.println("\nLa cajera " + super.getNombre() + " ha tardado " + auxScreen
				+ " segundos en procesar la compra del cliente " + c.getId());
		if(id!= 99) {
			CajeraCC.informe[id - 1] += "Cliente " + c.getId() + ":" + auxScreen + "s\n";
		}

	}



}
