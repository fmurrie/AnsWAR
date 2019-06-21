package componentes;

import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JTextField;

/**
 * Clase para elegir aleatoriamente una categoria de pregunta.
 * Contiene un conjunto de categorias. Y un resultado, que es la categoria arrojada.
 */
public class Ruleta
{
	// Atributos:

	private String[] areas =
	{ "Arte", "Ciencia", "Deporte", "Entretenimiento", "Geografia", "Historia" };
	private String resultado;

	// Constructores:

	public Ruleta()
	{
		setResultado("");
	}

	// Getters y Setters:

	private String[] getAreas()
	{
		return areas;
	}

	private void setResultado(String resultado)
	{
		this.resultado = resultado;
	}

	public String getResultado()
	{
		return resultado;
	}

	// Metodos extra:

	/**
	 * Metodo para obtener un resultado.
	 */
	public void girarRuleta()
	{
		obtenerResultadoAlAzar();
	}

	/**
	 * Metodo que obtiene un resultado al azar entre las categorias posibles
	 */
	private void obtenerResultadoAlAzar()
	{
		int i = 0;
		int j = 0;
		int cantidadVueltas = generarNumeroEnteroRandom(0,355);
		while(j < cantidadVueltas)
		{
			setResultado(this.areas[i]);
			i++;
			if(i >= areas.length)
				i = 0;
			j++;
		}
	}

	private int generarNumeroEnteroRandom(int min, int max)
	{
		int numero = ThreadLocalRandom.current().nextInt(min,max);

		return numero;
	}

}
