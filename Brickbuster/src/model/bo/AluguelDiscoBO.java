package model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.dao.AluguelDiscoDAO;
import model.vo.AluguelDiscoVO;
import model.vo.AluguelVO;

public class AluguelDiscoBO implements BaseinterBO<AluguelDiscoVO> {
	AluguelDiscoDAO dao = new AluguelDiscoDAO();

	@Override
	public void inserir(AluguelDiscoVO vo) throws Exception {
		try {
			ResultSet rs = dao.buscar();
			if (rs.next()) {
				throw new Exception("Imposs�vel inserir, pois j� existe aluguel de Disco com este id.");
			} else {
				dao.inserir(vo);
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	
	@Override
	public void editar(AluguelDiscoVO vo) throws Exception {
		try {
			ResultSet rs = dao.buscar();
			if (rs.next()) {
				dao.editar(vo);
			} else {
				throw new Exception("Imposs�vel editar, pois n�o existe aluguel de Disco com este id.");
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	

	@Override
	public void remover(AluguelDiscoVO vo) throws Exception {
		try {
			ResultSet rs = dao.buscar();
			if (rs.next()) {
				dao.remover(vo);
			} else {
				throw new Exception("Imposs�vel remover, pois n�o existe aluguel de Disco com este id.");
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
		

	public List<AluguelDiscoVO> listar(AluguelVO vo) throws Exception {
		List<AluguelDiscoVO> alugueldisc = null;
		try {
			ResultSet rs = dao.buscar();
			if(rs.next()) {
				alugueldisc = dao.listar(vo);
			}
			else {
				throw new Exception("Imposs�vel listar, pois n�o existem registros de alugu�is de livros.");
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
		return alugueldisc;
	}


	@Override
	public List<AluguelDiscoVO> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	}


