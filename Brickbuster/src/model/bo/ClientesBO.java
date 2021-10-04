package model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.dao.ClientesDAO;
import model.vo.ClientesVO;

public class ClientesBO implements BaseinterBO<ClientesVO> {
	
	ClientesDAO dao = new ClientesDAO();
	public void inserir(ClientesVO vo) throws Exception 
	{
		try {
			ResultSet rs = dao.pesquisarPorCpf(vo);
			if (rs.next()) {
				throws new Exception("Erro em inserir,  pois esse cpf já existe.");
			}
			else {
				dao.pesquisarPorCpf(vo);
			}
			catch(SQLException e) {
				throws new Exception(e.getMessage());			
			}
	    }
		
	}
	
	public void editar(ClientesVO vo) throws Exception
	{
		try {
			ResultSet rs = dao.pesquisarPorCpf(vo);
			if (rs.next()) {
				throws new Exception("Erro em editar, pois esse cpf não existe.");
			}
			else {
				dao.pesquisarPorCpf(vo);
		    }
			catch(SQLException e) {
				throws new Exception(e.getMessage());			
			}
		
	} 

	}
	
	public void remover(ClientesVO vo) throws Exception
	{
		try {
			ResultSet rs = dao.pesquisarPorCpf(vo);
			if (rs.next() == false) {
				throws new Exception("Erro em remover, pois esse cpf não existe.");
			}
			else {
				dao.pesquisarPorCpf(vo);
		    }
			catch(SQLException e) {
				throws new Exception(e.getMessage());			
			}
		
	} 

	}
	
}
