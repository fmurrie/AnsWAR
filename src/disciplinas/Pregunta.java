package disciplinas;

import java.util.ArrayList;

public class Pregunta
{
	// Atributos:
	private String enunciado;
	private ArrayList<Respuesta> opciones;
	private String id;

	// Constructores

	public Pregunta(String enunciado,String id)
	{
		this.enunciado = enunciado;
		opciones = new ArrayList<Respuesta>();
		this.id = id;
	}

	public void agregarRespuesta(Respuesta nueva)
	{
		opciones.add(nueva);
	}

	@Override
	public String toString()
	{
		return "Pregunta{" + "enunciado='" + enunciado + '\'' + ", opciones=" + opciones + ", id='" + id + '\'' + '}';
	}
}
