/*
 * Programaci�n Interactiva
 * Author: Juan David Olaya - 2026223
 * Case 1 : Game Atento y rapido
 */
package miniProyect;

import java.awt.EventQueue;

public class PrincipalMain {

	public static void main(String[] args) {
		// TODO Esbozo de m�todo generado autom�ticamente

		/*Una ventana grafica es un subproceso en si, por lo tanto falta una coordinacion
		Lo que se coordinan son los eventos que se den*/

	EventQueue.invokeLater(new Runnable() { //Hasta que el usuario no de click, no siguen los procesos

		@Override
		public void run() {
			GUIMiniProject play = new GUIMiniProject(); 
		}
	}); 
	}

}
