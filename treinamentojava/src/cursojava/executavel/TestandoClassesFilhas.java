package cursojava.executavel;

import cursojava.classes.Aluno;
import cursojava.classes.Diretor;
import cursojava.classes.Secretario;

public class TestandoClassesFilhas {

	public static void main(String[] args) {

		Aluno aluno = new Aluno();
		aluno.setNome("Gregório");
		aluno.setIdade(16);
		
		Diretor diretor = new Diretor();
		diretor.setTitulacao("Diretor geral");
		diretor.setIdade(56);
	
		Secretario secretario = new Secretario();
		secretario.setExperiencia("10 anos");
		secretario.setIdade(32);
		
		System.out.println(aluno.maiorDeIdade());
		System.out.println(diretor.maiorDeIdade());
		System.out.println(secretario.maiorDeIdade());
		
		System.out.println(aluno.salario());
		System.out.println(diretor.salario());
		System.out.println(secretario.salario());
	
	}

}
