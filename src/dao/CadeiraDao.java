package dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import modelo.ICadastro;
import negocio.Cadeira;
import negocio.ManagerApp;


public class CadeiraDao implements ICadastro{
	
	private Cadeira cadeira;
	private String arquivo;
	
	public CadeiraDao() {
		
	}
	
	public CadeiraDao(Cadeira cadeira) {
		this();
		this.cadeira = cadeira;
		//this.arquivo = ManagerApp.formatarData(cadeira);
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
			out.write(cadeira + "\r\n");
			
			out.close();
			return true;
		}catch (Exception e){
			System.out.println("Excecao");
			return false;
		}
	}	

}
