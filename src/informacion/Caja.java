package informacion;

import java.util.ArrayList;

public class Caja<T>
{
	// Atributos
	private ArrayList<T> coleccion;

	// Constructores
	public Caja()
	{
		coleccion = new ArrayList<T>();
	}
	// Getters Setters

	public ArrayList<T> getColeccion()
	{
		return coleccion;
	}

	// Metodos
	public void agregar(T nuevo)
	{
		coleccion.add(nuevo);
	}

	public void eliminar(T aBorrar)
	{
		coleccion.remove(aBorrar);
	}

	public String listarTodo()
	{
		StringBuilder sb = new StringBuilder();
		for(T iterador: coleccion)
		{
			sb.append(iterador.toString());
		}
		return sb.toString();
	}

}
