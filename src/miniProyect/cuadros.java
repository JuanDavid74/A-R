/*
 * Programación Interactiva
 * Author: Juan David Olaya - 2026223
 * Case 1 : Game Atento y rapido
 */
package miniProyect;

import java.util.Random;

public class cuadros {
	
	private int caraBaldosa; // only atribute of the cuadros class
	
	/*
	 * this method return a random number in the range
	 * */
	public int getBaldosa() {
		Random aleatorio = new Random(); //Instancia un objeto tipo Random
		caraBaldosa  = aleatorio.nextInt(17)+1; //Numero aleatorio entre 1 y 6
		return caraBaldosa;
	}
	
}