package cursojava.javaIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class EscreveJSon {

	public static void main(String[] args) throws IOException {

		Usuario usuario1 = new Usuario();
		usuario1.setNome("Carlos Gregório");
		usuario1.setLogin("ajfdbfdobv");
		usuario1.setSenha("837489256");
		usuario1.setCpf("567.657.787-56");

		Usuario usuario2 = new Usuario();
		usuario2.setNome("Lucca Pessanha");
		usuario2.setLogin("gnrtgngmymy");
		usuario2.setSenha("54654763764");
		usuario2.setCpf("232.674.132-67");

		List<Usuario> usuarios = new ArrayList<Usuario>();

		usuarios.add(usuario1);
		usuarios.add(usuario2);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create(); /* ORGANIZA A IMPRESSÃO */
		String JsonUser = gson.toJson(usuarios);
		
		System.out.println(JsonUser);
		
		FileWriter fileWriter = new FileWriter("C:\\Users\\carlo\\git\\JDevTreinamentos\\treinamentojava\\src\\cursojava\\javaIO\\fileJson.json");
		
		fileWriter.write(JsonUser);
		fileWriter.flush();
		fileWriter.close();

	}

}
