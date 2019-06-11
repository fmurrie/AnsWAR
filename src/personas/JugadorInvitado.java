package personas;

import java.util.concurrent.ThreadLocalRandom;

public class JugadorInvitado extends Jugador
{
	// Atributos:

	private String nickInvitador;

	// Constructores:

	public JugadorInvitado()
	{
		super();
	}
	
	public JugadorInvitado(String usuario,String clave,String dni,String correo,String nickInvitador)
	{
		super(usuario,clave,dni,correo);
		super.setNickname(generarNicknameTemporalRandom());
		setNickInvitador(nickInvitador);
	}

	public JugadorInvitado(String nickInvitador)
	{
		super.setNickname(generarNicknameTemporalRandom());
		setNickInvitador(nickInvitador);
	}

	// Getters y Setters:

	private String getNickInvitador()
	{
		return nickInvitador;
	}

	private void setNickInvitador(String nickInvitador)
	{
		this.nickInvitador = nickInvitador;
	}

	// Metodos extra:

	public String toString()
	{
		String dato = super.toString() + "\nInvitado por: " + getNickInvitador();

		return dato;
	}

	private String generarNicknameTemporalRandom()
	{
		int dato = ThreadLocalRandom.current().nextInt(1,999);
		String nickname = "Invitado" + Integer.toString(dato);

		return nickname;
	}

}
