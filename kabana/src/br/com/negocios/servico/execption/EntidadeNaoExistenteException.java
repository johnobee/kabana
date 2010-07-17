package br.com.negocios.servico.execption;

@SuppressWarnings("serial")
public class EntidadeNaoExistenteException extends Exception {

	public EntidadeNaoExistenteException(String msg) {
		super(msg);
	}
	
}
