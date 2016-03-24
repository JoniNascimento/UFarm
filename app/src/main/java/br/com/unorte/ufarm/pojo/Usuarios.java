package br.com.unorte.ufarm.pojo;

public class Usuarios {
	private int id;
	private int pago;
	private String dataCadastro;
	private String nome;
	private String email;
	private String tel;
	private String doc;
	private String tipoUser;
	private String empresa;
	private String ramoAtividade;
	private String instituicao;
	private String curso;
	private int ra;
	private String usuario;
	private String senha;
	private String conhecimento;
	private String representante;
	private int maisInfo;
	private int emailInfo;
	private String interesse;
	private int op1;
	private int op2;
	private int op3;
	private int op4;
	private int op5;
	private int op6;
	private String contrato;
	private String total;
	private String formaPgto;
	
	public Usuarios() {
		super();
		
	}


	public Usuarios(int id, int pago, String dataCadastro, String nome, String email, String tel, String doc,
			String tipoUser, String empresa, String ramoAtividade, String instituicao, String curso, int ra,
			String usuario, String senha, String conhecimento, String representante, int maisInfo, int emailInfo,
			String interesse, int op1, int op2, int op3, int op4, int op5, int op6, String contrato, String total,
			String formaPgto) {
		super();
		this.id = id;
		this.pago = pago;
		this.dataCadastro = dataCadastro;
		this.nome = nome;
		this.email = email;
		this.tel = tel;
		this.doc = doc;
		this.tipoUser = tipoUser;
		this.empresa = empresa;
		this.ramoAtividade = ramoAtividade;
		this.instituicao = instituicao;
		this.curso = curso;
		this.ra = ra;
		this.usuario = usuario;
		this.senha = senha;
		this.conhecimento = conhecimento;
		this.representante = representante;
		this.maisInfo = maisInfo;
		this.emailInfo = emailInfo;
		this.interesse = interesse;
		this.op1 = op1;
		this.op2 = op2;
		this.op3 = op3;
		this.op4 = op4;
		this.op5 = op5;
		this.op6 = op6;
		this.contrato = contrato;
		this.total = total;
		this.formaPgto = formaPgto;
	}
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getPago() {
		return pago;
	}


	public void setPago(int pago) {
		this.pago = pago;
	}


	public String getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getDoc() {
		return doc;
	}


	public void setDoc(String doc) {
		this.doc = doc;
	}


	public String getTipoUser() {
		return tipoUser;
	}


	public void setTipoUser(String tipoUser) {
		this.tipoUser = tipoUser;
	}


	public String getEmpresa() {
		return empresa;
	}


	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}


	public String getRamoAtividade() {
		return ramoAtividade;
	}


	public void setRamoAtividade(String ramoAtividade) {
		this.ramoAtividade = ramoAtividade;
	}


	public String getInstituicao() {
		return instituicao;
	}


	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}


	public String getCurso() {
		return curso;
	}


	public void setCurso(String curso) {
		this.curso = curso;
	}


	public int getRa() {
		return ra;
	}


	public void setRa(int ra) {
		this.ra = ra;
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


	public String getConhecimento() {
		return conhecimento;
	}


	public void setConhecimento(String conhecimento) {
		this.conhecimento = conhecimento;
	}


	public String getRepresentante() {
		return representante;
	}


	public void setRepresentante(String representante) {
		this.representante = representante;
	}


	public int getMaisInfo() {
		return maisInfo;
	}


	public void setMaisInfo(int maisInfo) {
		this.maisInfo = maisInfo;
	}


	public int getEmailInfo() {
		return emailInfo;
	}


	public void setEmailInfo(int emailInfo) {
		this.emailInfo = emailInfo;
	}


	public String getInteresse() {
		return interesse;
	}


	public void setInteresse(String interesse) {
		this.interesse = interesse;
	}


	public int getOp1() {
		return op1;
	}


	public void setOp1(int op1) {
		this.op1 = op1;
	}


	public int getOp2() {
		return op2;
	}


	public void setOp2(int op2) {
		this.op2 = op2;
	}


	public int getOp3() {
		return op3;
	}


	public void setOp3(int op3) {
		this.op3 = op3;
	}


	public int getOp4() {
		return op4;
	}


	public void setOp4(int op4) {
		this.op4 = op4;
	}


	public int getOp5() {
		return op5;
	}


	public void setOp5(int op5) {
		this.op5 = op5;
	}


	public int getOp6() {
		return op6;
	}


	public void setOp6(int op6) {
		this.op6 = op6;
	}


	public String getContrato() {
		return contrato;
	}


	public void setContrato(String contrato) {
		this.contrato = contrato;
	}


	public String getTotal() {
		return total;
	}


	public void setTotal(String total) {
		this.total = total;
	}


	public String getFormaPgto() {
		return formaPgto;
	}


	public void setFormaPgto(String formaPgto) {
		this.formaPgto = formaPgto;
	}


	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", usuario=" + usuario + ", senha=" + senha + "]";
	}


	
	
	
	


	
}
