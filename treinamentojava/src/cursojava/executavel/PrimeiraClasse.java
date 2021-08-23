package cursojava.executavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import cursojava.classes.Aluno;
import cursojava.classes.Disciplina;
import cursojava.classes.Pessoa;
import cursojava.classes.Secretario;
import cursojava.classesauxiliares.FuncaoAutenticacao;
import cursojava.constantes.StatusAluno;
import cursojava.interfaces.PermitirAcesso;

public class PrimeiraClasse {

	public static void main(String[] args) {

		String login = JOptionPane.showInputDialog("Digite o seu Login: ");
		int senha = Integer.parseInt(JOptionPane.showInputDialog("Digite a sua senha: "));
		
		FuncaoAutenticacao autenticacao = new FuncaoAutenticacao();
		PermitirAcesso permitirAcesso = new Secretario();
		
		if (autenticacao.autenticar(permitirAcesso)) {

			List<Aluno> alunos = new ArrayList<>();

			HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

			String qtdAlunos = JOptionPane.showInputDialog("Quantos alunos você quer adicionar? ");

			for (int qtd = 1; qtd <= Integer.valueOf(qtdAlunos); qtd++) {

				String nome = JOptionPane.showInputDialog("Qual o nome do " + qtd + "º aluno?");
//			String idade = JOptionPane.showInputDialog("Qual a idade do aluno " + nome);

				Aluno aluno1 = new Aluno();
				aluno1.setNome(nome);
//			aluno1.setIdade(Integer.valueOf(idade));

				for (int pos = 1; pos <= 1; pos++) {
					String nomeDisciplina = JOptionPane.showInputDialog("Qual o nome da " + pos + "ª disciplina?");
					String notaDisciplina = JOptionPane
							.showInputDialog("Qual a nota da disciplina " + nomeDisciplina + " ?");

					Disciplina disciplina = new Disciplina();
					disciplina.setDisciplina(nomeDisciplina);
					disciplina.setNota(Double.valueOf(notaDisciplina));

					aluno1.getDisciplinas().add(disciplina);

				}

				alunos.add(aluno1);
			}

			maps.put(StatusAluno.APROVADO, new ArrayList<Aluno>());
			maps.put(StatusAluno.RECUPERACAO, new ArrayList<Aluno>());
			maps.put(StatusAluno.REPROVADO, new ArrayList<Aluno>());

			for (Aluno aluno : alunos) {

				if (aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.APROVADO)) {
					maps.get(StatusAluno.APROVADO).add(aluno);

				} else if (aluno.getAlunoAprovado().equalsIgnoreCase(StatusAluno.RECUPERACAO)) {
					maps.get(StatusAluno.RECUPERACAO).add(aluno);
				} else {
					maps.get(StatusAluno.REPROVADO).add(aluno);
				}
			}

			System.out.println("---------ALUNOS APROVADOS---------");
			for (Aluno aluno : maps.get(StatusAluno.APROVADO)) {
				System.out.println(aluno.getNome());
				System.out.println("MÉDIA: " + aluno.getMediaAluno());
				System.out.println("-----------------------");
			}

			System.out.println("---------ALUNOS EM RECUPERAÇÃO---------");
			for (Aluno aluno : maps.get(StatusAluno.RECUPERACAO)) {
				System.out.println(aluno.getNome());
				System.out.println("MÉDIA: " + aluno.getMediaAluno());
				System.out.println("-----------------------");
			}

			System.out.println("---------ALUNOS REPROVADOS---------");
			for (Aluno aluno : maps.get(StatusAluno.REPROVADO)) {
				System.out.println(aluno.getNome());
				System.out.println("MÉDIA: " + aluno.getMediaAluno());
				System.out.println("-----------------------");
			}

		}else {
			JOptionPane.showMessageDialog(null, "Login ou senha Incorretos.");
		}
	}
}
