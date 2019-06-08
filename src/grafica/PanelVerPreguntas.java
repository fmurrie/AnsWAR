package grafica;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelVerPreguntas extends SuperPanel
{

	/**
	 * Create the panel.
	 */
	public PanelVerPreguntas(JPanel contentPane)
	{
		setLayout(new GridLayout(4, 1, 0, 0));
		setBackground(Color.BLACK);
		
		JLabel lblDisciplina = new JLabel("Seleccione la disciplina");
		lblDisciplina.setFont(new Font("Stencil", Font.PLAIN, 18));
		lblDisciplina.setForeground(Color.WHITE);
		add(lblDisciplina);
		
		JLabel label = new JLabel("");
		add(label);
		
		JLabel label_1 = new JLabel("");
		add(label_1);
		
		ButtonGroup grupoRdionBotomns=new ButtonGroup();
		JRadioButtonMenuItem rdbtnGeografia = new JRadioButtonMenuItem("Geografia");
		rdbtnGeografia.setSelected(true);
		JRadioButtonMenuItem rdbtnHistoria = new JRadioButtonMenuItem("Historia");
		JRadioButtonMenuItem rdbtnDeporte = new JRadioButtonMenuItem("Deporte");
		JRadioButtonMenuItem rdbtnEntretenimiento = new JRadioButtonMenuItem("Entretenimiento");
		JRadioButtonMenuItem rdbtnArte = new JRadioButtonMenuItem("Arte");
		JRadioButtonMenuItem rdbtnCiencia = new JRadioButtonMenuItem("Ciencia");
		grupoRdionBotomns.add(rdbtnGeografia);
		grupoRdionBotomns.add(rdbtnHistoria);
		grupoRdionBotomns.add(rdbtnDeporte);
		grupoRdionBotomns.add(rdbtnEntretenimiento);
		grupoRdionBotomns.add(rdbtnArte);
		grupoRdionBotomns.add(rdbtnCiencia);
		add(rdbtnGeografia);
		add(rdbtnHistoria);
		add(rdbtnDeporte);
		add(rdbtnEntretenimiento);
		add(rdbtnArte);
		add(rdbtnCiencia);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desplazarAotroPanel(contentPane,"panelMenuADMenunciados");
			}
		});
		btnVolver.setBackground(Color.BLACK);
		btnVolver.setForeground(Color.CYAN);
		btnVolver.setFont(new Font("Stencil", Font.PLAIN, 18));
		add(btnVolver);
		
		JLabel label_2 = new JLabel("");
		add(label_2);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.setFont(new Font("Stencil", Font.PLAIN, 18));
		btnMostrar.setForeground(Color.GREEN);
		btnMostrar.setBackground(Color.BLACK);
		add(btnMostrar);

	}

}
