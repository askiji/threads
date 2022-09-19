package paq1;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws InterruptedException {
		
		Scanner scLine = new Scanner(System.in);

		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		Cajera cajera1 = new Cajera();
		
		String repetir="s";
		int precision = getPrecision();
		do {

			cliente1.realizarCompra();
			cliente2.realizarCompra();

			cajera1.pasarCompra(cliente1 , precision);
			cajera1.pasarCompra(cliente2, precision);
			System.out.println("Pasar otra compra (s/n)?");
			
			repetir= scLine.nextLine();

		} while (repetir.equalsIgnoreCase("S"));

	}
	public static int getPrecision() {
		System.out.println("1) precision en segundo");
		System.out.println("2) precision en decimas de segundo");
		System.out.println("3) precision en centesimas de segundo");
		Scanner sc = new Scanner(System.in);
		int opcion = sc.nextInt();
		return opcion; 
	}

}
