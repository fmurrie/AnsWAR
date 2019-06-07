package disciplinas;

public class PreguntaArte extends Pregunta
{
	// Constructores:

	public PreguntaArte()
	{
		super();
	}

	public PreguntaArte(String interrogacion,String respuesta)
	{
		super(interrogacion,respuesta);
	}

	// Metodos extra:

	@Override
	public String toStringSinRespuesta()
	{
		String dato = super.toStringSinRespuesta() + "\nTipo: Arte";

		return dato;
	}

	@Override
	protected int determinarPuntos()
	{
		int puntos = 5;

		return puntos;
	}

}
