package negocio;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import auxiliar.Constante;
import modelo.IExibido;

@Entity
@Table(name = "TEmpresa")
public class Empresa implements IExibido {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String nome;
	private String endereco;
	private boolean nacional;
	private String email;
		
	public Empresa() {
		
	}	
	
	public Empresa(Integer id, String nome, String endereco, boolean nacional, String email) {
		this();
		this.nome = nome;
		this.endereco = endereco;
		this.nacional = nacional;
		this.email = email;
		this.id = id;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setNacional(boolean nacional) {
		this.nacional = nacional;
	}
	
	public boolean getNacional() {
		return nacional;
	}

	@Override
	public String toString() {		
		return String.format("Empresa: %s - %s - %s - %s",
				this.getNome(),
				this.getEmail(),
				this.getEndereco(),
				this.getNacional()?"Nacional":"Estrangeira");		
	}
	
	public void exibir() {				
		System.out.println(this);		
	}
}
