package br.com.unorte.ufarm.pojo;

public class Pgtos {
	
	private int id;
	private int formaPgto;
	private int pago;
	private String valor;
	private int desconto;
	private String valorFinal;
	private int idUser;
	private String tipoUsuario;
	private String token;
	private String idPayer;
	
	public Pgtos() {
		super();
	}

	public Pgtos(int id, int formaPgto, int pago, String valor, int desconto, String valorFinal, int idUser,
			String tipoUsuario, String token, String idPayer) {
		super();
		this.id = id;
		this.formaPgto = formaPgto;
		this.pago = pago;
		this.valor = valor;
		this.desconto = desconto;
		this.valorFinal = valorFinal;
		this.idUser = idUser;
		this.tipoUsuario = tipoUsuario;
		this.token = token;
		this.idPayer = idPayer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public int getDesconto() {
		return desconto;
	}

	public void setDesconto(int desconto) {
		this.desconto = desconto;
	}

	public String getValorFinal() {
		return valorFinal;
	}

	public void setValorFinal(String valorFinal) {
		this.valorFinal = valorFinal;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getIdPayer() {
		return idPayer;
	}

	public void setIdPayer(String idPlayer) {
		this.idPayer = idPlayer;
	}
	
}
