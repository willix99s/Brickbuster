package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.vo.AdminVO;

public class AdminDAO extends BaseDAO<AdminVO> {
	
	public void inserir(AdminVO vo) {	
		try {
			String sql = "insert into admin (codAdmin, login, senha, nome) values (?,?,?,?)";
			PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setInt(1, vo.getCodAdmin());
			ptst.setString(2, vo.getLogin());
			ptst.setString(3, vo.getSenha());
			ptst.setString(4, vo.getNome());
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new  SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if(generatedKeys.next()) {
				vo.setCodAdmin(generatedKeys.getInt(1));
			}
			else {
				throw new SQLException("A inserção falhou. Nenhum id foi retornado");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remover(AdminVO vo) {
		String sql = "delete from admin where codAdmin = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getCodAdmin());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public ResultSet buscar() 
	{
		String sql = "select * from admin";
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
	
	public void editar(AdminVO vo) {
		String sql = "update Admin set login = ?, senha = ?, nome = ? where codAdmin = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getLogin());
			ptst.setString(2, vo.getSenha());
			ptst.setString(3, vo.getNome());
			ptst.setInt(4, vo.getCodAdmin());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
