package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.vo.AluguelLivroVO;
import model.vo.AluguelVO;

public class AluguelLivroDAO extends BaseDAO {
	
	public void inserir(AluguelLivroVO vo[]) {
		
		conn = getConnection();
		String sql = "insert into aluguelLivro (codAluguelLivro, codAluguel, codLivro) values (?,?,?)";
		PreparedStatement ptst;
		try {
			
			for (int i = 0; i < vo.length; i++) {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, vo[i].getCodAluguelLivro());
			ptst.setInt(2, vo[i].getCodAluguel().getCodAluguel());
			ptst.setInt(3, vo[i].getCodLivro().getCodLivro());
			ptst.execute();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remover(AluguelLivroVO vo[]) {
		conn = getConnection();
		String sql = "delete from aluguelLivro where codAluguelLivro = ?";
		PreparedStatement ptst;
		try {
			for (int i = 0; i < vo.length; i++) {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, vo[i].getCodAluguelLivro());
			ptst.executeUpdate();
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public List<AluguelLivroVO> listar(AluguelVO voAluguel){
		conn = getConnection();
		String sql = "select * from aluguelLivro where codAluguel = ?";
		PreparedStatement ptst;
		ResultSet rs;
		List<AluguelLivroVO> alugueisL = new ArrayList<AluguelLivroVO>();
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, voAluguel.getCodAluguel());
			
			rs = ptst.executeQuery(sql);
			while(rs.next()) {
				AluguelLivroVO vo = new AluguelLivroVO();
				
				vo.setCodAluguelLivro(rs.getInt("codAluguelLivro"));
				vo.getCodAluguel().setCodAluguel(rs.getInt("codAluguel"));
				vo.getCodLivro().setCodLivro(rs.getInt("codLivro"));
				alugueisL.add(vo);
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alugueisL;
	}
	
	public void editar(AluguelLivroVO vo[]) {
		conn = getConnection();
		String sql = "update aluguelLivro set codLivro = ? where codAluguelLivro = ?";
		PreparedStatement ptst;
		try {
			
			for (int i = 0; i < vo.length; i++) {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, vo[i].getCodAluguel().getCodAluguel());
			ptst.setInt(2, vo[i].getCodAluguelLivro());
			ptst.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

	
}
