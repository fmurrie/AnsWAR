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

	// Constructor Vacio
	public Cuenta()
	{
		this.id = generarIdRandom(000000,999999);
		this.usuario = "";
		this.clave = "";
		this.dni = "";
		this.correo = "";
	}

	// Constructor por usuario y clave
	public Cuenta(String usuario,String clave)
	{
		this.id = generarIdRandom(000000,999999);
		this.usuario = usuario;
		this.clave = clave;
		this.dni = "";
		this.correo = "";
	}

	// Cosntructor completo
	public Cuenta(String usuario,String clave,String dni,String correo)
	{
		this.id = generarIdRandom(000000,999999);
		this.usuario = usuario;
		this.clave = clave;
		this.dni = dni;
		this.correo = correo;
	}

	// Getters
	public String getId()
	{
		return id;
	}

	public String getUsuario()
	{
		return usuario;
	}

	public String getClave() {
		return clave;
	}

	protected String getDni()
	{
		return dni;
	}

	private String getCorreo()
	{
		return correo;
	}


	@Override
	public String toString()
	{
		return "\nID: "+id+
				"\nUsuario: "+usuario+
				"\nContraseña: "+clave+
				"\nDNI: " +dni+
				"\nDireccion de correo: "+correo;
	}


	private String generarIdRandom(long min, long max)
	{
		long idNumero = ThreadLocalRandom.current().nextLong(min,max);
		String idString = Long.toString(idNumero);
		return idString;
	}

}
