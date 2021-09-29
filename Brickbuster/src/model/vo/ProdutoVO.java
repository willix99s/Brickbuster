package model.vo;

public abstract class ProdutoVO {
	private int codProduto;
	private String titulo;
	private int exemplares;
	private double valorAluguel;

	public int getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(int codProduto) {
		if (codProduto >= 0)
			this.codProduto = codProduto;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if (titulo == null) {
			System.out.println("T�tulo n�o pode ser nulo");
		} else {
			if (titulo.equals("")) {
				System.out.println("T�tulo n�o pode ser vazio");
			} else {
				this.titulo = titulo;
			}
		}
	}

	public int getExemplares() {
		return exemplares;
	}

	public void setExemplares(int exemplares) {
		if (exemplares <= 0) {
			System.out.println("Quantidade n�o permitida");
		} else {
			this.exemplares = exemplares;
		}
	}

	public double getValorAluguel() {
		return valorAluguel;
	}

	public void setValorAluguel(double valorAluguel) {
		if (valorAluguel <= 0) {
			System.out.println("Valor n�o permitido");
		} else {
			this.valorAluguel = valorAluguel;
		}
	}

	public ProdutoVO() {

	}

	public String toString() {
		String saida;
		saida = "C�digo: " + codProduto;
		saida = saida + "\n" + "T�tulo: " + titulo;
		saida = saida + "\n" + "N�mero de Exemplares: " + exemplares;
		saida = saida + "\n" + "Valor do Aluguel: " + valorAluguel;
		return saida;
	}

}
