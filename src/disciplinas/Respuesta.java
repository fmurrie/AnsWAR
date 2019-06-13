package disciplinas;

import informacion.IGenerateJSON;
import org.json.JSONException;
import org.json.JSONObject;

public class Respuesta implements IGenerateJSON {
	private String respuesta;
	private boolean esCorrecta;

	// Constructores

	public Respuesta(String respuesta,boolean esCorrecta)
	{
		this.respuesta = respuesta;
		this.esCorrecta = esCorrecta;
	}

	//Setters
	public void setEsCorrecta(boolean esCorrecta) {
		this.esCorrecta = esCorrecta;
	}

	// Getters
	public String getRespuesta() {
		return respuesta;
	}
	public boolean isEsCorrecta()
	{
		return esCorrecta;
	}


	@Override
	public JSONObject generarJSONObject() throws JSONException{

		JSONObject jsono = new JSONObject();
		jsono.put("respuesa",getRespuesta());
		jsono.put("esCorrecta",isEsCorrecta());
		return jsono;
	}

	@Override
	public String toString()
	{
		return  respuesta ;
	}
}
