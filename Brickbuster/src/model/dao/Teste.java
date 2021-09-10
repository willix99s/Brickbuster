package model.dao;

import model.vo.ClientesVO;

public class Teste {

	public static void main(String[] args) {
		BaseDAO dao = new BaseDAO();
		System.out.println(dao.getConnection());
		ClientesDAO daodois = new ClientesDAO();
		
		ClientesVO vo = new ClientesVO();
		vo.setCpf("123.123.123-12");
		vo.setEndereco("Rua Lagos, numero 8");
		vo.setNome("Matheus Queiroz");
		daodois.inserir(vo);
	}

}
