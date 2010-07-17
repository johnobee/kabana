package br.com.gui.action;

import br.com.gui.BaseAction;
import br.com.negocios.entidade.Administrador;
import br.com.negocios.servico.execption.EntidadeNaoExistenteException;

@SuppressWarnings("serial")
public class GerenciadorAdministracao extends BaseAction {
	
	public static final String ADMINISTRADOR = "administrador";
	
	public GerenciadorAdministracao() {
		
	}
	
	public String login(){
		
		String retorno = SUCCESS;
		String login = request.getParameter(LOGIN);
		String senha = request.getParameter(SENHA);
		
		Administrador administrador = null;
		try {
			administrador = getFachada().obterAdministradorLoginSenha(login, senha);
			request.setAttribute(ADMINISTRADOR, administrador);
		} catch (EntidadeNaoExistenteException e) {
			retorno = ERROR;
		}
		
		return retorno;
	}
	
	public String logout(){
		return null;
	}


}
