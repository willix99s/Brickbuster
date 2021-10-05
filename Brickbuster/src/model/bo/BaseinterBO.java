package model.bo;

import java.util.List;


public interface BaseinterBO <VO> {
	public void inserir(VO vo) throws Exception;
	public void editar(VO vo) throws Exception;
	public void remover(VO vo) throws Exception;
	public List<VO> listar() throws Exception;
}
