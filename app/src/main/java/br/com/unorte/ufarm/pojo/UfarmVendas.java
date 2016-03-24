package br.com.unorte.ufarm.pojo;

public class UfarmVendas {
	
	private int id;
	private String data;
	private int idProp;
	private int idAquisicao;
	private int idProducao;
	private String categoria;
	private String prodServ;
	private String cliente;
	private String nota;
	private String formaRecebimento;
	private int qtdeParcela;
	private int parcela;
	private String valorParcela;
	private String valorCompra;
	private String valorVenda;
	private int pago;
	private String dataVencimento;
	private String dataRecebimento;
	private int expedicao;
	
	public UfarmVendas() {
		super();
	}

	public UfarmVendas(int id, String data, int idProp, int idAquisicao, int idProducao, String categoria,
			String prodServ, String cliente, String nota, String formaRecebimento, int qtdeParcela, int parcela,
			String valorParcela, String valorCompra, String valorVenda, int pago, String dataVencimento,
			String dataRecebimento, int expedicao) {
		super();
		this.id = id;
		this.data = data;
		this.idProp = idProp;
		this.idAquisicao = idAquisicao;
		this.idProducao = idProducao;
		this.categoria = categoria;
		this.prodServ = prodServ;
		this.cliente = cliente;
		this.nota = nota;
		this.formaRecebimento = formaRecebimento;
		this.qtdeParcela = qtdeParcela;
		this.parcela = parcela;
		this.valorParcela = valorParcela;
		this.valorCompra = valorCompra;
		this.valorVenda = valorVenda;
		this.pago = pago;
		this.dataVencimento = dataVencimento;
		this.dataRecebimento = dataRecebimento;
		this.expedicao = expedicao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
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

	public int getIdProducao() {
		return idProducao;
	}

	public void setIdProducao(int idProducao) {
		this.idProducao = idProducao;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getProdServ() {
		return prodServ;
	}

	public void setProdServ(String prodServ) {
		this.prodServ = prodServ;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public String getFormaRecebimento() {
		return formaRecebimento;
	}

	public void setFormaRecebimento(String formaRecebimento) {
		this.formaRecebimento = formaRecebimento;
	}

	public int getQtdeParcela() {
		return qtdeParcela;
	}

	public void setQtdeParcela(int qtdeParcela) {
		this.qtdeParcela = qtdeParcela;
	}

	public int getParcela() {
		return parcela;
	}

	public void setParcela(int parcela) {
		this.parcela = parcela;
	}

	public String getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(String valorParcela) {
		this.valorParcela = valorParcela;
	}

	public String getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(String valorCompra) {
		this.valorCompra = valorCompra;
	}

	public String getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(String valorVenda) {
		this.valorVenda = valorVenda;
	}

	public int getPago() {
		return pago;
	}

	public void setPago(int pago) {
		this.pago = pago;
	}

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(String dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}

	public int getExpedicao() {
		return expedicao;
	}

	public void setExpedicao(int expedicao) {
		this.expedicao = expedicao;
	}
	
	

	
	
}
