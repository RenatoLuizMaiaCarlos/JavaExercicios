
public abstract class Pessoa {
	String nome;
	int idade;
	
	public Pessoa(String nome) {
		this.nome = nome;
	}
	public Pessoa() {}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public final void incrementarIdade() {//jamais será sobrescrito por subclasses
		this.idade+=1;
	}
	public abstract void imprimiCartaoAniversario(); // será obrigatoriamente implementado pelas subclasses
}
