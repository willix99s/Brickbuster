package model.dao;
import model.vo.ClientesVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ClientesDAO extends BaseDAO<ClientesVO> {

	public void inserir(ClientesVO vo) 
	{
		try {
			String sql = "insert into clientes (codClientes, nome, endereco, cpf) values (?,?,?,?)";
			PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setInt(1, vo.getCodClientes());
			ptst.setString(2, vo.getNome());
			ptst.setString(3, vo.getEndereco());
			ptst.setString(4, vo.getCpf());
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new  SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if(generatedKeys.next()) {
				vo.setCodClientes(generatedKeys.getInt(1));
			}
			else {
				throw new SQLException("A inserção falhou. Nenhum id foi retornado");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void remover (ClientesVO vo) 
	{
		String sql = "delete from clientes where codClientes = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getCodClientes());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public ResultSet buscar() 
	{
		String sql = "select * from clientes";
		Statement st;
		ResultSet rs = null;

		try {
			st = getConnection().createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public ResultSet pesquisarPorNome(ClientesVO vo) {
		String sql = "select * from Clientes where nome = ?";
				PreparedStatement ptst;
				ResultSet rs = null;	
		 		try {
		 			ptst = getConnection().prepareStatement(sql);
					ptst.setString(1, vo.getNome());
					rs = ptst.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rs;
			}

		public ResultSet pesquisarPorCpf(ClientesVO vo) {
		String sql = "select * from Clientes where cpf = ?";
				PreparedStatement ptst;
				ResultSet rs = null;
		 		try {
		 			ptst = getConnection().prepareStatement(sql);
					ptst.setString(1, vo.getCpf());
					rs = ptst.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rs;
			}
	
		public void editar(ClientesVO vo) {
			String sql = "update Clientes set nome = ?, endereco = ?, cpf = ? where codClientes = ?";
			PreparedStatement ptst;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setString(1, vo.getNome());
				ptst.setString(2, vo.getEndereco());
				ptst.setString(3, vo.getCpf());
				ptst.setInt(4, vo.getCodClientes());
				ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	
}
