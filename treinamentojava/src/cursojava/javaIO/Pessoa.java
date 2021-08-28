package cursojava.javaIO;

public class Pessoa {

	private String nome;
	private String idade;
	private String email;

	@Override
	public String toString() {
		return this.getNome() + " ; " + this.getIdade() + " ; " + this.getEmail();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String dados) {
		this.idade = dados;
	}

}
