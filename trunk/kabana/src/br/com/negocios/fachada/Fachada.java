package br.com.negocios.fachada;

import br.com.negocios.controlador.Controlador;
import br.com.negocios.entidade.Administrador;
import br.com.negocios.servico.execption.EntidadeNaoExistenteException;

public class Fachada {
	
	private Controlador controlador;
	
	private static Fachada fachada;
	
	private Fachada() {
		controlador = new Controlador();
	}
	
	public static Fachada getInstance(){
		if(fachada == null){
			fachada = new Fachada();
		}
		return fachada;
	}
	
	
	public Administrador obterAdministradorLoginSenha(String login, String senha) throws EntidadeNaoExistenteException{
		return controlador.obterAdmLoginSenha(login, senha);
	}
	
}
