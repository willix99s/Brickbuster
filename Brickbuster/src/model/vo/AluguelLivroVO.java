package model.vo;

public class AluguelLivroVO {

	private int codAluguelLivro;
	private AluguelVO codAluguel;
	private LivroVO codLivro;
	
	
	public int getCodAluguelLivro() {
		return codAluguelLivro;
	}
	public void setCodAluguelLivro(int codAluguelLivro) {
		this.codAluguelLivro = codAluguelLivro;
	}
	public AluguelVO getCodAluguel() {
		return codAluguel;
	}
	public void setCodAluguel(AluguelVO codAluguel) {
		this.codAluguel = codAluguel;
	}
	public LivroVO getCodLivro() {
		return codLivro;
	}
	public void setCodLivro(LivroVO codLivro) {
		this.codLivro = codLivro;
	}
	
}
