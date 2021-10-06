package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.vo.AluguelLivroVO;
import model.vo.AluguelVO;

public class AluguelLivroDAO extends BaseDAO<AluguelLivroVO> {
	
	public void inserir(AluguelLivroVO vo[]) {
		
		try {
			String sql = "insert into aluguelLivro (codAluguelLivro, codAluguel, codLivro) values (?,?,?)";
			PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			for (int i = 0; i < vo.length; i++) {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo[i].getCodAluguelLivro());
			ptst.setInt(2, vo[i].getCodAluguel().getCodAluguel());
			ptst.setInt(3, vo[i].getCodLivro().getCodLivro());
			ptst.execute();
			
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new  SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if(generatedKeys.next()) {
				vo[i].setCodAluguelLivro(generatedKeys.getInt(1));
			}
			else {
				throw new SQLException("A inserção falhou. Nenhum id foi retornado");
			}		
		}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remover(AluguelLivroVO vo[]) {
		
		String sql = "delete from aluguelLivro where codAluguelLivro = ?";
		PreparedStatement ptst;
		try {
			for (int i = 0; i < vo.length; i++) {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo[i].getCodAluguelLivro());
			ptst.executeUpdate();
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<AluguelLivroVO> listar(AluguelVO voAluguel){
		
		String sql = "select * from aluguelLivro where codAluguel = ?";
		PreparedStatement ptst;
		ResultSet rs;
		List<AluguelLivroVO> alugueisL = new ArrayList<AluguelLivroVO>();
		try {
			ptst = getConnection().prepareStatement(sql);
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
		
		String sql = "update aluguelLivro set codLivro = ? where codAluguelLivro = ?";
		PreparedStatement ptst;
		try {
			
			for (int i = 0; i < vo.length; i++) {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo[i].getCodAluguel().getCodAluguel());
			ptst.setInt(2, vo[i].getCodAluguelLivro());
			ptst.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet buscar() throws SQLException {
		String sql = "select * from aluguelLivro";
		Statement st;
		ResultSet rs = null;

		try {
			st = getConnection().createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public void inserir(AluguelLivroVO vo) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(AluguelLivroVO vo) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(AluguelLivroVO vo) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
}
