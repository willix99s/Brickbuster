package model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.dao.AluguelDAO;
import model.dao.AluguelDiscoDAO;
import model.dao.AluguelLivroDAO;
import model.vo.AluguelDiscoVO;
import model.vo.AluguelLivroVO;
import model.vo.AluguelVO;

public class AluguelBO implements BaseinterBO<AluguelVO> {

	AluguelDAO dao = new AluguelDAO();
	public void inserir(AluguelVO vo) throws Exception 
	{
		try {
			ResultSet rs = dao.buscar();
			if (rs.next()) {
				throw new Exception("Erro em inserir, pois esse aluguel já existe.");
			}
			else {
				dao.buscar();
			}
		}
			catch(SQLException e) {
				throw new Exception(e.getMessage());			
			}
	    }
		
	
	public void editar(AluguelVO vo) throws Exception 
	{
		try {
			ResultSet rs = dao.buscar();
			if (rs.next()) {
				throw new Exception("Erro em editar, pois esse aluguel não existe.");
			}
			else {
				dao.buscar();
			}
		}
			catch(SQLException e) {
				throw new Exception(e.getMessage());			
			}
	    }
		
	
	public void remover(AluguelVO vo) throws Exception 
	{
		try {
			ResultSet rs = dao.buscar();
			if (rs.next()) {
				throw new Exception("Erro em remover, pois esse aluguel não existe.");
			}
			else {
				dao.buscar();
			}
		}
			catch(SQLException e) {
				throw new Exception(e.getMessage());			
			}
	    }
		
	public List<AluguelVO> listar() throws Exception {
		
		List<AluguelVO> alugueis = new ArrayList<AluguelVO>();
		List<AluguelLivroVO> livros = new ArrayList<AluguelLivroVO>();
		List<AluguelDiscoVO> discos = new ArrayList<AluguelDiscoVO>();
		
		try {
			ResultSet rs = dao.buscar();
			while(rs.next()) {
				Calendar calendar = Calendar.getInstance();
				Calendar calendar2 = Calendar.getInstance();
						
				AluguelVO vo = new AluguelVO();
				vo.setCodAluguel(rs.getInt("codAluguel"));
				vo.getCodNomeCliente().setCodClientes(rs.getInt("codNomeCliente"));
				calendar.setTime(rs.getDate("dataInicio"));
				vo.setDataInicio(calendar);
				calendar.setTime(rs.getDate("dataFinal"));
				vo.setDataFinal(calendar2);
				vo.setValorAluguel(rs.getDouble("valorAluguel"));
				alugueis.add(vo);
				
				AluguelDiscoDAO dao1 = new AluguelDiscoDAO();
				discos = dao1.listar(vo);
				vo.setDisco(discos.toArray(new AluguelDiscoVO[discos.size()]));
				
				AluguelLivroDAO dao2 = new AluguelLivroDAO();
				livros = dao2.listar(vo);
				vo.setLivro(livros.toArray(new AluguelLivroVO[livros.size()]));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alugueis;
	}
	
	
	}

