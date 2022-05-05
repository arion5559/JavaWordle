package wordle;

import java.util.ArrayList;
import java.util.Arrays;

public class Palabra {
	private char[] charspalabra;

	public Palabra(String palabra) {
		super();
		this.charspalabra = new char[5];
		charspalabra = generarPalabra(palabra);
	}

	public char[] getCharspalabra() {
		return charspalabra;
	}

	public char[] setCharspalabra(char caracter, int pos) {
		this.charspalabra[pos] = caracter;
		return charspalabra;
	}

	public char getCharpalabra(int posicion) {
		return charspalabra[posicion];
	}

	@Override
	public String toString() {
		return "Palabra [charspalabra=" + Arrays.toString(charspalabra) + "]";
	}

	public String toStringCadena() {
		return Arrays.toString(charspalabra);
	}

	public char[] generarPalabra(String palabra) {
		charspalabra = palabra.toCharArray();

		return charspalabra;
	}

	public Palabra estaOno(Palabra comprobar, Palabra secreto) {
		Palabra posiciones;
		char[] posicionesAuxiliar = new char[5];
		String cadenaAuxiliarString = "";
		ArrayList<Character> palabraParaComprobar = new ArrayList<Character>();

		for (int i = 0; i < 5; i++) {
			palabraParaComprobar.add(comprobar.getCharpalabra(i));
		}

//		System.out.println(comprobar);
//		System.out.println(secreto);

		for (int i = 0; i < 5; i++) {
			if (comprobar.getCharpalabra(i) == secreto.getCharpalabra(i)
					|| comprobar.getCharpalabra(i) == Character.toUpperCase(secreto.getCharpalabra(i))
					|| comprobar.getCharpalabra(i) == Character.toLowerCase(secreto.getCharpalabra(i))
			/* && palabraParaComprobar.contains(comprobar.getCharpalabra(i)) */) {
				posicionesAuxiliar[i] = '+';
				// palabraParaComprobar.remove(comprobar.getCharpalabra(i));
			} else if (secreto.toStringCadena().indexOf(comprobar.getCharpalabra(i)) != -1
					|| secreto.toStringCadena().indexOf(Character.toUpperCase(comprobar.getCharpalabra(i))) != -1
					|| secreto.toStringCadena().indexOf(Character.toLowerCase(comprobar.getCharpalabra(i))) != -1
			/* && palabraParaComprobar.contains(comprobar.getCharpalabra(i)) */) {
				posicionesAuxiliar[i] = '*';
				// palabraParaComprobar.remove(comprobar.getCharpalabra(i));
			} else {
				posicionesAuxiliar[i] = '_';
			}
		}

		for (int i = 0; i < posicionesAuxiliar.length; i++) {
			cadenaAuxiliarString += posicionesAuxiliar[i];
		}

		posiciones = new Palabra(cadenaAuxiliarString);

		return posiciones;
	}
}