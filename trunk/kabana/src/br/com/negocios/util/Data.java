package br.com.negocios.util;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import br.com.negocios.servico.execption.ParametroInvalidoException;


public class Data implements Serializable {
	
	public static final long serialVersionUID = -2230569330166520753L;
	private String dia;
	private String mes;
	private String ano;
	private int hora;
	private int minuto;

	public Data() {
		Date data = new Date();
		this.inicializaData(data.getTime());

	}

	/**
	 * Construtor da classe passando inteiros como parametros.
	 * @param dia.
	 * @param mes.
	 * @param ano.
	 * @modelguid {A5082346-273E-44FD-8C4F-35476B15F49D}
	 */
	public Data(int dia, int mes, int ano) {
		this(String.valueOf(dia), String.valueOf(mes), String.valueOf(ano));
	}

	/**
	 * Construtor da classe para longs de Data no formato ex: "990562321450000"
	 * @param long dataLong
	 * @modelguid {C18AA2D1-D672-45FE-B5FD-6D51B29C7F3C}
	 */
	public Data(long dataLong) {
		this.inicializaData(dataLong);
	}


	/**
	 * Construtor da classe para Strings de Data no formato dd/mm/aaaa
	 * @param String dataString
	 * @modelguid {ED909098-F0EA-4AAB-AFA2-28F07E02A6E7}
	 */
	public Data(String dataString) {
		//Pode receber: 01/01/2004 ou 1/01/2004 ou 1/1/2004 ou 01/1/2004
		if (dataString.charAt(1) == '/') {
			// Adiciona um zero no caso da data vir como ex.: 4/12/2000
			dataString = "0" + dataString;
		}
		if (dataString.charAt(4) == '/') {
			// Adiciona um zero no caso da data vir como ex.: 4/12/2000
			dataString = dataString.substring(0, 3) + "0" + dataString.substring(3, dataString.length()); 
		}
		if (dataString.length() > 10) {
			dataString = dataString.substring(0, 10);
			if (!Character.isDigit(dataString.charAt(8))) {
				dataString = dataString.substring(0, 8);
			}
		}
		if (dataString.length() == 10) { //formato dd/mm/aaaa
			this.inicializaData( 
				dataString.substring(0, 2),
				dataString.substring(3, 5),
				dataString.substring(6, 10));
		} else if (dataString.length() == 8) { //formato dd/mm/aa
			this.inicializaData(
				dataString.substring(0, 2),
				dataString.substring(3, 5),
				dataString.substring(6, 8));
				int intano = Integer.parseInt(this.getAno());
				//MARRETA PARA ACEITAR ANOS COM 2 DIGITOS
				if (intano > 30) {
					this.ano = "19"+this.ano;
				} else {
					this.ano = "20"+this.ano;				
				}
		} else {
			Date data = new Date();
			this.inicializaData(data.getTime());
		}

	}
	/**
	 * Construtor da classe que recebe o dia, o mês e o ano separados, no formato String.
	 * @param dia.
	 * @param mes.
	 * @param ano.
	 * @modelguid {B2FD8C41-9157-49BC-95FA-4DFF63BC4414}
	 */
	public Data(String dia, String mes, String ano) {
		this.inicializaData(dia, mes, ano);
	}
	/**
	 * Construtor da classe passando um Date como parâmetro.
	 * @param Date data
	 * @modelguid {4C96FE2A-943E-4F39-B849-3E83D5FF9EBE}
	 */
	public Data(Date data) {
		if (data != null) {
			this.inicializaData(data.getTime());
		}
	}

	/**
	 * Construtor da classe para longs de Data no formato ex: "990562321450000"
	 * @param long dataLong
	 * @modelguid {E55F99C4-5191-426D-9B23-6414CF8991E6}
	 */
	public void inicializaData(long dataLong) {

		GregorianCalendar gc = new GregorianCalendar();
		gc.setTime(new Date(dataLong));
		this.setDia(String.valueOf(gc.get(GregorianCalendar.DAY_OF_MONTH)));
		this.setMes(String.valueOf(gc.get(GregorianCalendar.MONTH) + 1));
		this.setAno(String.valueOf(gc.get(GregorianCalendar.YEAR)));
	}

	/**
	 * Metodo que inicializa a data para os construtores
	 * @param String dia
	 * @param String mes
	 * @param String ano
	 * @modelguid {C4D1188A-93C4-4493-8E4E-2FFADF8F0D42}
	 */
	private void inicializaData(String dia, String mes, String ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}

	/**
	 * Metodo que retorna o ano da data.
	 * @return ano.
	 * @modelguid {B9DA5B2C-67A6-40E4-B7A8-B253077868E3}
	 */
	public String getAno() {
		return this.ano;
	}
	/**
	 * Metodo que retorna o dia da data.
	 * @return Dia.
	 * @modelguid {C01E2D9F-0220-44E6-9DEC-769428166EE5}
	 */
	public String getDia() {
		return this.dia;
	}
	/**
	 * Metodo que retorna o mes da data.
	 * @return mes.
	 * @modelguid {DF41A71D-440E-4047-A1D8-9E174859FC33}
	 */
	public String getMes() {
		return this.mes;
	}
	/**
	 * Metodo que recebe duas Datas e retorna o Número de dias entre elas
	 * @param Data data, Data outraData
	 * @modelguid {D4C65C5B-4E4E-4EFE-8DD9-DBED96E04E61}
	 */
	public static int intervalo(Data dataMenor, Data dataMaior) {
		// Intervalo total entre as datas
		int intervalo = 0;

		try {

			// Transforma as datas recebidas em Dates
			GregorianCalendar menorDate =
				new GregorianCalendar(
					Integer.parseInt(dataMenor.getAno()),
					Integer.parseInt(dataMenor.getMes()),
					Integer.parseInt(dataMenor.getDia()));
			GregorianCalendar maiorDate =
				new GregorianCalendar(
					Integer.parseInt(dataMaior.getAno()),
					Integer.parseInt(dataMaior.getMes()),
					Integer.parseInt(dataMaior.getDia()));

			// Valor de 1(UM) dia em Milisegundos
			long diaMilisegundos = 86400000;

			// Passando as Dates para Milisegundos
			long menorMilisegundos = menorDate.getTime().getTime();
			long maiorMilisegundos = maiorDate.getTime().getTime();

			// Checa se a primeira data é menor do que a segunda
			if (menorMilisegundos > maiorMilisegundos) {
				throw new ParametroInvalidoException("Valor invalido para data.");
			}

			// Calcula a quantidade de dias
			long longNumDias = maiorMilisegundos - menorMilisegundos;
			long intervaloMilisegundos = longNumDias / diaMilisegundos;
			String intervaloString = String.valueOf(intervaloMilisegundos);
			intervalo = Integer.parseInt(intervaloString);

		} catch (ParametroInvalidoException pie) {
			System.out.println(pie.getMessage() + "\n");
			pie.printStackTrace();

		}
		return intervalo;
	}
	/**
	 * Metodo que verifica se uma data passada é maior que a data corrente.
	 * @return boolean
	 * @modelguid {DEA278AA-41B9-4E17-AD58-75B074502D33}
	 */
	public boolean maior(Data data) {
		if (!(this.retornaMilisegundos() > data.retornaMilisegundos())) {
			return false;
		}
		return true;
	}


	/**
	 * Metodo que transorma uma Data em Milisegundos
	 * @param Data data
	 * @modelguid {A35794FE-5827-4C90-B16C-3B0BB6786CEF}
	 */
	public long retornaMilisegundos() {

		GregorianCalendar dataGerada =
			new GregorianCalendar(
				Integer.parseInt(this.getAno()),
				Integer.parseInt(this.getMes()) - 1,
				Integer.parseInt(this.getDia()));
		long dataMilisagundos = dataGerada.getTime().getTime();
		return dataMilisagundos;
	}
	/** @modelguid {CE2AABE2-784E-496F-A32F-5C0112A457F0} */
	public void setHora(int hora) {
		this.hora = hora;
	}
	/** @modelguid {C0D1397E-46E5-4EFE-A161-7360CA466518} */
	public void setMinuto(int minuto) {
		this.minuto = minuto;
	}
	/**
	 * Metodo que seta o ano da data.
	 * @param mes O mes da data.
	 * @modelguid {9B9701DC-DDF4-4632-87AE-FDE11027D7E7}
	 */
	public void setAno(String ano) {
		this.ano = ano;
	}
	/**
	 * Metodo que seta o dia da data.
	 * @param dia O dia da data
	 * @modelguid {001DF90B-723C-4912-A751-7F4D192DFDC1}
	 */
	public void setDia(String dia) {
		this.dia = dia;
	}
	/**
	 * Metodo que seta o mes da data.
	 * @param mes O mes da data.
	 * @modelguid {EF5DC000-77E7-43AE-8085-EA68DEDF1BD4}
	 */
	public void setMes(String mes) {
		this.mes = mes;
	}
	/**
	 * Metodo que soma um certo número de dias à Data dada
	 * @param String data, int numDias
	 * @modelguid {3785B009-B93E-49BB-AFDC-47CED052C167}
	 */
	public String somaDias(Data data, int numDias) {
		GregorianCalendar dataAtual =
			new GregorianCalendar(
				Integer.parseInt(data.getAno()),
				Integer.parseInt(data.getMes())-1,
				Integer.parseInt(data.getDia()));
		long diaMilisseconds = 86400000;
		long diaAtualMilisseconds = dataAtual.getTime().getTime();
		long longNumDias = numDias;
		long dataFuturaMiliseconds =
			diaAtualMilisseconds + (longNumDias * diaMilisseconds);
		Date dataFuturaAux = new Date(dataFuturaMiliseconds);
		Data dataFutura = new Data(dataFuturaAux);
		return dataFutura.toString();
	}
	/**
	 * Metodo que subtrai um certo número de dias à Data dada
	 * @param String data, int numDias
	 * @modelguid {2580CA0E-421E-4369-8D62-B7D6D96B33F9}
	 */
	public String subtraiDias(Data data, int numDias) {
		GregorianCalendar dataAtual =
			new GregorianCalendar(
				Integer.parseInt(data.getAno()),
				Integer.parseInt(data.getMes())-1,
				Integer.parseInt(data.getDia()));
		long diaMilisseconds = 86400000;
		long diaAtualMilisseconds = dataAtual.getTime().getTime();
		long longNumDias = numDias;
		long dataPassadaMiliseconds =
			diaAtualMilisseconds - (longNumDias * diaMilisseconds);
		Date dataPassadaAux = new Date(dataPassadaMiliseconds);
		Data dataPassada = new Data(dataPassadaAux);
		return dataPassada.toString();
	}
	/**
	 * Metodo que retorna a data como uma string.
	 * @return Data em formato de texto.
	 * @modelguid {4E248FB6-828A-49CC-BA99-848B9780BED5}
	 */
	public String toString() {
		String pagDia = this.getDia();
		String pagMes = this.getMes();
		String pagAno = this.getAno();
		String pagData = "";

		// Verifica se o mês é menor que 10, se for, ele adiciona o "0". Por exemplo, mês "09".
		if (pagDia.length() == 1)
			pagDia = "0" + pagDia;
		if (pagMes.length() == 1)
			pagMes = "0" + pagMes;

		pagData = pagDia + "/" + pagMes + "/" + pagAno;
		return pagData;
	}
	/**
	 * Returns the hora.
	 * @return int
	 * @modelguid {1BBFD814-E714-4077-9FEA-E63610A56E82}
	 */
	public int getHora() {
		return hora;
	}

	/**
	 * Returns the minuto.
	 * @return int
	 * @modelguid {E93B9D63-EF46-485C-9F06-037AFEB61C79}
	 */
	public int getMinuto() {
		return minuto;
	}
	/*
	 * Retorna o Objeto Date com esta Data.
	 * 
	 * @return Date data convertida para Date
	 * @modelguid {58A0A6F1-AB3B-4170-A5D6-C672D448B22D}
	 */

	public Date retornaObjetoDate() {
		return new Date(this.retornaMilisegundos());
	}
	

	/** @modelguid {0FEA6B14-9B29-4C2A-B8E1-9EB50F1F3548} */
	public static String retornarDataAtualFormatada() {
		Data data = new Data();
		String mes = "";
		switch (Integer.parseInt(data.getMes())) {
			case 1 :
				mes = "Janeiro";
				break;
			case 2 :
				mes = "Fevereiro";
				break;
			case 3 :
				mes = "Março";
				break;
			case 4 :
				mes = "Abril";
				break;
			case 5 :
				mes = "Maio";
				break;
			case 6 :
				mes = "Junho";
				break;
			case 7 :
				mes = "Julho";
				break;
			case 8 :
				mes = "Agosto";
				break;
			case 9 :
				mes = "Setembro";
				break;
			case 10 :
				mes = "Outubro";
				break;
			case 11 :
				mes = "Novembro";
				break;
			case 12 :
				mes = "Dezembro";
				break;
		}
		return data.getDia() + " de " + mes + " de " + data.getAno();
	}
	
	public static String retornarDataAtualFormatadaComSemana() {
		Data data = new Data();
		String mes = "";
		String diaDaSemana = "";
		GregorianCalendar gc = new GregorianCalendar(); 
		
		switch (gc.get(Calendar.DAY_OF_WEEK)) {  
			case Calendar.SUNDAY:  
				diaDaSemana = "Domingo";  
				break;  
			case Calendar.MONDAY:  
				diaDaSemana = "Segunda-feira";  
				break; 
			case Calendar.TUESDAY:  
				diaDaSemana = "Terça-feira";  
				break;  
			case Calendar.WEDNESDAY:  
				diaDaSemana = "Quarta-feira";  
				break;  
			case Calendar.THURSDAY:  
				diaDaSemana = "Quinta-feira";  
				break;  
			case Calendar.FRIDAY:  
				diaDaSemana = "Sexta-feira";  
				break;  
			case Calendar.SATURDAY:  
				diaDaSemana = "Sábado";  
				break;  		           
		}  
		
		switch (Integer.parseInt(data.getMes())) {
			case 1 :
				mes = "Janeiro";
				break;
			case 2 :
				mes = "Fevereiro";
				break;
			case 3 :
				mes = "Março";
				break;
			case 4 :
				mes = "Abril";
				break;
			case 5 :
				mes = "Maio";
				break;
			case 6 :
				mes = "Junho";
				break;
			case 7 :
				mes = "Julho";
				break;
			case 8 :
				mes = "Agosto";
				break;
			case 9 :
				mes = "Setembro";
				break;
			case 10 :
				mes = "Outubro";
				break;
			case 11 :
				mes = "Novembro";
				break;
			case 12 :
				mes = "Dezembro";
				break;
		}
		return diaDaSemana + ", " + data.getDia() + " de " + mes + " de " + data.getAno();
	}

	/** @modelguid {10F43E6A-A999-4A37-B177-EEB25F1C8DC6} */
	public boolean equals(Object object) {
		boolean resp = false;

		if (object != null && object instanceof Data) {
			Data data = (Data) object;
			resp = true;
			resp = (this.dia.equals(data.dia)) && (this.mes.equals(data.mes)) && this.ano.equals(data.ano)
				&& (this.hora == data.hora) && (this.minuto == data.minuto);
		}
		return resp;
	}
	
	/** @modelguid {10F43E6A-A999-4A37-B177-EEB25F1C8DC6} */
	public String retornarMesAnoFormatado(){
		switch (Integer.parseInt(mes)) {
		case 1 :
			mes = "Janeiro";
			break;
		case 2 :
			mes = "Fevereiro";
			break;
		case 3 :
			mes = "Março";
			break;
		case 4 :
			mes = "Abril";
			break;
		case 5 :
			mes = "Maio";
			break;
		case 6 :
			mes = "Junho";
			break;
		case 7 :
			mes = "Julho";
			break;
		case 8 :
			mes = "Agosto";
			break;
		case 9 :
			mes = "Setembro";
			break;
		case 10 :
			mes = "Outubro";
			break;
		case 11 :
			mes = "Novembro";
			break;
		case 12 :
			mes = "Dezembro";
			break;
	}
		return mes + "/" + ano;
	}
	
	/** @modelguid {10F43E6A-A999-4A37-B177-EEB25F1C8DC6} */
	public String retornarMesFormatado(){
		switch (Integer.parseInt(mes)) {
		case 1 :
			mes = "Janeiro";
			break;
		case 2 :
			mes = "Fevereiro";
			break;
		case 3 :
			mes = "Março";
			break;
		case 4 :
			mes = "Abril";
			break;
		case 5 :
			mes = "Maio";
			break;
		case 6 :
			mes = "Junho";
			break;
		case 7 :
			mes = "Julho";
			break;
		case 8 :
			mes = "Agosto";
			break;
		case 9 :
			mes = "Setembro";
			break;
		case 10 :
			mes = "Outubro";
			break;
		case 11 :
			mes = "Novembro";
			break;
		case 12 :
			mes = "Dezembro";
			break;
	}
		return mes;
	}


	/** @modelguid {0FEEBE8C-86AA-4475-B3A7-E44AEC2EB95D} */
	public boolean mesmoDia(Object object) {
		boolean resp = false;
		if (object != null && object instanceof Data) {
			Data data = (Data) object;
			int pdia = Integer.parseInt(data.getDia());
			int pmes = Integer.parseInt(data.getMes());
			int pano = Integer.parseInt(data.getAno());
			int tdia = Integer.parseInt(this.getDia());
			int tmes = Integer.parseInt(this.getMes());
			int tano = Integer.parseInt(this.getAno());
			resp = (pdia == tdia) && (pmes == tmes) && (pano == tano);
		}
		return resp;
	}


	/** @modelguid {BBF298C3-6AF2-4948-AD0F-7DCE9FD9C6DC} */
	public static String retornarTimestampAtual() {
		return String.valueOf(new Date().getTime());
	}

	public String retornarDataHora() {
		return new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss", new Locale("pt", "BR")).format(new Date());
	}
	
	public String retornarDataHora(String formato) {
		return new SimpleDateFormat(formato, new Locale("pt", "BR")).format(new Date());
	}
	
	public String retornarDataHora(Date data, String formato) {
		return new SimpleDateFormat(formato, new Locale("pt", "BR")).format(data);
	}
	
	public String retornarData() {
		return new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR")).format(new Date());
	}
	
	public String retornarData(Long data) {
		return new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR")).format(data);
	}
	
	/** @modelguid {C4AD102D-2E98-4033-8257-E105182C9F32} */
	public static void main(String[] args) {

		/*Data dataAtual = new Data("29/12/2005");
		String  txtData = dataAtual.somaDias(dataAtual, 90);

System.out.println("RestricaoTabelaPreco :: asSQLClause > txtData: "+new Data().getDataHora());

		Data dataLimite = new Data(txtData);
System.out.println("RestricaoTabelaPreco :: asSQLClause > dataLimite: "+dataLimite);
		
		long dataTime = dataLimite.retornaMilisegundos(); */
		 System.out.println(Data.retornarDataAtualFormatadaComSemana());

		
	}



}
