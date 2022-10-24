package paq1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import com.sun.tools.javac.Main;

	
public class Principal {
	private static int precision;
	private static ArrayList<Cliente> cola = new ArrayList<>(); 
	private static ArrayList<Cliente> colaPAraUnaSola = new ArrayList<>(); 
	private static CajeraCC cajeraC1 = new CajeraCC(1, "Maria", "Garcia", "Cajera", "1A", "3ed4",precision);
	private static CajeraCC cajeraC2 = new CajeraCC(2,"Paz","Perez","Cajera", "2b","5ft6",precision);
	private static CajeraCC cajeraC3 = new CajeraCC(3,"Pedro","Hernan","Cajero","3c","34sf4",precision);
	
	public static void main(String[] args) throws InterruptedException  {
		Scanner scLine = new Scanner(System.in);
		String repetir="s";
		precision = getPrecision();
		generarClientes();
		pasarCompras();
		String pause = scLine.nextLine();
		CajeraCC una = new CajeraCC(99,"Explotada","Mucho","Cajera","4C","4ft6",precision);
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
		Runnable r1 = new CajeraCC(1, "Maria", "Garcia", "Cajera", "1A", "3ed4",precision);
		Thread t1 = new Thread(r1);
		cajeraC1.setPrecision(precision);
		Runnable r2 = new CajeraCC(2,"Paz","Perez","Cajera", "2b","5ft6",precision);
		Thread t2 = new Thread(r2);
		cajeraC2.setPrecision(precision);
		Runnable r3 = new CajeraCC(3,"Pedro","Hernan","Cajero","3c","34sf4",precision);
		Thread t3 = new Thread(r3);
		cajeraC3.setPrecision(precision);
		while (cola.size()!=0) {
			if(!t1.isAlive() && cola.size()!=0) {
				getCliente((CajeraCC) r1);
				t1.start();
			}
			if(!t2.isAlive() && cola.size()!=0) {
				getCliente((CajeraCC) r2);
				t2.start();
			}
			if(!t3.isAlive() && cola.size()!=0) {
				getCliente((CajeraCC) r3);
				t3.start();
			}
		}
		if (cola.size() == 0) {
			System.out.println("Ya no quedan clientes en la fila única, pulse enter");
		}
		
	}

	private static void getCliente(CajeraCC cajera) {
		cajera.setC(cola.get(0));
		cola.remove(0);
	}

	private static void esperar(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			
		}
		
	}


	private static void generarClientes() {
		for (int i = 0; i < 3; i++) {
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
