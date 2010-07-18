package br.com.negocios.util;

public class UserSession {
	
	private String nome;
	private String sobrenome;
	private Data dataAcesso;
	
	public UserSession(String nome, String sobrenome, Data dataAcesso) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataAcesso = dataAcesso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Data getDataAcesso() {
		return dataAcesso;
	}

	public void setDataAcesso(Data dataAcesso) {
		this.dataAcesso = dataAcesso;
	}	
}
