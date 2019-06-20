package grafica;

import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import personas.Admin;
import personas.Jugador;
import personas.JugadorPermanente;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import informacion.Contenedor;

import javax.swing.ImageIcon;

public class PanelClasificacion extends SuperPanel
{
	private JList list = new JList();
	private JScrollPane scroll = new JScrollPane(list);
	/**
	 * Create the panel.
	 */
	public PanelClasificacion(SuperPanel contentPane)
	{
		setBackground(Color.BLACK);
		setLayout(new GridLayout(0,1,0,0));
		
				JLabel label_2 = new JLabel("");
				label_2.setHorizontalAlignment(SwingConstants.CENTER);
				label_2.setIcon(new ImageIcon("src/imagenes/AnswarTituloMenuLogin.png"));
				add(label_2);

		JLabel lblClasificarPor = new JLabel("Tabla de clasificacion jugadores:");
		lblClasificarPor.setHorizontalAlignment(SwingConstants.CENTER);
		lblClasificarPor.setForeground(Color.WHITE);
		lblClasificarPor.setFont(new Font("Stencil",Font.PLAIN,18));
		add(lblClasificarPor);
		ButtonGroup grupoRdionBotomns = new ButtonGroup();
		
		list = new JList();
		list.setBackground(Color.LIGHT_GRAY);
		list.setFont(new Font("Stencil",Font.PLAIN,12));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		add(list);

		scroll = new JScrollPane(list);
		add(scroll);
		
				JButton btnVolver = new JButton("Volver");
				btnVolver.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						restaurarListaJugadores();
						desplazarAotroPanel(contentPane,"panelMenuJugador");
					}
				});
				
				JButton btnVer = new JButton("Ver");
				btnVer.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						actualizarListaJugadores(contentPane);
					}
				});
				btnVer.setBackground(Color.BLACK);
				btnVer.setForeground(Color.GREEN);
				btnVer.setFont(new Font("Stencil", Font.PLAIN, 18));
				add(btnVer);
				btnVolver.setBackground(Color.BLACK);
				btnVolver.setForeground(Color.CYAN);
				btnVolver.setFont(new Font("Stencil",Font.PLAIN,18));
				add(btnVolver);
	}
	
	private void actualizarListaJugadores(SuperPanel contentPane)
	{
		contentPane.getData().copiarCuentasDelArchivoAlaColeccion("jugadores.dat");
		DefaultListModel listModel = new DefaultListModel();
		Contenedor<JugadorPermanente> listaAux1=contentPane.getData().getColeccionJugadores();

		for(int i = 0;i < contentPane.getData().getColeccionJugadores().cantidad();i++)
		{
			listModel.add(i,contentPane.getData().getColeccionJugadores().obtenerObjeto(i));
		}
		list.setModel(listModel);
	}

	public void restaurarListaJugadores()
	{
		DefaultListModel listModel = new DefaultListModel();
		list.setModel(listModel);
	}
}
