package personas;

import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

import informacion.Contenedor;

/**
 * Clase abstracta que cuenta con informacion del usuario.
 */
public abstract class Cuenta implements Serializable
{
	// Atributos:

	private String id;
	private String usuario;
	private String clave;
	private String dni;
	private String correo;

	// Constructores:

	public Cuenta()
	{
		setId(generarIdRandom(123456,999999));
		setUsuario("");
		setClave("");
		setDni("");
		setCorreo("");
	}

	public Cuenta(String usuario,String clave)
	{
		setId("");
		setUsuario(usuario);
		setClave(clave);
		setDni("");
		setCorreo("");
	}

	public Cuenta(String usuario,String clave,String dni,String correo)
	{
		setId(generarIdRandom(123456,999999));
		setUsuario(usuario);
		setClave(clave);
		setDni(dni);
		setCorreo(correo);

	}

	public Cuenta(String id,String usuario,String clave,String dni,String correo)
	{
		setId(id);
		setUsuario(usuario);
		setClave(clave);
		setDni(dni);
		setCorreo(correo);

	}

	public Cuenta(Cuenta c)
	{
		setId(c.getId());
		setUsuario(c.getUsuario());
		setClave(c.clave);
		setDni(c.dni);
		setCorreo(c.correo);

	}

	// Getters y Setters:

	public String getId()
	{
		return id;
	}

	public String getUsuario()
	{
		return usuario;
	}

	public String getClave()
	{
		return clave;
	}

	public String getDni()
	{
		return dni;
	}

	public String getCorreo()
	{
		return correo;
	}

	public void setId(String id)
	{

		this.id = id;
	}

	private void setUsuario(String usuario)
	{
		this.usuario = usuario;
	}

	private void setClave(String clave)
	{
		this.clave = clave;
	}

	private void setDni(String dni)
	{
		this.dni = dni;
	}

	private void setCorreo(String correo)
	{
		this.correo = correo;
	}

	// Metodos extra:

	@Override
	public String toString()
	{
		String dato = "ID: " + getId() + "  |  Usuario: " + getUsuario() + "  |  DNI: " + getDni()
				+ "  |  Direccion de correo: " + getCorreo();
		return dato;

	}

	@Override
	public boolean equals(Object obj)
	{
		boolean respuesta = false;

		if(obj instanceof Cuenta)
		{
			Cuenta aux = (Cuenta) obj;
			if(this.getId() == aux.getId())
				respuesta = true;

			if(this.getUsuario() == aux.getUsuario())
				respuesta = true;

			if(this.getDni() == aux.getDni())
				respuesta = true;

			if(this.getCorreo() == aux.getCorreo())
				respuesta = true;
		}
		return respuesta;
	}

	/**
	 * Metodo que genera un id aleatorio para la cuenta.
	 * @param min
	 * @param max
	 * @return
	 */
	private String generarIdRandom(long min, long max)
	{
		boolean esta=true;
		long idNumero=0;
		String idString="";
		while(esta==true)
		{
			idNumero = ThreadLocalRandom.current().nextLong(min,max);
			idString = Long.toString(idNumero);
			esta=verificarQueElIDnoExista("jugadores.dat",idString);
		}
		
		return idString;
	}

	/**
	 * Metodo que verifica que la cuenta no exista
	 * @param nombreArchivo Recibe el nombre del archivo donde se encuentran las cuentas
	 * @param idNueva recibe el id nuevo
	 * @return devuelve true si el id no existe, y false si el id ya existe.
	 */
	private boolean verificarQueElIDnoExista(String nombreArchivo, String idNueva)
	{
		File archiC = new File(nombreArchivo);
		boolean respuesta = false;

		if(archiC.exists())
		{
			ObjectInputStream archiCuentas;
			try
			{
				archiCuentas = new ObjectInputStream(new FileInputStream(archiC));
				JugadorPermanente aux = (JugadorPermanente) archiCuentas.readObject();
				while((aux != null) && (respuesta != true))
				{
					if(aux.getId().equalsIgnoreCase(idNueva))
						respuesta = true;
					aux = (JugadorPermanente) archiCuentas.readObject();
				}

				archiCuentas.close();

			}catch(FileNotFoundException e)
			{
				//e.printStackTrace();
			}catch(IOException e)
			{
				//e.printStackTrace();
			}catch(ClassNotFoundException e)
			{
				//e.printStackTrace();
			}

		}
		return respuesta;
	}

}
