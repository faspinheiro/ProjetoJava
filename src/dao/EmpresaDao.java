package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import conexao.Conexao;
import modelo.ICadastro;
import negocio.Empresa;

public class EmpresaDao implements ICadastro{

	/*private static Empresa empresa;
	private static String arquivo;*/
	
	private static EntityManager conexao;
	private static EntityTransaction transacao;
	
	public EmpresaDao() {
		
	}

	public boolean incluir() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static boolean incluir(Empresa empresa) {
		
			/*try {
				PreparedStatement ps = 
					Conexao.obterConexao("fd").prepareStatement(
						"INSERT into tempresa "
						+ "(nome, endereco, nacional, email) "
						+ "values (?,?,?,?)"
					);

				ps.setString(1, empresa.getNome());
				ps.setString(2, empresa.getEndereco());
				ps.setBoolean(3, empresa.getNacional());
				ps.setString(4, empresa.getEmail());
				
				ps.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}*/
		
			conexao = Conexao.obterConexao();
			
			transacao = conexao.getTransaction();
			
			transacao.begin();
			
			conexao.persist(empresa);
			
			transacao.commit();
			
			return empresa != null;
		}
	
	
	public static List<Empresa> obterLista() {
			
			List<Empresa> lista = new ArrayList<Empresa>();
		
			try {
				
				PreparedStatement ps = 
						Conexao.obterConexao("").prepareStatement(
								"SELECT * FROM tempresa"
						);
				
				ResultSet rs = ps.executeQuery();				
				
				while(rs.next()) {
					lista.add(new Empresa(
							rs.getInt("id"),
							rs.getString("nome"),
							rs.getString("endereco"),
							rs.getBoolean("nacional"),
							rs.getString("email")
							)
						);	
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return lista;
	}
	
	
//	public EmpresaDao(Empresa empresa) {
//		this();
//		this.empresa = empresa;
//		this.arquivo = ManagerApp.formatarData(empresa);
//	}
//	
//	
//	public static boolean incluir(Empresa empresa2) {
//		
//		BufferedWriter out = null;
//		try {
//			out = new BufferedWriter(new FileWriter(arquivo, true));
//		} catch (IOException e1) {
//			e1.printStackTrace();
//			return false;
//		}
//
//		try {
//			out.write(empresa + "\r\n");
//			
//			out.close();
//			return true;
//		}catch (Exception e){
//			System.out.println("Excecao");
//			return false;
//		}
//	}
//
//	public boolean incluir() {
//		// TODO Auto-generated method stub
//		return false;
//	}	
	
}
