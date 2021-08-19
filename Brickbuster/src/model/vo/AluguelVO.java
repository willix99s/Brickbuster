package model.vo;
import java.util.*;

public class AluguelVO {
	//Atributos de aluguel
	private ClientesVO nome;
	private Calendar dataInicio;
	private Calendar dataFinal;
	private double valorAluguel;
	private DiscoVO disco[];
	private LivroVO livro[];
	
	//Get e Set de nome
	public ClientesVO getNome() {
		return nome;
	}
	public void setNome(ClientesVO nome) {
		this.nome = nome;
	}
	
	//Get e Set de data inicial
	public Calendar getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio(Calendar dataInicio) {
		
		Calendar dataI = Calendar.getInstance();
		
		if ( dataInicio == dataI ) { System.out.println ("Data atual correta!"); }
		else { this.dataInicio = dataInicio; } 
		
	}
	
	//Get e Set de data final
	public Calendar getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(Calendar dataFinal) {
		this.dataFinal = dataFinal;
	}
	
	//Get e Set de valor do aluguel
	public double getValorAluguel() {
		return valorAluguel;
	}
	public void setValorAluguel(double valorAluguel) {
		
		if ( valorAluguel >= 0 ) { this.valorAluguel = valorAluguel; }
		
	}
	
	//Get e Set de disco
	public DiscoVO[] getDisco() {
		return disco;
	}
	public void setDisco(DiscoVO[] disco) {
		this.disco = disco;
	}
	
	//Get e Set de livro
	public LivroVO[] getLivro() {
		return livro;
	}
	public void setLivro(LivroVO[] livro) {
		this.livro = livro;
	}
	
	
}
