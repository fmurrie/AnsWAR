package grafica;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import disciplinas.Pregunta;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

/**
 * Panel grafico donde el administrador elige una categoria y puede ver todas
 * las preguntas ingresadas.
 */
public class PanelVerPreguntas extends SuperPanel
{
	private JList list = new JList();
	private JScrollPane scroll = new JScrollPane(list);

	private ButtonGroup grupoRdionBotomns = new ButtonGroup();
	private JRadioButtonMenuItem rdbtnGeografia = new JRadioButtonMenuItem("Geografia");
	private JRadioButtonMenuItem rdbtnHistoria = new JRadioButtonMenuItem("Historia");
	private JRadioButtonMenuItem rdbtnDeporte = new JRadioButtonMenuItem("Deporte");
	private JRadioButtonMenuItem rdbtnEntretenimiento = new JRadioButtonMenuItem("Entretenimiento");
	private JRadioButtonMenuItem rdbtnArte = new JRadioButtonMenuItem("Arte");
	private JRadioButtonMenuItem rdbtnCiencia = new JRadioButtonMenuItem("Ciencia");

	/**
	 * Create the panel.
	 */
	public PanelVerPreguntas(SuperPanel contentPane)
	{
		setLayout(new GridLayout(7,3,0,0));
		setBackground(Color.BLACK);

		JLabel lblDisciplina = new JLabel("Seleccione una disciplina:");
		lblDisciplina.setFont(new Font("Stencil",Font.PLAIN,18));
		lblDisciplina.setForeground(Color.WHITE);
		add(lblDisciplina);

		grupoRdionBotomns = new ButtonGroup();
		rdbtnHistoria = new JRadioButtonMenuItem("Historia");
		grupoRdionBotomns.add(rdbtnHistoria);

		JLabel lblListadoDeEnunciados = new JLabel("");
		lblListadoDeEnunciados.setForeground(Color.WHITE);
		lblListadoDeEnunciados.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoDeEnunciados.setBackground(Color.BLACK);
		lblListadoDeEnunciados.setFont(new Font("Stencil",Font.PLAIN,18));
		add(lblListadoDeEnunciados);
		rdbtnEntretenimiento = new JRadioButtonMenuItem("Entretenimiento");
		rdbtnEntretenimiento.setSelected(true);
		grupoRdionBotomns.add(rdbtnEntretenimiento);
		add(rdbtnEntretenimiento);
		rdbtnDeporte = new JRadioButtonMenuItem("Deporte");
		grupoRdionBotomns.add(rdbtnDeporte);
		add(rdbtnDeporte);
		add(rdbtnHistoria);
		rdbtnCiencia = new JRadioButtonMenuItem("Ciencia");
		grupoRdionBotomns.add(rdbtnCiencia);
		add(rdbtnCiencia);
		rdbtnGeografia = new JRadioButtonMenuItem("Geografia");
		grupoRdionBotomns.add(rdbtnGeografia);
		add(rdbtnGeografia);
		rdbtnArte = new JRadioButtonMenuItem("Arte");
		grupoRdionBotomns.add(rdbtnArte);
		add(rdbtnArte);

		JLabel label_1 = new JLabel("");
		add(label_1);

		JLabel lblListadoDeEnunciados_1 = new JLabel("Listado de enunciados:");
		lblListadoDeEnunciados_1.setForeground(Color.WHITE);
		lblListadoDeEnunciados_1.setBackground(Color.BLACK);
		lblListadoDeEnunciados_1.setFont(new Font("Stencil",Font.PLAIN,18));
		add(lblListadoDeEnunciados_1);

		JButton btnMostrar = new JButton("Listar");
		btnMostrar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				vaciarJList();
				listarPreguntasPorDisciplina(contentPane);
			}
		});
		btnMostrar.setFont(new Font("Stencil",Font.PLAIN,18));
		btnMostrar.setForeground(Color.GREEN);
		btnMostrar.setBackground(Color.BLACK);
		add(btnMostrar);

		list = new JList();
		list.setBackground(Color.LIGHT_GRAY);
		list.setFont(new Font("Stencil",Font.PLAIN,12));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		add(list);

		scroll = new JScrollPane(list);
		add(scroll);

		JButton btnEditarEnunciado = new JButton("Eliminar enunciado");
		btnEditarEnunciado.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int respuesta = JOptionPane.showConfirmDialog(null,"Realmente desea eliminar el enunciado?",
						"Eliminar enunciado",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(respuesta == 0)
				{
					eliminarPregunta(contentPane,"preguntas.dat");
				}
			}
		});
		btnEditarEnunciado.setForeground(Color.RED);
		btnEditarEnunciado.setBackground(Color.BLACK);
		btnEditarEnunciado.setFont(new Font("Stencil",Font.PLAIN,16));
		scroll.setColumnHeaderView(btnEditarEnunciado);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				vaciarJList();
				desplazarAotroPanel(contentPane,"panelMenuADMenunciados");
			}
		});
		btnVolver.setBackground(Color.BLACK);
		btnVolver.setForeground(Color.CYAN);
		btnVolver.setFont(new Font("Stencil",Font.PLAIN,18));
		add(btnVolver);

	}

	// Metodos varios:

	private void eliminarPregunta(SuperPanel contentPane, String rutaDelArchivo)
	{
		String auxCategoria = determinarDisciplina();

		contentPane.getData().eliminarPreguntaDeLaListaDelMapa("preguntas.dat",auxCategoria,
				(Pregunta) list.getSelectedValue());
		vaciarJList();
		meterEnElJListTodasLasPreguntasDeUnaDeterminadaDisciplina(contentPane,auxCategoria);
	}

	private void listarPreguntasPorDisciplina(SuperPanel contentPane)
	{
		String auxCategoria = determinarDisciplina();
		if(auxCategoria.equals("") == false)
		{
			meterEnElJListTodasLasPreguntasDeUnaDeterminadaDisciplina(contentPane,auxCategoria);
		}
	}

	private void meterEnElJListTodasLasPreguntasDeUnaDeterminadaDisciplina(SuperPanel contentPane, String clave)
	{
		contentPane.getData().copiarPreguntasDelArchivoAlaColeccion("preguntas.dat");

		DefaultListModel listModel = new DefaultListModel();
		ArrayList<Pregunta> listaPreguntas = contentPane.getData().getColeccionPreguntas().get(clave);

		if(listaPreguntas != null)
		{
			for(int i = 0;i < listaPreguntas.size();i++)
			{
				listModel.add(i,listaPreguntas.get(i));
			}
			list.setModel(listModel);
		}

	}

	private void vaciarJList()
	{
		DefaultListModel listModel = new DefaultListModel();
		list.setModel(listModel);
	}

	private String determinarDisciplina()
	{
		String auxCategoria = "";

		if(rdbtnGeografia.isSelected())
			auxCategoria = rdbtnGeografia.getText();

		if(rdbtnHistoria.isSelected())
			auxCategoria = rdbtnHistoria.getText();

		if(rdbtnDeporte.isSelected())
			auxCategoria = rdbtnDeporte.getText();

		if(rdbtnEntretenimiento.isSelected())
			auxCategoria = rdbtnEntretenimiento.getText();

		if(rdbtnArte.isSelected())
			auxCategoria = rdbtnArte.getText();

		if(rdbtnCiencia.isSelected())
			auxCategoria = rdbtnCiencia.getText();

		return auxCategoria;
	}

}
