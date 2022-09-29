package paq1;

public class CajeraCC extends Thread{
	
private Cliente c;
private int precision;
private static int contador;

private int id=0;

public CajeraCC() {
	
	super();
	contador++;
	this.id=contador;
}



//	@Override
//	private void run() {
//		pasarCompra();
//	}

	
		@Override
	public void run() {
		super.run();
		try {
			pasarCompra();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		//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
		int compraParaPasar[] = this.c.getCompra(); // Le pasa la compra a la cajera
		long inicial = System.currentTimeMillis();
		double tiempo=0;
		double tiempoFinal=0;
		double aux = 0;
		double screen =0;
		double cuantoHaPasado=0;
		String auxScreen="";
		if (this.precision == 1) aux = 1; 
		if (this.precision == 2) aux = 10.0;
		if (this.precision == 3) aux = 100.0;
		System.out.println("La cajera " + id + " comienza a pasar la compra en el segundo 0.\n");
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
		System.out.println("\nLa cajera " + id +" ha tardado " + auxScreen + " segundos en procesar la compra\n");
	};
	
	
	
	
}
