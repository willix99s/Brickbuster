package model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
				throw new Exception("Erro em inserir, pois j� existe um cliente com esse cpf.");
			}
			else {
				dao.inserir(vo);
				}
			}
			catch(SQLException e) {
				throw new Exception(e.getMessage());			
			}
	    
		
	}
	
	public void editar(ClientesVO vo) throws Exception
	{
		try {
			ResultSet rs = dao.pesquisarPorCpf(vo);
			if (rs.next()) {
				dao.editar(vo);
			}
			else {
				throw new Exception("Erro em editar, pois n�o existe um cliente com esse cpf.");
		    }
		}
			catch(SQLException e) {
				throw new Exception(e.getMessage());			
			}
		
	} 

	
	
	public void remover(ClientesVO vo) throws Exception
	{
		try {
			ResultSet rs = dao.pesquisarPorCpf(vo);
			if (rs.next()) {
				dao.remover(vo);
			}
			else {
				throw new Exception("Erro em remover, pois n�o existe um cliente com esse cpf.");
		    }
			}
			catch(SQLException e) {
				throw new Exception(e.getMessage());			
			}
		
	} 

	public List<ClientesVO> listar() throws Exception
	{
		List<ClientesVO> cliente = new ArrayList<ClientesVO>();
		try {
			ResultSet rs = dao.buscar();
			while(rs.next()) {
				ClientesVO vo = new ClientesVO();
				vo.setCodClientes(rs.getInt("codClientes"));
				vo.setCpf(rs.getString("cpf"));
				vo.setEndereco(rs.getString("endereco"));
				vo.setNome(rs.getString("nome"));
				cliente.add(vo);	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cliente;
	}
	
	public List<ClientesVO> pesquisarPorNome(ClientesVO cli) throws Exception {
		List<ClientesVO> cliente = new ArrayList<ClientesVO>();
		
		try {
			ResultSet rs = dao.pesquisarPorNome(cli);
			while (rs.next()) {
				ClientesVO vo = new ClientesVO();
				vo.setCodClientes(rs.getInt("codClientes"));
				vo.setCpf(rs.getString("cpf"));
				vo.setEndereco(rs.getString("endereco"));
				vo.setNome(rs.getString("nome"));
				cliente.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cliente;
	}
	
	public List<ClientesVO> pesquisarPorCpf(ClientesVO cli) throws Exception {
		List<ClientesVO> cliente = new ArrayList<ClientesVO>();
		
		try {
			ResultSet rs = dao.pesquisarPorCpf(cli);
			while (rs.next()) {
				ClientesVO vo = new ClientesVO();
				vo.setCodClientes(rs.getInt("codClientes"));
				vo.setCpf(rs.getString("cpf"));
				vo.setEndereco(rs.getString("endereco"));
				vo.setNome(rs.getString("nome"));
				cliente.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cliente;
	} 

}
