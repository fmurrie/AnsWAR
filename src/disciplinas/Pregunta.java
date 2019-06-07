package disciplinas;

public abstract class Pregunta
{
	// Atributos:

	private String interrogacion;
	private String respuesta;
	private long puntos;

	// Constructores:

	public Pregunta()
	{
		setInterrogacion("");
		setRespuesta("");
		setPuntos();
	}

	public Pregunta(String interrogacion,String respuesta)
	{
		setInterrogacion(interrogacion);
		setRespuesta(respuesta);
		setPuntos();

	}

	// Getters y Setters:

	private String getInterrogacion()
	{
		return interrogacion;
	}

	private String getRespuesta()
	{
		return respuesta;
	}

	private long getPuntos()
	{
		return puntos;
	}

	private void setInterrogacion(String interrogacion)
	{
		this.interrogacion = interrogacion;
	}

	private void setRespuesta(String respuesta)
	{
		this.respuesta = respuesta;
	}

	protected void setPuntos()
	{
		this.puntos = determinarPuntos();
	}

	// Metodos extra:

	@Override
	public String toString()
	{
		String dato = "\nPregunta: " + getInterrogacion() + "\nRespuesta: " + getRespuesta() + "\nPuntos: "
				+ getPuntos();

		return dato;
	}

	public String toStringSinRespuesta()
	{
		String dato = "\nPregunta: " + getInterrogacion() + "\nPuntos: " + getPuntos();

		return dato;
	}

	@Override
	public boolean equals(Object obj)
	{
		boolean respuesta = false;

		if(obj instanceof Pregunta)
		{
			Pregunta aux = (Pregunta) obj;
			if(this.getInterrogacion() == aux.getInterrogacion())
				respuesta = true;
		}

		return respuesta;
	}

	protected abstract int determinarPuntos();

}
