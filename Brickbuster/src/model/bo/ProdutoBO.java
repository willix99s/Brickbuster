package model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.dao.ProdutoDAO;
import model.vo.ProdutoVO;

public class ProdutoBO implements BaseinterBO<ProdutoVO>{
	ProdutoDAO<ProdutoVO> dao = new ProdutoDAO<ProdutoVO>();
	
	@Override
	public void inserir(ProdutoVO vo) throws Exception {
		try {
			ResultSet rs = dao.pesquisarPorTitulo(vo);
			if(rs.next()) {
				throw new Exception("Imposs�vel inserir, pois j� existe produto com este t�tulo.");
			}
			else {
				dao.inserir(vo);
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	public void editar(ProdutoVO vo) throws Exception {
		try {
			ResultSet rs = dao.pesquisarPorTitulo(vo);
			if(rs.next()) {
				dao.editar(vo);
			}
			else {
				throw new Exception("Imposs�vel editar, pois n�o existe produto com este t�tulo.");
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	public void remover(ProdutoVO vo) throws Exception {
		try {
			ResultSet rs = dao.pesquisarPorTitulo(vo);
			if(rs.next()) {
				dao.remover(vo);
			}
			else {
				throw new Exception("Imposs�vel remover, pois n�o existe produto com este t�tulo.");
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<ProdutoVO> listar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
