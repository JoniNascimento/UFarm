package br.com.unorte.ufarm.pojo;

public class Bds {
	
	private int id;
	private int idUser;
	private String bd;
	private String produto;
	
	public Bds(){
		super();
	}

	public Bds(int id, int idUser, String bd, String produto) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.bd = bd;
		this.produto = produto;
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

	public String getBd() {
		return bd;
	}

	public void setBd(String bd) {
		this.bd = bd;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}
	
	

}
