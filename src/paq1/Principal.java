package paq1;

import java.util.ArrayList;
import java.util.Scanner;

import com.sun.tools.javac.Main;

	
public class Principal {
	private static int precision;
	private static ArrayList<Cliente> cola = new ArrayList<>(); 
	private static ArrayList<Cliente> colaPAraUnaSola = new ArrayList<>(); 
	private static CajeraCC cajeraC1 = new CajeraCC(1);
	private static CajeraCC cajeraC2 = new CajeraCC(2);
	private static CajeraCC cajeraC3 = new CajeraCC(3);

	
	public static void main(String[] args) throws InterruptedException  {
		Scanner scLine = new Scanner(System.in);
		String repetir="s";
		precision = getPrecision();
		pedirClientes();
		pasarCompras();
		String pause = scLine.nextLine();
		CajeraCC una = new CajeraCC(99);
		una.setPrecision(precision);
		for (Cliente cliente : colaPAraUnaSola) {
			una.setC(cliente);
			una.pasarCompra();
		}
		System.out.println("Nos hemos ahorrado " + (CajeraCC.getUnaCajera()- CajeraCC.getTiempoMax()));
		System.out.println("Cajera 1:");
		System.out.println(CajeraCC.getInforme()[0]);
		System.out.println("Cajera 2:");
		System.out.println(CajeraCC.getInforme()[1]);
		System.out.println("Cajera 3:");
		System.out.println(CajeraCC.getInforme()[2]);
	}
	
	private static void pasarCompras() throws InterruptedException {
		int fixer= cola.size();
		do {
			do {
				if (!cajeraC1.isAlive() && cola.size() != 0) {
					CajeraCC cajeraC1 = new CajeraCC(1);
					cajeraC1.setPrecision(precision);
					cajeraC1.setC(cola.get(0));
					cajeraC1.start();
					colaPAraUnaSola.add(cola.get(0));
					cola.remove(0);
				}
				if (!cajeraC2.isAlive() && cola.size() != 0) {
					CajeraCC cajeraC2 = new CajeraCC(2);
					cajeraC2.setPrecision(precision);
					cajeraC2.setC(cola.get(0));
					cajeraC2.start();
					colaPAraUnaSola.add(cola.get(0));
					cola.remove(0);
				}
				if (!cajeraC3.isAlive() && cola.size() != 0) {
					CajeraCC cajeraC3 = new CajeraCC(3);
					cajeraC3.setPrecision(precision);
					cajeraC3.setC(cola.get(0));
					cajeraC3.start();
					colaPAraUnaSola.add(cola.get(0));
					cola.remove(0);
				}
				esperar(20);
			} while (cola.size() != 0);
		} while (cajeraC1.isAlive() || cajeraC2.isAlive() || cajeraC3.isAlive());
		if (cola.size() == 0) {
			System.out.println("Ya no quedan clientes en la fila única, pulse enter");
		}
		
	}

	private static void esperar(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			
		}
		
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
			Cliente aux = new Cliente();
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
