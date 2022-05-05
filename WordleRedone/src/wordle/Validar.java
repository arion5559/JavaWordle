package wordle;
import java.util.ArrayList;
import java.util.Scanner;

public class Validar {

	private int numeroInt;
	private float numeroFloat;

	public Validar(int numeroInt, float numeroFloat) {
		super();
		this.numeroInt = numeroInt;
		this.numeroFloat = numeroFloat;
	}

	public int getNumeroInt() {
		return numeroInt;
	}

	public void setNumeroInt(int numeroInt) {
		this.numeroInt = numeroInt;
	}

	public float getNumeroFloat() {
		return numeroFloat;
	}

	public void setNumeroFloat(float numeroFloat) {
		this.numeroFloat = numeroFloat;
	}

	public static int validarInt(String imprimir) {
		int numero;
		String numeroJug = "";
		String numeros = "1234567890";
		boolean valido = true;
		int contador;
		Scanner sc = new Scanner(System.in);

		do {
			contador = 0;
			System.out.println(imprimir);
			numeroJug = sc.nextLine();
			valido = true;
			do {
				if (numeros.indexOf(numeroJug.charAt(contador)) == -1) {
					valido = false;
					System.out.println("Error, no válido");
				}
				contador++;
			} while (valido && contador < numeroJug.length());
		} while (!valido);

		numero = Integer.parseInt(numeroJug);

		return numero;
	}

	public static float validarFloat(String imprimir) {
		float numero;
		String numerosString = "";
		String numeros = "1234567890";
		String coma = ".,'";
		boolean valido = true;
		int contador;
		Scanner sc = new Scanner(System.in);

		do {
			contador = 0;
			System.out.println(imprimir);
			numerosString = sc.nextLine();
			valido = true;
			do {
				if (numeros.indexOf(numerosString.charAt(contador)) == -1
						&& coma.indexOf(numerosString.charAt(contador)) == -1) {
					valido = false;
					System.out.println("Error, no válido");
				}
				contador++;
			} while (valido && contador < numerosString.length());
		} while (!valido);

		numero = Float.valueOf(numerosString);

		return numero;
	}
	
	public static char validarChar(String imprimir, char caracter1/*, char caracter2*/) {
		String respuesta = "";
		char respuestaChar;
		boolean valido = true;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println(imprimir);
			respuesta = sc.nextLine();
			valido = true;
			if (respuesta.length() > 2) {
				valido = false;
				System.out.println("Error, no válido");
			} else {
				if (respuesta.charAt(0) != caracter1 /*&& respuesta.charAt(0) != caracter2*/) {
					valido = false;
					System.out.println("Error, no válido");
				}
			}
		} while (!valido);

		respuestaChar = respuesta.charAt(0);

		return respuestaChar;
	}
	
	public static String validarPalabra(String imprimir, int longitud) {
		String respuesta = "";
		boolean valido = true;
		String letras = "qwertyuiopasdfghjklñzxcvbnmQWERTYUIOPASDFGHJKLÑZXCVBNM";
		int contador = 0;
		Scanner sc = new Scanner(System.in);

		do {
			valido = true;
			respuesta = "";
			contador = 0;
			System.out.println(imprimir);
			try {
			respuesta = sc.nextLine();
			} catch (Exception e) {
				valido = false;
			}
			
			if (valido) {
				if (respuesta.length() != longitud) {
					valido = false;
					System.out.println("Error, longitud no válida");
				} else {
					do {
						if (letras.indexOf(respuesta.charAt(contador)) == -1) {
							valido = false;
						}
						contador++;
					} while (valido && contador < respuesta.length());
				} 
			}
			
			valido = GestionPalabras.existe(respuesta);

		} while (!valido);

		//respuesta = respuesta.charAt(0);

		return respuesta;
	}

}
