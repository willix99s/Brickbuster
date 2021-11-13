package model.dao;

import java.sql.SQLException;

import model.bo.AdminBO;
import model.vo.AdminVO;
import model.vo.AluguelDiscoVO;
import model.vo.AluguelLivroVO;
import model.vo.AluguelVO;
import model.vo.ClientesVO;
import model.vo.DiscoVO;
import model.vo.LivroVO;
import model.vo.ProdutoVO;

public class Teste {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//BaseDAO dao = new BaseDAO();
		//System.out.println(dao.getConnection());
		
		ProdutoDAO<ProdutoVO> dao = new ProdutoDAO<ProdutoVO>();
		AdminDAO dao2 = new AdminDAO();
		ClientesDAO dao3 = new ClientesDAO();
		DiscoDAO dao4 = new DiscoDAO();
		LivroDAO dao5 = new LivroDAO();
		AluguelDAO dao6 = new AluguelDAO();
		AluguelDiscoDAO dao7 = new AluguelDiscoDAO();
		AluguelLivroDAO dao8 = new AluguelLivroDAO();
		AdminBO bo = new AdminBO();
		
		ProdutoVO vo = new LivroVO();
        vo.setTitulo("Nome do Produto");
        vo.setExemplares(5);
        vo.setValorAluguel(10.00);
        //dao.inserir(vo);
        
        AdminVO vo2 = new AdminVO();
        vo2.setLogin("srdudu");
        vo2.setNome("Dudu");
        vo2.setSenha("12345");
        //dao2.inserir(vo2);
        
        ClientesVO vo3 = new ClientesVO();
        vo3.setCpf("123.456.789-10");
        vo3.setEndereco("Rua Nova, 10");
        vo3.setNome("João Pedro");
        vo3.setCodClientes(1);
        //dao3.inserir(vo3);
        
        DiscoVO vo4 = new DiscoVO();
        vo4.setBanda("Beatles");
        vo4.setEstilo("Rock");
        vo4.setExemplares(5);
        vo4.setTitulo("Help");
        vo4.setValorAluguel(10.00);
        vo4.setCodDisco(1);
        //dao4.inserir(vo4);
        
        LivroVO vo5 = new LivroVO();
        vo5.setAno(1997);
        vo5.setAutor("J.K. Rowling");
        vo5.setExemplares(4);
        vo5.setGenero("Fantasia");
        vo5.setPaginas(255);
        vo5.setTitulo("Harry Potter e a Pedra Filosofal");
        vo5.setValorAluguel(15.00);
        vo5.setCodLivro(1);
        //dao5.inserir(vo5);
        
        AluguelVO vo6 = new AluguelVO();
        vo6.setCodNomeCliente(vo3);
        vo6.setDataInicio();
        vo6.setDataFinal();
        
        AluguelDiscoVO vo7 = new AluguelDiscoVO();
        AluguelDiscoVO aluD[] = new AluguelDiscoVO[1];
        aluD[0] = vo7;
        vo7.setCodAluguel(vo6);
        vo7.setCodDisco(vo4);
        
        AluguelLivroVO vo8 = new AluguelLivroVO();
        AluguelLivroVO aluL[] = new AluguelLivroVO[1];
        aluL[0] = vo8;
        vo8.setCodAluguel(vo6);
        vo8.setCodLivro(vo5);

        vo6.setLivro(aluL);
        vo6.setDisco(aluD);
        vo6.setValorAluguel(20.00);
        //dao6.inserir(vo6);
        
        /*
        try {
			bo.autenticar(vo2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}

}
