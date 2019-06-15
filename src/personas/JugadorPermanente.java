package personas;

public class JugadorPermanente extends Jugador
{
	// Constructores:

	public JugadorPermanente()
	{
		super();
	}

	public JugadorPermanente(String usuario,String clave,String dni,String correo,String nickname)
	{
		super(usuario,clave,dni,correo,nickname);
	}
	
	public JugadorPermanente(String id,String usuario,String clave,String dni,String correo,String nickname)
	{
		super(id,usuario,clave,dni,correo,nickname);
	}
	
	public JugadorPermanente(JugadorPermanente j)
	{
		super(j);
	}

	// Metodos extra:
	


}
