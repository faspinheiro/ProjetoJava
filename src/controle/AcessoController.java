package controle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PedidoDao;
import dao.UsuarioDao;

public class AcessoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AcessoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		if(UsuarioDao.validar(email, senha)) {
			request.getRequestDispatcher("empresaDetalhe.html").
				forward(request, response);
		} else {			
			request.setAttribute("validacao", false);
			
			request.getRequestDispatcher("login.jsp").
				forward(request, response);			
		}		
	}
}