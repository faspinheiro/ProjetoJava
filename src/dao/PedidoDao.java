package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import conexao.Conexao;
import negocio.Pedido;

public class PedidoDao {
	/*
	private Pedido pedido;
	private String arquivo;
	
	public PedidoDao() {
		
	}
	
	public PedidoDao(Pedido pedido) {
		this();
		this.pedido = pedido;
		this.arquivo = ManagerApp.formatarData(pedido);
	}
	
	
	public boolean incluir() {
		
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter(arquivo, true));
		} catch (IOException e1) {
			e1.printStackTrace();
			return false;
		}

		try {
			out.write(pedido + "\r\n");			
			out.close();			
			new EmpresaDao(pedido.getEmpresa()).incluir();			
			for(Produto prod : pedido.getProduto()) {				
				if(prod instanceof Cadeira) {
					new CadeiraDao((Cadeira)prod).incluir();					
				}else {
					new MesaDao((Mesa)prod).incluir();					
				}
			}
			
			return true;
		}catch (Exception e){
			System.out.println("Excecao");
			return false;
		}
	}	
	
	
	public static Map<Integer, Pedido> TPedido = new HashMap<Integer, Pedido>();
	
	private static Integer key = 1;
	
	public static boolean excluir(int id) {
		Pedido pedido = TPedido.remove(id);
		
		return pedido != null;
	}
	
	public static Pedido incluir(Pedido pedido) {
		
		pedido.setId(key++);
		
		TPedido.put(pedido.getId(), pedido);
		
		return pedido;
	}
	
	public static List<Pedido> obterLista(){
		
		List<Pedido> lista = new ArrayList<Pedido>();
		
		for(Integer k : TPedido.keySet()) {
			lista.add(TPedido.get(k));
		}
		
		return lista;
	}
	

	public static boolean validar(String descricao, String observacao) {
		
		return obterLista().contains(new Pedido(descricao, observacao));
	}*/
	
	private static EntityManager conexao;
	private static EntityTransaction transacao;
	
	public static boolean incluir(Pedido pedido) {
		
		conexao = Conexao.obterConexao();
		
		transacao = conexao.getTransaction();
		
		transacao.begin();
		
		conexao.persist(pedido);
		
		transacao.commit();
		
		return true;
	}

}
