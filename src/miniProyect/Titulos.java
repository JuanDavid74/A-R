/*
 * Programación Interactiva
 * Author: Juan David Olaya - 2026223
 * Case 1 : Game Atento y rapido
 */
package miniProyect;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Titulos extends JLabel {
	//atributes
	
	//methods
	
	// class for create tittles with defined characteristics  
	public Titulos(String texto, int tamano, Color colorFondo) {
		this.setText(texto);
		// propiedades basicar para la fuente
		Font font = new Font(Font.SERIF,Font.BOLD+Font.ITALIC, tamano);
							// font // style negrita and cursiva // size
		this.setFont(font); //for the text is aplicated this characteristics 
		this.setBackground(colorFondo); // color Background
		this.setForeground(Color.BLACK); //color text
		this.setHorizontalAlignment(JLabel.CENTER); // align the text (center in this case)
		this.setOpaque(true);
	}
}