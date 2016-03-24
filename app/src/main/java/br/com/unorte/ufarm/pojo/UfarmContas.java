package br.com.unorte.ufarm.pojo;

public class UfarmContas {
	
	private int id;
	private int idProp;
	private int idAquisicao;
	private int idDespesa;
	private String dataAquisicao;
	private String despesa;
	private String categoria;
	private String formaPagto;
	private int nf;
	private int qtdeParcelas;
	private int parcela;
	private String valor;
	private String dataVencimento;
	private int pago;
	private String dataPagto;
	
	public UfarmContas() {
		super();
	}

	public UfarmContas(int id, int idProp, int idAquisicao, int idDespesa, String dataAquisicao, String despesa,
			String categoria, String formaPagto, int nf, int qtdeParcelas, int parcela, String valor,
			String dataVencimento, int pago, String dataPagto) {
		super();
		this.id = id;
		this.idProp = idProp;
		this.idAquisicao = idAquisicao;
		this.idDespesa = idDespesa;
		this.dataAquisicao = dataAquisicao;
		this.despesa = despesa;
		this.categoria = categoria;
		this.formaPagto = formaPagto;
		this.nf = nf;
		this.qtdeParcelas = qtdeParcelas;
		this.parcela = parcela;
		this.valor = valor;
		this.dataVencimento = dataVencimento;
		this.pago = pago;
		this.dataPagto = dataPagto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdProp() {
		return idProp;
	}

	public void setIdProp(int idProp) {
		this.idProp = idProp;
	}

	public int getIdAquisicao() {
		return idAquisicao;
	}

	public void setIdAquisicao(int idAquisicao) {
		this.idAquisicao = idAquisicao;
	}

	public int getIdDespesa() {
		return idDespesa;
	}

	public void setIdDespesa(int idDespesa) {
		this.idDespesa = idDespesa;
	}

	public String getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(String dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public String getDespesa() {
		return despesa;
	}

	public void setDespesa(String despesa) {
		this.despesa = despesa;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getFormaPagto() {
		return formaPagto;
	}

	public void setFormaPagto(String formaPagto) {
		this.formaPagto = formaPagto;
	}

	public int getNf() {
		return nf;
	}

	public void setNf(int nf) {
		this.nf = nf;
	}

	public int getQtdeParcelas() {
		return qtdeParcelas;
	}

	public void setQtdeParcelas(int qtdeParcelas) {
		this.qtdeParcelas = qtdeParcelas;
	}

	public int getParcela() {
		return parcela;
	}

	public void setParcela(int parcela) {
		this.parcela = parcela;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public int getPago() {
		return pago;
	}

	public void setPago(int pago) {
		this.pago = pago;
	}

	public String getDataPagto() {
		return dataPagto;
	}

	public void setDataPagto(String dataPagto) {
		this.dataPagto = dataPagto;
	}
	
	
	
	
	
	

}
