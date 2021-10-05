package model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dao.LivroDAO;
import model.vo.LivroVO;

public class LivroBO implements BaseinterBO<LivroVO> {
	LivroDAO dao = new LivroDAO();

	@Override
	public void inserir(LivroVO vo) throws Exception {
		try {
			ResultSet rs = dao.pesquisarPorTitulo(vo);
			if (rs.next()) {
				throw new Exception("Imposs�vel inserir, pois j� existe livro com este t�tulo.");
			} else {
				dao.inserir(vo);
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void editar(LivroVO vo) throws Exception {
		try {
			ResultSet rs = dao.pesquisarPorTitulo(vo);
			if (rs.next()) {
				dao.editar(vo);
			} else {
				throw new Exception("Imposs�vel editar, pois n�o existe livro com este t�tulo.");
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void remover(LivroVO vo) throws Exception {
		try {
			ResultSet rs = dao.pesquisarPorTitulo(vo);
			if (rs.next()) {
				dao.remover(vo);
			} else {
				throw new Exception("Imposs�vel remover, pois n�o existe livro com este t�tulo.");
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	
	public List<LivroVO> listar(){
		List<LivroVO> livros = new ArrayList<LivroVO>();
		try {
			ResultSet rs = dao.buscar();
			while(rs.next()) {
				LivroVO vo = new LivroVO();
				vo.setAno(rs.getInt("ano"));
				vo.setAutor(rs.getString("autor"));
				vo.setCodProduto(rs.getInt("codLivro"));
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
	
	public List<LivroVO> pesquisarPorTitulo(LivroVO vo) throws Exception {
		List<LivroVO> livros = null;
		try {
			ResultSet rs = dao.pesquisarPorTitulo(vo);
			if(rs.next()) {
				livros = dao.listar();
			}
			else {
				throw new Exception("Imposs�vel pesquisar o livro, pois n�o existe livro com este t�tulo.");
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
		return livros;
	}
	
	public List<LivroVO> pesquisarPorAutor(LivroVO vo) throws Exception {
		List<LivroVO> livros = null;
		try {
			ResultSet rs = dao.pesquisarPorAutor(vo);
			if(rs.next()) {
				livros = dao.listar();
			}
			else {
				throw new Exception("Imposs�vel pesquisar, pois n�o existem livros deste autor.");
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
		return livros;
	}
	
	public List<LivroVO> pesquisarPorGenero(LivroVO vo) throws Exception {
		List<LivroVO> livros = null;
		try {
			ResultSet rs = dao.pesquisarPorGenero(vo);
			if(rs.next()) {
				livros = dao.listar();
			}
			else {
				throw new Exception("Imposs�vel pesquisar, pois n�o existem livros deste g�nero.");
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
		return livros;
	}
	
	public List<LivroVO> pesquisarPorAno(LivroVO vo) throws Exception {
		List<LivroVO> livros = null;
		try {
			ResultSet rs = dao.pesquisarPorAno(vo);
			if(rs.next()) {
				livros = dao.listar();
			}
			else {
				throw new Exception("Imposs�vel pesquisar, pois n�o existem livros com este ano de publica��o.");
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
		return livros;
	}
}
