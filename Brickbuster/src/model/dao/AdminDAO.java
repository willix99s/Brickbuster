package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.AdminVO;

public class AdminDAO extends BaseDAO {
	
	public void inserir(AdminVO vo) {
		conn = getConnection();
		String sql = "insert into admin (codAdmin, login, senha, nome) values (?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, vo.getCodAdmin());
			ptst.setString(2, vo.getLogin());
			ptst.setString(3, vo.getSenha());
			ptst.setString(4, vo.getNome());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remover(AdminVO vo) {
		conn = getConnection();
		String sql = "delete from admin where codAdmin = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, vo.getCodAdmin());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<AdminVO> listar(){
		conn = getConnection();
		String sql = "select * from admin";
		Statement st;
		ResultSet rs;
		List<AdminVO> admins = new ArrayList<AdminVO>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				AdminVO vo = new AdminVO();
				vo.setCodAdmin(rs.getInt("codAdmin"));
				vo.setLogin(rs.getString("login"));
				vo.setNome(rs.getString("nome"));
				vo.setSenha(rs.getString("senha"));
				admins.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admins;
	}
	
	public void editar(AdminVO vo) {
		conn = getConnection();
		String sql = "update admin set nome = ? where codAdmin = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, vo.getCodAdmin());
			ptst.setString(2, vo.getNome());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
