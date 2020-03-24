package interfaz;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelJugadores extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JLabel lbJugador1;
	public JLabel lbJugador2;
	private JTextField txtJugador1;
	private JTextField txtJugador2;
	private JButton btEnviar1;
	private JButton btEnviar2;


	public PanelJugadores(VentanaPrincipal ventanaPrincipal){
		setLayout(new GridLayout(3,2));
		setPreferredSize(new Dimension(0,100));
		TitledBorder TBorde= BorderFactory.createTitledBorder("Jugadores");
		TBorde.setTitleColor(Color.BLACK);
		setBorder(TBorde);
		btEnviar1 = new JButton("Enviar");
		btEnviar2 = new JButton("Enviar");
		txtJugador1=new JTextField();
		txtJugador2=new JTextField();
		lbJugador1=new JLabel("Jugador 1");
		lbJugador2=new JLabel("Jugador 2");
		lbJugador1.setForeground(Color.BLUE);
		lbJugador2.setForeground(Color.RED);
		btEnviar1.addActionListener(this);
		btEnviar2.addActionListener(this);
		
		add(btEnviar1);
		add(btEnviar2);
		add(txtJugador1);
		add(txtJugador2);
		add(lbJugador1);
		add(lbJugador2);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==btEnviar1){
			lbJugador1.setText(txtJugador1.getText());
		}
		if(e.getSource()==btEnviar2){
			lbJugador2.setText(txtJugador2.getText());
		}
	}

	
}
