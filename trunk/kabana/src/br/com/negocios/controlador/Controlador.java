package br.com.negocios.controlador;

import org.hibernate.Session;

import br.com.negocios.entidade.Administrador;
import br.com.negocios.servico.ControladorGeneric;
import br.com.negocios.servico.execption.EntidadeNaoExistenteException;
import br.com.persistencia.entidadeDAO.AdministradorDAO;

public class Controlador extends ControladorGeneric {

	private AdministradorDAO administradorDAO;
	
	public Controlador() {
		administradorDAO = new AdministradorDAO();
	}
	
	public Administrador obterAdmLoginSenha(String login, String senha) throws EntidadeNaoExistenteException{
		
		Session session = iniciarTransacao();
		administradorDAO.setSession(session);
		Administrador admObtido = administradorDAO.obterAdmLoginSenha(login, senha);
		if(admObtido == null){
			throw new EntidadeNaoExistenteException("O administrador não existe.");
		}
		fecharTransacao();
		
		return admObtido;
	}
	
}
