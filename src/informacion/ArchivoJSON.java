package informacion;

import org.json.JSONArray;

import java.io.*;

public class ArchivoJSON {

    private File archi;


    public String crearArchivo(){

        StringBuilder sb = new StringBuilder();

        archi = new File ("archivo.json");

        try{
            if(archi.createNewFile()){
                sb.append("El Archivo se ha creado correctamente");
            }
        }catch (IOException ex){
            sb.append("ERROR - No se puedo crear el archivo"+ex);
        }
        return sb.toString();
    }



    public String escribirArchivo(JSONArray array) {
        StringBuilder sb = new StringBuilder();
        try {
            FileWriter escribir = new FileWriter(archi);
            escribir.write(array.toString());
            escribir.flush();
            escribir.close();
            sb.append("El archivo se escribio correctamente");
        } catch (IOException ex) {
            sb.append("ERROR - El archivo no se puedo escribir"+ex);
        }
        return sb.toString();
    }

    public String leerArchivo()
    {
        String s = "";
        StringBuilder sb = new StringBuilder();
        try
        {
            FileReader lector = new FileReader(archi);
            BufferedReader lectura = new BufferedReader(lector);
            s = lectura.readLine();

            while(s != null){
                sb.append(s);
                s = lectura.readLine();
            }

        } catch (FileNotFoundException ex){
            sb.append("ERROR"+ex);
        }catch(IOException ex){
            sb.append("ERROR"+ex);
        }
        return sb.toString();
    }












}
