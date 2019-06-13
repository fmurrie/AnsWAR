package disciplinas;

import informacion.IGenerateJSON;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Pregunta implements IGenerateJSON
{
	// Atributos:
	private String id  ;
	private String enunciado;
	private ArrayList<Respuesta> opciones;


	// Constructores
	public Pregunta(String enunciado)
	{
		this.id = generarIdRandom(000000,999999);
		this.enunciado = enunciado;
		this.opciones = new ArrayList<Respuesta>();
	}


	public boolean verificarRespuestaCorrecta(){

		boolean rta = false;
		if(opciones == null){
			for(Respuesta r : opciones){
				if(r.isEsCorrecta()){
					rta = true;
				}
			}
		}
		return rta;
	}


	public void agregarRespuesta(Respuesta nueva)
	{
		int cont = 0;
		if(opciones.size() < 4 ) {

			opciones.add(nueva);

			if(nueva.isEsCorrecta() && !verificarRespuestaCorrecta()){
				opciones.add(nueva);
				cont = 1;
			}
			else if (nueva.isEsCorrecta() && cont==1){
				nueva.setEsCorrecta(false);
				opciones.add(nueva);
			}
			else if (!verificarRespuestaCorrecta() && (opciones.size() == 3)) {
				nueva.setEsCorrecta(true);
				opciones.add(nueva);
			}
		}
	}


	//Getters
	public String getId() {
		return id;
	}

	public String getEnunciado() {
		return enunciado;
	}


	@Override
	public JSONObject generarJSONObject() throws JSONException {

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", getId());
		jsonObject.put("pregunta",getEnunciado());

		JSONArray jsonArrayRespuestas = new JSONArray();

		for(Respuesta r : opciones){
			jsonArrayRespuestas.put(r.generarJSONObject());
		}
		jsonObject.put("respuesta", jsonArrayRespuestas);

		return jsonObject;
	}

	private String generarIdRandom(long min, long max)
	{
		long idNumero = ThreadLocalRandom.current().nextLong(min,max);
		String idString = Long.toString(idNumero);
		return idString;
	}

	@Override
	public String toString()
	{
		return "Pregunta{" + "enunciado='" + enunciado + '\'' + ", opciones=" + opciones + ", id='" + id + '\'' + '}';
	}


}
