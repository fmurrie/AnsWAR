package grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import disciplinas.Pregunta;
import disciplinas.Respuesta;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBox;

public class PanelCargarPreguntas extends SuperPanel
{
	private ButtonGroup grupoRdionBotomns = new ButtonGroup();
	private JRadioButtonMenuItem rdbtnGeografia = new JRadioButtonMenuItem("Geografia");
	private JRadioButtonMenuItem rdbtnHistoria = new JRadioButtonMenuItem("Historia");
	private JRadioButtonMenuItem rdbtnDeporte = new JRadioButtonMenuItem("Deporte");
	private JRadioButtonMenuItem rdbtnEntretenimiento = new JRadioButtonMenuItem("Entretenimiento");
	private JRadioButtonMenuItem rdbtnArte = new JRadioButtonMenuItem("Arte");
	private JRadioButtonMenuItem rdbtnCiencia = new JRadioButtonMenuItem("Ciencia");
	
	private JTextField preguntaField = new JTextField();
	private JTextField opcionAField = new JTextField();
	private JTextField opcionBField = new JTextField();
	private JTextField opcionCField = new JTextField();
	private JTextField opcionDField = new JTextField();
	
	private ButtonGroup grupoCheckBotomns = new ButtonGroup();
	private JCheckBox chckbxA = new JCheckBox("A");
	private JCheckBox chckbxB = new JCheckBox("B");
	private JCheckBox chckbxC = new JCheckBox("C");
	private JCheckBox chckbxD = new JCheckBox("D");
	
	public PanelCargarPreguntas(SuperPanel contentPane)
	{
		setLayout(new GridLayout(18,1,0,0));
		setBackground(Color.BLACK);

		JLabel lblDisciplina = new JLabel("     Disciplina");
		lblDisciplina.setFont(new Font("Stencil",Font.PLAIN,18));
		lblDisciplina.setForeground(Color.WHITE);
		add(lblDisciplina);

		JLabel label_3 = new JLabel("");
		add(label_3);

		grupoRdionBotomns = new ButtonGroup();
		
		rdbtnGeografia = new JRadioButtonMenuItem("Geografia");
		rdbtnGeografia.setText("Geografia");
		rdbtnGeografia.setSelected(true);
		
		rdbtnHistoria = new JRadioButtonMenuItem("Historia");
		rdbtnHistoria.setText("Historia");
		
		rdbtnDeporte = new JRadioButtonMenuItem("Deporte");
		rdbtnDeporte.setText("Deporte");
		
		rdbtnEntretenimiento = new JRadioButtonMenuItem("Entretenimiento");
		rdbtnEntretenimiento.setText("Entretenimiento");
		
		rdbtnArte = new JRadioButtonMenuItem("Arte");
		rdbtnArte.setText("Arte");
		
		rdbtnCiencia = new JRadioButtonMenuItem("Ciencia");
		rdbtnCiencia.setText("Ciencia");
		
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

		preguntaField = new JTextField();
		preguntaField.setHorizontalAlignment(SwingConstants.CENTER);
		preguntaField.setFont(new Font("Tahoma",Font.PLAIN,16));
		preguntaField.setBackground(Color.LIGHT_GRAY);
		add(preguntaField);
		preguntaField.setColumns(10);

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

		opcionAField = new JTextField();
		opcionAField.setHorizontalAlignment(SwingConstants.CENTER);
		opcionAField.setFont(new Font("Tahoma",Font.PLAIN,16));
		opcionAField.setBackground(Color.LIGHT_GRAY);
		add(opcionAField);
		opcionAField.setColumns(10);

		JLabel lblOpcionB = new JLabel("     Opcion B:");
		lblOpcionB.setBackground(Color.BLACK);
		lblOpcionB.setForeground(Color.WHITE);
		lblOpcionB.setHorizontalAlignment(SwingConstants.LEFT);
		lblOpcionB.setFont(new Font("Stencil",Font.PLAIN,18));
		lblOpcionB.setOpaque(true);
		add(lblOpcionB);

		opcionBField = new JTextField();
		opcionBField.setHorizontalAlignment(SwingConstants.CENTER);
		opcionBField.setFont(new Font("Tahoma",Font.PLAIN,16));
		opcionBField.setBackground(Color.LIGHT_GRAY);
		add(opcionBField);
		opcionBField.setColumns(10);

		JLabel lblOpcionC = new JLabel("     Opcion C:");
		lblOpcionC.setBackground(Color.BLACK);
		lblOpcionC.setForeground(Color.WHITE);
		lblOpcionC.setHorizontalAlignment(SwingConstants.LEFT);
		lblOpcionC.setFont(new Font("Stencil",Font.PLAIN,18));
		lblOpcionC.setOpaque(true);
		add(lblOpcionC);

		opcionCField = new JTextField();
		opcionCField.setHorizontalAlignment(SwingConstants.CENTER);
		opcionCField.setFont(new Font("Tahoma",Font.PLAIN,16));
		opcionCField.setBackground(Color.LIGHT_GRAY);
		add(opcionCField);
		opcionCField.setColumns(10);

		JLabel lblOpcionD = new JLabel("     Opcion D:");
		lblOpcionD.setBackground(Color.BLACK);
		lblOpcionD.setForeground(Color.WHITE);
		lblOpcionD.setHorizontalAlignment(SwingConstants.LEFT);
		lblOpcionD.setFont(new Font("Stencil",Font.PLAIN,18));
		lblOpcionD.setOpaque(true);
		add(lblOpcionD);

		opcionDField = new JTextField();
		opcionDField.setHorizontalAlignment(SwingConstants.CENTER);
		opcionDField.setFont(new Font("Tahoma",Font.PLAIN,16));
		opcionDField.setBackground(Color.LIGHT_GRAY);
		add(opcionDField);

		JLabel label_8 = new JLabel("");
		add(label_8);

		JLabel label_9 = new JLabel("");
		add(label_9);

		JLabel lblRespuesta = new JLabel("     Respuesta");
		lblRespuesta.setForeground(Color.WHITE);
		lblRespuesta.setFont(new Font("Stencil",Font.PLAIN,18));
		add(lblRespuesta);
		
		grupoCheckBotomns = new ButtonGroup();
		chckbxA = new JCheckBox("A");
		chckbxA.setText("A");
		chckbxA.setSelected(true);
		grupoCheckBotomns.add(chckbxA);
		add(chckbxA);
		
		JLabel label = new JLabel("");
		add(label);
		chckbxB = new JCheckBox("B");
		chckbxB.setText("B");
		grupoCheckBotomns.add(chckbxB);
		add(chckbxB);

		JLabel label_1 = new JLabel("");
		add(label_1);
		chckbxC = new JCheckBox("C");
		chckbxC.setText("C");
		grupoCheckBotomns.add(chckbxC);
		add(chckbxC);

		JLabel label_2 = new JLabel("");
		add(label_2);
		chckbxD = new JCheckBox("D");
		chckbxD.setText("D");
		grupoCheckBotomns.add(chckbxD);
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

		JButton btnCrearPregunta = new JButton("Crear pregunta");
		btnCrearPregunta.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				crearEnunciado(contentPane);
			}
		});
		btnCrearPregunta.setForeground(Color.GREEN);
		btnCrearPregunta.setFont(new Font("Stencil",Font.PLAIN,18));
		btnCrearPregunta.setBackground(Color.BLACK);
		add(btnCrearPregunta);

	}
	
	public void crearEnunciado(SuperPanel contentPane)
	{
		String auxPregunta=preguntaField.getText();
		String auxOpcionA=opcionAField.getText();
		String auxOpcionB=opcionBField.getText();
		String auxOpcionC=opcionCField.getText();
		String auxOpcionD=opcionDField.getText();
		
		String auxCategoria="";	
		auxCategoria=determinarDisciplina(auxCategoria);

		String auxOpcionCorrecta="";
		auxOpcionCorrecta=determinarOpcionCorrecta(auxOpcionCorrecta);
		
		Pregunta preguntaNueva;
		ArrayList<Respuesta> auxOpciones=new ArrayList<Respuesta>();
		Respuesta auxRespuesta;
		
		if((!auxPregunta.equals(""))&&(!auxOpcionA.equals(""))&&(!auxOpcionB.equals(""))&&(!auxOpcionC.equals(""))&&(!auxOpcionD.equals("")))
		{
			auxRespuesta=new Respuesta(auxOpcionA,false);
			if(auxOpcionCorrecta.equalsIgnoreCase("A"))
				auxRespuesta.setEsCorrecta(true);
			auxOpciones.add(auxRespuesta);
			
			auxRespuesta=new Respuesta(auxOpcionB,false);
			if(auxOpcionCorrecta.equalsIgnoreCase("B"))
				auxRespuesta.setEsCorrecta(true);
			auxOpciones.add(auxRespuesta);
			
			auxRespuesta=new Respuesta(auxOpcionC,false);
			if(auxOpcionCorrecta.equalsIgnoreCase("C"))
				auxRespuesta.setEsCorrecta(true);
			auxOpciones.add(auxRespuesta);
			
			auxRespuesta=new Respuesta(auxOpcionD,false);
			if(auxOpcionCorrecta.equalsIgnoreCase("D"))
				auxRespuesta.setEsCorrecta(true);
			auxOpciones.add(auxRespuesta);
			
			preguntaNueva=new Pregunta(auxPregunta,auxCategoria,auxOpciones);
		
			contentPane.getData().cargarNuevaPregunta("preguntas.dat",auxCategoria,preguntaNueva);
			
		}
				
	}
	
	private String determinarOpcionCorrecta(String auxOpcionCorrecta)
	{
		if(chckbxA.isSelected())
			auxOpcionCorrecta=chckbxA.getText();
		if(chckbxB.isSelected())
			auxOpcionCorrecta=chckbxB.getText();
		if(chckbxC.isSelected())
			auxOpcionCorrecta=chckbxC.getText();
		if(chckbxD.isSelected())
			auxOpcionCorrecta=chckbxD.getText();
		
		return auxOpcionCorrecta;
	}
	
	private String determinarDisciplina(String auxCategoria)
	{
		if(rdbtnGeografia.isSelected())
			auxCategoria=rdbtnGeografia.getText();
		
		if(rdbtnHistoria.isSelected())
			auxCategoria=rdbtnHistoria.getText();
		
		if(rdbtnDeporte.isSelected())
			auxCategoria=rdbtnDeporte.getText();
		
		if(rdbtnEntretenimiento.isSelected())
			auxCategoria=rdbtnEntretenimiento.getText();
		
		if(rdbtnArte.isSelected())
			auxCategoria=rdbtnArte.getText();
		
		if(rdbtnCiencia.isSelected())
			auxCategoria=rdbtnCiencia.getText();
		
		return auxCategoria;
	}
	
	public void restaurarTextfields()
	{
		preguntaField.setText("");
		opcionAField.setText("");
		opcionBField.setText("");
		opcionCField.setText("");
		opcionDField.setText("");
	}

}
