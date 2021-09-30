package model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.vo.DiscoVO;

public class DiscoDAO extends ProdutoDAO<DiscoVO> {
     
    @Override
    public void inserir(DiscoVO vo) {
		try {
			super.inserir(vo);
			String sql = "insert into livro (banda, estilo, codProduto) values (?,?,?)";
			PreparedStatement ptst;
			ptst = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, vo.getBanda());
			ptst.setString(2, vo.getEstilo());
			ptst.setInt(3, vo.getCodProduto());
			
	                int affectedRows = ptst.executeUpdate();
	                if (affectedRows == 0) {
				throw new SQLException("A inserção falhou. Nenhuma linha foi alterada.");
                        }
                        ResultSet generatedKeys = ptst.getGeneratedKeys();
                        if (generatedKeys.next()) {
                            vo.setCodDisco(generatedKeys.getInt(1));
                        }
                        else {
                                throw new SQLException("A inserção falhou. Nenhuma id foi retornado.");
                        }
                    }
                    catch (SQLException e) {
			e.printStackTrace();
                    }
               }
    @Override
    public void remover(DiscoVO vo) {
		String sql = "delete from disco where codDisco = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sql);
			ptst.setInt(1, vo.getCodDisco());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

   @Override
   public ResultSet buscar() {
		String sql = "select * from disco";
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
    
    public List<DiscoVO> listar() {
		List<DiscoVO> discos = new ArrayList<DiscoVO>();
		
		try {
			 
			 ResultSet rs = buscar();
			 while(rs.next()) {
				 DiscoVO vo = new DiscoVO();
				 vo.setCodDisco(rs.getInt("codDisco"));
				 vo.setTitulo(rs.getString("titulo"));
				 vo.setBanda(rs.getString("banda"));
				 vo.setEstilo(rs.getString("estilo"));
				 vo.setExemplares(rs.getInt("exemplares"));
				 vo.setValorAluguel(rs.getDouble("valorAluguel"));
				 discos.add(vo);
			 }
                } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return discos;
}
   public ResultSet pesquisarPorTitulo(DiscoVO vo) {
	
		String sql = "select * from Disco where titulo = ?";
				PreparedStatement ptst;
				ResultSet rs = null;	
		 		try {
					ptst = getConnection().prepareStatement(sql);
					ptst.setString(1, vo.getTitulo());
					rs = ptst.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rs;
			}
     
   public ResultSet pesquisarPorBanda(DiscoVO vo) {
		
		String sql = "select * from Disco where banda = ?";
				PreparedStatement ptst;
				ResultSet rs = null;
		 		try {
					ptst = getConnection().prepareStatement(sql);
					ptst.setString(1, vo.getBanda());
					rs = ptst.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rs;
			}

   public ResultSet pesquisarPorEstilo(DiscoVO vo) {
		
		String sql = "select * from Disco where estilo = ?";
				PreparedStatement ptst;
				ResultSet rs = null;	
		 		try {
					ptst = getConnection().prepareStatement(sql);
					ptst.setString(1, vo.getEstilo());
					rs = ptst.executeQuery();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return rs;
			}

   public void editar(DiscoVO vo) {
			
			String sql = "update Disco set titulo = ?, banda = ?, estilo = ?, exemplares = ?, valorAluguel = ? where codDisco = ?";
			PreparedStatement ptst;
			try {
				ptst = getConnection().prepareStatement(sql);
				ptst.setString(1, vo.getTitulo());
				ptst.setString(2, vo.getBanda());
				ptst.setString(3, vo.getEstilo());
				ptst.setInt(4, vo.getExemplares());
				ptst.setDouble(5, vo.getValorAluguel());			
				ptst.setInt(6, vo.getCodDisco());
				ptst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}