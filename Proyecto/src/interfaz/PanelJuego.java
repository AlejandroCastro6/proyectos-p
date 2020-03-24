package interfaz;

//import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

public class PanelJuego extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private VentanaPrincipal principal;
//	private PanelJugadores panelJugadores;
	// private JButton btAtacar[][]= new JButton[3][3];;
	private JButton btAtacar1;
	private JButton btAtacar2;
	private JButton btAtacar3;
	private JButton btAtacar4;
	private JButton btAtacar5;
	private JButton btAtacar6;
	private JButton btAtacar7;
	private JButton btAtacar8;
	private JButton btAtacar9;
//	private ImageIcon puntoRojo;
//	private ImageIcon puntoAzul;
	public int caso;

	public PanelJuego(VentanaPrincipal ventanaPrincipal) {
		setLayout(new GridLayout(3, 2));
		setPreferredSize(new Dimension(0, 470));
		btAtacar1 = new JButton("Atacar");
		btAtacar2 = new JButton("Atacar");
		btAtacar3 = new JButton("Atacar");
		btAtacar4 = new JButton("Atacar");
		btAtacar5 = new JButton("Atacar");
		btAtacar6 = new JButton("Atacar");
		btAtacar7 = new JButton("Atacar");
		btAtacar8 = new JButton("Atacar");
		btAtacar9 = new JButton("Atacar");
//		puntoRojo = new ImageIcon("H:/img/calaveraRoja.jpg/");
//		puntoAzul = new ImageIcon("H:/calaveraAzul.jpg/");
		principal = ventanaPrincipal;
		btAtacar1.addActionListener(this);
		btAtacar1.setEnabled(true);
		btAtacar2.addActionListener(this);
		btAtacar2.setEnabled(true);
		btAtacar3.addActionListener(this);
		btAtacar3.setEnabled(true);
		btAtacar4.addActionListener(this);
		btAtacar4.setEnabled(true);
		btAtacar5.addActionListener(this);
		btAtacar5.setEnabled(true);
		btAtacar6.addActionListener(this);
		btAtacar6.setEnabled(true);
		btAtacar7.addActionListener(this);
		btAtacar7.setEnabled(true);
		btAtacar8.addActionListener(this);
		btAtacar8.setEnabled(true);
		btAtacar9.addActionListener(this);
		btAtacar9.setEnabled(true);
		add(btAtacar1);
		add(btAtacar2);
		add(btAtacar3);
		add(btAtacar4);
		add(btAtacar5);
		add(btAtacar6);
		add(btAtacar7);
		add(btAtacar8);
		add(btAtacar9);
		// for (int i = 0; i < 3; i++) {
		// for (int j = 0; j < 3; j++) {
		// btAtacar[i][j] = new JButton();
		// btAtacar[i][j].addActionListener(this);
		// btAtacar[i][j].setEnabled(true);
		// add(btAtacar[i][j]);
		// }

		// }

	}
	
	public void pintarBotonA(){
		switch(caso){
		case 1:
		    btAtacar1.setBackground(Color.BLUE);
		    btAtacar1=null;
		  break;
		case 2:
			btAtacar2.setBackground(Color.BLUE);
		    btAtacar2=null;
		    break;
		case 3:
			btAtacar3.setBackground(Color.BLUE);
		    btAtacar3=null;
		    break;
		case 4:
			btAtacar4.setBackground(Color.BLUE);
		    btAtacar4=null;
		    break;
		case 5:
			btAtacar5.setBackground(Color.BLUE);
		    btAtacar5=null;
		    break;
		case 6:
			btAtacar6.setBackground(Color.BLUE);
		    btAtacar6=null;
		    break;
		case 7:
			btAtacar7.setBackground(Color.BLUE);
		    btAtacar7=null;
		    break;
		case 8:
			btAtacar8.setBackground(Color.BLUE);
		    btAtacar8=null;
		    break;
		case 9:
			btAtacar9.setBackground(Color.BLUE);
		    btAtacar9=null;
		    break;
		}
		
	}
	
	public void pintarBotonR(){
		switch(caso){
		case 1:
		    btAtacar1.setBackground(Color.RED);
		    btAtacar1=null;
		  break;
		case 2:
			btAtacar2.setBackground(Color.RED);
		    btAtacar2=null;
		    break;
		case 3:
			btAtacar3.setBackground(Color.RED);
		    btAtacar3=null;
		    break;
		case 4:
			btAtacar4.setBackground(Color.RED);
		    btAtacar4=null;
		    break;
		case 5:
			btAtacar5.setBackground(Color.RED);
		    btAtacar5=null;
		    break;
		case 6:
			btAtacar6.setBackground(Color.RED);
		    btAtacar6=null;
		    break;
		case 7:
			btAtacar7.setBackground(Color.RED);
		    btAtacar7=null;
		    break;
		case 8:
			btAtacar8.setBackground(Color.RED);
		    btAtacar8=null;
		    break;
		case 9:
			btAtacar9.setBackground(Color.RED);
		    btAtacar9=null;
		    break;
		}
}
	

	public void actionPerformed(ActionEvent click) {

		if (click.getSource() == btAtacar1 ){
			if (btAtacar1 != null){
				caso=1;
				principal.btAtacar();
		    }
		}
		else if (click.getSource() == btAtacar2 ){
			if (btAtacar2 != null){
				caso=2;
				principal.btAtacar();
		    }
		}
		else if (click.getSource() == btAtacar3 ){
			if (btAtacar3 != null){
				caso=3;
				principal.btAtacar();
		    }
		}
		else if (click.getSource() == btAtacar4 ){
			if (btAtacar4 != null){
				caso=4;
				principal.btAtacar();
		    }
		}
		else if (click.getSource() == btAtacar5 ){
			if (btAtacar5 != null){
				caso=5;
				principal.btAtacar();
		    }
		}
		else if (click.getSource() == btAtacar6 ){
			if (btAtacar6 != null){
				caso=6;
				principal.btAtacar();
		    }
		}
		else if (click.getSource() == btAtacar7 ){
			if (btAtacar7 != null){
				caso=7;
				principal.btAtacar();
		    }
		}
		else if (click.getSource() == btAtacar8 ){
			if (btAtacar8 != null){
				caso=8;
				principal.btAtacar();
		    }
		}
		else if (click.getSource() == btAtacar9 ){
			if (btAtacar9 != null){
				caso=9;
				principal.btAtacar();
		    }
		}
	}

		// for (int i = 0; i < 3; i++) {
		// for (int j = 0; j < 3; j++) {
		// if (click.getSource() == btAtacar[i][j]) {
		// if (btAtacar[i][j].getIcon() == null) {
		// if (principal.btAtacar() == 1) {
		// btAtacar[i][j].setIcon(puntoAzul);
		// }else if(principal.btAtacar()==2){
		// btAtacar[i][j].setIcon(puntoRojo);
		// }
		//
		// }
		// }
		// }
		// }
	}

	/*
	 * public void recorrerMatriz() { int contJ1=0; int contJ2=0; for (int i =
	 * 0; i < 3; i++) { for (int j = 0; j < 3; j++) {
	 * if(btAtacar[i][j].getIcon()!= null){ if(btAtacar[i][j].getIcon()==
	 * puntoAzul) contJ1++; } if(btAtacar[i][j].getIcon()!= null){
	 * if(btAtacar[i][j].getIcon()== puntoRojo){ contJ2++; } } } }
	 * if(contJ1>contJ2){ System.out.println("gana Jugador 1"); }
	 * if(contJ2>contJ1){ System.out.println("gana Jugador 2"); } }
	 */

