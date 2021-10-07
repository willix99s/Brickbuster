package model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.AdminDAO;
import model.vo.AdminVO;

public class AdminBO implements BaseinterBO<AdminVO> {

	AdminDAO dao = new AdminDAO();

	public void inserir(AdminVO vo) throws Exception {
		try {
			ResultSet rs = dao.buscar();
			if (rs.next()) {
				throw new Exception("Erro em inserir, pois esse Admin já existe.");
			} else {
				dao.inserir(vo);
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}

	}

	public void editar(AdminVO vo) throws Exception {
		try {
			ResultSet rs = dao.buscar();
			if (rs.next()) {
				dao.editar(vo);
			} else {
				throw new Exception("Erro em editar, pois esse Admin não existe.");
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}

	}

	public void remover(AdminVO vo) throws Exception {
		try {
			ResultSet rs = dao.buscar();
			if (rs.next()) {
				dao.remover(vo);
			} else {
				throw new Exception("Erro em remover, pois esse Admin não existe.");
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}

	}

	public List<AdminVO> listar() throws Exception {
		List<AdminVO> admins = new ArrayList<AdminVO>();
		try {
			ResultSet rs = dao.buscar();
			while (rs.next()) {
				AdminVO vo = new AdminVO();
				vo.setCodAdmin(rs.getInt("codAdmin"));
				vo.setLogin(rs.getString("login"));
				vo.setNome(rs.getString("nome"));
				vo.setSenha(rs.getString("senha"));
				admins.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return admins;
	}

}
