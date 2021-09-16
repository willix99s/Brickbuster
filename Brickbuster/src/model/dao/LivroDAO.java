package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.LivroVO;

public class LivroDAO extends BaseDAO {
	
	public void inserir(LivroVO vo) {
		conn = getConnection();
		String sql = "insert into livro (codLivro, titulo, autor, genero, ano, paginas, exemplares, valorAluguel) values (?,?,?,?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, vo.getCodLivro());
			ptst.setString(2, vo.getTitulo());
			ptst.setString(3, vo.getAutor());
			ptst.setString(4, vo.getGenero());
			ptst.setInt(5, vo.getAno());
			ptst.setInt(6, vo.getPaginas());
			ptst.setInt(7, vo.getExemplares());
			ptst.setDouble(8, vo.getValorAluguel());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remover(LivroVO vo) {
		conn = getConnection();
		String sql = "delete from livro where codLivro = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, vo.getCodLivro());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<LivroVO> listar(){
		conn = getConnection();
		String sql = "select * from livro";
		Statement st;
		ResultSet rs;
		List<LivroVO> livros = new ArrayList<LivroVO>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				LivroVO vo = new LivroVO();
				vo.setAno(rs.getInt("ano"));
				vo.setAutor(rs.getString("autor"));
				vo.setCodLivro(rs.getInt("codLivro"));
				vo.setExemplares(rs.getInt("exemplares"));
				vo.setGenero(rs.getString("genero"));
				vo.setPaginas(rs.getInt("paginas"));
				vo.setTitulo(rs.getString("titulo"));
				vo.setValorAluguel(rs.getDouble("valorAluguel"));
				livros.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return livros;
	}
	
	public ResultSet pesquisarPorTitulo(LivroVO vo) {
		conn = getConnection();
		String sql = "select * from Livro where titulo = ?";
				PreparedStatement ptst;
				ResultSet rs = null;
		 		try {
					ptst = conn.prepareStatement(sql);
					ptst.setString(1, vo.getTitulo());
					rs = ptst.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rs;
			}

		public ResultSet pesquisarPorAutor(LivroVO vo) {
		conn = getConnection();
		String sql = "select * from Livro where autor = ?";
				PreparedStatement ptst;
				ResultSet rs = null;
		 		try {
					ptst = conn.prepareStatement(sql);
					ptst.setString(1, vo.getAutor());
					rs = ptst.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rs;
			}

		public ResultSet pesquisarPorGenero(LivroVO vo) {
		conn = getConnection();
		String sql = "select * from Livro where genero = ?";
				PreparedStatement ptst;
				ResultSet rs = null;
		 		try {
					ptst = conn.prepareStatement(sql);
					ptst.setString(1, vo.getGenero());
					rs = ptst.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rs;
			}

		public ResultSet pesquisarPorAno(LivroVO vo) {
		conn = getConnection();
		String sql = "select * from Livro where ano = ?";
				PreparedStatement ptst;
				ResultSet rs = null;
		 		try {
					ptst = conn.prepareStatement(sql);
					ptst.setInt(1, vo.getAno());
					rs = ptst.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rs;
			}
	
	public void editar(LivroVO vo) {
		conn = getConnection();
		String sql = "update livro set titulo = ? where codLivro = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getTitulo());
			ptst.setInt(2, vo.getCodLivro());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
