package wordle;
import wordle.GestionPalabras;
import wordle.Palabra;
import wordle.Tablero;
import wordle.Validar;

public class Gestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Palabra palabrasecreta = GestionPalabras.generarPalabra();
		
		// System.out.println(palabrasecreta.toString());
		
 		jugar(palabrasecreta);
	}

	private static void jugar(Palabra secreto) {
		String palabra;
		Palabra respuesta;
		Tablero tableroJuego = new Tablero();
		boolean correcto = false;
		int intentos = 0;
		
		do {
			palabra = Validar.validarPalabra("Introduzca su intento", 5);
			respuesta = new Palabra(palabra);
			
			correcto = tableroJuego.comprobarTablero(respuesta, intentos, secreto);
			
			intentos++;
		} while (!correcto && intentos < 6);
		
		System.out.println(secreto.toStringCadena());
		System.out.println(intentos);
	}
}
