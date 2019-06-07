package componentes;

import disciplinas.Enunciado;
import personas.Jugador;
import tiempo.Temporizador;;

public class Partida<T>
{
	// Atributos:

	private Temporizador reloj;
	private Ruleta destino;
	private T partidor;

	// Constructores:

	public Partida(T partidor)
	{
		setReloj(new Temporizador());
		setDestino(new Ruleta());
		setPartidor(partidor);

	}

	// Getters y Setters:

	private Temporizador getReloj()
	{
		return reloj;
	}

	private Ruleta getDestino()
	{
		return destino;
	}

	private T getPartidor()
	{
		return partidor;
	}

	private void setReloj(Temporizador reloj)
	{
		this.reloj = reloj;
	}

	private void setDestino(Ruleta destino)
	{
		this.destino = destino;
	}

	private void setPartidor(T partidor)
	{
		this.partidor = partidor;
	}

	// Metodos extra:

	public void iniciarPartida()
	{
		reloj.start(100,1000);
	}

}
