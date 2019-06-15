package personas;

public class Admin extends Cuenta
{
	// Atributos:

	// Constructores:

	public Admin()
	{
		super();
	}

	public Admin(String usuario,String clave)
	{
		super(usuario,clave);
	}

	public Admin(String usuario,String clave,String dni,String correo)
	{
		super(usuario,clave,dni,correo);
	}

	// Metodos extra:

	@Override
	public String toString()
	{
		String dato = "\nAdministrador: BA_" + getUsuario() + super.toString(); // BA ES LA ABREVIATURA DE "BOARD
																				// ADMINISTRATOR"

		return dato;
	}

}
