package informacion;

import java.util.ArrayList;
import java.util.HashMap;

import disciplinas.Pregunta;
import personas.Cuenta;
import personas.Jugador;

public class BaseDeDatos
{
	// Atributos
	
	private HashMap<String, ArrayList<Pregunta>> coleccionPreguntas;
	private Contenedor<Cuenta> coleccionCuentas;

	// Constructores
	
	public BaseDeDatos()
	{
		coleccionPreguntas = new HashMap<String, ArrayList<Pregunta>>();
		coleccionCuentas = new Contenedor<Cuenta>();
	}

	//Getters y Setters
	
	private HashMap<String, ArrayList<Pregunta>> getRegistroEnunciados()
	{
		return coleccionPreguntas;
	}

	private Contenedor<Cuenta> getRegistroJugadores()
	{
		return coleccionCuentas;
	}

	private void setRegistroEnunciados(HashMap<String, ArrayList<Pregunta>> registroEnunciados)
	{
		this.coleccionPreguntas = registroEnunciados;
	}

	private void setRegistroJugadores(Contenedor<Cuenta> registroJugadores)
	{
		this.coleccionCuentas = coleccionCuentas;
	}
	
	
	//Metodos extra:
	
	public void agregarEnunciados(String categoria, Pregunta nuevaPregunta)
	{
		ArrayList<Pregunta> aux = new ArrayList<Pregunta>();
		aux.add(nuevaPregunta);
		coleccionPreguntas.put(categoria,aux);
	}

	@Override
	public String toString()
	{
		return "BaseDeDatos{" + "registroEnunciados=" + coleccionPreguntas + ", registroJugadores=" + coleccionCuentas+ '}';
	}
}
