package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.LivroVO;
import model.vo.ProdutoVO;

public class ProdutoDAO<VO extends ProdutoVO> extends BaseDAO<VO> {
	
	@Override
	public void inserir(VO vo) throws SQLException {
		String sql = "insert into produto (titulo, exemplares, valorAluguel) values (?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, vo.getTitulo());
			ptst.setInt(2, vo.getExemplares());
			ptst.setDouble(3, vo.getValorAluguel());

			int affectedRows = ptst.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				vo.setCodProduto(generatedKeys.getInt(1));
			} else {
				throw new SQLException("A inserção falhou. Nenhuma id foi retornado.");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void remover(VO vo) {
		String sql = "delete from produto where codProduto = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getCodProduto());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public ResultSet buscar() {
		String sql = "select * from produto";
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

	public ResultSet pesquisarPorTitulo(VO vo) {
		String sql = "select * from produto where titulo = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getTitulo());
			System.out.println(ptst);
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public void editar(VO vo) {
		String sql = "update produto set titulo = ?, exemplares = ?, valorAluguel = ? where codProduto = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setString(1, vo.getTitulo());
			ptst.setInt(2, vo.getExemplares());
			ptst.setDouble(3, vo.getValorAluguel());
			ptst.setInt(4, vo.getCodProduto());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
