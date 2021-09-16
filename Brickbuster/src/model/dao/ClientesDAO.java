package model.dao;
import model.vo.ClientesVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientesDAO extends BaseDAO {

	public void inserir(ClientesVO vo) 
	{
		conn = getConnection();
		String sql = "insert into clientes (codClientes, nome, endereco, cpf) values (?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, vo.getCodClientes());
			ptst.setString(2, vo.getNome());
			ptst.setString(3, vo.getEndereco());
			ptst.setString(4, vo.getCpf());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void remover (ClientesVO vo) 
	{
		conn = getConnection();
		String sql = "delete from clientes where codClientes = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, vo.getCodClientes());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<ClientesVO> listar(){
		conn = getConnection();
		String sql = "select * from clientes";
		Statement st;
		ResultSet rs;
		List<ClientesVO> cliente = new ArrayList<ClientesVO>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
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
	
	public ResultSet pesquisarPorNome(ClientesVO vo) {
		conn = getConnection();
		String sql = "select * from Clientes where nome = ?";
				PreparedStatement ptst;
				ResultSet rs = null;	
		 		try {
					ptst = conn.prepareStatement(sql);
					ptst.setString(1, vo.getNome());
					rs = ptst.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rs;
			}

		public ResultSet pesquisarPorCpf(ClientesVO vo) {
		conn = getConnection();
		String sql = "select * from Clientes where cpf = ?";
				PreparedStatement ptst;
				ResultSet rs = null;
		 		try {
					ptst = conn.prepareStatement(sql);
					ptst.setString(1, vo.getCpf());
					rs = ptst.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rs;
			}
	
	public void editar(ClientesVO vo) 
	{
		conn = getConnection();
		String sql = "update from clientes set nome = ? where codClientes = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setInt(2, vo.getCodClientes());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
}
