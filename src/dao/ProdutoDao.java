package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import conexao.Conexao;
import modelo.Produto;

public class ProdutoDao {
		
	private static EntityManager conexao;
	private static EntityTransaction transacao;
	
	public static boolean incluir(Produto produto) {
		
		conexao = Conexao.obterConexao();
		
		transacao = conexao.getTransaction();
		
		transacao.begin();
		
		conexao.persist(produto);
		
		transacao.commit();
		
		return true;
	}

}
