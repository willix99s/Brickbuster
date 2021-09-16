package model.vo;

public class AluguelDiscoVO {

	private int codAluguelDisco;
	private AluguelVO codAluguel;
	private DiscoVO codDisco;
	
	
	public int getCodAluguelDisco() {
		return codAluguelDisco;
	}
	public void setCodAluguelDisco(int codAluguelDisco) {
		this.codAluguelDisco = codAluguelDisco;
	}
	public AluguelVO getCodAluguel() {
		return codAluguel;
	}
	public void setCodAluguel(AluguelVO codAluguel) {
		this.codAluguel = codAluguel;
	}
	public DiscoVO getCodDisco() {
		return codDisco;
	}
	public void setCodDisco(DiscoVO codDisco) {
		this.codDisco = codDisco;
	}
	
}
