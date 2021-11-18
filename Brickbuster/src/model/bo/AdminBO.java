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
				throw new Exception("Erro em inserir, pois esse Admin j� existe.");
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
				throw new Exception("Erro em editar, pois esse Admin n�o existe.");
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
				throw new Exception("Erro em remover, pois esse Admin n�o existe.");
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
	
	public AdminVO autenticar(AdminVO vo) throws Exception {
		ResultSet rs = dao.buscarPorLogin(vo);
		try {
			if (rs.next()) {
				System.out.println(rs.getString("login"));
				if(rs.getString("login").equals(vo.getLogin())) {
					
					if(rs.getString("senha").equals(vo.getSenha())) {	
						
						AdminVO adm = new AdminVO();
						adm.setCodAdmin(rs.getInt("codAdmin"));
						
							adm.setCodAdmin(vo.getCodAdmin());
							adm.setLogin(vo.getLogin());
							adm.setNome(vo.getNome());
							adm.setSenha(vo.getSenha());
							
							System.out.println("Logado com sucesso.");
							
							return adm;
					} else {
						throw new Exception("Erro em autenticar, pois esse Admin n�o existe.");
					}
				} else {
					throw new Exception("Erro em autenticar, pois esse Admin n�o existe.");
				}
			} else {
				throw new Exception("Erro em autenticar, pois esse Admin n�o existe.");
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
	}

}
