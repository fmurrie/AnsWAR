package componentes;

import java.util.concurrent.ThreadLocalRandom;

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

	public String girarRuleta()
	{
		obtenerResultadoAlAzar();
		String dato = "Resultado: " + getResultado();

		return dato;
	}

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
