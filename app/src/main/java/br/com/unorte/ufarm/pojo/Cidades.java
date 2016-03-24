package br.com.unorte.ufarm.pojo;

public class Cidades {
	
	private int codEstados;
	private int codCidades;
	private String nomeCidade;
	private String cep;
	
	public Cidades(){
		super();
	}

	public Cidades(int codEstados, int codCidades, String nomeCidade, String cep) {
		super();
		this.codEstados = codEstados;
		this.codCidades = codCidades;
		this.nomeCidade = nomeCidade;
		this.cep = cep;
	}

	public int getCodEstados() {
		return codEstados;
	}

	public void setCodEstados(int codEstados) {
		this.codEstados = codEstados;
	}

	public int getCodCidades() {
		return codCidades;
	}

	public void setCodCidades(int codCidades) {
		this.codCidades = codCidades;
	}

	public String getNomeCidade() {
		return nomeCidade;
	}

	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	

}
