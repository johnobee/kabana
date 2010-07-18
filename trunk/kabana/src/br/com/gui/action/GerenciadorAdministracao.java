package br.com.gui.action;

import br.com.gui.BaseAction;
import br.com.negocios.entidade.Administrador;
import br.com.negocios.servico.execption.EntidadeNaoExistenteException;
import br.com.negocios.util.Data;
import br.com.negocios.util.UserSession;

@SuppressWarnings("serial")
public class GerenciadorAdministracao extends BaseAction {
	
	public static final String ADMINISTRADOR = "administrador";
	private Administrador administrador;
	
	public GerenciadorAdministracao() {}
	
	public String login(){
		
		String retorno = SUCCESS;
		try {
			administrador = getFachada().obterAdministradorLoginSenha(administrador.getLogin(), administrador.getSenha());
			UserSession userSession = new UserSession(administrador.getNome(), administrador.getSobrenome(), new Data(System.currentTimeMillis()));
			request.getSession().setAttribute(SESSIONKEY, userSession);
		} catch (EntidadeNaoExistenteException e) {
			retorno = INPUT;
			addActionError("Login ou Senha Invalidos.");
		} catch (Exception e) {
			retorno = INPUT;
			addActionError("Você não tem permissão para efetuar essa operação.");
		}
		
		return retorno;
	}
	
	public String logout(){
		request.getSession().invalidate();
		return null;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

}
