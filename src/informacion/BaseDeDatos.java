package informacion;

import java.io.*;
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
		setColeccionPreguntas(new HashMap<String, ArrayList<Pregunta>>());
		setColeccionCuentas(new Contenedor<Cuenta>());
	}

	//Getters y Setters
	
	private HashMap<String, ArrayList<Pregunta>> getColeccionPreguntas()
	{
		return coleccionPreguntas;
	}

	private Contenedor<Cuenta> getColeccionCuentas()
	{
		return coleccionCuentas;
	}

	private void setColeccionPreguntas(HashMap<String, ArrayList<Pregunta>> coleccionPreguntas)
	{
		this.coleccionPreguntas = coleccionPreguntas;
	}

	private void setColeccionCuentas(Contenedor<Cuenta> coleccionCuentas)
	{
		this.coleccionCuentas = coleccionCuentas;
	}
	
	//Metodos extra:
	
	@Override
	public String toString()
	{
		return "BaseDeDatos{" + "registroEnunciados=" + coleccionPreguntas + ", registroJugadores=" + coleccionCuentas+ '}';
	}
	
	public void registrarCuenta(String nombreArchivo,Cuenta obj)
	{
		if(obj!=null)
		{
			copiarCuentasDelArchivoAlaColeccion(nombreArchivo);
			this.coleccionCuentas.agregar(obj);
			copiarCuentasDeColeccionAlArchivo(nombreArchivo);
		}	
	}
	
	public boolean loggearCuenta(String nombreArchivo,Cuenta obj)
	{
		boolean busqueda=false;
		if(obj!=null)
		{
			copiarCuentasDelArchivoAlaColeccion(nombreArchivo);
			busqueda=this.coleccionCuentas.verificarExistencia(obj);
			copiarCuentasDeColeccionAlArchivo(nombreArchivo);
		}
		
		return busqueda;
	}
	
	public void modificarCuenta(String nombreArchivo,Cuenta obj)
	{
		if(obj!=null)
		{
			copiarCuentasDelArchivoAlaColeccion(nombreArchivo);
			int posicion=this.coleccionCuentas.obtenerPosicionObjeto(obj);
			if(posicion!=-1)
				this.coleccionCuentas.reemplazarObjetoDeUnaPosicion(obj,posicion);
			copiarCuentasDeColeccionAlArchivo(nombreArchivo);
		}
		
	}
	
	private void copiarCuentasDeColeccionAlArchivo(String nombreArchivo)
	{
		try
		{
			ObjectOutputStream archiCuentas= new ObjectOutputStream(new FileOutputStream(nombreArchivo));
			int i=0;
			while(i<getColeccionCuentas().cantidad())
			{
				Cuenta aux=(Cuenta)this.coleccionCuentas.obtenerObjeto(i);
				if(aux!=null)
					archiCuentas.writeObject(aux);
			}
			
			archiCuentas.close();
			
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private void copiarCuentasDelArchivoAlaColeccion(String nombreArchivo)
	{
		try
		{
			ObjectInputStream archiCuentas= new ObjectInputStream(new FileInputStream(nombreArchivo));
			Object aux;
			do
			{	
				aux = archiCuentas.readObject();
				
			}while(aux != null);

			archiCuentas.close();
			
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	
	private void copiarPreguntasDeColeccionAlArchivo(String nombreArchivo)
	{
		try
		{
			ObjectOutputStream archiPreguntas= new ObjectOutputStream(new FileOutputStream(nombreArchivo));
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private void copiarPreguntasDelArchivoAlaColeccion(String nombreArchivo)
	{
		try
		{
			ObjectInputStream archiPreguntas= new ObjectInputStream(new FileInputStream(nombreArchivo));
			
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	public void agregarEnunciados(String categoria, Pregunta nuevaPregunta)
	{
		ArrayList<Pregunta> aux = new ArrayList<Pregunta>();
		aux.add(nuevaPregunta);
		coleccionPreguntas.put(categoria,aux);
	}

	
}
