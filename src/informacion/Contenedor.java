package informacion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.AbstractListModel;

import personas.Cuenta;

public class Contenedor<T> 
{
	// Atributos:
	private ArrayList<T> elementos;

	// Constructores:

	public Contenedor()
	{
		elementos = new ArrayList<T>();
	}

	// Getters y Setters:

	private ArrayList<T> getElementos()
	{
		return elementos;
	}

	// Metodos varios:

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
		StringBuilder sb = new StringBuilder();

		for(T e: elementos)
		{
			sb.append(e.toString());
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
		return elementos.get(index);
	}

	public void reemplazarElemento(int pos, T objRemplazo)
	{
		if(pos != -1)
			elementos.set(pos,objRemplazo);
	}

	public void eliminarElemento(T param)
	{
		this.elementos.remove(param);
	}

}
