package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.vo.AluguelDiscoVO;
import model.vo.AluguelVO;

public class AluguelDiscoDAO extends BaseDAO {

	public void inserir(AluguelDiscoVO vo[]) {
		
		conn = getConnection();
		String sql = "insert into aluguelDisco (codAluguelDisco, codAluguel, codDisco) values (?,?,?)";
		PreparedStatement ptst;
		try {
			
			for (int i = 0; i < vo.length; i++) {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, vo[i].getCodAluguelDisco());
			ptst.setInt(2, vo[i].getCodAluguel().getCodAluguel());
			ptst.setInt(3, vo[i].getCodDisco().getCodDisco());
			ptst.execute();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remover(AluguelDiscoVO vo[]) {
		conn = getConnection();
		String sql = "delete from aluguelDisco where codAluguelDisco = ?";
		PreparedStatement ptst;
		try {
			for (int i = 0; i < vo.length; i++) {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, vo[i].getCodAluguelDisco());
			ptst.executeUpdate();
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<AluguelDiscoVO> listar(AluguelVO voAluguel){
		conn = getConnection();
		String sql = "select * from aluguelDisco where codAluguel = ?";
		PreparedStatement ptst;
		ResultSet rs;
		List<AluguelDiscoVO> alugueisD = new ArrayList<AluguelDiscoVO>();
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, voAluguel.getCodAluguel());

			rs = ptst.executeQuery(sql);
			while(rs.next()) {
				AluguelDiscoVO vo = new AluguelDiscoVO();
				
				vo.setCodAluguelDisco(rs.getInt("codAluguelDisco"));
				vo.getCodAluguel().setCodAluguel(rs.getInt("codAluguel"));
				vo.getCodDisco().setCodDisco(rs.getInt("codDisco"));
				alugueisD.add(vo);
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alugueisD;
	}
	
	
	public void editar(AluguelDiscoVO vo[]) {
		conn = getConnection();
		String sql = "update aluguelDisco set codAluguel = ? where codAluguelDisco = ?";
		PreparedStatement ptst;
		try {
			
			for (int i = 0; i < vo.length; i++) {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, vo[i].getCodAluguel().getCodAluguel());
			ptst.setInt(2, vo[i].getCodAluguelDisco());
			ptst.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
	

