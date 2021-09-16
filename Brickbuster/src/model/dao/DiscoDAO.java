package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.DiscoVO;

public class DiscoDAO extends BaseDAO {
	
	public void inserir(DiscoVO vo) {
		conn = getConnection();
		String sql = "insert into disco (codDisco, titulo, banda, estilo, exemplares, valorAluguel) values (?,?,?,?,?,?)";
		PreparedStatement ptst;
	    try {
				ptst = conn.prepareStatement(sql);
				ptst.setInt(1, vo.getCodDisco());
				ptst.setString(2, vo.getTitulo());
				ptst.setString(3, vo.getBanda());
				ptst.setString(4, vo.getEstilo());
				ptst.setInt(5, vo.getExemplares());
				ptst.setDouble(6, vo.getValorAluguel());
				ptst.execute();
	    } catch (SQLException e) {
	    	// TODO Auto-generated catch block
	    	e.printStackTrace();
		}
	    
	}
	public void remover(DiscoVO vo) {
		conn = getConnection();
		String sql = "delete from disco where codDisco = ?";
		PreparedStatement ptst;
	    try {
				ptst = conn.prepareStatement(sql);
				ptst.setInt(1, vo.getCodDisco());
				ptst.executeUpdate();
	    } catch (SQLException e) {
	    	// TODO Auto-generated catch block
	    	e.printStackTrace();
	}
  }
	public List<DiscoVO> listar() {
		conn = getConnection();
		String sql = "Select * from disco";
		Statement st;
		ResultSet rs;
		List<DiscoVO> discos = new ArrayList<DiscoVO>();
		
		try {
			 st = conn.createStatement();
			 rs = st.executeQuery(sql);
			 while(rs.next()) {
				 DiscoVO vo = new DiscoVO();
				 vo.setCodDisco(rs.getInt("codDisco"));
				 vo.setTitulo(rs.getString("titulo"));
				 vo.setBanda(rs.getString("banda"));
				 vo.setEstilo(rs.getString("estilo"));
				 vo.setExemplares(rs.getInt("exemplares"));
				 vo.setValorAluguel(rs.getDouble("valorAluguel"));
				 discos.add(vo);
			 }
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return discos;
}
	public void editar(DiscoVO vo) {
		conn = getConnection();
		String sql = "update from disco set banda = ? where codDisco = ?";
		PreparedStatement ptst;
		try {
			 ptst = conn.prepareStatement(sql);
			 ptst.setString(1, vo.getTitulo());
			 ptst.setInt(2, vo.getCodDisco());
			 ptst.executeUpdate();
		} catch (SQLException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}