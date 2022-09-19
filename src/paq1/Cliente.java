package paq1;

import java.util.Scanner;

public class Cliente {

	private int compra[] = new int [6];
	
	// ***** Getters y Setters
	
	public int[] getCompra() {
		return compra;
	}

	public void setCompra(int[] compra) {
		this.compra = compra;
	}
	
	//********

	
	
	public void realizarCompra() {
		
		Scanner scInt = new Scanner(System.in);
		int unidades=0;
		
		for (int i=0; i<6; i++) compra[i]=0; // vaciar la cesta
		
		for (int i=0; i<6;i++) {
		
			do {
				System.out.println("Unidades compradas del producto " + (i+1) + "?");
				unidades= scInt.nextInt();
				if (unidades==-1) break;
				
			}while(unidades<1 || unidades>4);
			
			if (unidades==-1) break;
			compra[i]=unidades;

		}
	}
	
	
	
	
}
