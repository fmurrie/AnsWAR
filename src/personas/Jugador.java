package personas;

public abstract class Jugador extends Cuenta  {

	// Atributos:
	private String nickname;
	private long puntaje;
	private int ranking;
	private int numPartidasJugadas;
	private int numPreguntasAcertadas;

	private final long puntajeDefault = 0;
	private final int rankingDefault = -1;
	private final int numPartidasJugadasDefault = 0;
	private final int numPreguntasAcertadasDefault = 0;


	// Constructores:
	// Vacio
	public Jugador()
	{
		super();
		this.nickname = "";
		this.puntaje = puntajeDefault;
		this.ranking = rankingDefault;
		this.numPreguntasAcertadas = numPreguntasAcertadasDefault;
		this.numPartidasJugadas = numPartidasJugadasDefault;
	}

	//Constructor Inicial
	public Jugador(String usuario,String clave,String dni,String correo,String nickname)
	{
		super(usuario,clave,dni,correo);
		this.nickname = nickname;
		this.puntaje = puntajeDefault;
		this.ranking = rankingDefault;
		this.numPreguntasAcertadas = numPreguntasAcertadasDefault;
		this.numPartidasJugadas = numPartidasJugadasDefault;

	}

	//Cosntructor completo
	public Jugador(String usuario,String clave,String dni,String correo,String nickname,long puntaje,
			int ranking,int numPartidasJugadas,int numPreguntasAcertadas)
	{
		super(usuario,clave,dni,correo);
		this.nickname = nickname;
		this.puntaje = puntaje;
		this.ranking = ranking;
		this.numPreguntasAcertadas = numPreguntasAcertadas;
		this.numPartidasJugadas = numPartidasJugadas;
	}


	//Setters
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
		this.ranking = rangoClasificacion;
	}

	private void setNumPartidasJugadas(int numPartidasJugadas)
	{
		this.numPartidasJugadas = numPartidasJugadas;
	}

	private void setNumPreguntasAcertadas(int numPreguntasAcertadas)
	{
		this.numPreguntasAcertadas = numPreguntasAcertadas;
	}



	// Getters
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
		return ranking;
	}

	public int getNumPartidasJugadas()
	{
		return numPartidasJugadas;
	}

	public int getNumPreguntasAcertadas()
	{
		return numPreguntasAcertadas;
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
	public boolean equals(Object obj) {

		if (obj!=null)
		{
			if (obj instanceof Jugador)
			{
				Jugador jugador = (Jugador)obj;
				if (jugador.getNickname().equals(getNickname()))
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



}
