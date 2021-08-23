package cursojava.classes;

import cursojava.interfaces.PermitirAcesso;

public class Secretario extends Pessoa implements PermitirAcesso {

	private String registro;
	private String nivelCargo;
	private String experiencia;
	
	private String login;
	private int senha;

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public String getNivelCargo() {
		return nivelCargo;
	}

	public void setNivelCargo(String nivelCargo) {
		this.nivelCargo = nivelCargo;
	}

	public String getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

	@Override
	public boolean maiorDeIdade() {
		return idade >= 30;
	}

	@Override
	public double salario() {
		return 2000 + (2000.00 * 0.1);
	}

	@Override
	public boolean autenticar(String login, int senha) {

		return autenticar();
	}
	
	@Override
	public boolean autenticar() {
		
		return login.equalsIgnoreCase("admin") && senha == 12345;
	}

}
