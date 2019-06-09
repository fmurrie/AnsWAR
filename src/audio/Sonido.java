package audio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Sonido extends Thread
{
	private Player reproductor;
	private boolean estado=true;
	
	
	public Sonido(String rutaCancion) throws FileNotFoundException, JavaLayerException
	{
		setReproductor(new Player(new FileInputStream(rutaCancion)));
	}
	
	private void setReproductor(Player reproductor)
	{
		this.reproductor = reproductor;
	}
	
	

	private boolean getEstado()
	{
		return estado;
	}

	private void setEstado(boolean estado)
	{
		this.estado = estado;
	}

	public void run()
	{
		while(estado)
		{
		try
		{
				reproductor.play();
		}
		catch(JavaLayerException e)
		{
			e.printStackTrace();
		}
		}
	}
	
	public void correr()
	{
		start();
		setEstado(true);
	}
	
	public void detener()
	{
		setEstado(false);
	}
	

}
