package informacion;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

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
		
		efectivo =verificarSiSeRepiteLaCuenta(obj);
		if ((obj != null)&&(efectivo==false))
		{
				this.coleccionJugadores.agregar(obj);
			
		}
		
		copiarCuentasDeColeccionAlArchivo(nombreArchivo);
		
		return efectivo;
	}
	
	public JugadorPermanente loggearCuenta(String nombreArchivo, String usuario, String clave)
	{

		JugadorPermanente obj=null;
		
		for(int i=0;i<coleccionJugadores.cantidad();i++)
		{
			if((coleccionJugadores.obtenerObjeto(i).getUsuario().equals(usuario))&&(coleccionJugadores.obtenerObjeto(i).getClave().equals(clave)))
			{
				obj=coleccionJugadores.obtenerObjeto(i);
			}
		}

		return obj;
	}
	
	public void modificarCuenta(String nombreArchivo, JugadorPermanente original, JugadorPermanente modificada)
	{
		if (original != null)
		{
			
			int pos=retornarPosicionJugador(original);
			this.coleccionJugadores.reemplazarElemento(pos, modificada);
			
			copiarCuentasDeColeccionAlArchivo(nombreArchivo);
		}
	}
	
	public String retornarColeccionJugadoresParaMostrar()
	{
		String dato="";
		for(int i=0;i<this.coleccionJugadores.cantidad();i++)
		{
			dato=dato+coleccionJugadores.obtenerObjeto(i).toString();
		}
	
		return dato;
	}
	
	private boolean verificarSiSeRepiteLaCuenta(JugadorPermanente obj)
	{
		boolean encontrada=false;
		
		JugadorPermanente aux;
		
		for(int i=0;i<coleccionJugadores.cantidad();i++)
		{
			aux=getColeccionJugadores().obtenerObjeto(i);
			if((obj.getId().equals(aux.getId()))||(obj.getUsuario().equals(aux.getUsuario()))||(obj.getDni().equals(aux.getDni()))||(obj.getCorreo().equals(aux.getCorreo()))||(obj.getNickname().equals(aux.getNickname())))
			{
				encontrada=true;
			}
		}
		
		return encontrada;
	}

	public int retornarPosicionJugador(JugadorPermanente param)
	{
		int pos = -1;

			for(int i = 0; i < coleccionJugadores.cantidad(); i++)
			{
				if (param.getId().equals(coleccionJugadores.obtenerObjeto(i).getId()))
					pos = i;
			}
		return pos;
	}

	public void copiarCuentasDeColeccionAlArchivo(String nombreArchivo)
	{
		File archiC = new File(nombreArchivo);
		if (!archiC.exists())
		{
			try
			{
				archiC.createNewFile();
			} catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}

		try
		{
			ObjectOutputStream archiCuentas = new ObjectOutputStream(new FileOutputStream(archiC));
			int i = 0;
			while (i < getColeccionJugadores().cantidad())
			{
				JugadorPermanente aux = this.coleccionJugadores.obtenerObjeto(i);	
				archiCuentas.writeObject(aux);
				i++;
			}

			archiCuentas.close();
		} catch (FileNotFoundException e)
		{
			// e.printStackTrace();
		} catch (IOException e)
		{
			// e.printStackTrace();
		}

	}

	public void copiarCuentasDelArchivoAlaColeccion(String nombreArchivo)
	{
		File archiC = new File(nombreArchivo);
		if (archiC.exists())
		{
			try
			{
				ObjectInputStream archiCuentas = new ObjectInputStream(new FileInputStream(archiC));
				setColeccionJugadores(new Contenedor<JugadorPermanente>());
				JugadorPermanente aux=(JugadorPermanente) archiCuentas.readObject();
				while(aux != null)
				{
					this.coleccionJugadores.agregar(aux);
					aux = (JugadorPermanente) archiCuentas.readObject();
				}

				archiCuentas.close();

			} catch (FileNotFoundException e)
			{
				// e.printStackTrace();
			} catch (IOException e)
			{
				// e.printStackTrace();
			} catch (ClassNotFoundException e)
			{
				// e.printStackTrace();
			}
		}
	}

	//----------------------------------------------------------------------------------------------------------------------------------
	
	private void copiarPreguntasDeColeccionAlArchivo(String nombreArchivo)
	{
		try
		{
			ObjectOutputStream archiPreguntas = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
		} catch (FileNotFoundException e)
		{
			// e.printStackTrace();
		} catch (IOException e)
		{
			// e.printStackTrace();
		}
	}

	private void copiarPreguntasDelArchivoAlaColeccion(String nombreArchivo)
	{
		try
		{
			ObjectInputStream archiPreguntas = new ObjectInputStream(new FileInputStream(nombreArchivo));

		} catch (FileNotFoundException e)
		{
			// e.printStackTrace();
		} catch (IOException e)
		{
			// e.printStackTrace();
		}
	}

	public void agregarEnunciados(String categoria, Pregunta nuevaPregunta)
	{
		ArrayList<Pregunta> aux = new ArrayList<Pregunta>();
		aux.add(nuevaPregunta);
		coleccionPreguntas.put(categoria, aux);
	}

}
