package negocio;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import modelo.Produto;

@Entity
@Table(name = "TMesa")
@PrimaryKeyJoinColumn(name = "idProduto")
public class Mesa extends Produto{

	private float altura;
	private int lugares;
	private float largura;
	
	public Mesa() {
		
	}
	
	public Mesa(String fabricante, String modelo, float preco, float altura, int lugares, float largura) {
		super(fabricante, modelo, preco);
		this.altura = altura;
		this.lugares = lugares;
		this.largura = largura;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public int getLugares() {
		return lugares;
	}

	public void setLugares(int lugares) {
		this.lugares = lugares;
	}



	public float getLargura() {
		return largura;
	}



	public void setLargura(float largura) {
		this.largura = largura;
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
		return String.format("%s - %s - %.2f - %.2f - %d - R$ %.2f",
				this.getModelo(),
				this.getFabricante(),				
				this.getAltura(),
				this.getLargura(),
				this.getLugares(),
				this.getPreco());
	}

}
