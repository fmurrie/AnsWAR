package disciplinas;

public class PreguntaGeografia extends Pregunta
{
	// Constructores:

	public PreguntaGeografia()
	{
		super();
	}

	public PreguntaGeografia(String interrogacion,String respuesta)
	{
		super(interrogacion,respuesta);
	}

	// Metodos extra:

	@Override
	public String toStringSinRespuesta()
	{
		String dato = super.toStringSinRespuesta() + "\nTipo: Geografia";

		return dato;
	}

	@Override
	protected int determinarPuntos()
	{
		int puntos = 15;

		return puntos;
	}

}
