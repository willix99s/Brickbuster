package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.vo.AluguelDiscoVO;
import model.vo.AluguelLivroVO;
import model.vo.AluguelVO;

public class AluguelDAO extends BaseDAO {
	

	public void inserir(AluguelVO vo) {
		
		conn = getConnection();
		String sql = "insert into aluguel (codAluguel, codNomeCliente, dataInicio, dataFinal, valorAluguel) values (?,?,?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, vo.getCodAluguel());
			ptst.setInt(2, vo.getCodNomeCliente().getCodClientes());
			ptst.setDate(3, new java.sql.Date(vo.getDataInicio().getTime().getTime()));
			ptst.setDate(4, new java.sql.Date(vo.getDataFinal().getTime().getTime()));
			ptst.setDouble(5, vo.getValorAluguel());
			ptst.execute();
			
			AluguelDiscoDAO dao = new AluguelDiscoDAO();
			dao.inserir(vo.getDisco());
			
			AluguelLivroDAO dao2 = new AluguelLivroDAO();
			dao2.inserir(vo.getLivro());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
	
	
	public void remover(AluguelVO vo) {
		conn = getConnection();
		String sql = "delete from aluguel where codAluguel = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
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
	
	
	public List<AluguelVO> listar(){
		conn = getConnection();
		String sql = "select * from aluguel";
		Statement st;
		ResultSet rs;
		List<AluguelVO> alugueis = new ArrayList<AluguelVO>();
		List<AluguelLivroVO> livros = new ArrayList<AluguelLivroVO>();
		List<AluguelDiscoVO> discos = new ArrayList<AluguelDiscoVO>();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				Calendar calendar = Calendar.getInstance();
				Calendar calendar2 = Calendar.getInstance();
						
				AluguelVO vo = new AluguelVO();
				vo.setCodAluguel(rs.getInt("codAluguel"));
				vo.getCodNomeCliente().setCodClientes(rs.getInt("codNomeCliente"));
				calendar.setTime(rs.getDate("dataInicio"));
				vo.setDataInicio(calendar);
				calendar.setTime(rs.getDate("dataFinal"));
				vo.setDataFinal(calendar2);
				vo.setValorAluguel(rs.getDouble("valorAluguel"));
				alugueis.add(vo);
				
				AluguelDiscoDAO dao = new AluguelDiscoDAO();
				discos = dao.listar(vo);
				vo.setDisco(discos.toArray(new AluguelDiscoVO[discos.size()]));
				
				AluguelLivroDAO dao2 = new AluguelLivroDAO();
				livros = dao2.listar(vo);
				vo.setLivro(livros.toArray(new AluguelLivroVO[livros.size()]));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alugueis;
	}
	
	
	public void editar(AluguelVO vo) {
		conn = getConnection();
		String sql = "update aluguel set  codNomeCliente = ? where codAluguel = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setInt(1, vo.getCodNomeCliente().getCodClientes());
			ptst.setInt(2, vo.getCodAluguel());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	}
		
	
