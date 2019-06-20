package grafica;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.FileNotFoundException;

import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import audio.Sonido;
import informacion.BaseDeDatos;
import javazoom.jl.decoder.JavaLayerException;
import personas.Cuenta;
import personas.Jugador;
import personas.JugadorInvitado;
import personas.JugadorPermanente;

public class SuperPanel<T extends Cuenta> extends JPanel implements IRelacionFrameYPaneles
{

	private T cuentaActiva; // cuenta que inicio sesion para todos los paneles
	private BaseDeDatos data = new BaseDeDatos();
	private JTextField txtId = new JTextField();
	private JTextField txtUsuario = new JTextField();

	public SuperPanel()
	{

	}

	// Getters y Setters:

	public void setCuentaActiva(T cuentaActiva)
	{
		this.cuentaActiva = cuentaActiva;
		restaurarLosTextFieldCuentaActiva();
	}

	public void setCuentaActivaYactualizarTextFields(T cuentaActiva)
	{
		this.cuentaActiva = cuentaActiva;

		actualizarTextFieldCuentaActiva();
	}

	public T getCuentaActiva()
	{
		return cuentaActiva;
	}

	public JTextField getTxtId()
	{
		return txtId;
	}

	public JTextField getTxtUsuario()
	{
		return txtUsuario;
	}

	public BaseDeDatos getData()
	{
		return data;
	}

	public void setTxtId(JTextField txtId)
	{
		this.txtId = txtId;
	}

	public void setTxtUsuario(JTextField txtUsuario)
	{
		this.txtUsuario = txtUsuario;
	}

	private void setData(BaseDeDatos data)
	{
		this.data = data;
	}

	// Metodos varios:

	public void desplazarAotroPanel(SuperPanel contentPane, String panelAmostrar)
	{
		boolean busqueda = false;
		Component auxiliar = new JPanel();
		Component auxiliar2 = contentPane.getComponent(0);
		int i = 0;
		while(busqueda == false)
		{
			auxiliar = contentPane.getComponent(i);
			if(panelAmostrar.equalsIgnoreCase(auxiliar.getName()))
			{
				contentPane.add(auxiliar,0);
				contentPane.add(auxiliar2,i);
				busqueda = true;
			}

			i++;
		}
		restaurarValoresPanelPartida(contentPane);
		actualizarJlistDelPanelInspeccionarJugadores(contentPane);

	}

	@Override
	public void desplazarAotroPanelDentroDeUnaPartida(SuperPanel contentPane, String panelAmostrar)
	{
		boolean busqueda = false;
		Component auxiliar = new JPanel();
		Component auxiliar2 = contentPane.getComponent(0);
		int i = 0;
		while(busqueda == false)
		{
			auxiliar = contentPane.getComponent(i);
			if(panelAmostrar.equalsIgnoreCase(auxiliar.getName()))
			{
				contentPane.add(auxiliar,0);
				contentPane.add(auxiliar2,i);
				busqueda = true;
			}

			i++;
		}
		restaurarValoresPanelPartida(contentPane);
	}

	public void restaurarValoresRuleta(SuperPanel contentPane)
	{
		if(contentPane.getComponent(0).getName().equalsIgnoreCase("panelRuleta"))
		{
			PanelRuleta panelRuleta = new PanelRuleta(contentPane);
			panelRuleta.setName("panelRuleta");
			contentPane.remove(0);
			contentPane.add(panelRuleta,0);
		}
	}

	public void restaurarValoresPanelParaResponder(SuperPanel contentPane)
	{
		if(contentPane.getComponent(0).getName().equalsIgnoreCase("panelParaResponder"))
		{
			PanelParaResponder panelParaResponder = new PanelParaResponder(contentPane);
			panelParaResponder.setName("panelParaResponder");
			contentPane.remove(0);
			contentPane.add(panelParaResponder,0);
		}
	}

	public void restaurarValoresPanelPartida(SuperPanel contentPane)
	{
		if(contentPane.getComponent(0).getName().equalsIgnoreCase("panelPartida"))
		{
			PanelPartida panelPartida = new PanelPartida(contentPane);
			panelPartida.setName("panelPartida");
			contentPane.remove(0);
			contentPane.add(panelPartida,0);
		}
	}

	public int buscarPanelPorNombreYdevolverPos(SuperPanel contentPane, String nombrePanel)
	{
		boolean encontro = false;
		int i = 0;

		while(encontro == false)
		{
			if(contentPane.getComponent(i).getName().equals(nombrePanel))
			{
				encontro = true;
			}
			i++;
		}
		return i;
	}

	public Component obtenerPanelPorNombreYdevolverPos(SuperPanel contentPane, String nombrePanel)
	{
		boolean encontro = false;
		Component aux = null;
		int i = 0;

		while(encontro == false)
		{
			if(contentPane.getComponent(i).getName().equals(nombrePanel))
			{
				aux = contentPane.getComponent(i);
				encontro = true;
			}
			i++;
		}
		return aux;
	}

	private void actualizarTextFieldCuentaActiva()
	{
		if(cuentaActiva instanceof JugadorInvitado)
			actualizarLosTextFieldParaInvitado();
		else
			actualizarLosTextFieldParaJugadorYAdmin();
	}

	private void actualizarLosTextFieldParaJugadorYAdmin()
	{
		txtId.setText("ID: " + getCuentaActiva().getId());
		txtId.setEnabled(false);
		txtId.setBackground(Color.BLACK);
		txtId.setForeground(Color.WHITE);
		txtId.setFont(new Font("Stencil",Font.PLAIN,11));
		txtId.setEditable(false);
		txtId.setColumns(10);

		txtUsuario.setText("Usuario: " + getCuentaActiva().getUsuario());
		txtUsuario.setEditable(false);
		txtUsuario.setEnabled(false);
		txtUsuario.setFont(new Font("Stencil",Font.PLAIN,11));
		txtUsuario.setForeground(Color.WHITE);
		txtUsuario.setBackground(Color.BLACK);
		txtUsuario.setColumns(10);
	}

	private void actualizarLosTextFieldParaInvitado()
	{
		txtId.setText("");
		txtId.setEnabled(false);
		txtId.setBackground(Color.BLACK);
		txtId.setForeground(Color.WHITE);
		txtId.setFont(new Font("Stencil",Font.PLAIN,11));
		txtId.setEditable(false);
		txtId.setColumns(10);

		txtUsuario.setText("");
		txtUsuario.setEditable(false);
		txtUsuario.setEnabled(false);
		txtUsuario.setFont(new Font("Stencil",Font.PLAIN,11));
		txtUsuario.setForeground(Color.WHITE);
		txtUsuario.setBackground(Color.BLACK);
		txtUsuario.setColumns(10);
	}

	public void restaurarLosTextFieldCuentaActiva()
	{
		txtId.setText("");
		txtId.setEnabled(false);
		txtId.setBackground(Color.BLACK);
		txtId.setForeground(Color.WHITE);
		txtId.setFont(new Font("Stencil",Font.PLAIN,11));
		txtId.setEditable(false);
		txtId.setColumns(10);

		txtUsuario.setText("");
		txtUsuario.setEditable(false);
		txtUsuario.setEnabled(false);
		txtUsuario.setFont(new Font("Stencil",Font.PLAIN,11));
		txtUsuario.setForeground(Color.WHITE);
		txtUsuario.setBackground(Color.BLACK);
		txtUsuario.setColumns(10);
	}

	public void actualizarTextFieldPanelConfiguracionJugador(SuperPanel contentPane)
	{
		Component aux = obtenerPanelPorNombreYdevolverPos(contentPane,"panelConfiguracionJugador");
		((PanelConfiguracionJugador) aux).actualizarTextoTextFields(contentPane);
	}
	
	public void actualizarTextFieldPanelPerfilJugador(SuperPanel contentPane)
	{
		Component aux = obtenerPanelPorNombreYdevolverPos(contentPane,"panelPerfilJugador");
		((PanelPerfilJugador) aux).actualizarTextoTextFields(contentPane);
	}

	public void actualizarJlistDelPanelInspeccionarJugadores(SuperPanel contentPane)
	{
		Component aux = obtenerPanelPorNombreYdevolverPos(contentPane,"panelInspeccionarJugadores");
		((PanelInspeccionarJugadores) aux).actualizarListaJugadores(contentPane);
	}

	@Override
	public void eliminarUnPanel(SuperPanel contentPane, String nombrePanel)
	{
		boolean encontro = false;
		int i = 0;

		while(encontro == false)
		{
			if(contentPane.getComponent(i).getName().equals(nombrePanel))
			{
				contentPane.remove(i);
				encontro = true;
			}
			i++;
		}
	}

}
