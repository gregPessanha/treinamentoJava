package cursojava.classes;

import java.util.ArrayList;
import java.util.List;

import cursojava.constantes.StatusAluno;

public class Aluno {

	private String nome;
	private int idade;
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public double getMediaAluno() {
		
		double somaNotas = 0;
		
		for (Disciplina disciplina : disciplinas) {
			
			somaNotas += disciplina.getNota();
		}
		return somaNotas / disciplinas.size();
	}

	public String getAlunoAprovado() {
		double media = this.getMediaAluno();
		if (media >= 5) {
			if(media >= 7) {
				return StatusAluno.APROVADO;
			}else {
				return StatusAluno.RECUPERACAO;
			}
		} else {
			return StatusAluno.REPROVADO;
		}
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + "\nIdade: " + idade;
	}
}
