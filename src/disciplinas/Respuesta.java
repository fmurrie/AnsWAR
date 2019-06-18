package disciplinas;

import java.io.Serializable;

public class Respuesta implements Serializable
{
	private String respuesta;
	private boolean esCorrecta=false;

	// Constructores

	public Respuesta(String respuesta,boolean esCorrecta)
	{
		setRespuesta(respuesta);
		setEsCorrecta(esCorrecta);
	}

	// Getters Setters


	private String getRespuesta()
	{
		return respuesta;
	}

	private boolean getEsCorrecta()
	{
		return esCorrecta;
	}
	
	private void setRespuesta(String respuesta)
	{
		this.respuesta = respuesta;
	}

	public void setEsCorrecta(boolean esCorrecta)
	{
		this.esCorrecta = esCorrecta;
	}

	//Metodos varios:
	
	@Override
	public String toString()
	{
		String dato =getRespuesta()+" su valor es: "+getEsCorrecta();
		
		return dato;
	}
}
