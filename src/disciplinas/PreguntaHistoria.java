package disciplinas;

public class PreguntaHistoria extends Pregunta
{
	// Constructores:

	public PreguntaHistoria()
	{
		super();
	}

	public PreguntaHistoria(String interrogacion,String respuesta)
	{
		super(interrogacion,respuesta);
	}

	// Metodos extra:

	@Override
	public String toStringSinRespuesta()
	{
		String dato = super.toStringSinRespuesta() + "\nTipo: Historia";

		return dato;
	}

	@Override
	protected int determinarPuntos()
	{
		int puntos = 15;

		return puntos;
	}

}
