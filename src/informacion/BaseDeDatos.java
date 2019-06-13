package informacion;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import disciplinas.Pregunta;
import personas.Admin;
import personas.Cuenta;
import personas.Jugador;

public class BaseDeDatos
{
	// Atributos
	private ArrayList<Pregunta> preguntas;
	private HashMap<String, ArrayList<Pregunta>> coleccionPreguntas;
	private Contenedor<Cuenta> coleccionCuentas;

	// Constructores
	public BaseDeDatos()
	{
		this.preguntas = new ArrayList<Pregunta>();
		this.coleccionPreguntas = new HashMap<String,ArrayList<Pregunta>>();
		this.coleccionCuentas = new Contenedor<Cuenta>();
	}

	//Getters y Setters
	public Contenedor<Cuenta> getColeccionCuentas() {
		return coleccionCuentas;
	}

	//Metodos extra:
	public boolean verificarNickname(Jugador j){
		return  coleccionCuentas.verificarExistencia(j);
	}

	public boolean verificarCuenta(Cuenta c){
		return coleccionCuentas.verificarExistencia(c);
	}


	//Add Cuenta
	public boolean registrarCuenta(String nombreArchivo, Cuenta cuenta){

		if( cuenta != null )
		{
			if(cuenta instanceof Jugador){

				if( !verificarNickname((Jugador) cuenta) ){
					copiarCuentasDelArchivoAlaColeccion(nombreArchivo);
					this.coleccionCuentas.agregar((Jugador)cuenta);
					copiarCuentasDeColeccionAlArchivo(nombreArchivo);
					return true;
				}
				else{
					return false;
				}
			}
			if(cuenta instanceof Admin){
				if( !verificarCuenta((Admin)cuenta) ){
					copiarCuentasDelArchivoAlaColeccion(nombreArchivo);
					this.coleccionCuentas.agregar((Admin)cuenta);
					copiarCuentasDeColeccionAlArchivo(nombreArchivo);

					return true;

				}
				else{
					return false;
				}

			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}

	// Buscar y verificar si la cuenta existe retorna true
	public boolean iniciarSesionCuenta(String nombreArchivo,Cuenta obj)
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
			while(i <= getColeccionCuentas().cantidad())
			{
				Cuenta aux=this.coleccionCuentas.obtenerObjeto(i);

				if(aux!=null)
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



	//Cargar ArrayList de Preguntas
	public boolean agregarPregunta(Pregunta p){

		if (preguntas.add(p)) {
			return true;
		}
		else {
			return false;
		}
	}

	//Cargar HashMap Enunciados
	public void agregarEnunciados(String categoria, ArrayList<Pregunta> preguntas)
	{

		coleccionPreguntas.put(categoria,preguntas);
	}


	@Override
	public String toString()
	{
		return "BaseDeDatos{" + "registroEnunciados=" + coleccionPreguntas + ", registroJugadores=" + coleccionCuentas+ '}';
	}



}
