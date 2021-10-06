package model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.dao.DiscoDAO;
import model.vo.DiscoVO;

public class DiscoBO implements BaseinterBO<DiscoVO>{
	DiscoDAO dao = new DiscoDAO();

	@Override
	public void inserir(DiscoVO vo) throws Exception {
		try {
			ResultSet rs = dao.pesquisarPorTitulo(vo);
			if (rs.next()) {
				throw new Exception("Impossível inserir, pois já existe Disco com este título.");
			}   else {
				dao.inserir(vo);
		    }
		    }
			catch (SQLException e) {
				throw new Exception(e.getMessage());
			}
	}

	@Override
	public void editar(DiscoVO vo) throws Exception {
		try {
			ResultSet rs = dao.pesquisarPorTitulo(vo);
			if (rs.next()) {
				dao.editar(vo);
			} else {
				throw new Exception("Impossível editar, pois não existe Disco com este título.");
			}
		    }   
		    catch (SQLException e) {
			throw new Exception(e.getMessage());
		    }
	}

	@Override
	public void remover(DiscoVO vo) throws Exception {
		try {
			ResultSet rs = dao.pesquisarPorTitulo(vo);
			if (rs.next()) {
				dao.remover(vo);
			} else {
				throw new Exception("Impossível remover, pois não existe Disco com este título.");
			}
		    } 
		    catch (SQLException e) {
			throw new Exception(e.getMessage());
		    }
	 }
		
	
	
	public List<DiscoVO> listar() throws Exception {
		List<DiscoVO> discos = new ArrayList<DiscoVO>();
		try {
			 
			 ResultSet rs = dao.buscar();
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
			
			e.printStackTrace();
		}
		return discos;
	  }
    
     public List<DiscoVO> pesquisarPorTitulo(DiscoVO disc) throws Exception {
    	 List<DiscoVO> discos = new ArrayList<DiscoVO>();
    	 
         try {
			 ResultSet rs = dao.pesquisarPorTitulo(disc);
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
			
			e.printStackTrace();
		}
		return discos;
     }

      public List<DiscoVO> pesquisarPorBanda(DiscoVO disc) throws Exception {
           List<DiscoVO> discos = new ArrayList<DiscoVO>();
           
           try {
  			 ResultSet rs = dao.pesquisarPorBanda(disc);
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
  			
  			e.printStackTrace();
  		}
  		return discos;
       }
           
      public List<DiscoVO> pesquisarPorEstilo(DiscoVO disc) throws Exception {
          List<DiscoVO> discos = new ArrayList<DiscoVO>();
          
          try {
   			 ResultSet rs = dao.pesquisarPorEstilo(disc);
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
   			
   			e.printStackTrace();
   		}
   		return discos;
        }
}
      
          

      
