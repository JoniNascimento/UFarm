package br.com.unorte.ufarm.pojo;

public class Assinaturas {
	
	private int id;
	private int idUser;
	private String data;
	private String tipoUsuario;
	private String produto;
	private String ciclo;
	private int qtdeLi;
	private String total;
	private int qtdeProp;
	private int formaPgto;
	private int pago;
	
	public Assinaturas() {
		super();
	}

	public Assinaturas(int id, int idUser, String data, String tipoUsuario,  String produto, String ciclo, int qtdeLi, String total,
			int qtdeProp, int formaPgto, int pago) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.data = data;
		this.tipoUsuario = tipoUsuario;
		this.produto = produto;
		this.ciclo = ciclo;
		this.qtdeLi = qtdeLi;
		this.total = total;
		this.qtdeProp = qtdeProp;
		this.formaPgto = formaPgto;
		this.pago = pago;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public int getQtdeLi() {
		return qtdeLi;
	}

	public void setQtdeLi(int qtdeLi) {
		this.qtdeLi = qtdeLi;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public int getQtdeProp() {
		return qtdeProp;
	}

	public void setQtdeProp(int qtdeProp) {
		this.qtdeProp = qtdeProp;
	}

	public int getFormaPgto() {
		return formaPgto;
	}

	public void setFormaPgto(int formaPgto) {
		this.formaPgto = formaPgto;
	}

	public int getPago() {
		return pago;
	}

	public void setPago(int pago) {
		this.pago = pago;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}
	
	
	

}
