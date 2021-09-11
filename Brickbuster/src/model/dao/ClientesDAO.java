package model.dao;
import model.vo.ClientesVO;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientesDAO extends BaseDAO {

	public void inserir(ClientesVO vo) 
	{
		conn = getConnection();
		String sql = "insert into clientesdao (nome, endereço, cpf) values (?,?,?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setString(2, vo.getEndereco());
			ptst.setString(3, vo.getCpf());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
