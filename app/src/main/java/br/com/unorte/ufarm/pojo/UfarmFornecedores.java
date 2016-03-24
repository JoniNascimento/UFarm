package br.com.unorte.ufarm.pojo;

public class UfarmFornecedores {
	
	private int Id;
	private int IdPropriedade;
	private String Nome;
	private String RazaoSocial;
	private String Cnpj;
	private String Ramo;
	private String Tel;
	private String Cel;
	private String Endereco;
	private int NumeroEndereco;
	private String FornecedorDe;
	private String Obs;
	
	public UfarmFornecedores(){
		super();
	}
	public UfarmFornecedores( int Id,int IdPropriedade, String Nome, String RazaoSocial, String Cnpj,
							String Ramo, String Tel, String Cel, String Endereco,int NumeroEndereco,
							String FornecedorDe, String Obs){
		super();
		this.Id = Id;
		this.IdPropriedade = IdPropriedade;
		this.Nome = Nome;
		this.RazaoSocial = RazaoSocial;
		this.Ramo = Ramo;
		this.Cnpj = Cnpj;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getIdPropriedade() {
		return IdPropriedade;
	}
	public void setIdPropriedade(int idPropriedade) {
		IdPropriedade = idPropriedade;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getRazaoSocial() {
		return RazaoSocial;
	}
	public void setRazaoSocial(String razaoSocial) {
		RazaoSocial = razaoSocial;
	}
	public String getCnpj() {
		return Cnpj;
	}
	public void setCnpj(String cnpj) {
		Cnpj = cnpj;
	}
	public String getRamo() {
		return Ramo;
	}
	public void setRamo(String ramo) {
		Ramo = ramo;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getCel() {
		return Cel;
	}
	public void setCel(String cel) {
		Cel = cel;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public int getNumeroEndereco() {
		return NumeroEndereco;
	}
	public void setNumeroEndereco(int numeroEndereco) {
		NumeroEndereco = numeroEndereco;
	}
	public String getFornecedorDe() {
		return FornecedorDe;
	}
	public void setFornecedorDe(String fornecedorDe) {
		FornecedorDe = fornecedorDe;
	}
	public String getObs() {
		return Obs;
	}
	public void setObs(String obs) {
		Obs = obs;
	}
	
	
	@Override
	public String toString() {
		return  Nome ;
	}
}
