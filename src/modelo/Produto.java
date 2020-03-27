package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import negocio.Pedido;

@Entity
@Table(name = "TProduto")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Produto implements IExibido{	
	
	@Id
	@GeneratedValue
	private Integer id;
	private String fabricante;
	private String modelo;
	private float preco;	
	@ManyToOne
	@JoinColumn(name = "idPedido")
	private Pedido pedido;
	
	protected static int qtde;
	
	public Produto() {
		
	}
	
	public Produto(String fabricante, String modelo, float preco) {		
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.preco = preco;
		
		qtde++;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public static int obterQtdeProduto() {
		return qtde;		
	}
	
	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public abstract String obterCabecalho();
}
