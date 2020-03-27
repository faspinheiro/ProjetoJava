package dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import modelo.ICadastro;
import negocio.ManagerApp;
import negocio.Mesa;

public class MesaDao implements ICadastro {
	
	private Mesa mesa;
	private String arquivo;
	
	public MesaDao() {
		
	}
	
	public MesaDao(Mesa mesa) {
		this();
		this.mesa = mesa;
		//this.arquivo = ManagerApp.formatarData(mesa);
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
			out.write(mesa + "\r\n");
			
			out.close();
			return true;
		}catch (Exception e){
			System.out.println("Excecao");
			return false;
		}
	}	

}
