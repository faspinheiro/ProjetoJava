package testes;

import negocio.Empresa;

public class EmpresaTestes {
	
	public static void main(String[] args) {
		
		Empresa empresa = new Empresa();
		empresa.setEmail("empresa@empresa.com");
		empresa.setEndereco("Rua 1");
		//empresa.setNumEndereco(10);
		empresa.exibir();
		
	}
}
