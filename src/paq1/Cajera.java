package paq1;

import java.util.Iterator;

public class Cajera {


	
	public void pasarCompra(Cliente c , int precision) throws InterruptedException{
		int compraParaPasar[] = c.getCompra(); // Le pasa la compra a la cajera
		long inicial = System.currentTimeMillis();
		double tiempo=0;
		double aux = 0;
		double screen =0;
		double cuantoHaPasado=0;
		if (precision == 1) aux = 1.0; 
		if (precision == 2) aux = 10.0;
		if (precision == 3) aux = 100.0;
		System.out.println("La cajera comienza a pasar la compra en el segundo 0.\n");
		for (int i=0; i<6; i++) {
			if (compraParaPasar[i]==0) break;
			for (int j = 0; j < compraParaPasar[i]; j++) {				
				Thread.sleep(1110);
			}
			cuantoHaPasado = (System.currentTimeMillis()-inicial);
//			System.out.println(cuantoHaPasado);
			tiempo = tiempo + cuantoHaPasado;
			screen = Math.round((tiempo/1000.0)*aux)/aux;
			System.out.println("Acaba de pasar el producto " + (i+1) + " en el segundo " + screen);
		}
		System.out.println("\nLa cajera ha tardado " + screen + " segundos en procesar la compra\n");
	};
	
	
	
	
	
}
