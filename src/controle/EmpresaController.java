package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmpresaDao;
import dao.PedidoDao;
import dao.UsuarioDao;
import negocio.Empresa;
import negocio.Pedido;

/**
 * Servlet implementation class EmpresaController
 */
public class EmpresaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpresaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.obterLista(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Empresa empresa = new Empresa();
		empresa.setNome(request.getParameter("nome"));
		empresa.setEndereco(request.getParameter("endereco"));
		empresa.setNacional(Boolean.valueOf(request.getParameter("nacional")));
		empresa.setEmail(request.getParameter("email"));
		
		if(EmpresaDao.incluir(empresa)) {
			this.obterLista(request, response);

		} else {
			System.out.println("Não foi!");
		}		
	}
	
	
	private void obterLista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			request.setAttribute("empresas", EmpresaDao.obterLista());
			
			request.getRequestDispatcher("empresaLista.jsp").forward(request, response);
	}

}
