package informacion;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import disciplinas.Pregunta;
import personas.Cuenta;
import personas.Jugador;
import personas.JugadorPermanente;

public class BaseDeDatos
{
	// Atributos

	private HashMap<String, ArrayList<Pregunta>> coleccionPreguntas;
	private Contenedor<JugadorPermanente> coleccionJugadores;

	// Constructores

	public BaseDeDatos()
	{
		setColeccionPreguntas(new HashMap<String, ArrayList<Pregunta>>());
		setColeccionJugadores(new Contenedor<JugadorPermanente>());
	}

	// Getters y Setters

	public HashMap<String, ArrayList<Pregunta>> getColeccionPreguntas()
	{
		return coleccionPreguntas;
	}

	public Contenedor<JugadorPermanente> getColeccionJugadores()
	{
		return coleccionJugadores;
	}

	private void setColeccionPreguntas(HashMap<String, ArrayList<Pregunta>> coleccionPreguntas)
	{
		this.coleccionPreguntas = coleccionPreguntas;
	}

	private void setColeccionJugadores(Contenedor<JugadorPermanente> coleccionJugadores)
	{
		this.coleccionJugadores = coleccionJugadores;
	}

	// Metodos extra:

	public boolean registrarCuenta(String nombreArchivo, JugadorPermanente obj)
	{
		boolean efectivo = false;

		efectivo = verificarSiSeRepiteLaCuenta(obj);
		if((obj != null) && (efectivo == false))
		{
			this.coleccionJugadores.agregar(obj);

		}

		copiarCuentasDeColeccionAlArchivo(nombreArchivo);

		return efectivo;
	}

	public JugadorPermanente loggearCuenta(String nombreArchivo, String usuario, String clave)
	{

		JugadorPermanente obj = null;

		for(int i = 0;i < coleccionJugadores.cantidad();i++)
		{
			if((coleccionJugadores.obtenerObjeto(i).getUsuario().equals(usuario))
					&& (coleccionJugadores.obtenerObjeto(i).getClave().equals(clave)))
			{
				obj = coleccionJugadores.obtenerObjeto(i);
			}
		}

		return obj;
	}

	public void modificarCuenta(String nombreArchivo, JugadorPermanente original, JugadorPermanente modificada)
	{
		if(original != null)
		{

			int pos = retornarPosicionJugador(original);
			this.coleccionJugadores.reemplazarElemento(pos,modificada);

			copiarCuentasDeColeccionAlArchivo(nombreArchivo);
		}
	}

	public void eliminarJugadorDeLaLista(String nombreArchivo, JugadorPermanente obj)
	{
		for(int i = 0;i < this.coleccionJugadores.cantidad();i++)
		{
			if(obj.getId().equals(coleccionJugadores.obtenerObjeto(i).getId()))
				this.coleccionJugadores.eliminar(coleccionJugadores.obtenerObjeto(i));
		}
		copiarCuentasDeColeccionAlArchivo(nombreArchivo);
	}

	public String retornarColeccionJugadoresParaMostrar()
	{
		String dato = "";
		for(int i = 0;i < this.coleccionJugadores.cantidad();i++)
		{
			dato = dato + coleccionJugadores.obtenerObjeto(i).toString();
		}

		return dato;
	}

	private boolean verificarSiSeRepiteLaCuenta(JugadorPermanente obj)
	{
		boolean encontrada = false;

		JugadorPermanente aux;

		for(int i = 0;i < coleccionJugadores.cantidad();i++)
		{
			aux = getColeccionJugadores().obtenerObjeto(i);
			if((obj.getId().equals(aux.getId())) || (obj.getUsuario().equals(aux.getUsuario()))
					|| (obj.getDni().equals(aux.getDni())) || (obj.getCorreo().equals(aux.getCorreo()))
					|| (obj.getNickname().equals(aux.getNickname())))
			{
				encontrada = true;
			}
		}

		return encontrada;
	}

	public int retornarPosicionJugador(JugadorPermanente param)
	{
		int pos = -1;

		for(int i = 0;i < coleccionJugadores.cantidad();i++)
		{
			if(param.getId().equals(coleccionJugadores.obtenerObjeto(i).getId()))
				pos = i;
		}
		return pos;
	}

	public void copiarCuentasDeColeccionAlArchivo(String nombreArchivo)
	{
		File archiC = new File(nombreArchivo);
		if(!archiC.exists())
		{
			try
			{
				archiC.createNewFile();
			}catch(IOException e1)
			{
				e1.printStackTrace();
			}
		}

		try
		{
			ObjectOutputStream archiCuentas = new ObjectOutputStream(new FileOutputStream(archiC));
			int i = 0;
			while(i < getColeccionJugadores().cantidad())
			{
				JugadorPermanente aux = this.coleccionJugadores.obtenerObjeto(i);
				archiCuentas.writeObject(aux);
				i++;
			}

			archiCuentas.close();
		}catch(FileNotFoundException e)
		{
			// e.printStackTrace();
		}catch(IOException e)
		{
			// e.printStackTrace();
		}

	}

	public void copiarCuentasDelArchivoAlaColeccion(String nombreArchivo)
	{
		File archiC = new File(nombreArchivo);
		if(archiC.exists())
		{
			try
			{
				ObjectInputStream archiCuentas = new ObjectInputStream(new FileInputStream(archiC));
				setColeccionJugadores(new Contenedor<JugadorPermanente>());
				JugadorPermanente aux = (JugadorPermanente) archiCuentas.readObject();
				while(aux != null)
				{
					this.coleccionJugadores.agregar(aux);
					aux = (JugadorPermanente) archiCuentas.readObject();
				}

				archiCuentas.close();

			}catch(FileNotFoundException e)
			{
				// e.printStackTrace();
			}catch(IOException e)
			{
				// e.printStackTrace();
			}catch(ClassNotFoundException e)
			{
				// e.printStackTrace();
			}
		}
	}

	// ----------------------------------------------------------------------------------------------------------------------------------

	public void copiarPreguntasDeColeccionAlArchivo(String nombreArchivo)
	{
		File archiP = new File(nombreArchivo);
		if(!archiP.exists())
		{
			try
			{
				archiP.createNewFile();
			}catch(IOException e1)
			{
				e1.printStackTrace();
			}
		}
		try
		{
			ObjectOutputStream archiPreguntas = new ObjectOutputStream(new FileOutputStream(archiP));

			for(HashMap.Entry<String, ArrayList<Pregunta>> entry: coleccionPreguntas.entrySet())
			{
				for(int i = 0;i < coleccionPreguntas.get(entry.getKey()).size();i++)
				{
					Pregunta aux = coleccionPreguntas.get(entry.getKey()).get(i);
					archiPreguntas.writeObject(aux);
				}
			}

			archiPreguntas.close();

		}catch(FileNotFoundException e)
		{
			// e.printStackTrace();
		}catch(IOException e)
		{
			// e.printStackTrace();
		}
		
		try
		{
			copiarPreguntasAlArchivoJSON();
			
		}catch(JSONException e)
		{
			e.printStackTrace();
		}	
	}

	public void copiarPreguntasDelArchivoAlaColeccion(String nombreArchivo)
	{
		File archiP = new File(nombreArchivo);
		try
		{
			ObjectInputStream archiPreguntas = new ObjectInputStream(new FileInputStream(archiP));
			setColeccionPreguntas(new HashMap<String, ArrayList<Pregunta>>());
			Pregunta aux = (Pregunta) archiPreguntas.readObject();
			while(aux != null)
			{
				if(coleccionPreguntas.containsKey(aux.getDisciplina()) == false)
				{
					ArrayList<Pregunta> arrayAuxiliar = new ArrayList<Pregunta>();
					arrayAuxiliar.add(aux);
					coleccionPreguntas.put(aux.getDisciplina(),arrayAuxiliar);
				}else
				{
					coleccionPreguntas.get(aux.getDisciplina()).add(aux);
				}

				aux = (Pregunta) archiPreguntas.readObject();
			}
		
			archiPreguntas.close();
			
		}catch(FileNotFoundException e)
		{
			// e.printStackTrace();
		}catch(IOException e)
		{
			// e.printStackTrace();
		}catch(ClassNotFoundException e)
		{
			// e.printStackTrace();
		}
		try
		{
			copiarPreguntasAlArchivoJSON();
			
		}catch(JSONException e)
		{
			e.printStackTrace();
		}	
	}

	public void copiarPreguntasAlArchivoJSON() throws JSONException
	{
		JSONArray arregloJson = new JSONArray();

		int j = 0;
		for(HashMap.Entry<String, ArrayList<Pregunta>> entry: coleccionPreguntas.entrySet())
		{
			for(int i = 0;i < coleccionPreguntas.get(entry.getKey()).size();i++)
			{
				JSONObject objetoJson = new JSONObject();
				Pregunta auxPregunta = coleccionPreguntas.get(entry.getKey()).get(i);
				objetoJson.put("ID",auxPregunta.getId());
				objetoJson.put("Enunciado",auxPregunta.getEnunciado());
				objetoJson.put("Disciplina",auxPregunta.getDisciplina());
				objetoJson.put("Opcion A",auxPregunta.getOpciones().get(0));
				objetoJson.put("Opcion B",auxPregunta.getOpciones().get(1));
				objetoJson.put("Opcion C",auxPregunta.getOpciones().get(2));
				objetoJson.put("Opcion D",auxPregunta.getOpciones().get(3));
				arregloJson.put(j,objetoJson);
				j++;
			}
		}
		
		try
		{
			ObjectOutputStream escritura = new ObjectOutputStream(new FileOutputStream("infopreguntas.txt"));
			escritura.writeObject(arregloJson.toString());
			escritura.flush();
			escritura.close();

		}catch(IOException e)
		{
			e.printStackTrace();
		}

		
	}

	public void cargarNuevaPregunta(String nombreArchivo, String categoria, Pregunta nuevaPregunta)
	{

		if(coleccionPreguntas.containsKey(categoria) == false)
		{
			ArrayList<Pregunta> aux = new ArrayList<Pregunta>();
			aux.add(nuevaPregunta);
			coleccionPreguntas.put(categoria,aux);
		}else
		{
			coleccionPreguntas.get(categoria).add(nuevaPregunta);
		}

		copiarPreguntasDeColeccionAlArchivo(nombreArchivo);
	}

	public void eliminarPreguntaDeLaListaDelMapa(String nombreArchivo, String categoria, Pregunta obj)
	{

		for(int i = 0;i < this.coleccionPreguntas.get(categoria).size();i++)
		{
			if(obj.getId().equals(coleccionPreguntas.get(categoria).get(i).getId()))
			{
				this.coleccionPreguntas.get(categoria).remove(i);
			}
		}
		copiarPreguntasDeColeccionAlArchivo(nombreArchivo);
	}

}
