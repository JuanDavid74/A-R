package miniProyect;
/*
 * Programación Interactiva
 * Author: Juan David Olaya - 2026223
 * Case 1 : Game Atento y rapido
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;

import javax.swing.JPopupMenu.Separator;
import javax.swing.JTextField;

public class controlProjec {
private cuadros c1,c2,c3,c4,c5,c6,c7,c8;
	
	private int baldosaRandom, baldosaEscogida;
	private boolean pulsador= true, variable,variableEr; 
	private int[] baldosas,vectorNuevo;
	private Timer tiempo;

    //private String[] list = {"c1","c2","c3","c4","c5","c6","c7","c8"};

	/*
	 * this is the method constructor when is inicializated diferents atributes,and objects
	 * */
public controlProjec() {
	c1 = new cuadros(); 
	c2 = new cuadros();
	c3 = new cuadros();
	c4 = new cuadros();
	c5 = new cuadros();
	c6 = new cuadros();
	c7 = new cuadros();
	c8 = new cuadros();
	tiempo = new Timer();
	baldosas = new int[8];
	vectorNuevo = new int[3];
}
/*
 * return the level of the user
 * */
public int getNivel(int nivel){
	return nivel;
}
/*
 * return the lifes of the user
 * */
public int getVidas(int vidas) {
	return vidas;
}

}
