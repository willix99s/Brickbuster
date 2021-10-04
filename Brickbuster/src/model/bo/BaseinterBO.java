package model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BaseinterBO <VO> {
	public void inserir(VO vo);
	public void editar(VO vo) throws SQLException;
	public void remover(VO vo) throws SQLException;
	public ResultSet buscar() throws SQLException;
}
