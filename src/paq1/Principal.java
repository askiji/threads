package paq1;

import java.util.ArrayList;
import java.util.Scanner;

import com.sun.tools.javac.Main;

	
public class Principal {
	private static int precision;
	private static ArrayList<Cliente> cola = new ArrayList<>(); 
	private static CajeraCC cajeraC1 = new CajeraCC(1);
	private static CajeraCC cajeraC2 = new CajeraCC(2);
	private static CajeraCC cajeraC3 = new CajeraCC(3);
	
	public static void main(String[] args) throws InterruptedException {
		Scanner scLine = new Scanner(System.in);
//		Cliente cliente1 = new Cliente();
//		Cliente cliente2 = new Cliente();
//		Cliente cliente3 = new Cliente();
		String repetir="s";
		int precision = getPrecision();
		cajeraC1.setPrecision(precision);
		cajeraC2.setPrecision(precision);
		cajeraC3.setPrecision(precision);
//		cajeraC1.start();
//		cajeraC2.start();
//		cajeraC3.start();

		pedirClientes();
		pasarCompras();
//		do {
//   		cliente1.realizarCompra();
//			cliente2.realizarCompra();
//			cliente3.realizarCompra();
//			cliente1.imprimirCompra();
//			cliente2.imprimirCompra();
//			cliente3.imprimirCompra();
//			cajera1.setPrecision(precision);
//			cajera1.setC(cliente1);
//			cajera1.pasarCompra();
//			cajera1.setC(cliente2);
//			cajera1.pasarCompra();
//			cajera1.setC(cliente3);
//			cajera1.pasarCompra();
//			System.out.println("ahora las 3 cajeras");
//			cajeraC1.setC(cliente1);
//			cajeraC2.setC(cliente2);
//			cajeraC3.setC(cliente3);
//			
//				do {
//					
//					Thread.sleep(1200);
//				} while (cajeraC1.isAlive() || cajeraC2.isAlive() || cajeraC3.isAlive());
//			System.out.println("Tiempo invertido en pasar las 3 compras una cajera : "  + cajera1.getTiempoTodasCompras());
//			System.out.println("Tiempo invertido en pasar las 3 compras 3 cajeras en paralelo : "+ CajeraCC.getTiempoMax());
//			System.out.println("TIEMPO GANADO EN EL SEGUNDO CASO : " +(cajera1.getTiempoTodasCompras()-CajeraCC.getTiempoMax()));
//				System.out.println("Pasar otra compra (s/n)? ");
//				repetir= scLine.nextLine();
//		} while (repetir.equalsIgnoreCase("S"));
	}
	
	private static void pasarCompras() throws InterruptedException {
		int ClienteContador=0;
		do {
//			System.out.println(cajeraC1.isAlive());

			if(!cajeraC1.isAlive()) {
				System.out.println("CCCCCCCCCCCCCCCC");
				cajeraC1 = new CajeraCC(1);
				cajeraC1.setPrecision(precision);
				cajeraC1.setC(cola.get(ClienteContador++));
				cajeraC1.start();
//				cajeraC1.pasarCompra();
//				cola.remove(0);
			}
		
			else if(!cajeraC2.isAlive()) {
				cajeraC2 = new CajeraCC(2);
				cajeraC2.setPrecision(precision);
				cajeraC2.setC(cola.get(ClienteContador++));
				cajeraC2.start();
//				cajeraC2.pasarCompra();
//				cola.remove(0);
			}
			else if(!cajeraC3.isAlive()) {
				cajeraC3 = new CajeraCC(3);
				cajeraC3.setPrecision(precision);
				cajeraC3.setC(cola.get(ClienteContador++));
				cajeraC3.start();
				
//				cajeraC3.pasarCompra();
//				cola.remove(0);
			}
		} while (!(ClienteContador == cola.size()));
		
	}

	private static void pedirClientes() {
		System.out.println("Cuantos clientes existen (4  a 8)");
		Scanner sc = new Scanner(System.in);
		try {
			int aux = sc.nextInt();
			if(aux>=4 && aux<=8 ) {
				generarClientes(aux);
				
			}
			else {
				pedirClientes();
			}
		} catch (Exception e) {
			pedirClientes();
		}
	}

	private static void generarClientes(int numeroClietnes) {
		for (int i = 0; i < numeroClietnes; i++) {
			System.out.println("asdasd");
			Cliente aux = new Cliente();
			
			System.out.println(aux.toString());
			aux.realizarCompra();
			cola.add(aux);
			cola.get(i).imprimirCompra();
		}
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
