package br.com.unorte.ufarm.pojo;

public class UfarmFormularios {

	
	private int id;
	private String item;
	private String legenda;
	
	public UfarmFormularios() {
		super();
	}

	public UfarmFormularios(int id, String item, String legenda) {
		super();
		this.id = id;
		this.item = item;
		this.legenda = legenda;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getLegenda() {
		return legenda;
	}

	public void setLegenda(String legenda) {
		this.legenda = legenda;
	}
	
	@Override
	public String toString() {
		return item ;
	}

	
	
	
	
}
