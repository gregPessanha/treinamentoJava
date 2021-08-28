package cursojava.javaIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class InsercaoDados {

	public static void main(String[] args) throws IOException {

		List<Pessoa> pessoas = new ArrayList<>();

		int qtdInsercoes = Integer
				.parseInt(JOptionPane.showInputDialog("Digite a quantidade de pessoas que deseja cadastrar: "));

		for (int i = 1; i <= qtdInsercoes; i++) {

			Pessoa pessoa = new Pessoa();

			String nomePessoa = JOptionPane.showInputDialog("Digite o nome da pessoa: ");
			String idadePessoa = JOptionPane.showInputDialog("Digite a idade da pessoa: ");
			String emailPessoa = JOptionPane.showInputDialog("Digite o e-mail da pessoa: ");

			pessoa.setNome(nomePessoa);
			pessoa.setIdade(idadePessoa);
			pessoa.setEmail(emailPessoa);

			pessoas.add(pessoa);

		}

		File arquivoNovo = new File(
				"C:\\Users\\carlo\\git\\JDevTreinamentos\\treinamentojava\\src\\cursojava\\javaIO\\arquivoNovo.csv");

		FileWriter escreverArquivoNovo = new FileWriter(arquivoNovo);

		for (Pessoa pessoa : pessoas) {
			escreverArquivoNovo.write(pessoa.getNome() + " ; " + pessoa.getEmail() + " ; " + pessoa.getIdade() + ";\n");

		}

		escreverArquivoNovo.flush();
		escreverArquivoNovo.close();

	}

}
