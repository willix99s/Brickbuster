package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.vo.AluguelVO;

public class AluguelDAO extends BaseDAO<AluguelVO> {
	
	public void inserir(AluguelVO vo) {

		try {
			String sql = "insert into aluguel (codNomeCliente, dataInicio, dataFinal, valorAluguel) values (?,?,?,?)";
			PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setInt(1, vo.getCodNomeCliente().getCodClientes());
			ptst.setDate(2, new java.sql.Date(vo.getDataInicio().getTime().getTime()));
			ptst.setDate(3, new java.sql.Date(vo.getDataFinal().getTime().getTime()));
			ptst.setDouble(4, vo.getValorAluguel());
			int affectedRows = ptst.executeUpdate();
			
			if(affectedRows == 0) {
				throw new  SQLException("A inserção falhou. Nenhuma linha foi alterada.");
			}
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			if(generatedKeys.next()) {
				vo.setCodAluguel(generatedKeys.getInt(1));
			}
			else {
				throw new SQLException("A inserção falhou. Nenhum id foi retornado");
			}
			
			AluguelDiscoDAO dao = new AluguelDiscoDAO();
			System.out.println(vo.getLivro()[0].getCodAluguel().getCodAluguel());
			System.out.println(vo.getLivro()[0].getCodAluguelLivro());
			System.out.println(vo.getLivro()[0].getCodLivro());
			System.out.println(vo.getLivro().length);
			dao.inserir(vo.getDisco());
			
			AluguelLivroDAO dao2 = new AluguelLivroDAO();
			dao2.inserir(vo.getLivro());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
	
	
	public void remover(AluguelVO vo) {
		String sql = "delete from aluguel where codAluguel = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getCodAluguel());
			ptst.executeUpdate();
			
			AluguelDiscoDAO dao = new AluguelDiscoDAO();
			dao.remover(vo.getDisco());
			
			AluguelLivroDAO dao2 = new AluguelLivroDAO();
			dao2.remover(vo.getLivro());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public ResultSet buscar() 
	{
		String sql = "select * from aluguel";
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
	
	
	
	public void editar(AluguelVO vo) {
		String sql = "update aluguel set codNomeCliente = ? where codAluguel = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getCodNomeCliente().getCodClientes());
			ptst.setInt(2, vo.getCodAluguel());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	}
		
	
