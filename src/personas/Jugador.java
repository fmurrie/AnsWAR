package personas;

public abstract class Jugador extends Cuenta
{
	// Atributos:

	private String nickname;
	private long puntaje;
	private int rangoClasificacion;
	private int numPartidasJugadas;
	private int numPreguntasAcertadas;

	// Constructores:

	public Jugador()
	{
		super();
		setNickname("");
		setPuntaje(0);
		setRangoClasificacion(-1);
		setNumPartidasJugadas(0);
		setNumPreguntasAcertadas(0);
	}

	public Jugador(String usuario,String clave,String dni,String correo,String nickname,long puntaje,
			int rangoClasificacion,int numPartidasJugadas,int numPreguntasAcertadas)
	{
		super(usuario,clave,dni,correo);
		setNickname(nickname);
		setPuntaje(puntaje);
		setRangoClasificacion(rangoClasificacion);
		setNumPartidasJugadas(numPartidasJugadas);
		setNumPreguntasAcertadas(numPreguntasAcertadas);

	}

	public Jugador(String usuario,String clave,String dni,String correo,String nickname)
	{
		super(usuario,clave,dni,correo);
		setNickname(nickname);
		setPuntaje(0);
		setRangoClasificacion(-1);
		setNumPartidasJugadas(0);
		setNumPreguntasAcertadas(0);

	}

	public Jugador(String usuario,String clave,String dni,String correo)
	{
		super(usuario,clave,dni,correo);
		setNickname("");
		setPuntaje(0);
		setRangoClasificacion(-1);
		setNumPartidasJugadas(0);
		setNumPreguntasAcertadas(0);

	}

	// Getters y Setters:

	public String getNickname()
	{
		return nickname;
	}

	public long getPuntaje()
	{
		return puntaje;
	}

	private int getRangoClasificacion()
	{
		return rangoClasificacion;
	}

	public int getNumPartidasJugadas()
	{
		return numPartidasJugadas;
	}

	public int getNumPreguntasAcertadas()
	{
		return numPreguntasAcertadas;
	}

	protected void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	private void setPuntaje(long puntaje)
	{
		this.puntaje = puntaje;
	}

	private void setRangoClasificacion(int rangoClasificacion)
	{
		this.rangoClasificacion = rangoClasificacion;
	}

	private void setNumPartidasJugadas(int numPartidasJugadas)
	{
		this.numPartidasJugadas = numPartidasJugadas;
	}

	private void setNumPreguntasAcertadas(int numPreguntasAcertadas)
	{
		this.numPreguntasAcertadas = numPreguntasAcertadas;
	}

	// Metodos extra:

	@Override
	public String toString()
	{
		String dato = super.toString() + "\nNickname: " + getNickname() + "\nPuntuacion: " + getPuntaje()
				+ "\nPosicion: " + getRangoClasificacion() + "\nRespuestas correctas: " + getNumPreguntasAcertadas();

		return dato;
	}

	@Override
	public boolean equals(Object obj)
	{
		boolean respuesta = false;

		if(obj instanceof Jugador)
		{
			Jugador aux = (Jugador) obj;

			if(this.getId() == aux.getId())
				respuesta = true;

			if(this.getUsuario() == aux.getUsuario())
				respuesta = true;

			if(this.getDni() == aux.getDni())
				respuesta = true;

			if(this.getNickname() == aux.getNickname())
				respuesta = true;
		}

		return respuesta;
	}

}
