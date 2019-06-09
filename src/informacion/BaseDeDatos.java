package informacion;

import java.util.HashMap;

import disciplinas.Pregunta;
import personas.Cuenta;
import personas.Jugador;

public class BaseDeDatos
{
	// Atributos
	private HashMap<String, Caja<Pregunta>> registroEnunciados;
	private Caja<Jugador> registroJugadores;

	// Constructores
	public BaseDeDatos()
	{
		registroEnunciados = new HashMap<String, Caja<Pregunta>>();
		registroJugadores = new Caja<Jugador>();
	}

	public void agregarEnunciados(String categoria, Pregunta nuevaPregunta)
	{
		Caja<Pregunta> aux = new Caja<Pregunta>();
		aux.agregar(nuevaPregunta);
		registroEnunciados.put(categoria,aux);
	}

	@Override
	public String toString()
	{
		return "BaseDeDatos{" + "registroEnunciados=" + registroEnunciados + ", registroJugadores=" + registroJugadores
				+ '}';
	}
}
