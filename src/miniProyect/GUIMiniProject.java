/*
 * Programación Interactiva
 * Author: Juan David Olaya - 2026223
 * Case 1 : Game Atento y rapido
 */
package miniProyect;

//all the importations that we need
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;

public  class GUIMiniProject extends JFrame {
	//atributes
	private JPanel punYniv, panelVid, panelUp, panelPull, panelLeft, panelRight , panelExit, panelDown ; 
	private JLabel lPuntaje, lNivel, lVidas;
	private JTextField tPuntaje, tVidas, tNivel;
	private JButton pulsador, exitGame;
	private ImageIcon imagen,imagen1,imagen2;
	private Titulos titulo;
	private Escucha escucha;
	private JFrame GUIMiniProject ;
	private controlProjec control;
	private int puntaje=0, vidas=3, aciertos=0, nivel=1;
	private Timer timer1, timer2, timer3, timer4, timer5,timerR,timerR2,timerR3,timerR4,timerR5;
	private Boolean yesDelay= false, retraso = false, gano = false;
	private JLabel labels[] = new JLabel[8];
	
	//methods
	/*
	 * this is the constructor of the GuiMiniproject
	 * with default values 
	 * */
	public GUIMiniProject(){
	
		//set default window configuration
		initGUI();
		control = new controlProjec();
		this.setUndecorated(true); //para quitar el decorado de la ventana
		this.setBackground(Color.WHITE);//el ultimo parametro es la transparencia
		this.pack(); // the size of the container is decide by computer
		this.setLocationRelativeTo(null);
		this.setResizable(false); 
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true); 
	}
	
	private void initGUI() {
		//set up container - layout

		this.getContentPane().setLayout(new GridBagLayout());
		GridBagConstraints contraints = new GridBagConstraints();
		
		//create objetos Escucha, contro, and others
		escucha = new Escucha();
		GUIMiniProject = this; //apuntador a si mismo (clase JFrame)
		timer1 = new Timer(2000,escucha); 
        timer2 = new Timer(1500,escucha);
        timer3 = new Timer(1100,escucha);
        timer4 = new Timer(900,escucha);
		timer5 = new Timer(700,escucha);
		//timer6 = new Timer(1700, escucha);
		timerR = new Timer(2000,escucha);
		timerR2 = new Timer(1500,escucha);
		timerR3 = new Timer(1100,escucha);
		timerR4 = new Timer(900,escucha);
		timerR5 = new Timer(700,escucha);

		//set up GUIComponents 

	//set up GUIcomponents 
	// titulo
	titulo = new Titulos(" Juego ",30, new Color(14, 240, 182));										
	titulo.setForeground(Color.WHITE); // letters colors
	titulo.addMouseListener(escucha); // in indicated the object where we can move
	titulo.addMouseMotionListener(escucha);
	titulo.setCursor(new Cursor(Cursor.MOVE_CURSOR)); // cursor type 
	// It is used to modify the characteristics where the "titulo" appears
	contraints.gridx=0; // busy column
	contraints.gridy=0; // busy row
	contraints.gridwidth = 3; // width 
	contraints.gridheight = 1; // height
	contraints.fill = GridBagConstraints.HORIZONTAL; // orientation
	add(titulo,contraints); // titulo is added into container with the contrains characteristics

	for(int i = 0; i < labels.length-1; i++) {
		labels[i] = new JLabel(); 
	}
	
		//Panel de puntaje y nivel
		punYniv = new JPanel();
		punYniv.setLayout(new GridLayout(2,4));
		punYniv.setBorder(new EmptyBorder(15,10,10,10) );
		
		lPuntaje = new JLabel("Puntaje");
		lNivel = new JLabel("Nivel");
		tPuntaje = new JTextField();
		tPuntaje.setEditable(false);
		tNivel = new JTextField();
		tNivel.setEditable(false);
		tPuntaje.setHorizontalAlignment(SwingConstants.CENTER);
		tNivel.setHorizontalAlignment(SwingConstants.CENTER);
		contraints.gridx = 0;
		contraints.gridy = 1;
		contraints.gridwidth = 1;
		contraints.gridheight = 1;
		contraints.fill = GridBagConstraints.NONE;
		contraints.anchor = GridBagConstraints.PAGE_START; // position in this coords
		punYniv.add(lPuntaje);
		punYniv.add(tPuntaje);
		punYniv.add(lNivel);
		punYniv.add(tNivel);
		add(punYniv, contraints);

		//Panel de las vidas
		panelVid = new JPanel();
		panelVid.setLayout(new GridLayout(1,1)); //matriz 2x2
		panelVid.setBorder(new EmptyBorder(15,10,10,10));
		
		lVidas = new JLabel("Vidas");
		tVidas = new JTextField();
		tVidas.setEditable(false);
		tVidas.setText(String.valueOf(vidas));
		tVidas.setHorizontalAlignment(SwingConstants.CENTER);
		panelVid.add(lVidas);
		panelVid.add(tVidas);
		//panelVid.setBackground(Color.WHITE);
		contraints.gridx = 2;
		contraints.gridy = 1;
		contraints.gridwidth = 1;
		contraints.gridheight = 1;
		contraints.fill = GridBagConstraints.NONE;
		contraints.anchor = GridBagConstraints.PAGE_START;
		add(panelVid, contraints);
		
		//Panel up
		panelUp = new JPanel();
		panelUp.setLayout(new GridLayout(2,1)); //matriz 2x1
		Border border = BorderFactory.createLineBorder(new Color(14, 240, 182),5);
		panelUp.setBorder(border);
		imagen1 = new ImageIcon("src/imagenes/6.png");
		labels[5] = new JLabel(imagen1);
		imagen1 = new ImageIcon("src/imagenes/5.png");
		labels[4] = new JLabel(imagen1);
		panelUp.add(labels[5]);
		panelUp.add(labels[4]);
		labels[5].setVisible(true);
		labels[4].setVisible(true);
		//panelVid.setBackground(Color.white);
		contraints.gridx = 1;
		contraints.gridy = 1;
		contraints.gridwidth = 1;
		//contraints.gridheight = 1;
		contraints.fill = GridBagConstraints.FIRST_LINE_START;
		add(panelUp, contraints);
		
		//Panel left
		panelLeft = new JPanel();
		panelLeft.setLayout(new GridLayout(1,2)); //matriz 1x2
		Border border2 = BorderFactory.createLineBorder(new Color(14, 240, 182),5); // this is the border of the panel
		panelLeft.setBorder(border2);
		imagen1 = new ImageIcon("src/imagenes/1.png");
		labels[0] = new JLabel(imagen1);
		imagen1 = new ImageIcon("src/imagenes/2.png");
		labels[1] = new JLabel(imagen1);
		panelLeft.add(labels[0]);
		panelLeft.add(labels[1]);
		labels[0].setVisible(true);
		labels[1].setVisible(true);
		contraints.gridx = 0;
		contraints.gridy = 2;
		contraints.gridwidth = 1;
		//contraints.gridheight = 1;
		contraints.fill = GridBagConstraints.NONE;
		add(panelLeft, contraints);
		
		//Panel right
		panelRight = new JPanel();
		panelRight.setLayout(new GridLayout(1,2)); //matriz 2x2
		Border border3 = BorderFactory.createLineBorder(new Color(14, 240, 182),5);
		panelRight.setBorder(border3);
		imagen1 = new ImageIcon("src/imagenes/7.png");
		labels[6] = new JLabel(imagen1);
		imagen1 = new ImageIcon("src/imagenes/8.png");
		labels[7] = new JLabel(imagen1);
		panelRight.add(labels[6]);
		panelRight.add(labels[7]);
		labels[6].setVisible(true);
		labels[7].setVisible(true);
		contraints.gridx = 2;
		contraints.gridy = 2;
		contraints.gridwidth = 1;
		//contraints.gridheight = 1;
		contraints.fill = GridBagConstraints.FIRST_LINE_START;
		add(panelRight, contraints);		
		
		//Panel pull
		panelPull = new JPanel();
		panelPull.setLayout(new GridLayout(1,2)); //matriz 2x2
		Border border4 = BorderFactory.createLineBorder(new Color(14, 240, 182),5);
		panelPull.setBorder(border4);
		pulsador = new JButton(" ");
		panelPull.setPreferredSize(new Dimension(100,100));
		pulsador.addActionListener(escucha);
		panelPull.add(pulsador);
		//panelVid.setBackground(Color.white);
		contraints.gridx = 1;
		contraints.gridy = 2;
		contraints.gridwidth = 1;
		//contraints.gridheight = 1;
		contraints.fill = GridBagConstraints.FIRST_LINE_START;
		contraints.anchor = GridBagConstraints.CENTER;
		add(panelPull, contraints);

		//Panel down
		panelDown = new JPanel();
		panelDown.setLayout(new GridLayout(2,1)); //matriz 2x1
		Border border5 = BorderFactory.createLineBorder(new Color(14, 240, 182),5);
		panelDown.setBorder(border5);
		imagen1 = new ImageIcon("src/imagenes/3.png");
		labels[2] = new JLabel(imagen1);
		imagen1 = new ImageIcon("src/imagenes/4.png");
		labels[3] = new JLabel(imagen1);
		panelDown.add(labels[2]);
		panelDown.add(labels[3]);
		labels[2].setVisible(true);
		labels[3].setVisible(true);
		contraints.gridx = 1;
		contraints.gridy = 3;
		contraints.gridwidth = 1;
		//contraints.gridheight = 1;
		contraints.fill = GridBagConstraints.NONE;
		add(panelDown, contraints);
		
		// Button exit
		exitGame = new JButton("Exit");
		exitGame.addActionListener(escucha);
		exitGame.setPreferredSize(new Dimension(70,50));
		exitGame.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		//Panel exit
		panelExit = new JPanel();
		panelExit.setLayout(new GridLayout(1,2)); //matriz 2x2
		panelExit.add(exitGame);
		//panelVid.setBackground(Color.white);
		contraints.gridx = 2;
		contraints.gridy = 3;
		contraints.gridwidth = 1;
		//contraints.gridheight = 1;
		contraints.fill = GridBagConstraints.FIRST_LINE_START;
		contraints.anchor = GridBagConstraints.PAGE_END;
		panelExit.setBorder(new EmptyBorder(15,10,10,10));
		add(panelExit, contraints);
		nivelesDos();
		tPuntaje.setText(String.valueOf(puntaje));
		
		labels[0].setVisible(false);
		labels[1].setVisible(false);
		labels[2].setVisible(false);
		labels[3].setVisible(false);
		labels[4].setVisible(false);
		labels[5].setVisible(false);
		labels[6].setVisible(false);
		labels[7].setVisible(false);	
     }
	
	//metodos
	
	public void random(int cuadros){
		
		Random aleatorio = new Random(System.currentTimeMillis());
		// Refrescar datos aleatorios 
		aleatorio.setSeed(System.currentTimeMillis());

		int nCuadro = aleatorio.nextInt(21)+1;

		imagen = new ImageIcon("src/imagenes/"+nCuadro+".png");
		int cC  = aleatorio.nextInt(cuadros);
		labels[cC].setIcon(imagen);
		
		if(labels[cC].equals(labels[0]) || labels[cC].equals(labels[1]) ){
			panelLeft.add(labels[cC]);
			
		}if( labels[cC].equals(labels[2]) || labels[cC].equals(labels[3]) ){
			panelDown.add(labels[cC]);
			
		}if(labels[cC].equals(labels[4]) || labels[cC].equals(labels[5])){
			panelUp.add(labels[cC]);
			
		}if (labels[cC].equals(labels[6]) || labels[cC].equals(labels[7])){
			panelRight.add(labels[cC]);
		
		}
		
		
		}
	
	/*
	 * if the comparations of the labels is true, win a point, this value is almacenated in his score
	 * is ubicated in a new level, and his hits are incremented
	 * */
	public void ganoPunto() {
		  puntaje+=5;
	      nivel+=1;
	      aciertos+=1;
	      tPuntaje.setText(String.valueOf(puntaje));
	     
	}

	/*
	 * if the comparations of the labels is false the user lose a point, and his lifes are reduced
	 * */
	public void perder() {
	    vidas-=1;
	    tVidas.setText(String.valueOf(vidas));
	}
	
	//metodos

	/*
	 * this method implements all the actions, and characteristics that make the objects like labels, buttons, titles, textarea, textfield.
	 * include all the interactions with the mouse or window
	 * some of this functions are: change the TextField, exit the program, move the window, make diferents mesagges. 
	 * */
	private class Escucha implements ActionListener, MouseListener, MouseMotionListener{
		private int x,y;

		
		@Override
		public void actionPerformed(ActionEvent event) {

			//PULSADOR
			if(event.getSource() == pulsador) {
					retraso = false;
					elDelay();					
					boolRepaint();
					compare();
					nivelesDos();
				
			}
			//NIVEL 1
					
			if(event.getSource() == timerR) {
				compare2();
				timerRetraso();	
			}
			if(event.getSource() == timer1){	
				labels[0].setVisible(true);
				labels[1].setVisible(true);
				labels[2].setVisible(true);		
				random(3);	
			}
			//NIVEL 2
			if(event.getSource() == timerR2) {
				timerRetraso();
				compare2();
			}
			
			if(event.getSource() == timer2){	
				labels[0].setVisible(true);
				labels[1].setVisible(true);
				labels[2].setVisible(true);
				labels[3].setVisible(true);
				random(4);
			}	
			//NIVEL 3
			if(event.getSource() == timerR3) {
				timerRetraso();
				compare2();
				}
			
			if(event.getSource() == timer3){
				labels[0].setVisible(true);
				labels[1].setVisible(true);
				labels[2].setVisible(true);
				labels[3].setVisible(true);
				labels[4].setVisible(true);	
				random(5);
			}
			
			
			//NIVEL 4	
			if(event.getSource() == timerR4) {
				timerRetraso();
				compare2();
			}	
			if(event.getSource() == timer4){	
				labels[0].setVisible(true);
				labels[1].setVisible(true);
				labels[2].setVisible(true);
				labels[3].setVisible(true);
				labels[4].setVisible(true);
				labels[5].setVisible(true);
				random(6);
			}
			
			
			//NIVEL 5
			
			if(event.getSource() == timerR5) {
				timerRetraso();
				compare2();	
				}
			
			if(event.getSource() == timer5){
				random(8);
				labels[0].setVisible(true);
				labels[1].setVisible(true);
				labels[2].setVisible(true);
				labels[3].setVisible(true);
				labels[4].setVisible(true);
				labels[5].setVisible(true);
				labels[6].setVisible(true);
				labels[7].setVisible(true);		
			}
			
			if(event.getSource() == exitGame) {
				System.exit(0); //0 porque se cierra de forma voluntaria
			}
		}
		public void mouseClicked(MouseEvent eventMouse) { //press + realeased
		}

		/**
		 * Mouse pressed. Indica un evento cuando el mouse es presionado en un punto especifico de la GUI.
		 */
		@Override
		public void mousePressed(MouseEvent eventMouse) {
			x= eventMouse.getX();
			y= eventMouse.getY();
		}

		/**
		 * mouseReleased. Indica un evento cuando el mouse esta sobre el area de un componente.
		 */
		
		@Override
		public void mouseReleased(MouseEvent eventMouse) {
		}

		/**
		 * mouseEntered. Indica un evento cuando se suelta un boton del mouse.
		 */
		@Override
		public void mouseEntered(MouseEvent eventMouse) {
		}
		/**
		 * mouseExited. Indica un evento cuando el mouse sale del area de un componente.
		 */
		@Override
		public void mouseExited(MouseEvent eventMouse) {
		}

		/**
		 * mouseDragged. Indica un evento cuando el mouse se oprime sobre un componente 
		 * y se mueve hacia otro lado mientras se mantiene presionado.
		 */
		
		@Override
		public void mouseDragged(MouseEvent eventMouse) { //Para desplazar la ventana

			/*El movimiento de la ventana se hace con mousePressed +mouseDragged
			 * vistaGridBagLayout.getLocation() posicion de la ventana
			 * x+eventMouseMotion.getX()-x numero de unidades que se esta moviendo el puntero
			 */
			// TODO Esbozo de método generado automáticamente
			// position of the window, number of the units thats move in x 
	setLocation(GUIMiniProject.getLocation().x +eventMouse.getX()- x ,
	//position of the window, number of the units thats move in y 
			GUIMiniProject.getLocation().y+eventMouse.getY()- y );
		}

		/**
		 * mouseMoved. Indica un evento cuando se mueve el mouse mientas está sobre un componente.
		 */
		@Override
		public void mouseMoved(MouseEvent eventMouseMotion) {
		}
	}
	/*
	 * This function or this method compare the labels of the panels when pulsador is push, and return a different acctions, like:
	 * ganoPunto(),perdioPunto(), set up the variables retraso and gano  
	 * */
	public void compare() {
		String lc1C = labels[0].getIcon().toString();
		String lc2C = labels[1].getIcon().toString();
		String lc3C = labels[2].getIcon().toString();
		String lc4C = labels[3].getIcon().toString();
		String lc5C = labels[4].getIcon().toString();
		String lc6C = labels[5].getIcon().toString();
		String lc7C = labels[6].getIcon().toString();
		String lc8C = labels[7].getIcon().toString();
		
		if(nivel == 1) { // 1 2 3
		 if(lc1C.equals(lc2C) || lc1C.equals(lc3C) || lc2C.equals(lc3C) ){
			retraso = false;
			gano = false;
			 ganoPunto();
			 
		 }else {
			perder();
			
		}
		}else if(nivel == 2) { // 1 2 3 4 
		 //compara los del nivel 2
		 if(lc1C.equals(lc2C) || lc1C.equals(lc3C) || lc1C.equals(lc4C) || lc2C.equals(lc3C) || lc2C.equals(lc4C) || lc3C.equals(lc4C) ){
			 retraso = false;
			gano = false;
			 ganoPunto();

		 }else {
			 perder();
		 }
		}else if(nivel == 3) { // 1 2 3 4 5
		 //compara los del nivel 3
		 if(lc1C.equals(lc2C) || lc1C.equals(lc3C) || lc1C.equals(lc4C)  || lc1C.equals(lc5C) || lc2C.equals(lc3C) || lc2C.equals(lc4C) || lc2C.equals(lc5C) || lc3C.equals(lc4C) || lc3C.equals(lc5C ) || lc4C.equals(lc5C )){          
			retraso = false;
			gano = false;
			ganoPunto();
		 }else {
			 perder();
		 }
		}else if(nivel == 4) { // 1 2 3 4 5 6 
		//compara los del nivel 4
		 if(lc1C.equals(lc2C) || lc1C.equals(lc3C) || lc1C.equals(lc4C)  || lc1C.equals(lc5C) || lc2C.equals(lc3C) || lc2C.equals(lc4C) || lc2C.equals(lc5C) || lc3C.equals(lc4C) || lc3C.equals(lc5C ) || lc4C.equals(lc5C ) || lc1C.equals(lc6C)  || lc2C.equals(lc6C)  || lc3C.equals(lc6C)  || lc4C.equals(lc6C)  || lc5C.equals(lc6C) ) {
			retraso = false;
			gano = false;
			ganoPunto();
		 }else{ 
			 perder();
		 }
	}else if(nivel >= 5) { // 1 2 3 4 5 6 7 8
		if(lc1C.equals(lc2C) || lc1C.equals(lc3C) || lc1C.equals(lc4C)  || lc1C.equals(lc5C) || lc2C.equals(lc3C) || lc2C.equals(lc4C) || lc2C.equals(lc5C) || lc3C.equals(lc4C) || lc3C.equals(lc5C ) || lc4C.equals(lc5C ) || lc1C.equals(lc6C)  || lc2C.equals(lc6C)  || lc3C.equals(lc6C)  || lc4C.equals(lc6C)  || lc5C.equals(lc6C) || lc1C.equals(lc7C) || lc1C.equals(lc8C) || lc2C.equals(lc7C) || lc2C.equals(lc8C) || lc3C.equals(lc7C) || lc3C.equals(lc8C) || lc4C.equals(lc7C) || lc4C.equals(lc8C) || lc5C.equals(lc7C) || lc5C.equals(lc8C) || lc6C.equals(lc7C) || lc6C.equals(lc8C) || lc7C.equals(lc8C) ) {
			retraso = false;
			gano = false;	
			ganoPunto();
			
		}else {
			perder();
		}
	}
	}
	
	/*
	 * This function or this method compare the labels of the panels when they are equals and the user dont push the button
	 * and return a different acctions, like:
	 * set up the variables retraso and gano  
	 * */
	public void compare2(){
		//compara los del nivel 2
		String lc1C = labels[0].getIcon().toString();
		String lc2C = labels[1].getIcon().toString();
		String lc3C = labels[2].getIcon().toString();
		String lc4C = labels[3].getIcon().toString();
		String lc5C = labels[4].getIcon().toString();
		String lc6C = labels[5].getIcon().toString();
		String lc7C = labels[6].getIcon().toString();
		String lc8C = labels[7].getIcon().toString();
			
		if(nivel == 1) { // 1 2 3
			if(lc1C.equals(lc2C) || lc1C.equals(lc3C) || lc2C.equals(lc3C)){
				retraso = true;
				gano = true;  
		   }else{
			   retraso = false;
			   gano = false;
		   }
		   }else if(nivel == 2) { // 1 2 3 4 
			//compare the level 2
			if(lc1C.equals(lc2C) || lc1C.equals(lc3C) || lc1C.equals(lc4C) || lc2C.equals(lc3C) || lc2C.equals(lc4C) || lc3C.equals(lc4C) ){
				retraso = true;
				gano = true;
			}else {
				retraso = false;
				gano = false;
			}
		   }else if(nivel == 3) { // 1 2 3 4 5
			//compara los del nivel 3
			if(lc1C.equals(lc2C) || lc1C.equals(lc3C) || lc1C.equals(lc4C)  || lc1C.equals(lc5C) || lc2C.equals(lc3C) || lc2C.equals(lc4C) || lc2C.equals(lc5C) || lc3C.equals(lc4C) || lc3C.equals(lc5C ) || lc4C.equals(lc5C )){          
				retraso = true;
				gano = true;
			}else {
				retraso = false;
				gano = false;
			}
		   }else if(nivel == 4) { // 1 2 3 4 5 6 
		   //compara los del nivel 4
			if(lc1C.equals(lc2C) || lc1C.equals(lc3C) || lc1C.equals(lc4C)  || lc1C.equals(lc5C) || lc2C.equals(lc3C) || lc2C.equals(lc4C) || lc2C.equals(lc5C) || lc3C.equals(lc4C) || lc3C.equals(lc5C ) || lc4C.equals(lc5C ) || lc1C.equals(lc6C)  || lc2C.equals(lc6C)  || lc3C.equals(lc6C)  || lc4C.equals(lc6C)  || lc5C.equals(lc6C) ){
				retraso = true;
				gano = true;
			}else {
				retraso = false;
				gano = false;
			}
	   }else if(nivel >= 5) { // 1 2 3 4 5 6 7 8
		   if(lc1C.equals(lc2C) || lc1C.equals(lc3C) || lc1C.equals(lc4C)  || lc1C.equals(lc5C) || lc2C.equals(lc3C) || lc2C.equals(lc4C) || lc2C.equals(lc5C) || lc3C.equals(lc4C) || lc3C.equals(lc5C ) || lc4C.equals(lc5C ) || lc1C.equals(lc6C)  || lc2C.equals(lc6C)  || lc3C.equals(lc6C)  || lc4C.equals(lc6C)  || lc5C.equals(lc6C) || lc1C.equals(lc7C) || lc1C.equals(lc8C) || lc2C.equals(lc7C) || lc2C.equals(lc8C) || lc3C.equals(lc7C) || lc3C.equals(lc8C) || lc4C.equals(lc7C) || lc4C.equals(lc8C) || lc5C.equals(lc7C) || lc5C.equals(lc8C) || lc6C.equals(lc7C) || lc6C.equals(lc8C) || lc7C.equals(lc8C) ) {
			retraso = true;
			gano = true;
			   
		   }else {
			retraso = false;
			gano = false;
		   }
	   }
	
	}



/*
 * this method evaluate the level of the user play, start the timers, and execute other function or method
 * */
public void nivelesDos() {
	yesDelay = true;
	tNivel.setText(String.valueOf(nivel)); // put in screen the level of the user
	//nivel 1
	if(nivel == 1){	
	timerR.start(); // start the time of the compare2
	timer1.start(); // start the time of the normal compare 
	lose(); 
	}
	
	if(nivel == 2){
	retraso = false;
	timerR2.start();
	timer2.start();
	lose();
	}

	//nivel 3
	if(nivel ==3){
	retraso = false;
	timerR3.start();
	timer3.start();
	
	lose();
	}
	//nivel 4
	if(nivel ==4){
	timerR4.start();
	timer4.start();
	
	lose();
	//nivel 5 en adelante
	}
	if(nivel >= 5) {
	timer5.start();
	timerR5.start();
	lose();
	}
}

/*
 * elDelay is a method which stopped the time, wait a 700 miliseconds and change the labels and his visibility
 * also stop the time, in the differents levels, the visibility of the labels it varies
 * */
public void elDelay() {
	int n = control.getNivel(nivel);
if(yesDelay == true){

    try {
       Thread.sleep(800); // the time between change of the labels and the level
       if(n == 1) { // the level of the user
       timerR.stop();  
       random(3);
       labels[0].setVisible(false); // the differents labels are oculted
       labels[1].setVisible(false);
       labels[2].setVisible(false);
       timer1.stop();
            }
      if(n == 2) { 
    	  timerR2.stop();
    	  random(4);
          labels[0].setVisible(false);
          labels[1].setVisible(false);
          labels[2].setVisible(false);
          labels[3].setVisible(false);      
          timer2.stop();
          
          }
      if(n== 3) {
    	  timerR3.stop();
    	  random(5);
          labels[0].setVisible(false);
          labels[1].setVisible(false);
          labels[2].setVisible(false);
          labels[3].setVisible(false);
          labels[4].setVisible(false);
            
          timer3.stop();
          }
      if(n == 4) {
    	  timerR4.stop();
    	  random(6);
          labels[0].setVisible(false);
          labels[1].setVisible(false);
          labels[2].setVisible(false);
		  labels[3].setVisible(false);
		  labels[4].setVisible(false);
		  labels[5].setVisible(false);
          timer4.stop();
         }
            if(n >= 5) {    
            timerR5.stop();
            random(8);
            labels[0].setVisible(false);
			labels[1].setVisible(false);
			labels[2].setVisible(false);
			labels[3].setVisible(false);
			labels[4].setVisible(false);
			labels[5].setVisible(false);
			labels[6].setVisible(false);
			labels[7].setVisible(false);
			timer5.start();
            }
     
    }catch (InterruptedException ie){
        Thread.currentThread().interrupt();
    }
    }

}
/*
 * repaint the panels when are contained the labels
 * */
public void boolRepaint() {
	
	if(nivel!=1) {
	
	panelLeft.repaint();
	panelDown.repaint();
	panelUp.repaint();
	panelRight.repaint();
}
}

/*
 * this method is executed all the same time with the change of images in the labels
 * the funcionality of the compare2 its compare the labels and if two of they are same
 * wait a second(or more)
 * and if the "pulsador" is not push, remove a life
 * */
public void timerRetraso() {
	
	lose();
	if(retraso == true){
		try {
			Thread.sleep(1000); //wait time
			if(gano == true){ 
				vidas-=1;
				tVidas.setText(String.valueOf(vidas));
			}
		}catch (InterruptedException ie){
			Thread.currentThread().interrupt();
		}
		
	}else{
		gano = false;
		tPuntaje.setText(String.valueOf(puntaje));
	}
}

/*
 * if the lifes are equal to 0 run a message in other window
 * when is visualizated the wrong, points, level, and there is a only option to exit the program
 * */
public void lose(){
	
	if( vidas == 0){
		
		String[] list = {"Salir"};
		imagen2 = new ImageIcon("src/imagenes/333.png");
		JOptionPane.showOptionDialog(GUIMiniProject,"Puntaje: "+puntaje+"\n"+"Errores : 3\n"+"Aciertos: "+aciertos,null,
				JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE , imagen2, list , JOptionPane.DEFAULT_OPTION);	
		System.exit(0);
		}
		
	}
}



