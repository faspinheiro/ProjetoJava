package negocio;

public class Usuario {
 
	private int id;
	private String nome;
	private String email;
	private String senha;
	
	public Usuario(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}
	public Usuario(String nome, String email, String senha) {
		this(email, senha);
		this.nome = nome;
	}
	
	public Usuario(int id, String nome, String email, String senha) {
		this(nome, email, senha);
		this.id = id;
	}
	
	@Override
	public String toString() {
		return String.format("%d - %s - %s - %s",
					this.getId(),
					this.getNome(),
					this.getEmail(),
					this.getSenha()
				);
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}
}
