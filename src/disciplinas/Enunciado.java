package disciplinas;

import java.util.concurrent.ThreadLocalRandom;

public class Enunciado
{
	// Atributos:

	private String id;
	private Pregunta cuestion;
	private String[] opciones;

	// Constructores:

	public Enunciado(Pregunta cuestion,String[] opciones)
	{
		setId();
		setPregunta(cuestion);
		setOpciones(opciones);
	}

	// Getters y Setters:

	private String getId()
	{
		return id;
	}

	private Pregunta getPregunta()
	{
		return cuestion;
	}

	private String[] getOpciones()
	{
		return opciones;
	}

	private void setId()
	{
		this.id = generarIdRandom(12345678,99999999);
	}

	private void setPregunta(Pregunta cuestion)
	{
		this.cuestion = cuestion;
	}

	private void setOpciones(String[] opciones)
	{
		this.opciones = opciones;
	}

	// Metodos extra:

	@Override
	public String toString()
	{
		String dato = "\nID: " + getId() + this.cuestion.toStringSinRespuesta() + "\nOpciones:\nA) " + opciones[0]
				+ "\nB) " + opciones[1] + "\nC) " + opciones[2] + "\nD) " + opciones[3];

		return dato;
	}

	@Override
	public boolean equals(Object obj)
	{
		boolean respuesta = false;

		if(obj instanceof Enunciado)
		{
			Enunciado aux = (Enunciado) obj;
			if(this.getId() == aux.getId())
				respuesta = true;
			if(this.getPregunta().equals(aux.getPregunta()))
				respuesta = true;
		}

		return respuesta;
	}

	private String generarIdRandom(long min, long max)
	{
		long idNumero = ThreadLocalRandom.current().nextLong(min,max);
		String idString = Long.toString(idNumero);

		return idString;
	}

}
