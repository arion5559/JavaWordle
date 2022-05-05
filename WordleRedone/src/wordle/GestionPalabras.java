package wordle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class GestionPalabras {

	public static Palabra generarPalabra() {

		String cadena = "";
		String palabra;
		Palabra palabraAuxiliar;
		FileReader fichero = null;
		BufferedReader lector = null;
		int numPalabras = 0;
		int posicionPalabra = 0;
		int contador = 0;
		boolean correcto = false;

		do {
			correcto = false;
			try {
				// la ruta del fichero es:
				fichero = new FileReader("datos/palabras2.txt");
				lector = new BufferedReader(fichero);

				while ((cadena = lector.readLine()) != null) {
					numPalabras++;
				}

				posicionPalabra = (int) Math.floor(Math.random() * numPalabras);

				fichero = new FileReader("datos/palabras2.txt");
				lector = new BufferedReader(fichero);

				for (int i = 0; i < posicionPalabra; i++) {
					cadena = lector.readLine();
				}

//				while ((cadena = lector.readLine()) != null && contador < posicionPalabra) {
//					contador++;
//				}

				correcto = true;

			} catch (FileNotFoundException e) {
				// e.printStackTrace();
				System.out.println("No se encuentra el fichero");
				correcto = true;
			} catch (IOException e) {
				System.out.println("Hay un problema de lectura");
				correcto = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

				try {
					if (lector != null) {
						lector.close();
					}
					if (fichero != null) {
						fichero.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				// System.out.println("fin");
			}
		} while (!correcto);

		palabraAuxiliar = new Palabra(cadena);

		return palabraAuxiliar;

	}

	public static boolean existe(String comprobar) {
		String palabra = "";
		String cadena = "";
		boolean existe = false;
		FileReader fichero = null;
		BufferedReader lector = null;
		int numPalabras = 0;

		if (comprobar.length() == 5) {
			for (int i = 0; i < 5; i++) {
				palabra += comprobar.charAt(i);
			}
			try {
				// la ruta del fichero es:
				fichero = new FileReader("datos/palabras2.txt");
				lector = new BufferedReader(fichero);

				while ((cadena = lector.readLine()) != null) {
					numPalabras++;
				}

				fichero = new FileReader("datos/palabras2.txt");
				lector = new BufferedReader(fichero);

				while ((cadena = lector.readLine()) != null && !existe) {
					if (cadena.equals(palabra) || cadena.toUpperCase().equals(palabra.toUpperCase())
							|| cadena.toLowerCase().equals(palabra.toLowerCase())) {
						existe = true;
					}
				}

			} catch (FileNotFoundException e) {
				// e.printStackTrace();
				System.out.println("No se encuentra el fichero");
			} catch (IOException e) {
				System.out.println("Hay un problema de lectura");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

				try {
					if (lector != null) {
						lector.close();
					}
					if (fichero != null) {
						fichero.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				// System.out.println("fin");
			}
			
			if (!existe) {
				System.out.println("Palabra no existente en el diccionario");
			}
		}
		
		return existe;
	}

}
