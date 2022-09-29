package paq1;

import java.util.Scanner;

	
public class Principal {
	private static int precision;
	public static void main(String[] args) throws InterruptedException {
		Scanner scLine = new Scanner(System.in);
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		Cliente cliente3 = new Cliente();
		CajeraSC cajera1 = new CajeraSC();
		CajeraCC cajeraC1 = new CajeraCC();
		CajeraCC cajeraC2 = new CajeraCC();
		CajeraCC cajeraC3 = new CajeraCC();
		String repetir="s";
		int precision = getPrecision();
		do {
   			cliente1.realizarCompra();
			cliente2.realizarCompra();
			cliente3.realizarCompra();
			cajera1.setPrecision(precision);
			cajera1.setC(cliente1);
			cajera1.pasarCompra();
			cajera1.setC(cliente2);
			cajera1.pasarCompra();
			cajera1.setC(cliente3);
			cajera1.pasarCompra();
			System.out.println("ahora las 3 cajeras");
			cajeraC1.setC(cliente1);
			cajeraC1.setPrecision(precision);
			cajeraC2.setC(cliente2);
			cajeraC2.setPrecision(precision);
			cajeraC3.setC(cliente3);
			cajeraC3.setPrecision(precision);
			cajeraC1.start();
			cajeraC2.start();
			cajeraC3.start();
			
			
//			System.out.println("Pasar otra compra (s/n)?");
			repetir= scLine.nextLine();
		} while (repetir.equalsIgnoreCase("S"));
	}
	
	public static int getPrecision() {
		System.out.println("1) precision en segundo");
		System.out.println("2) precision en decimas de segundo");
		System.out.println("3) precision en centesimas de segundo");
		Scanner sc = new Scanner(System.in);
		int opcion = sc.nextInt();
		precision = opcion;
		return opcion; 
	}
}
