package br.com.unorte.ufarm.pojo;

public class Anuncios {
	
	private int id;
	private int idUser;
	private String tipoAnuncio;
	private String imagem;
	private String url;
	
	public Anuncios() {
		super();
	}

	public Anuncios(int id, int idUser, String tipoAnuncio, String imagem, String url) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.tipoAnuncio = tipoAnuncio;
		this.imagem = imagem;
		this.url = url;
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

	public String getTipoAnuncio() {
		return tipoAnuncio;
	}

	public void setTipoAnuncio(String tipoAnuncio) {
		this.tipoAnuncio = tipoAnuncio;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Anuncios [id=" + id + ", idUser=" + idUser + ", tipoAnuncio=" + tipoAnuncio + ", imagem=" + imagem
				+ ", url=" + url + "]";
	}
	
	

}