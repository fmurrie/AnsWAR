package informacion;

import java.util.ArrayList;
import java.util.HashMap;

import disciplinas.Enunciado;
import personas.Admin;
import personas.Jugador;

public class BaseDeDatos
{
	// Atributos
	private HashMap<String, Enunciado> registroEnunciados;
	private ArrayList<Jugador> registroJugadores;
	private Admin administrador;

	// Constructores

	public BaseDeDatos()
	{
		registroEnunciados = new HashMap<>();
		registroJugadores = new ArrayList<>();
		administrador = new Admin();
	}

}
