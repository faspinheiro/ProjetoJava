package negocio;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import modelo.Produto;

@Entity
@Table(name = "TCadeira")
@PrimaryKeyJoinColumn(name = "idProduto")
public class Cadeira extends Produto{

	private float altura;
	//@Transient //Campo que não quero usar @Transient
	//private Pedido pedido;
	
	public Cadeira() {
		
	}
	
	public Cadeira(String fabricante, String modelo, float preco, float altura) {
		super(fabricante, modelo, preco);		
		this.altura = altura;
	}	

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}
	
	@Override
	public String obterCabecalho() {
		return Cadeira.class.getSimpleName();
	}

	public void exibir() {
		System.out.println(this);
		
	}
	
	@Override
	public String toString() {
		
		return String.format("%s - %s - %.2f - R$ %.2f",
				this.getModelo(),
				this.getFabricante(),				
				this.getAltura(),				
				this.getPreco());
	}

}
