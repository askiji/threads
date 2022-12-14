package paq1;

import java.util.Iterator;

public class CajeraSC {
	private Cliente c;
	private int precision;
	private static int contador;
	private long tiempoTodasCompras=0;
	private int id;
	
	public long getTiempoTodasCompras() {
		return tiempoTodasCompras;
	}

	public void setTiempoTodasCompras(long tiempoTodasCompras) {
		this.tiempoTodasCompras = tiempoTodasCompras;
	}

	public CajeraSC() {
		super();
		contador++;
		this.id= contador;
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

	public void pasarCompra() throws InterruptedException{
		int compraParaPasar[] = this.c.getCompra(); // Le pasa la compra a la cajera
		long inicial = System.currentTimeMillis();
		double tiempo=0;
		double tiempoFinal=0;
		double aux = 0;
		double screen =0;
		double cuantoHaPasado=0;
		String auxScreen="";
		if (precision == 1) aux = 1; 
		if (precision == 2) aux = 10.0;
		if (precision == 3) aux = 100.0;
		System.out.println("La cajera "+ id + " comienza a pasar la compra en el segundo 0.\n");
		for (int i=0; i<4; i++) {
			if (compraParaPasar[i]==0) break;
			for (int j = 0; j < compraParaPasar[i]; j++) {				
				Thread.sleep(1110);
			}
			cuantoHaPasado = (System.currentTimeMillis()-inicial);
			screen = Math.round((cuantoHaPasado/1000)*aux)/aux;
			auxScreen = Double.toString(screen) ;
			if(precision==1) {
				auxScreen = String.format("%.0f", screen);
			}
			System.out.println("\nLa cajera " + id +" acaba de pasar el producto " + (i+1) +" del cliente " + c.getId() +" en el segundo " + auxScreen);
		}
		tiempoTodasCompras += screen;
		System.out.println("\nLa cajera " + id + " ha tardado " + auxScreen + " segundos en procesar la compra\n");
	};
	
	
	
	
	
}
