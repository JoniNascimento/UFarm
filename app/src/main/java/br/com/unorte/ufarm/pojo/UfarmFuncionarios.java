package br.com.unorte.ufarm.pojo;

public class UfarmFuncionarios {
	
	private int id;
	private int idProp;
    private String nome;
    private String tel;
    private String cel;
    private String email;
    private String endereco;
    private int numeroEndereco;
    private String cargo;
    private String qualificacoes;
    private String ctps;
    private String pis;
    private String tituloEleitor;
    private String dataNascimento;
    private String dataAdmissao;
    private String salario;
    private int comissao;
    private int produtividade;
    private int fgts;
    private int inss;
    private int salarioEducacao;
    private int risco1;
    private int risco2;
    private int risco3;
    private int contrTerceiros;
    private String vt;
    private String vr;
    private String va;
    private String totalComplementos;
    private String totalEncargos;
    private String totalBeneficios;
    private String folha;
    
	public UfarmFuncionarios() {
		super();
	}

	public UfarmFuncionarios(int id, int idProp, String nome, String tel, String cel, String email, String endereco,
			int numeroEndereco, String cargo, String qualificacoes, String ctps, String pis, String tituloEleitor,
			String dataNascimento, String dataAdmissao, String salario, int comissao, int produtividade, int fgts,
			int inss, int salarioEducacao, int risco1, int risco2, int risco3, int contrTerceiros, String vt, String vr,
			String va, String totalComplementos, String totalEncargos, String totalBeneficios, String folha) {
		super();
		this.id = id;
		this.idProp = idProp;
		this.nome = nome;
		this.tel = tel;
		this.cel = cel;
		this.email = email;
		this.endereco = endereco;
		this.numeroEndereco = numeroEndereco;
		this.cargo = cargo;
		this.qualificacoes = qualificacoes;
		this.ctps = ctps;
		this.pis = pis;
		this.tituloEleitor = tituloEleitor;
		this.dataNascimento = dataNascimento;
		this.dataAdmissao = dataAdmissao;
		this.salario = salario;
		this.comissao = comissao;
		this.produtividade = produtividade;
		this.fgts = fgts;
		this.inss = inss;
		this.salarioEducacao = salarioEducacao;
		this.risco1 = risco1;
		this.risco2 = risco2;
		this.risco3 = risco3;
		this.contrTerceiros = contrTerceiros;
		this.vt = vt;
		this.vr = vr;
		this.va = va;
		this.totalComplementos = totalComplementos;
		this.totalEncargos = totalEncargos;
		this.totalBeneficios = totalBeneficios;
		this.folha = folha;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCel() {
		return cel;
	}

	public void setCel(String cel) {
		this.cel = cel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumeroEndereco() {
		return numeroEndereco;
	}

	public void setNumeroEndereco(int numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getQualificacoes() {
		return qualificacoes;
	}

	public void setQualificacoes(String qualificacoes) {
		this.qualificacoes = qualificacoes;
	}

	public String getCtps() {
		return ctps;
	}

	public void setCtps(String ctps) {
		this.ctps = ctps;
	}

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public String getTituloEleitor() {
		return tituloEleitor;
	}

	public void setTituloEleitor(String tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(String dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public int getComissao() {
		return comissao;
	}

	public void setComissao(int comissao) {
		this.comissao = comissao;
	}

	public int getProdutividade() {
		return produtividade;
	}

	public void setProdutividade(int produtividade) {
		this.produtividade = produtividade;
	}

	public int getFgts() {
		return fgts;
	}

	public void setFgts(int fgts) {
		this.fgts = fgts;
	}

	public int getInss() {
		return inss;
	}

	public void setInss(int inss) {
		this.inss = inss;
	}

	public int getSalarioEducacao() {
		return salarioEducacao;
	}

	public void setSalarioEducacao(int salarioEducacao) {
		this.salarioEducacao = salarioEducacao;
	}

	public int getRisco1() {
		return risco1;
	}

	public void setRisco1(int risco1) {
		this.risco1 = risco1;
	}

	public int getRisco2() {
		return risco2;
	}

	public void setRisco2(int risco2) {
		this.risco2 = risco2;
	}

	public int getRisco3() {
		return risco3;
	}

	public void setRisco3(int risco3) {
		this.risco3 = risco3;
	}

	public int getContrTerceiros() {
		return contrTerceiros;
	}

	public void setContrTerceiros(int contrTerceiros) {
		this.contrTerceiros = contrTerceiros;
	}

	public String getVt() {
		return vt;
	}

	public void setVt(String vt) {
		this.vt = vt;
	}

	public String getVr() {
		return vr;
	}

	public void setVr(String vr) {
		this.vr = vr;
	}

	public String getVa() {
		return va;
	}

	public void setVa(String va) {
		this.va = va;
	}

	public String getTotalComplementos() {
		return totalComplementos;
	}

	public void setTotalComplementos(String totalComplementos) {
		this.totalComplementos = totalComplementos;
	}

	public String getTotalEncargos() {
		return totalEncargos;
	}

	public void setTotalEncargos(String totalEncargos) {
		this.totalEncargos = totalEncargos;
	}

	public String getTotalBeneficios() {
		return totalBeneficios;
	}

	public void setTotalBeneficios(String totalBeneficios) {
		this.totalBeneficios = totalBeneficios;
	}

	public String getFolha() {
		return folha;
	}

	public void setFolha(String folha) {
		this.folha = folha;
	}

	@Override
	public String toString() {
		return "UfarmFuncionarios [id=" + id + ", idProp=" + idProp + ", nome=" + nome + ", tel=" + tel + ", cel=" + cel
				+ ", email=" + email + ", endereco=" + endereco + ", numeroEndereco=" + numeroEndereco + ", cargo="
				+ cargo + ", qualificacoes=" + qualificacoes + ", ctps=" + ctps + ", pis=" + pis + ", tituloEleitor="
				+ tituloEleitor + ", dataNascimento=" + dataNascimento + ", dataAdmissao=" + dataAdmissao + ", salario="
				+ salario + ", comissao=" + comissao + ", produtividade=" + produtividade + ", fgts=" + fgts + ", inss="
				+ inss + ", salarioEducacao=" + salarioEducacao + ", risco1=" + risco1 + ", risco2=" + risco2
				+ ", risco3=" + risco3 + ", contrTerceiros=" + contrTerceiros + ", vt=" + vt + ", vr=" + vr + ", va="
				+ va + ", totalComplementos=" + totalComplementos + ", totalEncargos=" + totalEncargos
				+ ", totalBeneficios=" + totalBeneficios + ", folha=" + folha + "]";
	}
	
	
    
    
    
}
