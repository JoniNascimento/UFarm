package br.com.unorte.ufarm.pojo;

public class Propriedades {
	
	private int id;
	private int idAss;
	private int idUser;
	private String prop;
	private String denominacao;
	private String usuario;
	private String senha;
	private int cadastro;
	private int relatorios;
	private int producao;
	private int contabil;
	private int painelProdutivo;
	private int mapa;
	private int grafico;
	private int planejamento;
	private int chat;
	
	public Propriedades() {
		super();
	}

	public Propriedades(int id, int idAss, int idUser, String prop, String denominacao, String usuario, String senha,
			int cadastro, int relatorios, int producao, int contabil, int painelProdutivo, int mapa, int grafico,
			int planejamento, int chat) {
		super();
		this.id = id;
		this.idAss = idAss;
		this.idUser = idUser;
		this.prop = prop;
		this.denominacao = denominacao;
		this.usuario = usuario;
		this.senha = senha;
		this.cadastro = cadastro;
		this.relatorios = relatorios;
		this.producao = producao;
		this.contabil = contabil;
		this.painelProdutivo = painelProdutivo;
		this.mapa = mapa;
		this.grafico = grafico;
		this.planejamento = planejamento;
		this.chat = chat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAss() {
		return idAss;
	}

	public void setIdAss(int idAss) {
		this.idAss = idAss;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getProp() {
		return prop;
	}

	public void setProp(String prop) {
		this.prop = prop;
	}

	public String getDenominacao() {
		return denominacao;
	}

	public void setDenominacao(String denominacao) {
		this.denominacao = denominacao;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getCadastro() {
		return cadastro;
	}

	public void setCadastro(int cadastro) {
		this.cadastro = cadastro;
	}

	public int getRelatorios() {
		return relatorios;
	}

	public void setRelatorios(int relatorios) {
		this.relatorios = relatorios;
	}

	public int getProducao() {
		return producao;
	}

	public void setProducao(int producao) {
		this.producao = producao;
	}

	public int getContabil() {
		return contabil;
	}

	public void setContabil(int contabil) {
		this.contabil = contabil;
	}

	public int getPainelProdutivo() {
		return painelProdutivo;
	}

	public void setPainelProdutivo(int painelProdutivo) {
		this.painelProdutivo = painelProdutivo;
	}

	public int getMapa() {
		return mapa;
	}

	public void setMapa(int mapa) {
		this.mapa = mapa;
	}

	public int getGrafico() {
		return grafico;
	}

	public void setGrafico(int grafico) {
		this.grafico = grafico;
	}

	public int getPlanejamento() {
		return planejamento;
	}

	public void setPlanejamento(int planejamento) {
		this.planejamento = planejamento;
	}

	public int getChat() {
		return chat;
	}

	public void setChat(int chat) {
		this.chat = chat;
	}

	@Override
	public String toString() {
		return prop;
	}

	
	
	
	
	

}
