package grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PanelMenuADMjugadores extends SuperPanel
{

	/**
	 * Create the panel.
	 */
	public PanelMenuADMjugadores(JPanel contentPane)
	{
		setBackground(Color.BLACK);
		setLayout(new GridLayout(0,1,0,0));

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("src/imagenes/AnswarTitulo.png"));
		add(label);

		JButton btnVerRank = new JButton("Ver clasificacion");
		btnVerRank.setBackground(Color.BLACK);
		btnVerRank.setForeground(Color.GREEN);
		btnVerRank.setFont(new Font("Stencil",Font.PLAIN,18));
		add(btnVerRank);

		JButton btnEditJugador = new JButton("Editar jugador");
		btnEditJugador.setForeground(Color.ORANGE);
		btnEditJugador.setFont(new Font("Stencil",Font.PLAIN,18));
		btnEditJugador.setBackground(Color.BLACK);
		add(btnEditJugador);
		
		JButton btnElimicarJugador = new JButton("Eliminar jugador");
		btnElimicarJugador.setForeground(Color.RED);
		btnElimicarJugador.setBackground(Color.BLACK);
		btnElimicarJugador.setFont(new Font("Stencil", Font.PLAIN, 18));
		add(btnElimicarJugador);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desplazarAotroPanel(contentPane,"panelMenuAdministracion");
			}
		});
		btnVolver.setForeground(Color.CYAN);
		btnVolver.setBackground(Color.BLACK);
		btnVolver.setFont(new Font("Stencil", Font.PLAIN, 18));
		add(btnVolver);

	}

}
