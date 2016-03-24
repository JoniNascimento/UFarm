package br.com.unorte.ufarm.pojo;

public class UfarmProducaoAgricola {
	
	private int id;
	private int idProp;
	private String tipoCultura;
	private String Cultura;
	private String unMedida;
	private String areaPlantada;
	private String dataPlantacao;
	private String areaColhida;
	private String dataColheita;
	private String saldo;
	private String qtdeColhida;
	private String unMedidaColhida;
	private String valorUn;
	private String valorTotal;
	private int vendido;
	private String dataVenda;
	private String valorVenda;
	private int negociacaoRecebimento;
	
	public UfarmProducaoAgricola() {
		super();
	}

	public UfarmProducaoAgricola(int id, int idProp, String tipoCultura, String cultura, String unMedida,
			String areaPlantada, String dataPlantacao, String areaColhida, String dataColheita, String saldo,
			String qtdeColhida, String unMedidaColhida, String valorUn, String valorTotal, int vendido,
			String dataVenda, String valorVenda, int negociacaoRecebimento) {
		super();
		this.id = id;
		this.idProp = idProp;
		this.tipoCultura = tipoCultura;
		Cultura = cultura;
		this.unMedida = unMedida;
		this.areaPlantada = areaPlantada;
		this.dataPlantacao = dataPlantacao;
		this.areaColhida = areaColhida;
		this.dataColheita = dataColheita;
		this.saldo = saldo;
		this.qtdeColhida = qtdeColhida;
		this.unMedidaColhida = unMedidaColhida;
		this.valorUn = valorUn;
		this.valorTotal = valorTotal;
		this.vendido = vendido;
		this.dataVenda = dataVenda;
		this.valorVenda = valorVenda;
		this.negociacaoRecebimento = negociacaoRecebimento;
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

	public String getTipoCultura() {
		return tipoCultura;
	}

	public void setTipoCultura(String tipoCultura) {
		this.tipoCultura = tipoCultura;
	}

	public String getCultura() {
		return Cultura;
	}

	public void setCultura(String cultura) {
		Cultura = cultura;
	}

	public String getUnMedida() {
		return unMedida;
	}

	public void setUnMedida(String unMedida) {
		this.unMedida = unMedida;
	}

	public String getAreaPlantada() {
		return areaPlantada;
	}

	public void setAreaPlantada(String areaPlantada) {
		this.areaPlantada = areaPlantada;
	}

	public String getDataPlantacao() {
		return dataPlantacao;
	}

	public void setDataPlantacao(String dataPlantacao) {
		this.dataPlantacao = dataPlantacao;
	}

	public String getAreaColhida() {
		return areaColhida;
	}

	public void setAreaColhida(String areaColhida) {
		this.areaColhida = areaColhida;
	}

	public String getDataColheita() {
		return dataColheita;
	}

	public void setDataColheita(String dataColheita) {
		this.dataColheita = dataColheita;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public String getQtdeColhida() {
		return qtdeColhida;
	}

	public void setQtdeColhida(String qtdeColhida) {
		this.qtdeColhida = qtdeColhida;
	}

	public String getUnMedidaColhida() {
		return unMedidaColhida;
	}

	public void setUnMedidaColhida(String unMedidaColhida) {
		this.unMedidaColhida = unMedidaColhida;
	}

	public String getValorUn() {
		return valorUn;
	}

	public void setValorUn(String valorUn) {
		this.valorUn = valorUn;
	}

	public String getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getVendido() {
		return vendido;
	}

	public void setVendido(int vendido) {
		this.vendido = vendido;
	}

	public String getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(String valorVenda) {
		this.valorVenda = valorVenda;
	}

	public int getNegociacaoRecebimento() {
		return negociacaoRecebimento;
	}

	public void setNegociacaoRecebimento(int negociacaoRecebimento) {
		this.negociacaoRecebimento = negociacaoRecebimento;
	}
	
	
	

}
