package disciplinas;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Pregunta implements Serializable
{
	// Atributos:
	private String id;
	private String enunciado;
	private ArrayList<Respuesta> opciones=new ArrayList<Respuesta>();
	private String disciplina;
	

	// Constructores

	public Pregunta(String enunciado,String disciplina,ArrayList<Respuesta> opciones)
	{
		setId(disciplina.charAt(0)+"-"+generarIdRandom(1000, 9999));
		setEnunciado(enunciado);
		setDisciplina(disciplina);
		setOpciones(opciones);
	
	}
	
	public Pregunta(Pregunta aux)
	{
		setId(aux.getId());
		setEnunciado(aux.getEnunciado());
		setDisciplina(aux.getDisciplina());
		setOpciones(aux.getOpciones());
	}

	//Getters y Setters:
	
	private String getEnunciado()
	{
		return enunciado;
	}

	private ArrayList<Respuesta> getOpciones()
	{
		return opciones;
	}

	private String getId()
	{
		return id;
	}
	
	public String getDisciplina()
	{
		return disciplina;
	}

	private void setEnunciado(String enunciado)
	{
		this.enunciado = enunciado;
	}

	private void setOpciones(ArrayList<Respuesta> opciones)
	{
		this.opciones = opciones;
	}

	private void setId(String id)
	{
		this.id = id;
	}
	
	public void setDisciplina(String disciplina)
	{
		this.disciplina=disciplina;
	}
	
	//Metodos varios:
	
	public void agregarRespuesta(Respuesta nueva)
	{
		opciones.add(nueva);
	}

	@Override
	public String toString()
	{
		String dato="\nID: "+getId()+"\nPregunta: "+getEnunciado()+"\nOpcion A) "+getOpciones().get(0).toString()+"\nOpcion B) "+getOpciones().get(1).toString()+"\nOpcion C) "+getOpciones().get(2).toString()+"\nOpcion D) "+getOpciones().get(3).toString();
		
		return  dato;
	}
	
	private String generarIdRandom(long min, long max)
	{
		long idNumero = ThreadLocalRandom.current().nextLong(min,max);
		String idString = Long.toString(idNumero);
		return idString;
	}

}
