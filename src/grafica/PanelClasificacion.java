package grafica;

import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import personas.Admin;
import personas.Jugador;
import personas.JugadorPermanente;
import personas.JugadorRank;

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

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

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
		list.setForeground(Color.LIGHT_GRAY);
		list.setBackground(Color.BLACK);
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
				btnVolver.setBackground(Color.BLACK);
				btnVolver.setForeground(Color.CYAN);
				btnVolver.setFont(new Font("Stencil",Font.PLAIN,18));
				add(btnVolver);
	}
	
	public void actualizarListaJugadores(SuperPanel contentPane)
	{
		contentPane.getData().copiarCuentasDelArchivoAlaColeccion("jugadores.dat");
		DefaultListModel listModel = new DefaultListModel();
		Contenedor<JugadorPermanente> listaAux1=contentPane.getData().getColeccionJugadores();
		Contenedor<JugadorRank> listaAux2=new Contenedor<JugadorRank>();
		
		for(int i = 0;i < listaAux1.cantidad();i++)
		{
			JugadorRank auxJrank=new JugadorRank(listaAux1.obtenerObjeto(i));
			auxJrank.setPuntaje(listaAux1.obtenerObjeto(i).getPuntaje());
			listaAux2.agregar(auxJrank);
		}
		
		ordenarListaJugadoresRank(listaAux2);
		      	
		for(int i = 0;i < listaAux2.cantidad();i++)
		{
			listaAux2.obtenerObjeto(i).setRangoClasificacion(i+1);
			listModel.add(i,listaAux2.obtenerObjeto(i));
		}
		list.setModel(listModel);
	}
	
	private void ordenarListaJugadoresRank(Contenedor<JugadorRank> listaAux)
	{		
		for(int j=0;j<listaAux.cantidad();j++)
		{
			for(int i=0;i<listaAux.cantidad();i++)
			{
				int resultado=listaAux.obtenerObjeto(j).compareTo(listaAux.obtenerObjeto(i));
				if(resultado>0)
				{
					JugadorRank aux1=listaAux.obtenerObjeto(j);
					JugadorRank aux2=listaAux.obtenerObjeto(i);
					listaAux.reemplazarElemento(j,aux2);
					listaAux.reemplazarElemento(i,aux1);	
				}		
			}
		}
	}

	public void restaurarListaJugadores()
	{
		DefaultListModel listModel = new DefaultListModel();
		list.setModel(listModel);
	}
}
