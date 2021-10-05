package model.bo;

import java.sql.ResultSet;

public interface BaseinterBO <VO> {
	public void inserir(VO vo) throws Exception;
	public void editar(VO vo) throws Exception;
	public void remover(VO vo) throws Exception;
	public ResultSet buscar() throws Exception;
}
