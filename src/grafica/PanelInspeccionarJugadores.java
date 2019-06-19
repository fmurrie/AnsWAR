package grafica;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import personas.JugadorPermanente;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class PanelInspeccionarJugadores extends SuperPanel
{
	private JList list = new JList();
	private JScrollPane scroll = new JScrollPane(list);

	/**
	 * Create the panel.
	 */
	/*
	 * public PanelInspeccionarJugadores(SuperPanel contentPane) {
	 * 
	 * }
	 */

	public PanelInspeccionarJugadores(SuperPanel contentPane)
	{
		setBackground(Color.BLACK);
		setLayout(new GridLayout(0,1,0,0));

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("src/imagenes/AnswarTituloMenuLogin.png"));
		add(label);

		JLabel lblListadoDeJugadores = new JLabel("Listado de jugadores registrados:");
		lblListadoDeJugadores.setBackground(Color.BLACK);
		lblListadoDeJugadores.setHorizontalAlignment(SwingConstants.CENTER);
		lblListadoDeJugadores.setForeground(Color.WHITE);
		lblListadoDeJugadores.setFont(new Font("Stencil",Font.PLAIN,18));
		add(lblListadoDeJugadores);

		list = new JList();
		list.setBackground(Color.LIGHT_GRAY);
		list.setFont(new Font("Stencil",Font.PLAIN,12));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		contentPane.getData().copiarCuentasDelArchivoAlaColeccion("jugadores.dat");
		DefaultListModel listModel = new DefaultListModel();

		for(int i = 0;i < contentPane.getData().getColeccionJugadores().cantidad();i++)
		{
			listModel.add(i,contentPane.getData().getColeccionJugadores().obtenerObjeto(i));
		}
		list.setModel(listModel);
		add(list);

		scroll = new JScrollPane(list);
		add(scroll);

		JButton btnEditarJugador = new JButton("Editar Jugador");
		btnEditarJugador.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if((JugadorPermanente) list.getSelectedValue() != null)
				{
					((PanelEditarJugadoresAdm) contentPane.obtenerPanelPorNombreYdevolverPos(contentPane,
							"panelEditarJugadoresAdm")).setJugadorInterferidoYactualizarTextFields(
									(JugadorPermanente) list.getSelectedValue());
					desplazarAotroPanel(contentPane,"panelEditarJugadoresAdm");
				}
			}
		});
		btnEditarJugador.setForeground(Color.ORANGE);
		btnEditarJugador.setBackground(Color.BLACK);
		btnEditarJugador.setFont(new Font("Stencil",Font.PLAIN,16));
		scroll.setColumnHeaderView(btnEditarJugador);

		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				desplazarAotroPanel(contentPane,"panelMenuADMjugadores");
			}
		});
		btnVolver.setForeground(Color.CYAN);
		btnVolver.setBackground(Color.BLACK);
		btnVolver.setFont(new Font("Stencil",Font.PLAIN,18));
		add(btnVolver);

	}

	public void actualizarListaJugadores(SuperPanel contentPane)
	{
		contentPane.getData().copiarCuentasDelArchivoAlaColeccion("jugadores.dat");
		DefaultListModel listModel = new DefaultListModel();

		for(int i = 0;i < contentPane.getData().getColeccionJugadores().cantidad();i++)
		{
			listModel.add(i,contentPane.getData().getColeccionJugadores().obtenerObjeto(i));
		}
		list.setModel(listModel);
	}
}
