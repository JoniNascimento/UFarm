package br.com.unorte.ufarm.pojo;

import java.io.Serializable;
import java.util.Date;

public class UfarmAquisicoes  implements Serializable{
	
	private int id;
	private int idProp;
	private Date data;
	private String tipo;
	private String prodServico;
	private String categoria;
	private String subCategoria;
	private String fornecedor;
	private String contrato;
	private String cliente;
	private String sacas;
	private String massa;
	private String rpa;
	private int nf;
	private int serie;
	private int parcelaLote;
	private String cfop;
	private String imposto;
	private String frete;
	private String desconto;
	private int funcionario;
	private String funcao;
	private int qtde;
	private String area;
	private String valorUn;
	private String depreciacao;
	private String valorTotal;
	private int quitado;
	private int vendido;
	private int abatido;
	private String dataVenda;
	private String valorVenda;
	private int negociacaoPagto;
	private int negociacaoRecebimento;
	private String unMedida;
	private String benfeitoria;
	private String comprimento;
	private int idRecurso;
	private String modelo;
	private int ano;
	private String potencia;
	private String tipoPecuaria;
	private String raca;
	private String sexo;
	private String utilidade;
	private String marcaRebanho;
	private String localMarca;
	private String peso;
	private String altura;
	private String dataNascimento;
	private int lote;
	private String brinco;
	private String vacinacao;
	private String sanitade;
	private String nomeAnimal; 
	private String nomePai;
	private String racaPai;
	private String nomeMae;
	private String racaMae;
	
	public UfarmAquisicoes() {
		super();
	}

	public UfarmAquisicoes(int id, int idProp, Date data, String tipo, String prodServico, String categoria,
			String subCategoria, String fornecedor, String contrato, String cliente, String sacas, String massa,
			String rpa, int nf, int serie, int parcelaLote, String cfop, String imposto, String frete, String desconto,
			int funcionario, String funcao, int qtde, String area, String valorUn, String depreciacao,
			String valorTotal, int quitado, int vendido, String dataVenda, String valorVenda, int negociacaoPagto,
			int negociacaoRecebimento, String unMedida, String benfeitoria, String comprimento, int idRecurso,
			String modelo, int ano, String potencia, String tipoPecuaria, String raca, String sexo, String utilidade,
			String marcaRebanho, String localMarca, String peso, String altura, String dataNascimento, int lote,
			String brinco, String vacinacao, String sanitade, String nomePai, String racaPai, String nomeMae,
			String racaMae) {
		super();
		this.id = id;
		this.idProp = idProp;
		this.data = data;
		this.tipo = tipo;
		this.prodServico = prodServico;
		this.categoria = categoria;
		this.subCategoria = subCategoria;
		this.fornecedor = fornecedor;
		this.contrato = contrato;
		this.cliente = cliente;
		this.sacas = sacas;
		this.massa = massa;
		this.rpa = rpa;
		this.nf = nf;
		this.serie = serie;
		this.parcelaLote = parcelaLote;
		this.cfop = cfop;
		this.imposto = imposto;
		this.frete = frete;
		this.desconto = desconto;
		this.funcionario = funcionario;
		this.funcao = funcao;
		this.qtde = qtde;
		this.area = area;
		this.valorUn = valorUn;
		this.depreciacao = depreciacao;
		this.valorTotal = valorTotal;
		this.quitado = quitado;
		this.vendido = vendido;
		this.dataVenda = dataVenda;
		this.valorVenda = valorVenda;
		this.negociacaoPagto = negociacaoPagto;
		this.negociacaoRecebimento = negociacaoRecebimento;
		this.unMedida = unMedida;
		this.benfeitoria = benfeitoria;
		this.comprimento = comprimento;
		this.idRecurso = idRecurso;
		this.modelo = modelo;
		this.ano = ano;
		this.potencia = potencia;
		this.tipoPecuaria = tipoPecuaria;
		this.raca = raca;
		this.sexo = sexo;
		this.utilidade = utilidade;
		this.marcaRebanho = marcaRebanho;
		this.localMarca = localMarca;
		this.peso = peso;
		this.altura = altura;
		this.dataNascimento = dataNascimento;
		this.lote = lote;
		this.brinco = brinco;
		this.vacinacao = vacinacao;
		this.sanitade = sanitade;
		this.nomePai = nomePai;
		this.racaPai = racaPai;
		this.nomeMae = nomeMae;
		this.racaMae = racaMae;
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getProdServico() {
		return prodServico;
	}

	public void setProdServico(String prodServico) {
		this.prodServico = prodServico;
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

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getSacas() {
		return sacas;
	}

	public void setSacas(String sacas) {
		this.sacas = sacas;
	}

	public String getMassa() {
		return massa;
	}

	public void setMassa(String massa) {
		this.massa = massa;
	}

	public String getRpa() {
		return rpa;
	}

	public void setRpa(String rpa) {
		this.rpa = rpa;
	}

	public int getNf() {
		return nf;
	}

	public void setNf(int nf) {
		this.nf = nf;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

	public int getParcelaLote() {
		return parcelaLote;
	}

	public void setParcelaLote(int parcelaLote) {
		this.parcelaLote = parcelaLote;
	}

	public String getCfop() {
		return cfop;
	}

	public void setCfop(String cfop) {
		this.cfop = cfop;
	}

	public String getImposto() {
		return imposto;
	}

	public void setImposto(String imposto) {
		this.imposto = imposto;
	}

	public String getFrete() {
		return frete;
	}

	public void setFrete(String frete) {
		this.frete = frete;
	}

	public String getDesconto() {
		return desconto;
	}

	public void setDesconto(String desconto) {
		this.desconto = desconto;
	}

	public int getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(int funcionario) {
		this.funcionario = funcionario;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getValorUn() {
		return valorUn;
	}

	public void setValorUn(String valorUn) {
		this.valorUn = valorUn;
	}

	public String getDepreciacao() {
		return depreciacao;
	}

	public void setDepreciacao(String depreciacao) {
		this.depreciacao = depreciacao;
	}

	public String getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getQuitado() {
		return quitado;
	}

	public void setQuitado(int quitado) {
		this.quitado = quitado;
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

	public int getNegociacaoPagto() {
		return negociacaoPagto;
	}

	public void setNegociacaoPagto(int negociacaoPagto) {
		this.negociacaoPagto = negociacaoPagto;
	}

	public int getNegociacaoRecebimento() {
		return negociacaoRecebimento;
	}

	public void setNegociacaoRecebimento(int negociacaoRecebimento) {
		this.negociacaoRecebimento = negociacaoRecebimento;
	}

	public String getUnMedida() {
		return unMedida;
	}

	public void setUnMedida(String unMedida) {
		this.unMedida = unMedida;
	}

	public String getBenfeitoria() {
		return benfeitoria;
	}

	public void setBenfeitoria(String benfeitoria) {
		this.benfeitoria = benfeitoria;
	}

	public String getComprimento() {
		return comprimento;
	}

	public void setComprimento(String comprimento) {
		this.comprimento = comprimento;
	}

	public int getIdRecurso() {
		return idRecurso;
	}

	public void setIdRecurso(int idRecurso) {
		this.idRecurso = idRecurso;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	public String getTipoPecuaria() {
		return tipoPecuaria;
	}

	public void setTipoPecuaria(String tipoPecuaria) {
		this.tipoPecuaria = tipoPecuaria;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getUtilidade() {
		return utilidade;
	}

	public void setUtilidade(String utilidade) {
		this.utilidade = utilidade;
	}

	public String getMarcaRebanho() {
		return marcaRebanho;
	}

	public void setMarcaRebanho(String marcaRebanho) {
		this.marcaRebanho = marcaRebanho;
	}

	public String getLocalMarca() {
		return localMarca;
	}

	public void setLocalMarca(String localMarca) {
		this.localMarca = localMarca;
	}

	public String getPeso() {
		return peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public int getLote() {
		return lote;
	}

	public void setLote(int lote) {
		this.lote = lote;
	}

	public String getBrinco() {
		return brinco;
	}

	public void setBrinco(String brinco) {
		this.brinco = brinco;
	}

	public String getVacinacao() {
		return vacinacao;
	}

	public void setVacinacao(String vacinacao) {
		this.vacinacao = vacinacao;
	}

	public String getSanitade() {
		return sanitade;
	}

	public void setSanitade(String sanitade) {
		this.sanitade = sanitade;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getRacaPai() {
		return racaPai;
	}

	public void setRacaPai(String racaPai) {
		this.racaPai = racaPai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getRacaMae() {
		return racaMae;
	}

	public void setRacaMae(String racaMae) {
		this.racaMae = racaMae;
	}

	public int getAbatido() {
		return abatido;
	}

	public void setAbatido(int abatido) {
		this.abatido = abatido;
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public void setNomeAnimal(String nomeAnimal) {
		this.nomeAnimal = nomeAnimal;
	}
		

}
