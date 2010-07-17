package br.com.negocios.servico.execption;

@SuppressWarnings("serial")
public class ParametroInvalidoException extends Exception {
	public ParametroInvalidoException(String msg) {
		super(msg);
	}	
}
