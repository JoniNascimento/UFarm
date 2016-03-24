package br.com.unorte.ufarm.pojo;

public class UfarmServicos {

	private int id;
	private String data;
	private String tipo;
	private String atividade;
	private String categoria;
	private String subCategoria;
	private String local;
	private String realizadoPor;
	private String horaInicial;
	private String horaFinal;
	private String horasTrabalhadas;
	private String area;
	private int qtde;
	private String valorServico;
	private String valorTotal;
	private int pago;
	private String status;
	private String motivo;
	
	public UfarmServicos() {
		super();
	}

	public UfarmServicos(int id, String data, String tipo, String atividade, String categoria, String subCategoria,
			String local, String realizadoPor, String horaInicial, String horaFinal, String horasTrabalhadas,
			String area, int qtde, String valorServico, String valorTotal, int pago, String status, String motivo) {
		super();
		this.id = id;
		this.data = data;
		this.tipo = tipo;
		this.atividade = atividade;
		this.categoria = categoria;
		this.subCategoria = subCategoria;
		this.local = local;
		this.realizadoPor = realizadoPor;
		this.horaInicial = horaInicial;
		this.horaFinal = horaFinal;
		this.horasTrabalhadas = horasTrabalhadas;
		this.area = area;
		this.qtde = qtde;
		this.valorServico = valorServico;
		this.valorTotal = valorTotal;
		this.pago = pago;
		this.status = status;
		this.motivo = motivo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getAtividade() {
		return atividade;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
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

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getRealizadoPor() {
		return realizadoPor;
	}

	public void setRealizadoPor(String realizadoPor) {
		this.realizadoPor = realizadoPor;
	}

	public String getHoraInicial() {
		return horaInicial;
	}

	public void setHoraInicial(String horaInicial) {
		this.horaInicial = horaInicial;
	}

	public String getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(String horaFinal) {
		this.horaFinal = horaFinal;
	}

	public String getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(String horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	public String getValorServico() {
		return valorServico;
	}

	public void setValorServico(String valorServico) {
		this.valorServico = valorServico;
	}

	public String getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(String valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getPago() {
		return pago;
	}

	public void setPago(int pago) {
		this.pago = pago;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	

	
	
}
