package informacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.swing.AbstractListModel;

import personas.Cuenta;

/**
 * Clase generica que contiene un ArrayList de elementos.
 * Dentro de ella podemos Agregar, eliminar, listar, ver la cantidad de elementos. Verificar si un  elemento existe.
 * Y reemplazar un objeto determinado por otro dentro del arreglo.
 * @param <T>
 */
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

	/**
	 * Metodo que retorna todos los elementos del arreglo.
	 * @return
	 */
	private ArrayList<T> getElementos()
	{
		return elementos;
	}

	// Metodos varios:

	/**
	 * Metodo que retorna la cantidad de elementos del arreglo.
	 * @return
	 */
	public int cantidad()
	{
		return this.elementos.size();
	}

	/**
	 * Metodo para agregar un nuevo elemento al arreglo.
	 * @param param Recibe por parametro el nuevo elemento.
	 */
	public void agregar(T param)
	{
		this.elementos.add(param);
	}

	/**
	 * Metodo para eliminar un elemento del arreglo.
	 * @param param Recibe por parametro el elemento a eliminar.
	 */
	public void eliminar(T param)
	{
		this.elementos.remove(param);
	}

	/**
	 * Metodo que devuelve todos los elementos del arreglo en forma de String.
	 * @return Retorna un String.
	 */
	public String listar()
	{
		StringBuilder sb = new StringBuilder();

		for(T e: elementos)
		{
			sb.append(e.toString());
		}
		return sb.toString();
	}

	/**
	 * Metodo que recibe por parametro un elemento para verificar si existe en el arreglo.
	 * @param param Recibe por parametro un elemento
	 * @return Devuelve true si el elemento existe, o false si el elemento no existe.
	 */
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
	
}
