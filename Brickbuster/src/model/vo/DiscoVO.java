package model.vo;

public class DiscoVO extends ProdutoVO {
	private int codDisco;
	private String banda;
	private String estilo;

	public int getCodDisco() {
		return codDisco;
	}

	public void setCodDisco(int codDisco) {
		if (codDisco >= 0)
			this.codDisco = codDisco;
	}

	public String getBanda() {
		return banda;
	}

	public void setBanda(String banda) {
		this.banda = banda;
	}

	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public DiscoVO() {

	}

	public String toString() {
		String saida;
		saida = super.toString();
		saida = saida + "\n" + "Nome da Banda: " + banda;
		saida = saida + "\n" + "Estilo: " + estilo;
		return saida;
	}

}
