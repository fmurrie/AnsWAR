package disciplinas;

public class PreguntaCiencia extends Pregunta
{
	// Constructores:

	public PreguntaCiencia()
	{
		super();
	}

	public PreguntaCiencia(String interrogacion,String respuesta)
	{
		super(interrogacion,respuesta);
	}

	// Metodos extra:

	@Override
	public String toStringSinRespuesta()
	{
		String dato = super.toStringSinRespuesta() + "\nTipo: Ciencia";

		return dato;
	}

	@Override
	protected int determinarPuntos()
	{
		int puntos = 20;

		return puntos;
	}

}
