package personas;

public class Admin extends Cuenta
{

	// Admin no necesita dni o correo

	// Constructores:
	//Admin por defecto : el Inicial
	public Admin()
	{
		super("Admin","1234");
	}

	//Admin creado con usuario y contraseña por si en un futuro se desea agregar un administrador, siempre creado del Admin Inicial
	public Admin(String usuario,String clave)
	{
		super(usuario,clave);
	}


	@Override
	public boolean equals(Object obj) {

		if (obj!=null)
		{
			if (obj instanceof Admin)
			{
				Admin admin = (Admin)obj;
				if (admin.getUsuario().equals(getUsuario()))
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

	// Metodos extra:
	@Override
	public String toString()
	{
		return "\nID: "+getId()+
			"\nUsuario: "+getUsuario()+
			"\nContraseña: "+getClave();
	}

}
