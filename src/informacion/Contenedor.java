package informacion;
import java.util.HashSet;
import java.util.Iterator;

public class Contenedor<T>
{
	//Atributos:
	private HashSet<T> elementos;
	
	//Constructores:

	public Contenedor()
	{
		setElementos(new HashSet<T>());
	}

	//Getters y Setters:
	
	private HashSet<T> getElementos()
	{
		return elementos;
	}
	
	private void setElementos(HashSet<T> elementos)
	{
		this.elementos = elementos;
	}
	
	//Metodos varios:
	
	public void agregar(T param)
	{
		elementos.add(param);
	}

	public void eliminar(T param)
	{
		elementos.remove(param);
	}

	public String listar()
	{
		Iterator<T> it = elementos.iterator();
		StringBuilder sb = new StringBuilder();

		while(it.hasNext())
		{

			sb.append(it.next().toString());
		}
		return sb.toString();
	}

	public boolean verificarExistencia(T param)
	{
		Iterator<T> it = elementos.iterator();
		boolean encontrado = false;
		while(it.hasNext())
		{
			T obj = it.next();
			if(obj.equals(param))
			{
				encontrado = true;
			}
		}
		return encontrado;
	}

}
