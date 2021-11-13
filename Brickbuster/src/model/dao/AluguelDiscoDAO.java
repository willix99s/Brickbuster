package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.vo.AluguelDiscoVO;
import model.vo.AluguelVO;

public class AluguelDiscoDAO extends BaseDAO<AluguelDiscoVO> {

	public void inserir(AluguelDiscoVO vo[]) {
		
		try {
			String sql = "insert into aluguelDisco (codAluguel, codDisco) values (?,?)";
			PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			for (int i = 0; i < vo.length; i++) {
			ptst.setInt(1, vo[i].getCodAluguel().getCodAluguel());
			ptst.setInt(2, vo[i].getCodDisco().getCodDisco());
			
			System.out.println(vo.length);
			
			  int affectedRows = ptst.executeUpdate();
				
				if(affectedRows == 0) {
					throw new  SQLException("A inserção falhou. Nenhuma linha foi alterada.");
				}
				ResultSet generatedKeys = ptst.getGeneratedKeys();
				if(generatedKeys.next()) {
					vo[i].setCodAluguelDisco(generatedKeys.getInt(1));
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
	
	public void remover(AluguelDiscoVO vo[]) {
		
		String sql = "delete from aluguelDisco where codAluguelDisco = ?";
		PreparedStatement ptst;
		try {
			for (int i = 0; i < vo.length; i++) {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo[i].getCodAluguelDisco());
			ptst.executeUpdate();
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<AluguelDiscoVO> listar(AluguelVO voAluguel){
		
		String sql = "select * from aluguelDisco where codAluguel = ?";
		PreparedStatement ptst;
		ResultSet rs;
		List<AluguelDiscoVO> alugueisD = new ArrayList<AluguelDiscoVO>();
		try {
			ptst = getConnection().prepareStatement(sql);
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
		
		String sql = "update aluguelDisco set codAluguel = ? where codAluguelDisco = ?";
		PreparedStatement ptst;
		try {
			
			for (int i = 0; i < vo.length; i++) {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo[i].getCodAluguel().getCodAluguel());
			ptst.setInt(2, vo[i].getCodAluguelDisco());
			ptst.executeUpdate();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public ResultSet buscar() throws SQLException {
		String sql = "select * from aluguelDisco";
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
	public void inserir(AluguelDiscoVO vo) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar(AluguelDiscoVO vo) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(AluguelDiscoVO vo) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}

