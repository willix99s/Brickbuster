package model.vo;
import java.util.*;

public class AluguelVO {
	//Atributos de aluguel
	private int codAluguel;
	private ClientesVO codNomeCliente;
	private Calendar dataInicio;
	private Calendar dataFinal;
	private double valorAluguel;
	private AluguelDiscoVO disco[];
	private AluguelLivroVO livro[];
	
	//Get e Set de codAluguel
	public int getCodAluguel() {
		return codAluguel;
	}
	public void setCodAluguel(int codAluguel) {
		if (codAluguel >= 0) this.codAluguel = codAluguel;
	}
	
	//Get e Set de codCodNomeCliente
	
	public ClientesVO getCodNomeCliente() {
		return codNomeCliente;
	}
	public void setCodNomeCliente(ClientesVO codNomeCliente) {
		this.codNomeCliente = codNomeCliente;
	}
	
	//Get e Set de data inicial
	public Calendar getDataInicio() {
		return dataInicio;
	}
	
	public void setDataInicio() {
		
		Calendar dataI = Calendar.getInstance();
		this.dataInicio = dataI;
		
	}
	
	//Get e Set de data final
	public Calendar getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal() {
		
		Calendar dataF = Calendar.getInstance();
		dataF.add(Calendar.DAY_OF_MONTH, 3);
		this.dataFinal = dataF;
	
	}
	
	//Get e Set de valor do aluguel
	public double getValorAluguel() {
		return valorAluguel;
	}
	public void setValorAluguel(double valorAluguel) {
		
		if ( valorAluguel >= 0 ) { this.valorAluguel = valorAluguel; }
		
	}
	
	//Get e Set de disco
	public AluguelDiscoVO[] getDisco() {
		return disco;
	}
	public void setDisco(AluguelDiscoVO[] disco) {
		this.disco = disco;
	}
	
	//Get e Set de livro
	public AluguelLivroVO[] getLivro() {
		return livro;
	}
	public void setLivro(AluguelLivroVO[] livro) {
		this.livro = livro;
	}
	
	
}
