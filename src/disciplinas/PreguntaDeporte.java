package disciplinas;

public class PreguntaDeporte extends Pregunta
{
	// Constructores:

	public PreguntaDeporte()
	{
		super();
	}

	public PreguntaDeporte(String interrogacion,String respuesta)
	{
		super(interrogacion,respuesta);
	}

	// Metodos extra:

	@Override
	public String toStringSinRespuesta()
	{
		String dato = super.toStringSinRespuesta() + "\nTipo: Deporte";

		return dato;
	}

	@Override
	protected int determinarPuntos()
	{
		int puntos = 10;

		return puntos;
	}

}
