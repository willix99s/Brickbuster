package model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.dao.ProdutoDAO;
import model.vo.ProdutoVO;

public class ProdutoBO implements BaseinterBO<ProdutoVO>{
	ProdutoDAO<ProdutoVO> dao = new ProdutoDAO<ProdutoVO>();
	
	@Override
	public void inserir(ProdutoVO vo) throws Exception {
		try {
			ResultSet rs = dao.pesquisarPorTitulo(vo);
			if(rs.next()) {
				throw new Exception("Impossível inserir, pois já existe produto com este título.");
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
				throw new Exception("Impossível editar, pois não existe produto com este título.");
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
				throw new Exception("Impossível remover, pois não existe produto com este título.");
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Override
	public ResultSet buscar() throws Exception {
		try {
			ResultSet rs = dao.buscar();
			if(rs.next()) {
				dao.buscar();
			}
			else {
				throw new Exception("Impossível listar, pois não existem produtos cadastrados.");
			}
		}
		catch(SQLException e) {
			throw new Exception(e.getMessage());
		}
		return null;
	}
	
}
