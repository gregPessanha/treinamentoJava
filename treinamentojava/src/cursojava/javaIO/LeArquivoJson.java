package cursojava.javaIO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class LeArquivoJson {

	public static void main(String[] args) throws FileNotFoundException {
		
		FileReader fileReader = new FileReader("C:\\Users\\carlo\\git\\JDevTreinamentos\\treinamentojava\\src\\cursojava\\javaIO\\fileJson.json");
		
		JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);
		
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		
		for (JsonElement jsonElement : jsonArray) {
			
			Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);
			
			listaUsuarios.add(usuario);
		}
		
		System.out.println(listaUsuarios);
		System.out.println("LEITURA DO ARQUIVO JSON TERMINADA");
	}
}
 