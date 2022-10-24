package paq1;

import java.util.Random;

public class Cliente {

	private int compra[] = new int [4];
	private static int contador;
	private int id=0;
	
	public int getId() {
			return this.id;
		
	}

	public Cliente() {
		super();
		contador++;
		this.id= contador;
	}

	// ***** Getters y Setters
	
	public int[] getCompra() {
		
		return compra;
	}

	public void setCompra(int[] compra) {
		this.compra = compra;
	}
	
	//********
	
	public void realizarCompra() {
		Random r = new Random();
		for (int i = 0; i < r.nextInt(4)+1 ; i++) {
				compra[i]=r.nextInt(4)+1;
//				System.out.println(compra[i]);
			
		}
	}
	public void imprimirCompra(){
		System.out.println("Compra del cliente " + id);
		int aux = 1;
		for (int i : compra) {
			if (i==0) break;
			System.out.println("Producto " + (aux++) +" : "+ i +" unidades ");
		}
		System.out.println();
	}
	
	
	
}
