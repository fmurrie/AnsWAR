package personas;

import java.util.concurrent.ThreadLocalRandom;

public class JugadorInvitado extends Jugador
{
	// Atributos:


	// Constructores:

	public JugadorInvitado()
	{
		super.setNickname(generarNicknameTemporalRandom());
	}

	// Getters y Setters:



	// Metodos extra:


	private String generarNicknameTemporalRandom()
	{
		int dato = ThreadLocalRandom.current().nextInt(1,999);
		String nickname = "Invitado" + Integer.toString(dato);

		return nickname;
	}

}
