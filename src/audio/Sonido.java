package audio;

import java.io.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Sonido extends Thread
{
	private Player reproductor;

	public Sonido(String rutaCancion) throws FileNotFoundException,JavaLayerException
	{
		setReproductor(new Player(new FileInputStream(rutaCancion)));
	}

	private void setReproductor(Player reproductor)
	{
		this.reproductor = reproductor;
	}

	public void run()
	{
		try
		{
			reproductor.play();
		}catch(JavaLayerException e)
		{
			e.printStackTrace();
		}

	}
}
