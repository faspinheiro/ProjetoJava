package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import negocio.Pedido;
import negocio.Usuario;

public class UsuarioDao {
	
	public static Map<Integer, Usuario> TUsuario = new HashMap<Integer, Usuario>(){{
		put(0, new Usuario("Administrador", "admin@admin.com", "admin"));
	}};
	
	private static Integer key = 1;
	
	public static boolean excluir(int id) {
		Usuario usuario = TUsuario.remove(id);
		
		return usuario != null;
	}
	
	public static Usuario incluir(Usuario usuario) {
		
		usuario.setId(key++);
		
		TUsuario.put(usuario.getId(), usuario);
		
		return usuario;
	}
	
	public static List<Usuario> obterLista(){
		
		List<Usuario> lista = new ArrayList<Usuario>();
		
		for(Integer k : TUsuario.keySet()) {
			lista.add(TUsuario.get(k));
		}
		
		return lista;
	}
	

	public static boolean validar(String email, String senha) {
		
		return obterLista().contains(new Usuario(email, senha));
	}

}
