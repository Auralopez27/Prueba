package API.Prueba;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.json.JSONException;
import org.json.JSONObject;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class PruebaGET {

	public static void main(String[] args) throws Exception{
        // Establecer la base URL de la API
		String apiUrl = "https://reqres.in/api/users?page=2";
		String encodedUrl = URLEncoder.encode(apiUrl, StandardCharsets.UTF_8.toString());
		RestAssured.baseURI = encodedUrl;

        // Realizar la solicitud GET
        Response response = RestAssured.get();

        // Obtener el código de respuesta
        int statusCode = response.getStatusCode();
        System.out.println("Código de respuesta: " + statusCode);
        
        // Obtener el cuerpo de la respuesta como JSON
        String responseBody = response.getBody().asString();
        //System.out.println("Cuerpo de respuesta: " + responseBody);

        // Puedes imprimir el cuerpo de la respuesta con formato si es JSON
        // Asegúrate de que el cuerpo de la respuesta sea un JSON válido
        try {
            System.out.println("Esquema de respuesta:");
            JSONObject jsonObj = new JSONObject();
            jsonObj.put(responseBody,true);
            System.out.println(jsonObj.toString(6));
            //System.out.println(new JSONObject(responseBody).toString(4)); // Imprimir el JSON con formato
        } catch (JSONException e) {
            System.out.println("Error al intentar parsear el JSON:");
            e.printStackTrace();
        }
    }
}