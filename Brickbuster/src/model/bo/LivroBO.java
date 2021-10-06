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

	public List<LivroVO> listar() throws Exception {
		List<LivroVO> livros = new ArrayList<LivroVO>();
		try {
			ResultSet rs = dao.buscar();
			while (rs.next()) {
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

	public List<LivroVO> pesquisarPorTitulo(LivroVO liv) throws Exception {
		List<LivroVO> livros = new ArrayList<LivroVO>();

		try {
			ResultSet rs = dao.pesquisarPorTitulo(liv);
			while (rs.next()) {
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
			e.printStackTrace();
		}

		return livros;
	}

	public List<LivroVO> pesquisarPorAutor(LivroVO liv) throws Exception {
		List<LivroVO> livros = new ArrayList<LivroVO>();

		try {
			ResultSet rs = dao.pesquisarPorAutor(liv);
			while (rs.next()) {
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
			e.printStackTrace();
		}

		return livros;
	}

	public List<LivroVO> pesquisarPorGenero(LivroVO liv) throws Exception {
		List<LivroVO> livros = new ArrayList<LivroVO>();

		try {
			ResultSet rs = dao.pesquisarPorGenero(liv);
			while (rs.next()) {
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
			e.printStackTrace();
		}

		return livros;
	}

	public List<LivroVO> pesquisarPorAno(LivroVO liv) throws Exception {
		List<LivroVO> livros = new ArrayList<LivroVO>();
		
		try {
			ResultSet rs = dao.pesquisarPorAno(liv);
			while (rs.next()) {
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
			e.printStackTrace();
		}
		
		return livros;
	}
}
