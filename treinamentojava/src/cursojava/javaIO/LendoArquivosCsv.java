package cursojava.javaIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LendoArquivosCsv {

	public static void main(String[] args) throws FileNotFoundException {

		FileInputStream entradaArquivo = new FileInputStream(
				"C:\\Users\\carlo\\git\\JDevTreinamentos\\treinamentojava\\src\\cursojava\\javaIO\\arquivo.csv");

		Scanner lerArquivo = new Scanner(entradaArquivo, "ISO-8859-1");
		
		List<Pessoa> pessoas = new ArrayList<>();

		while (lerArquivo.hasNext()) {
			String linha = lerArquivo.nextLine();
			
			/* N?O LER LINHA EM BRANCO */
			if (linha != null && !linha.isEmpty()) {

				String dados[] = linha.split("\\;");
				
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(dados[0]);
				pessoa.setIdade(Double.valueOf(dados[1]).intValue());
				pessoa.setEmail(dados[2]);
				
				pessoas.add(pessoa);
			}

		}
		
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa.toString());
			System.out.println("---------------------------------------------------------------------------------");
		}

	}

}
