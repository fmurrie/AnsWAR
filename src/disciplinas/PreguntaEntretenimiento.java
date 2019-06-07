package disciplinas;

public class PreguntaEntretenimiento extends Pregunta
{
	// Constructores:

	public PreguntaEntretenimiento()
	{
		super();
	}

	public PreguntaEntretenimiento(String interrogacion,String respuesta)
	{
		super(interrogacion,respuesta);
	}

	// Metodos extra:

	@Override
	public String toStringSinRespuesta()
	{
		String dato = super.toStringSinRespuesta() + "\nTipo: Entretenimiento";

		return dato;
	}

	@Override
	protected int determinarPuntos()
	{
		int puntos = 15;

		return puntos;
	}

}
