package br.com.unorte.ufarm.pojo;

public class Estados {
	
	private int codEstados;
	private String sigla;
	private String nome;
	
	public Estados(){
		super();
	}

	public Estados(int codEstados, String sigla, String nome) {
		super();
		this.codEstados = codEstados;
		this.sigla = sigla;
		this.nome = nome;
	}

	public int getCodEstados() {
		return codEstados;
	}

	public void setCodEstados(int codEstados) {
		this.codEstados = codEstados;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
}
