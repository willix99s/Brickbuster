package model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
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
				throw new Exception("Impossível inserir, pois já existe livro com este título.");
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
				throw new Exception("Impossível editar, pois não existe livro com este título.");
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
				throw new Exception("Impossível remover, pois não existe livro com este título.");
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public ResultSet buscar() throws Exception {
		try {
			ResultSet rs = dao.buscar();
			if (rs.next()) {
				dao.buscar();
			} else {
				throw new Exception("Impossível buscar, pois não existem livros cadastrados.");
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		return null;
	}
	
	public List<LivroVO> listar(LivroVO vo) throws Exception {
		List<LivroVO> livros = null;
		try {
			ResultSet rs = dao.buscar();
			if(rs.next()) {
				livros = dao.listar();
			}
			else {
				throw new Exception("Impossível listar, pois não existem livros cadastrados.");
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
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
				throw new Exception("Impossível pesquisar o livro, pois não existe livro com este título.");
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
				throw new Exception("Impossível pesquisar, pois não existem livros deste autor.");
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
				throw new Exception("Impossível pesquisar, pois não existem livros deste gênero.");
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
				throw new Exception("Impossível pesquisar, pois não existem livros com este ano de publicação.");
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
		return livros;
	}
}
