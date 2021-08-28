package cursojava.javaIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LendoArquivosTxt {

	public static void main(String[] args) throws FileNotFoundException {

		FileInputStream entradaArquivo = new FileInputStream(
				"C:\\Users\\carlo\\git\\JDevTreinamentos\\treinamentojava\\src\\cursojava\\javaIO\\arquivo.txt");

		Scanner lerArquivo = new Scanner(entradaArquivo, "ISO-8859-1");
		
		List<Pessoa> pessoas = new ArrayList<>();

		while (lerArquivo.hasNext()) {
			String linha = lerArquivo.nextLine();
			
			/* NÃO LER LINHA EM BRANCO */
			if (linha != null && !linha.isEmpty()) {

				String dados[] = linha.split("\\;");
				
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(dados[0]);
				pessoa.setIdade(dados[1]);
				pessoa.setEmail(dados[2]);
				
				pessoas.add(pessoa);
			}

		}
		
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa.toString());
//			System.out.println(pessoa.getNome() + pessoa.getIdade() + pessoa.getEmail());
			System.out.println("---------------------------");
		}

	}

}
