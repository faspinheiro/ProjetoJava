package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
	private static Connection conn = null;
	
	public static Connection obterConexao(String connection){

		if (conn == null){

			String serverName = "localhost";			
			String bancoDados = "dbInfnet";      				
			String url = "jdbc:mysql://" + serverName + "/" + bancoDados + "?useTimezone=true&serverTimezone=UTC";				
			String usuario = "root";              				
			String senha = "senha";

			try {
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				conn = DriverManager.getConnection(url,usuario, senha);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return conn;
	}
	
	private static EntityManager em = null;

	public static EntityManager obterConexao() {
		
		if (em == null){
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("infnetPU");
			
		    em = factory.createEntityManager();			
		}
	    return em;
    } 	

	
}
