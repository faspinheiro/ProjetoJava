package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PedidoDao;
import negocio.Pedido;

public class PedidoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public PedidoController() {
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Pedido pedido = new Pedido();
		pedido.setDescricao(request.getParameter("descricao"));
		pedido.setObservacao(request.getParameter("observacao"));
		pedido.setValor(Double.parseDouble(request.getParameter("valor")));
		pedido.setEntregue("Entregue".equals(request.getParameter("entregue")));
		
		if(PedidoDao.incluir(pedido)) {
			request.getRequestDispatcher("pedidoLista.jsp").
				forward(request, response);
		} else {
			System.out.println("Não foi!");
		}	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
