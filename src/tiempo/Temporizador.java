package tiempo;

import java.awt.Component;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import grafica.ContenidoPartida;
import grafica.PanelPartida;
import grafica.SuperPanel;
import personas.Jugador;
import personas.JugadorPermanente;

public class Temporizador
{
	private int hour = 0;
	private int minute = 0;
	private int second = 5;
	private Timer timer;
	private boolean isTimerRunning;
	private Display display;
	private JTextField componente;
	private SuperPanel contentPane;
	private ContenidoPartida contenidoPartida;
	private Jugador jugador;

	public Temporizador(JTextField componente,SuperPanel contentPane,ContenidoPartida contenidoPartida,Jugador jugador)
	{
		timer = new Timer();
		display = new Display();
		this.componente = componente;
		this.contentPane=contentPane;
		this.contenidoPartida=contenidoPartida;
		this.jugador=jugador;
		
	}

	TimerTask task = new TimerTask()
	{
		@Override
		public void run()
		{
			isTimerRunning = true;
			if(second > 0)
			{
				second--;
			}else
			{
				second = 59;
				if(minute > 0)
					minute--;
				else
				{
					minute = 59;
					if(hour > 0)
						hour--;
					// si segundo = 0, minuto = 0 y hora = 0,
					// cancelamos el timer
					else
					{
						isTimerRunning = false;
						timer.cancel();
						timer.purge();
					}
				}
			}
			if(isTimerRunning)
			{
				display.printTime(hour,minute,second,componente);
			}
				
			else
			{
				if(jugador instanceof JugadorPermanente)
				{
					int respuesta = JOptionPane.showConfirmDialog(null,"¿Desea guardar su resultado?","Partida finalizada",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					if(respuesta==0)
					{
						JugadorPermanente auxOriginal=(JugadorPermanente)jugador;
						jugador.setPuntaje(jugador.getPuntaje()+contenidoPartida.getPuntosDePartida());
						jugador.setNumPreguntasAcertadas(jugador.getNumPreguntasAcertadas()+contenidoPartida.getPreguntasAcertadasDePartida());
						jugador.setNumPartidasJugadas(jugador.getNumPartidasJugadas()+1);
						JugadorPermanente auxModificado=(JugadorPermanente)jugador;
						contentPane.getData().modificarCuenta("jugadores.dat",auxOriginal,auxModificado);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Se perdera el resultado debido a que es un jugador invitado.");
					
				}
				desplazarAotroPanelDentroDeUnaPartida(contentPane,"panelMenuJugador");

			}
				
		}
	}; // fin timertask

	public void start(int timeout, int interval)
	{
		timer.schedule(task,timeout,interval);
	}

	public String devolverTiempoInicial()
	{
		String dato = "";

		dato += (hour > 9) ? ":" + hour : "0" + hour;
		dato += (minute > 9) ? ":" + minute : ":0" + minute;
		dato += (second > 9) ? ":" + second : ":0" + second;

		return dato;
	}
	
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
	

}
