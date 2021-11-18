package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseDAO<VO> implements BaseInterDAO<VO> {
	private static Connection conn = null;
	private static final String url = "jdbc:postgresql://localhost:5432/brickbuster";
	private static final String user = "postgres";
	private static final String senha = "12345";
	
	public static Connection getConnection()
	{
		if(conn == null)
		{
			try {
				conn = DriverManager.getConnection(url, user, senha);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
		else return conn;
	}
	
	public static void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public abstract void inserir(VO vo) throws SQLException;
	public abstract void editar(VO vo) throws SQLException;
	public abstract void remover(VO vo) throws SQLException;
	public abstract ResultSet buscar() throws SQLException;
	
}