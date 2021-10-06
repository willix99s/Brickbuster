package model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.dao.AluguelLivroDAO;
import model.vo.AluguelLivroVO;
import model.vo.AluguelVO;

public class AluguelLivroBO implements BaseinterBO<AluguelLivroVO> {
	AluguelLivroDAO dao = new AluguelLivroDAO();
	
	public void inserir(AluguelLivroVO vo[]) throws Exception {
		try {
			ResultSet rs = dao.buscar();
			if (rs.next()) {
				throw new Exception("Impossível inserir, pois já existe aluguel de livro com este id.");
			} else {
				dao.inserir(vo);
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	public void editar(AluguelLivroVO vo[]) throws Exception {
		try {
			ResultSet rs = dao.buscar();
			if (rs.next()) {
				dao.editar(vo);
			} else {
				throw new Exception("Impossível editar, pois não existe aluguel de livro com este id.");
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	public void remover(AluguelLivroVO vo[]) throws Exception {
		try {
			ResultSet rs = dao.buscar();
			if (rs.next()) {
				dao.remover(vo);
			} else {
				throw new Exception("Impossível remover, pois não existe aluguel de livro com este id.");
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<AluguelLivroVO> listar(AluguelVO vo) throws Exception{
		List<AluguelLivroVO> alugueisL = null;
		try {
			ResultSet rs = dao.buscar();
			if (rs.next()) {
				alugueisL = dao.listar(vo);
			} else {
				throw new Exception("Impossível listar, pois não existe aluguel de livro com este id.");
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		return alugueisL;
	}

	@Override
	public void inserir(AluguelLivroVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(AluguelLivroVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(AluguelLivroVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AluguelLivroVO> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
