package personas;

import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

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
		String dato = "\nID: " + getId() + "\nDNI: " + getDni() + "\nDireccion de correo: " + getCorreo();
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

	private String generarIdRandom(long min, long max)
	{
		long idNumero = ThreadLocalRandom.current().nextLong(min,max);
		String idString = Long.toString(idNumero);
		return idString;
	}
	
	public boolean compararCuentasPorUsuarioYclave(String usuario,String clave)
	{
		boolean existe=false;
		if((this.getClave().equals(usuario))&&(this.getUsuario().equals(clave)))
			existe=true;
		return existe;
	}

}
