package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import model.vo.LivroVO;

public class LivroDAO extends ProdutoDAO<LivroVO> {
	
	@Override
	public void inserir(LivroVO vo) {
		try {
			super.inserir(vo);
			String sql = "insert into livro (autor, genero, ano, paginas, codProduto) values (?,?,?,?,?)";
			PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, vo.getAutor());
			ptst.setString(2, vo.getGenero());
			ptst.setInt(3, vo.getAno());
			ptst.setInt(4, vo.getPaginas());
			ptst.setInt(5, vo.getCodProduto());
			
			int affectedRows = ptst.executeUpdate();

			if (affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if (generatedKeys.next()) {
				vo.setCodLivro(generatedKeys.getInt(1));
			} else {
				throw new SQLException("A inserção falhou. Nenhuma id foi retornado.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void remover(LivroVO vo) {
		String sql = "delete from livro where codLivro = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getCodLivro());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public ResultSet buscar() {
		String sql = "select * from livro";
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
	
	
	
	public ResultSet pesquisarPorTitulo(LivroVO vo) {
		String sql = "select * from Livro where titulo = ?";
				PreparedStatement ptst;
				ResultSet rs = null;
		 		try {
					ptst = getConnection().prepareStatement(sql);
					ptst.setString(1, vo.getTitulo());
					rs = ptst.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rs;
			}

		public ResultSet pesquisarPorAutor(LivroVO vo) {
		String sql = "select * from Livro where autor = ?";
				PreparedStatement ptst;
				ResultSet rs = null;
		 		try {
					ptst = getConnection().prepareStatement(sql);
					ptst.setString(1, vo.getAutor());
					rs = ptst.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rs;
			}

		public ResultSet pesquisarPorGenero(LivroVO vo) {
		String sql = "select * from Livro where genero = ?";
				PreparedStatement ptst;
				ResultSet rs = null;
		 		try {
					ptst = getConnection().prepareStatement(sql);
					ptst.setString(1, vo.getGenero());
					rs = ptst.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rs;
			}

		public ResultSet pesquisarPorAno(LivroVO vo) {
		String sql = "select * from Livro where ano = ?";
				PreparedStatement ptst;
				ResultSet rs = null;
		 		try {
					ptst = getConnection().prepareStatement(sql);
					ptst.setInt(1, vo.getAno());
					rs = ptst.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rs;
			}
	
		public void editar(LivroVO vo) {
			String sql = "update Livro set titulo = ?, autor = ?, genero = ?, ano = ?, paginas = ?, exemplares = ?, valorAluguel = ? where codLivro = ?";
			PreparedStatement ptst;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setString(1, vo.getTitulo());
				ptst.setString(2, vo.getAutor());
				ptst.setString(3, vo.getGenero());
				ptst.setInt(4, vo.getAno());
				ptst.setInt(5, vo.getPaginas());			
				ptst.setInt(6, vo.getExemplares());
				ptst.setDouble(7, vo.getValorAluguel());
				ptst.setInt(8, vo.getCodProduto());
				ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
}
