package cursojava.javaIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EscrevendoArquivosTxt {

	public static void main(String[] args) throws IOException {

		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("Carlos Gregório Olivier Pessanha");
		pessoa1.setEmail("carlosgregoriopessanha@gmail.com");
		pessoa1.setIdade("35");

		Pessoa pessoa2 = new Pessoa();
		pessoa2.setNome("Lucca Dantas de Oliveira Olivier Pessanha");
		pessoa2.setEmail("luccadantaspessanha@gmail.com");
		pessoa2.setIdade("8");

		Pessoa pessoa3 = new Pessoa();
		pessoa3.setNome("Júlia Rafaela Dantas de Oliveira e Silva");
		pessoa3.setEmail("juliarafaelapessanha@gmail.com");
		pessoa3.setIdade("31");

		/*
		 * ESSA LISTA PODE VIR DE QUALQUER FONTE DE DADOS, POR EXEMPLO UM BANCO DE
		 * DADOS;
		 */
		List<Pessoa> pessoas = new ArrayList<>();

		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);

		File arquivo = new File(
				"C:\\Users\\carlo\\git\\JDevTreinamentos\\treinamentojava\\src\\cursojava\\javaIO\\arquivo.txt");

		if (!arquivo.exists()) {
			arquivo.createNewFile();

		}
		FileWriter escreverNoArquivo = new FileWriter(arquivo);

		for (Pessoa pessoa : pessoas) {

			escreverNoArquivo.write(pessoa.getNome() + " ; " + pessoa.getEmail() + " ; " + pessoa.getIdade() + "\n");
		}

		escreverNoArquivo.flush();
		escreverNoArquivo.close();

	}

}
