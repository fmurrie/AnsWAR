package personas;

public class JugadorRank extends JugadorPermanente implements Comparable<JugadorRank>
{
	
	public JugadorRank(JugadorPermanente obj)
	{
		super(obj.getId(),obj.getUsuario(),obj.getClave(),obj.getDni(),obj.getCorreo(),obj.getNickname(),obj.getPuntaje(),obj.getNumPartidasJugadas(),obj.getNumPreguntasAcertadas());
		
	}
	
	@Override
	public String toString()
	{
		String dato =getRangoClasificacion()+". "+getNickname() + "  |  Puntuacion: " + getPuntaje()+"  |  Respuestas correctas: " + getNumPreguntasAcertadas()+ "  |  Partidas jugadas: " + getNumPartidasJugadas();

		return dato;
	}

	@Override
	public int compareTo(JugadorRank obj)
	{
		Long a=new Long(this.getPuntaje()+this.getNumPreguntasAcertadas()+this.getNumPartidasJugadas());
        Long b=new Long(obj.getPuntaje()+obj.getNumPreguntasAcertadas()+obj.getNumPartidasJugadas());
        
        return a.compareTo(b);
	}

}
