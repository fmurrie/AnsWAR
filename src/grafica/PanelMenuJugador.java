package grafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import disciplinas.Pregunta;
import personas.JugadorPermanente;

/**
 * Panel grafico donde el jugador puede optar entre jugar, ver la clasificacion,
 * ir a la configuracion o ver su perfil.
 */
public class PanelMenuJugador extends SuperPanel
{

	/**
	 * Create the panel.
	 */
	public PanelMenuJugador(SuperPanel contentPane)
	{
		setBackground(Color.BLACK);
		setLayout(new GridLayout(0,1,0,0));

		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setIcon(new ImageIcon("src/imagenes/AnswarTitulo.png"));
		add(label);

		JButton btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				boolean hayPreguntas = false;
				hayPreguntas = verificarQueHayanPreguntasParaJugar("preguntas.dat");
				if(hayPreguntas == true)
					desplazarAotroPanel(contentPane,"panelPartida");
				else
					JOptionPane.showMessageDialog(null,"En este momento el sistema se encuentra en mantenimiento.");
			}
		});
		btnJugar.setBackground(Color.BLACK);
		btnJugar.setForeground(Color.GREEN);
		btnJugar.setFont(new Font("Stencil",Font.PLAIN,18));
		add(btnJugar);

		JButton btnClasificacion = new JButton("Ver clasificacion");
		btnClasificacion.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				contentPane.actualizarJlistDelPanelClasificacion(contentPane);
				desplazarAotroPanel(contentPane,"panelClasificacion");
			}
		});
		btnClasificacion.setForeground(Color.GREEN);
		btnClasificacion.setFont(new Font("Stencil",Font.PLAIN,18));
		btnClasificacion.setBackground(Color.BLACK);
		add(btnClasificacion);

		JButton btnPerfil = new JButton("Mi perfil");
		btnPerfil.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(contentPane.getCuentaActiva() instanceof JugadorPermanente)
				{
					contentPane.actualizarTextFieldPanelPerfilJugador(contentPane);
					desplazarAotroPanel(contentPane,"panelPerfilJugador");
				}

			}
		});
		btnPerfil.setForeground(Color.BLUE);
		btnPerfil.setBackground(Color.BLACK);
		btnPerfil.setFont(new Font("Stencil",Font.PLAIN,18));
		add(btnPerfil);

		JButton btnConfiguracion = new JButton("Configuracion");
		btnConfiguracion.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(contentPane.getCuentaActiva() instanceof JugadorPermanente)
				{
					contentPane.actualizarTextFieldPanelConfiguracionJugador(contentPane);
					desplazarAotroPanel(contentPane,"panelConfiguracionJugador");
				}

			}
		});
		btnConfiguracion.setForeground(Color.WHITE);
		btnConfiguracion.setBackground(Color.BLACK);
		btnConfiguracion.setFont(new Font("Stencil",Font.PLAIN,18));
		add(btnConfiguracion);

	}

	private boolean verificarQueHayanPreguntasParaJugar(String nombreArchivo)
	{
		File archiP = new File(nombreArchivo);
		boolean respuesta = false;
		boolean hayDeGeografia = false;
		boolean hayDeHistoria = false;
		boolean hayDeDeporte = false;
		boolean hayDeEntretenimiento = false;
		boolean hayDeCiencia = false;
		boolean hayDeArte = false;

		if(archiP.exists())
		{
			ObjectInputStream archiPreguntas;
			try
			{
				archiPreguntas = new ObjectInputStream(new FileInputStream(archiP));
				Pregunta aux = (Pregunta) archiPreguntas.readObject();
				while((aux != null) && (respuesta != true))
				{
					if((aux.getId().charAt(0) == 'G') && (!hayDeGeografia))
						hayDeGeografia = true;
					if((aux.getId().charAt(0) == 'H') && (!hayDeHistoria))
						hayDeHistoria = true;
					if((aux.getId().charAt(0) == 'D') && (!hayDeDeporte))
						hayDeDeporte = true;
					if((aux.getId().charAt(0) == 'E') && (!hayDeEntretenimiento))
						hayDeEntretenimiento = true;
					if((aux.getId().charAt(0) == 'C') && (!hayDeCiencia))
						hayDeCiencia = true;
					if((aux.getId().charAt(0) == 'A') && (!hayDeArte))
						hayDeArte = true;

					if((hayDeGeografia) && (hayDeHistoria) && (hayDeDeporte) && (hayDeEntretenimiento) && (hayDeCiencia)
							&& (hayDeArte))
						respuesta = true;

					aux = (Pregunta) archiPreguntas.readObject();
				}

				archiPreguntas.close();

			}catch(FileNotFoundException e)
			{
				// e.printStackTrace();
			}catch(IOException e)
			{
				// e.printStackTrace();
			}catch(ClassNotFoundException e)
			{
				// e.printStackTrace();
			}

		}
		return respuesta;
	}

}
