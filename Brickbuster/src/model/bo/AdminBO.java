package model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.dao.AdminDAO;
import model.vo.AdminVO;

public class AdminBO implements BaseinterBO<AdminVO> {

	AdminDAO dao = new AdminDAO();
	public void inserir(AdminVO vo) throws Exception 
	{
		try {
			ResultSet rs = dao.buscar(vo);
			if (rs.next()) {
				throws new Exception("Erro em inserir, pois esse Admin já existe.");
			}
			else {
				dao.buscar(vo);
			}
			catch(SQLException e) {
				throws new Exception(e.getMessage());			
			}
	    }
		
	}
	
	public void editar(AdminVO vo) throws Exception 
	{
		try {
			ResultSet rs = dao.buscar(vo);
			if (rs.next()) {
				throws new Exception("Erro em editar, pois esse Admin não existe.");
			}
			else {
				dao.buscar(vo);
			}
			catch(SQLException e) {
				throws new Exception(e.getMessage());			
			}
	    }
		
	}
	
	public void remover(AdminVO vo) throws Exception 
	{
		try {
			ResultSet rs = dao.buscar(vo);
			if (rs.next()) {
				throws new Exception("Erro em remover, pois esse Admin não existe.");
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
