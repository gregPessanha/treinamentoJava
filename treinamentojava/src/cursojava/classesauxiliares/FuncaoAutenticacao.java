package cursojava.classesauxiliares;

import cursojava.interfaces.PermitirAcesso;

public class FuncaoAutenticacao {
	
	public boolean autenticar(PermitirAcesso acesso) {
		return acesso.autenticar();
	}

}
