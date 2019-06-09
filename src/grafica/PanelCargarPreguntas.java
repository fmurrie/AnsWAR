package grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBox;

public class PanelCargarPreguntas extends SuperPanel
{
	/**
	 * Create the panel.
	 */
	public PanelCargarPreguntas(JPanel contentPane)
	{
		setLayout(new GridLayout(18,1,0,0));
		setBackground(Color.BLACK);

		JLabel lblDisciplina = new JLabel("     Disciplina");
		lblDisciplina.setFont(new Font("Stencil",Font.PLAIN,18));
		lblDisciplina.setForeground(Color.WHITE);
		add(lblDisciplina);

		JLabel label_3 = new JLabel("");
		add(label_3);

		ButtonGroup grupoRdionBotomns = new ButtonGroup();
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

		JLabel label_4 = new JLabel("");
		add(label_4);

		JLabel label_5 = new JLabel("");
		add(label_5);

		JLabel lblPregunta = new JLabel("     Pregunta: ");
		lblPregunta.setBackground(Color.BLACK);
		lblPregunta.setForeground(Color.WHITE);
		lblPregunta.setHorizontalAlignment(SwingConstants.LEFT);
		lblPregunta.setFont(new Font("Stencil",Font.PLAIN,18));
		lblPregunta.setOpaque(true);
		add(lblPregunta);

		JTextField textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Tahoma",Font.PLAIN,16));
		textField.setBackground(Color.LIGHT_GRAY);
		add(textField);
		textField.setColumns(10);

		JLabel label_6 = new JLabel("");
		add(label_6);

		JLabel label_7 = new JLabel("");
		add(label_7);

		JLabel lblOpcionA = new JLabel("     Opcion A:");
		lblOpcionA.setBackground(Color.BLACK);
		lblOpcionA.setForeground(Color.WHITE);
		lblOpcionA.setHorizontalAlignment(SwingConstants.LEFT);
		lblOpcionA.setFont(new Font("Stencil",Font.PLAIN,18));
		lblOpcionA.setOpaque(true);
		add(lblOpcionA);

		JTextField textField36 = new JTextField();
		textField36.setHorizontalAlignment(SwingConstants.CENTER);
		textField36.setFont(new Font("Tahoma",Font.PLAIN,16));
		textField36.setBackground(Color.LIGHT_GRAY);
		add(textField36);
		textField36.setColumns(10);

		JLabel lblOpcionB = new JLabel("     Opcion B:");
		lblOpcionB.setBackground(Color.BLACK);
		lblOpcionB.setForeground(Color.WHITE);
		lblOpcionB.setHorizontalAlignment(SwingConstants.LEFT);
		lblOpcionB.setFont(new Font("Stencil",Font.PLAIN,18));
		lblOpcionB.setOpaque(true);
		add(lblOpcionB);

		JTextField textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setFont(new Font("Tahoma",Font.PLAIN,16));
		textField_2.setBackground(Color.LIGHT_GRAY);
		add(textField_2);
		textField_2.setColumns(10);

		JLabel lblOpcionC = new JLabel("     Opcion C:");
		lblOpcionC.setBackground(Color.BLACK);
		lblOpcionC.setForeground(Color.WHITE);
		lblOpcionC.setHorizontalAlignment(SwingConstants.LEFT);
		lblOpcionC.setFont(new Font("Stencil",Font.PLAIN,18));
		lblOpcionC.setOpaque(true);
		add(lblOpcionC);

		JTextField textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setFont(new Font("Tahoma",Font.PLAIN,16));
		textField_1.setBackground(Color.LIGHT_GRAY);
		add(textField_1);
		textField_1.setColumns(10);

		JLabel lblOpcionD = new JLabel("     Opcion D:");
		lblOpcionD.setBackground(Color.BLACK);
		lblOpcionD.setForeground(Color.WHITE);
		lblOpcionD.setHorizontalAlignment(SwingConstants.LEFT);
		lblOpcionD.setFont(new Font("Stencil",Font.PLAIN,18));
		lblOpcionD.setOpaque(true);
		add(lblOpcionD);

		JTextField textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setFont(new Font("Tahoma",Font.PLAIN,16));
		textField_3.setBackground(Color.LIGHT_GRAY);
		add(textField_3);

		JLabel label_8 = new JLabel("");
		add(label_8);

		JLabel label_9 = new JLabel("");
		add(label_9);

		JLabel lblRespuesta = new JLabel("     Respuesta");
		lblRespuesta.setForeground(Color.WHITE);
		lblRespuesta.setFont(new Font("Stencil",Font.PLAIN,18));
		add(lblRespuesta);
		ButtonGroup grupoCheckBotomns = new ButtonGroup();
		JCheckBox chckbxA = new JCheckBox("A");
		chckbxA.setSelected(true);
		JCheckBox chckbxB = new JCheckBox("B");
		JCheckBox chckbxC = new JCheckBox("C");
		JCheckBox chckbxD = new JCheckBox("D");
		grupoCheckBotomns.add(chckbxA);
		grupoCheckBotomns.add(chckbxB);
		grupoCheckBotomns.add(chckbxC);
		grupoCheckBotomns.add(chckbxD);
		add(chckbxA);

		JLabel label = new JLabel("");
		add(label);

		add(chckbxB);

		JLabel label_1 = new JLabel("");
		add(label_1);

		add(chckbxC);

		JLabel label_2 = new JLabel("");
		add(label_2);

		add(chckbxD);

		JLabel label_10 = new JLabel("");
		add(label_10);

		JLabel label_11 = new JLabel("");
		add(label_11);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				desplazarAotroPanel(contentPane,"panelMenuADMenunciados");
			}
		});
		btnVolver.setForeground(Color.CYAN);
		btnVolver.setBackground(Color.BLACK);
		btnVolver.setFont(new Font("Stencil",Font.PLAIN,18));
		add(btnVolver);

		JButton btnRegistrarse = new JButton("Crear pregunta");
		btnRegistrarse.setForeground(Color.GREEN);
		btnRegistrarse.setFont(new Font("Stencil",Font.PLAIN,18));
		btnRegistrarse.setBackground(Color.BLACK);
		add(btnRegistrarse);

	}

}
