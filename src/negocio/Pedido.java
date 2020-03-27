package negocio;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import auxiliar.Constante;
import modelo.IExibido;
import modelo.Produto;


@Entity
@Table(name = "TPedido")
public class Pedido implements IExibido {
	
	@Id
	@GeneratedValue
	private Integer id;
	private boolean entregue;
	private double valor;
	private String observacao;
	private String descricao;
	@OneToMany(
			mappedBy = "pedido",
			fetch = FetchType.EAGER,
			cascade = CascadeType.PERSIST
			)	
	private List<Produto> produtos;
	@OneToOne(
			fetch = FetchType.EAGER,
			cascade = CascadeType.PERSIST
			)
	@JoinColumn(name = "idEmpresa")
	private Empresa empresa;
	private int[] qtdeProdutos;	
	
	public Pedido() {		
		produtos = new ArrayList<Produto>();
	}
	
	public Pedido(Integer id, String descricao, String observacao, double valor, boolean entregue) {		
		this(descricao, observacao);
		this.id = id;
		this.valor = valor;		
		this.entregue = entregue;
	}
	
	
	public Pedido(Integer id, double valor, String observacao, String descricao, boolean entregue, Integer idEmpresa, String nome, String endereco, boolean nacional, String email) {
		this(id, descricao, observacao, valor, entregue);			
		this.empresa = new Empresa(idEmpresa, nome, endereco, nacional, email);
	}
	
	public Pedido(String descricao, String observacao) {
		this.observacao = observacao;
		this.descricao = descricao;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public boolean isEntregue() {
		return entregue;
	}

	public void setEntregue(boolean entregue) {
		this.entregue = entregue;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public Empresa getEmpresa() {
		return this.empresa;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Produto> getProduto() {
		return produtos;
	}

	public void adiciona(Produto produto) {
		produtos.add(produto);
	}
	
	private void showProdutos() {
		for(Produto item : this.produtos) {
			this.contabiliza(item);
			item.exibir();			
		}
	}
	
	private void showContabiliza() {
		System.err.println("Contabiliza: ");
		for(int i = 0; i < this.qtdeProdutos.length; i++) {
			System.err.println("-" + 
					   Constante.PRODUTOS[i] + ": " +
					   this.qtdeProdutos[i]);
		}		
	}
	

	@Override
	public String toString() {		
		return String.format("Pedido: %s - %.2f - %s",
				this.getObservacao(),
				this.getValor(),
				this.isEntregue() ? "Entregue" : "A caminho"); 
	}
	
	public void exibir() {
		if(validar()) {
			this.qtdeProdutos = new int[Constante.PRODUTOS.length];					
			System.out.println(this);		
			empresa.exibir();			
		}else {
			System.err.println("Inválido");
		}		
	}
	
	
	private boolean validar() {
		return this.getProduto().size() == Produto.obterQtdeProduto();
	}
	
	private void contabiliza(Produto produto){
		if(produto instanceof Produto) {
			this.qtdeProdutos[0]++;
		}else if(produto instanceof Produto){
			this.qtdeProdutos[1]++;
		}
	}
	
	public void associa(Empresa empresa){
		this.empresa = empresa;		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((observacao == null) ? 0 : observacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (observacao == null) {
			if (other.observacao != null)
				return false;
		} else if (!observacao.equals(other.observacao))
			return false;
		return true;
	}
	
}
