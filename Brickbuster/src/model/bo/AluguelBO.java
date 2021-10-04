package model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.dao.AluguelDAO;
import model.vo.AluguelVO;

public class AluguelBO implements BaseinterBO<AluguelVO> {

	AluguelDAO dao = new AluguelDAO();
	public void inserir(AluguelVO vo) throws Exception 
	{
		try {
			ResultSet rs = dao.buscar();
			if (rs.next()) {
				throws new Exception("Erro em inserir, pois esse aluguel j� existe.");
			}
			else {
				dao.buscar(vo);
			}
			catch(SQLException e) {
				throws new Exception(e.getMessage());			
			}
	    }
		
	}
	
	public void editar(AluguelVO vo) throws Exception 
	{
		try {
			ResultSet rs = dao.buscar();
			if (rs.next()) {
				throws new Exception("Erro em editar, pois esse aluguel n�o existe.");
			}
			else {
				dao.buscar(vo);
			}
			catch(SQLException e) {
				throws new Exception(e.getMessage());			
			}
	    }
		
	}
	
	public void remover(AluguelVO vo) throws Exception 
	{
		try {
			ResultSet rs = dao.buscar();
			if (rs.next()) {
				throws new Exception("Erro em remover, pois esse aluguel n�o existe.");
			}
			else {
				dao.buscar(vo);
			}
			catch(SQLException e) {
				throws new Exception(e.getMessage());			
			}
	    }
		
	}
}
