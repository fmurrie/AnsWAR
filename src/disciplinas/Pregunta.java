package disciplinas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import personas.JugadorPermanente;

/**
 * Esta clase almacena el enunciado, un ArrayList del tipo respuesta, la disciplina a la que pertenece la pregunta
 * y un id aleatorio.
 * Implementa la interfaz Serializable.
 */
public class Pregunta implements Serializable
{
	// Atributos:
	private String id;
	private String enunciado;
	private ArrayList<Respuesta> opciones = new ArrayList<Respuesta>();
	private String disciplina;

	// Constructores

	public Pregunta()
	{
		setId("");
		setEnunciado("");
		setDisciplina("");
		setOpciones(new ArrayList<Respuesta>());

	}

	public Pregunta(String enunciado,String disciplina,ArrayList<Respuesta> opciones)
	{
		setDisciplina(disciplina);
		setId(generarIdRandom(1000,9999));
		setEnunciado(enunciado);
		setOpciones(opciones);

	}

	public Pregunta(Pregunta aux)
	{
		setId(aux.getId());
		setEnunciado(aux.getEnunciado());
		setDisciplina(aux.getDisciplina());
		setOpciones(aux.getOpciones());
	}

	// Getters y Setters:

	public String getEnunciado()
	{
		return enunciado;
	}

	public ArrayList<Respuesta> getOpciones()
	{
		return opciones;
	}

	public String getId()
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
		this.disciplina = disciplina;
	}

	// Metodos varios:

	/**
	 * Metodo que agrega una respuesta al arreglo de opciones. El cual contiene 4 respuestas.
	 * @param nueva Recibe por parametro la respuesta a agregar
	 */
	public void agregarRespuesta(Respuesta nueva)
	{
		opciones.add(nueva);
	}

	@Override
	public String toString()
	{
		String dato = "ID: " + getId() + "  |  Pregunta: " + getEnunciado() + "  |  Opcion A) "
				+ getOpciones().get(0).toString() + "  |  Opcion B) " + getOpciones().get(1).toString()
				+ "  |  Opcion C) " + getOpciones().get(2).toString() + "  |  Opcion D) "
				+ getOpciones().get(3).toString();

		return dato;
	}

	/**
	 * Metodo para generar el id del enunciado aleatoriamente. Verifica que el id no este en uso.
	 *
	 * @param min Recibe un long que es el numero minimo que puede arrojar aleatoriamente.
	 * @param max Recibe un long que es el numero maximo que puede arrojar aleatoriamente.
	 * @return
	 */
	private String generarIdRandom(long min, long max)
	{
		boolean esta = true;
		long idNumero = 0;
		String idString = "";
		while(esta == true)
		{
			idNumero = ThreadLocalRandom.current().nextLong(min,max);
			idString = disciplina.charAt(0) + "-" + Long.toString(idNumero);
			esta=verificarQueElIDnoExista("preguntas.dat",idString);
		}

		return idString;
	}

	/**
	 * Metodo que verifica en el archivo donde se encuentran las preguntas que un id especifico no se encuentre en uso.
	 * @param nombreArchivo direccion del archivo donde se encuentran las preguntas
	 * @param idNueva id a verificar que no exista.
	 * @return retorna un booleano: false si no existe el id, true si el id ya existe.
	 */
	private boolean verificarQueElIDnoExista(String nombreArchivo, String idNueva)
	{
		File archiP = new File(nombreArchivo);
		boolean respuesta = false;

		if(archiP.exists())
		{
			ObjectInputStream archiPreguntas;
			try
			{
				archiPreguntas = new ObjectInputStream(new FileInputStream(archiP));
				Pregunta aux = (Pregunta) archiPreguntas.readObject();
				while((aux != null) && (respuesta != true))
				{
					if(aux.getId().equalsIgnoreCase(idNueva))
						respuesta = true;
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

		}
		return respuesta;
	}

}
