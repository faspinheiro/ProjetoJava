package negocio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import dao.PedidoDao;

public class ManagerApp {
	
//	/*public static String formatarData(Object objeto) {		
//		LocalDateTime dataAtual = LocalDateTime.now();
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
//		String dataAtualFormatada = dataAtual.format(formatter);		
//		return String.format("%s%s.txt", objeto.getClass().getSimpleName(), dataAtualFormatada);
//	}
//	
//	public static Pedido converte(String arquivo) {
//		Pedido pedido = null;		
//		int linhaAtual = 1;		
//		BufferedReader in = null;
//		try {
//			in = new BufferedReader(new FileReader(arquivo));
//		} catch (FileNotFoundException e1) {
//			e1.printStackTrace();
//		}
//		try {
//			String linha = in.readLine();			
//			String[] campos = null;
//			while(linha != null){
//				campos = linha.split(";");				
//				if(linhaAtual == 1) {
//					pedido = new Pedido(Double.valueOf(campos[0]),campos[1],campos[2],Boolean.valueOf(campos[3]),campos[4],campos[5],Integer.valueOf(campos[6]),campos[7]);
//				}else {
//					if(campos.length == 2) {
//						if(Integer.valueOf(campos[0]) != linhaAtual ||
//						   Integer.valueOf(campos[1]) != pedido.getProduto().size()) {
//							pedido = null;
////						}else {
////							PedidoDao pedidoDao = new PedidoDao(pedido);							
////							sucesso = pedidoDao.incluir();
//						}
//					} else {
//						if("C".equals(campos[0])){
//							pedido.adiciona(new Cadeira(campos[1],campos[2],Float.valueOf(campos[3]),Float.valueOf(campos[4])));						
//						}else {
//							pedido.adiciona(new Mesa(campos[1],campos[2],Float.valueOf(campos[3]), Float.valueOf(campos[4]),Integer.valueOf(campos[5]), Float.valueOf(campos[6])));
//						}					
//					}					
//				}
//				
//				/*if(linhaAtual == Integer.valueOf(campos[0]) && pedido.getProduto().size() == Integer.valueOf(campos[1])) {
//					
//						
//					
//				}*/
//				
//				linha = in.readLine();
//				linhaAtual++;
//			}
//			in.close();			
//			if(pedido != null) {
//				//new PedidoDao(pedido).incluir();
//			}
//			
//		}catch (Exception e){
//			System.out.println(e.toString());
//		}
//				
//		return pedido;
//	}

}
