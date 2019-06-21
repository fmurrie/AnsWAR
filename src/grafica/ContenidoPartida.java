package grafica;

/**
 * Contiene los componentes de la partida actual.
 */
public class ContenidoPartida extends SuperPanel
{
	private long puntosDePartida = 0;
	private int preguntasAcertadasDePartida = 0;
	
	public long getPuntosDePartida()
	{
		return puntosDePartida;
	}
	public int getPreguntasAcertadasDePartida()
	{
		return preguntasAcertadasDePartida;
	}
	public void setPuntosDePartida(long puntosDePartida)
	{
		this.puntosDePartida = puntosDePartida;
	}
	public void setPreguntasAcertadasDePartida(int preguntasAcertadasDePartida)
	{
		this.preguntasAcertadasDePartida = preguntasAcertadasDePartida;
	}
	
}
