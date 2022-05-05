package wordle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class Tablero {
	private Palabra[] tablero = new Palabra[6];
	private Palabra[] correctoOno = new Palabra[6];
	private ArrayList<Character> letrasQueEstan = new ArrayList<Character>();
	private ArrayList<Character> letrasQueNoEstan = new ArrayList<Character>();

	public Tablero() {
		super();
		this.tablero = tablero;
		this.correctoOno = correctoOno;
		this.letrasQueEstan = letrasQueEstan;
		this.letrasQueNoEstan = letrasQueNoEstan;
		generarTablero();
	}

	public Palabra getTablero(int posicion) {
		return tablero[posicion];
	}

	public void setTablero(Palabra palabrapos, int posicion) {
		this.tablero[posicion] = palabrapos;
	}

	public Palabra[] getTablero() {
		return tablero;
	}

	public void setTablero(Palabra[] tablero) {
		this.tablero = tablero;
	}

	public Palabra[] getCorrectoOno() {
		return correctoOno;
	}

	public void setCorrectoOno(Palabra[] correctoOno) {
		this.correctoOno = correctoOno;
	}

	public ArrayList<Character> getLetrasQueEstan() {
		return letrasQueEstan;
	}

	public void setLetrasQueEstan(ArrayList<Character> letrasQueEstan) {
		this.letrasQueEstan = letrasQueEstan;
	}

	public ArrayList<Character> getLetrasQueNoEstan() {
		return letrasQueNoEstan;
	}

	public void setLetrasQueNoEstan(ArrayList<Character> letrasQueNoEstan) {
		this.letrasQueNoEstan = letrasQueNoEstan;
	}

	@Override
	public String toString() {
		return "Tablero [tablero=" + Arrays.toString(tablero) + ", correctoOno=" + Arrays.toString(correctoOno)
				+ ", letrasQueEstan=" + letrasQueEstan + ", letrasQueNoEstan=" + letrasQueNoEstan + "]";
	}

	private void generarTablero() {
		for (int i = 0; i < 6; i++) {
			tablero[i] = new Palabra("     ");
			correctoOno[i] = new Palabra("     ");
		}
	}

	public boolean comprobarTablero(Palabra comprobar, int contadorTablero, Palabra secreto) {
		boolean correcto = false;

		if (secreto.toStringCadena().equals(comprobar.toStringCadena())
				|| secreto.toStringCadena().toLowerCase().equals(comprobar.toStringCadena())
				|| secreto.toStringCadena().toUpperCase().equals(comprobar.toStringCadena())) {
			correcto = true;
		} else {
			tablero[contadorTablero] = comprobar;
			correctoOno[contadorTablero] = correctoOno[contadorTablero].estaOno(comprobar, secreto);

			for (int i = 0; i < comprobar.getCharspalabra().length; i++) {
				if (letrasQueEstan.toString().indexOf(comprobar.getCharpalabra(i)) == -1
						&& letrasQueEstan.toString().toUpperCase().indexOf(comprobar.getCharpalabra(i)) == -1
						&& letrasQueEstan.toString().indexOf(comprobar.getCharpalabra(i)) == -1
						&& comprobarChar(comprobar.getCharpalabra(i), secreto)) {
					letrasQueEstan.add(comprobar.getCharpalabra(i));
				} else if (letrasQueNoEstan.toString().indexOf(comprobar.getCharpalabra(i)) == -1
						&& letrasQueNoEstan.toString().toUpperCase().indexOf(comprobar.getCharpalabra(i)) == -1
						&& letrasQueNoEstan.toString().indexOf(comprobar.getCharpalabra(i)) == -1
						&& !letrasQueEstan.contains(comprobar.getCharpalabra(i))) {
					letrasQueNoEstan.add(comprobar.getCharpalabra(i));
				}
			}

			for (int i = 0; i < 6; i++) {
				System.out.println("   Intento: " + tablero[i].toStringCadena());
				System.out.println("Corrección: " + correctoOno[i].toStringCadena());
			}

			Collections.sort(letrasQueEstan);
			Collections.sort(letrasQueNoEstan);

			System.out.println("Letras que estan en la palabra hasta ahora: " + letrasQueEstan.toString());
			System.out.println(
					"Letras utilizadas no presentes en la palabra hasta ahora: " + letrasQueNoEstan.toString());
		}

		return correcto;
	}

	private static boolean comprobarChar(char comprobar, Palabra secreto) {
		boolean esta = false;
		String secretoString = "";

		for (int i = 0; i < 5; i++) {
			secretoString += secreto.getCharpalabra(i);
		}

		if (secretoString.indexOf(comprobar) != -1 || secretoString.toLowerCase().indexOf(comprobar) != -1
				|| secretoString.toUpperCase().indexOf(comprobar) != -1) {
			esta = true;
		}

		return esta;
	}
}
