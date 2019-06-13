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
	
	public int cantidad()
	{
		return this.elementos.size();
	}
	
	public void agregar(T param)
	{
		this.elementos.add(param);
	}

	public void eliminar(T param)
	{
		this.elementos.remove(param);
	}

	public String listar()
	{
		Iterator<T> it = this.elementos.iterator();
		StringBuilder sb = new StringBuilder();

		while(it.hasNext())
		{

			sb.append(it.next().toString());
		}
		return sb.toString();
	}

	public boolean verificarExistencia(T param)
	{
		Iterator<T> it = this.elementos.iterator();
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
	
	public T obtenerObjeto(int index)
	{
		Iterator<T> it = this.elementos.iterator();
		T encontrado=null;
		int i=0;
		while(it.hasNext())
		{
			T obj = it.next();
			if(i==index)
			{
				encontrado = obj;
			}
			i++;
		}
		return encontrado;
	}

	public int obtenerPosicionObjeto(T param)
	{
		Iterator<T> it = this.elementos.iterator();
		boolean encontrado = false;
		int i=0;
		while((it.hasNext())&&(encontrado==false))
		{
			T obj = it.next();
			if(obj.equals(param))
			{
				encontrado = true;
			}
			i++;
		}
		if(encontrado==false)
			i=-1;
		return i;
	}
	
	public void reemplazarObjetoDeUnaPosicion(T param,int index)
	{
		Iterator<T> it = this.elementos.iterator();
		int i=0;
		T obj= it.next();
		while(i<=index)
		{
			obj = it.next();
			i++;
		}
		obj=param;
	}
}
