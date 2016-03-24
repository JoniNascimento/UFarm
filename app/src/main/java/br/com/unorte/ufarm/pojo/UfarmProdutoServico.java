package br.com.unorte.ufarm.pojo;

public class UfarmProdutoServico {
	
	private int id;
	private int aquisicao;
	private int pagamento;
	private int venda;
	private int recebimento;
	private int atividadeOp;
	private String produtoServico;
	private String categoria;
	private String subCategoria;
	private int brinco;
	private int forncedor;
	private int contrato;
	private int nf;
	private int imposto;
	private int frete;
	private int desconto;
	private int qtde;
	private int area;
	private int valorUn;
	private int depreciacao;
	private int valorTotal;
	private int rpaRecibo;
	private int salario;
	private int cliente;
	private int sacas;
	private int massa;
	private int realizado;
	private int horasTrabalhadas;
	private int statusServico;
	
	public UfarmProdutoServico() {
		super();
	}

	public UfarmProdutoServico(int id, int aquisicao, int pagamento, int venda, int recebimento, int atividadeOp,
			String produtoServico, String categoria, String subCategoria, int brinco, int forncedor, int contrato,
			int nf, int imposto, int frete, int desconto, int qtde, int area, int valorUn, int depreciacao,
			int valorTotal, int rpaRecibo, int salario, int cliente, int sacas, int massa, int realizado,
			int horasTrabalhadas, int statusServico) {
		super();
		this.id = id;
		this.aquisicao = aquisicao;
		this.pagamento = pagamento;
		this.venda = venda;
		this.recebimento = recebimento;
		this.atividadeOp = atividadeOp;
		this.produtoServico = produtoServico;
		this.categoria = categoria;
		this.subCategoria = subCategoria;
		this.brinco = brinco;
		this.forncedor = forncedor;
		this.contrato = contrato;
		this.nf = nf;
		this.imposto = imposto;
		this.frete = frete;
		this.desconto = desconto;
		this.qtde = qtde;
		this.area = area;
		this.valorUn = valorUn;
		this.depreciacao = depreciacao;
		this.valorTotal = valorTotal;
		this.rpaRecibo = rpaRecibo;
		this.salario = salario;
		this.cliente = cliente;
		this.sacas = sacas;
		this.massa = massa;
		this.realizado = realizado;
		this.horasTrabalhadas = horasTrabalhadas;
		this.statusServico = statusServico;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAquisicao() {
		return aquisicao;
	}

	public void setAquisicao(int aquisicao) {
		this.aquisicao = aquisicao;
	}

	public int getPagamento() {
		return pagamento;
	}

	public void setPagamento(int pagamento) {
		this.pagamento = pagamento;
	}

	public int getVenda() {
		return venda;
	}

	public void setVenda(int venda) {
		this.venda = venda;
	}

	public int getRecebimento() {
		return recebimento;
	}

	public void setRecebimento(int recebimento) {
		this.recebimento = recebimento;
	}

	public int getAtividadeOp() {
		return atividadeOp;
	}

	public void setAtividadeOp(int atividadeOp) {
		this.atividadeOp = atividadeOp;
	}

	public String getProdutoServico() {
		return produtoServico;
	}

	public void setProdutoServico(String produtoServico) {
		this.produtoServico = produtoServico;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getSubCategoria() {
		return subCategoria;
	}

	public void setSubCategoria(String subCategoria) {
		this.subCategoria = subCategoria;
	}

	public int getBrinco() {
		return brinco;
	}

	public void setBrinco(int brinco) {
		this.brinco = brinco;
	}

	public int getForncedor() {
		return forncedor;
	}

	public void setForncedor(int forncedor) {
		this.forncedor = forncedor;
	}

	public int getContrato() {
		return contrato;
	}

	public void setContrato(int contrato) {
		this.contrato = contrato;
	}

	public int getNf() {
		return nf;
	}

	public void setNf(int nf) {
		this.nf = nf;
	}

	public int getImposto() {
		return imposto;
	}

	public void setImposto(int imposto) {
		this.imposto = imposto;
	}

	public int getFrete() {
		return frete;
	}

	public void setFrete(int frete) {
		this.frete = frete;
	}

	public int getDesconto() {
		return desconto;
	}

	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getValorUn() {
		return valorUn;
	}

	public void setValorUn(int valorUn) {
		this.valorUn = valorUn;
	}

	public int getDepreciacao() {
		return depreciacao;
	}

	public void setDepreciacao(int depreciacao) {
		this.depreciacao = depreciacao;
	}

	public int getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getRpaRecibo() {
		return rpaRecibo;
	}

	public void setRpaRecibo(int rpaRecibo) {
		this.rpaRecibo = rpaRecibo;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public int getSacas() {
		return sacas;
	}

	public void setSacas(int sacas) {
		this.sacas = sacas;
	}

	public int getMassa() {
		return massa;
	}

	public void setMassa(int massa) {
		this.massa = massa;
	}

	public int getRealizado() {
		return realizado;
	}




	public void setRealizado(int realizado) {
		this.realizado = realizado;
	}

	public int getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(int horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public int getStatusServico() {
		return statusServico;
	}

	public void setStatusServico(int statusServico) {
		this.statusServico = statusServico;
	}

	@Override
	public String toString() {
		return produtoServico;
	}

	
	
}
