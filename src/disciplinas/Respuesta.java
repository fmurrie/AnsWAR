package disciplinas;

public class Respuesta
{
	private String respuesta;
	private boolean esCorrecta;

	// Constructores

	public Respuesta(String respuesta,boolean esCorrecta)
	{
		this.respuesta = respuesta;
		this.esCorrecta = esCorrecta;
	}

	// Getters Setters

	public boolean isEsCorrecta()
	{
		return esCorrecta;
	}

	@Override
	public String toString()
	{
		return "Respuesta{" + "respuesta='" + respuesta + '\'' + ", esCorrecta=" + esCorrecta + '}';
	}
}
