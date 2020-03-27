package testes;

import dao.PedidoDao;
import negocio.Cadeira;
import negocio.Empresa;
import negocio.Mesa;
import negocio.Pedido;

public class PedidoTestes {
	
	public static void main(String[] args) {
		
		Empresa empresa = new Empresa();
		empresa.setNome("Empresa 1");
		
		Pedido pedido = new Pedido();
		pedido.setDescricao("Pedido 1");
		
		pedido.associa(empresa);
		
		Cadeira cadeira = new Cadeira();
		cadeira.setModelo("cadeira 1");
		cadeira.setPedido(pedido);
		
		Mesa mesa = new Mesa();
		mesa.setModelo("Mesa 1");
		mesa.setPedido(pedido);
		
		pedido.adiciona(cadeira);
		pedido.adiciona(mesa);
		
		PedidoDao.incluir(pedido);
		
		System.out.println(pedido);		
		
	}
}
