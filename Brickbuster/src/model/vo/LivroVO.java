package model.vo;

public class LivroVO extends ProdutoVO {
	private int codLivro;
	private String autor;
	private String genero;
	private int ano;
	private int paginas;

	public int getCodLivro() {
		return codLivro;
	}

	public void setCodLivro(int codLivro) {
		if (codLivro >= 0)
			this.codLivro = codLivro;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		if (autor == null) {
			System.out.println("Autor n�o pode ser nulo");
		} else {
			if (autor.equals("")) {
				System.out.println("Autor n�o pode ser vazio");
			} else {
				this.autor = autor;
			}
		}
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		if (genero == null) {
			System.out.println("G�nero n�o pode ser nulo");
		} else {
			if (genero.equals("")) {
				System.out.println("G�nero n�o pode ser vazio");
			} else {
				this.genero = genero;
			}
		}
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		if (ano <= 0) {
			System.out.println("Ano inv�lido");
		} else {
			this.ano = ano;
		}
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		if (paginas <= 0) {
			System.out.println("Quantidade n�o permitida");
		} else {
			this.paginas = paginas;
		}
	}

	public LivroVO() {

	}

	public String toString() {
		String saida;
		saida = super.toString();
		saida = saida + "\n" + "Autor: " + autor;
		saida = saida + "\n" + "G�nero: " + genero;
		saida = saida + "\n" + "Ano de Lan�amento: " + ano;
		saida = saida + "\n" + "N�mero de P�ginas: " + paginas;
		return saida;
	}

}
