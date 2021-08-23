package cursojava.classes;

import java.util.ArrayList;
import java.util.List;

import cursojava.constantes.StatusAluno;

public class Aluno extends Pessoa{

	private String DataMatricula;
	private String NomeEscola;
	private String SerieMatriculado;
	
	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
	
	public String getDataMatricula() {
		return DataMatricula;
	}

	public void setDataMatricula(String dataMatricula) {
		DataMatricula = dataMatricula;
	}

	public String getNomeEscola() {
		return NomeEscola;
	}

	public void setNomeEscola(String nomeEscola) {
		NomeEscola = nomeEscola;
	}

	public String getSerieMatriculado() {
		return SerieMatriculado;
	}

	public void setSerieMatriculado(String serieMatriculado) {
		SerieMatriculado = serieMatriculado;
	}
	
	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinas;
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
	public boolean maiorDeIdade() {
		return idade >= 18;
	}
	
	@Override
	public String toString() {
		return "Nome: " + nome + "\nIdade: " + idade;
	}
	
	public double salario() {
		return 1500;
	}
}
