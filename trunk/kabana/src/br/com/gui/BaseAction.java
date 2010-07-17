package br.com.gui;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import br.com.negocios.fachada.Fachada;

import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport implements ServletRequestAware {
	
	private static final long serialVersionUID = 1L;

	private Fachada fachada;
	
	protected HttpServletRequest request;
	
	public static final String INSERIR = "inserir";
	public static final String EDITAR = "editar";
	
	public static final String INDEX = "index";
	public static final String PLUGIN = "plugin";
	public static final String MSG = "msg";
	public static final String OPCAO = "opcao";
	
	public static final String LOGIN = "login";
	public static final String SENHA = "senha";
	
	public static final String SIM = "sim";
	public static final String NAO = "nao";
	
	private File[] arquivos;
	private String[] arquivosNome;
	private String[] arquivosTipo;
	
	public static final String urlBase = "http://localhost:8080/kabana";
	
	public BaseAction() {
		this.fachada = Fachada.getInstance();
	}
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletRequest getServletRequest() {
		return this.request;
	}
	public static String getUrlBase() {
		return urlBase;
	}
	public File[] getArquivos() {
		return arquivos;
	}
 
	public void setArquivos(File[] arquivos) {
		this.arquivos = arquivos;
	}

	public String[] getArquivosFileName() {
		return arquivosNome;
	}

	public void setArquivosFileName(String[] arquivosNome) {
		this.arquivosNome = arquivosNome;
	}

	public String[] getArquivosContentType() {
		return arquivosTipo;
	}

	public void setArquivosContentType(String[] arquivosTipo) {
		this.arquivosTipo = arquivosTipo;
	}

	public Fachada getFachada() {
		return fachada;
	}

	public void setFachada(Fachada fachada) {
		this.fachada = fachada;
	}
	
}
