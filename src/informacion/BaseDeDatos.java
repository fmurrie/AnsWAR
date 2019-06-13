package informacion;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

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

	// Getters y Setters

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

	// Metodos extra:

	@Override
	public String toString()
	{
		return "BaseDeDatos{" + "registroEnunciados=" + coleccionPreguntas + ", registroJugadores=" + coleccionCuentas
				+ '}';
	}

	public void registrarCuenta(String nombreArchivo, Cuenta obj)
	{
		if(obj != null)
		{
			copiarCuentasDelArchivoAlaColeccion(nombreArchivo);
			this.coleccionCuentas.agregar(obj);
			copiarCuentasDeColeccionAlArchivo(nombreArchivo);
		}
	}

	public Cuenta loggearCuenta(String nombreArchivo, String usuario, String clave)
	{
		copiarCuentasDelArchivoAlaColeccion(nombreArchivo);
		
		Cuenta obj = corroborarSiExisteLaCuentaLogueando(usuario,clave);

		copiarCuentasDeColeccionAlArchivo(nombreArchivo);
		
		return obj;
	}

	private Cuenta corroborarSiExisteLaCuentaLogueando(String usuario, String clave)
	{	
		boolean encontrado = false;
		Cuenta obj =null;
		int i=0;
		
		while((i<getColeccionCuentas().cantidad()) && (encontrado == false))
		{
			obj=getColeccionCuentas().obtenerObjeto(i);
			if(obj.compararCuentasPorUsuarioYclave(usuario,clave))
			{
				encontrado = true;
			}
			i++;
		}
		if(encontrado==false)
			obj =null;
		
		return obj;
	}

	public void modificarCuenta(String nombreArchivo, Cuenta obj)
	{
		if(obj != null)
		{
			copiarCuentasDelArchivoAlaColeccion(nombreArchivo);
			int posicion = this.coleccionCuentas.obtenerPosicionObjeto(obj);
			if(posicion != -1)
				this.coleccionCuentas.reemplazarObjetoDeUnaPosicion(obj,posicion);
			copiarCuentasDeColeccionAlArchivo(nombreArchivo);
		}

	}

	private void copiarCuentasDeColeccionAlArchivo(String nombreArchivo)
	{
		File archiC=new File(nombreArchivo);
		if(!archiC.exists())
		try
		{
			archiC.createNewFile();
		}catch(IOException e1)
		{
			e1.printStackTrace();
		}
		try
		{
			ObjectOutputStream archiCuentas = new ObjectOutputStream(new FileOutputStream(archiC));
			int i = 0;
			while(i <= getColeccionCuentas().cantidad())
			{
				Cuenta aux = this.coleccionCuentas.obtenerObjeto(i);

				if(aux != null)
					archiCuentas.writeObject(aux);
				i++;

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
		File archiC=new File(nombreArchivo);
		if(archiC.exists())
		{
		try
		{
			ObjectInputStream archiCuentas = new ObjectInputStream(new FileInputStream(archiC));
			setColeccionCuentas(new Contenedor<Cuenta>());
			Cuenta aux;
			do
			{
				aux = (Cuenta) archiCuentas.readObject();
				if(aux!=null)
					this.coleccionCuentas.agregar(aux);

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
	}

	private void copiarPreguntasDeColeccionAlArchivo(String nombreArchivo)
	{
		try
		{
			ObjectOutputStream archiPreguntas = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
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
			ObjectInputStream archiPreguntas = new ObjectInputStream(new FileInputStream(nombreArchivo));

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
