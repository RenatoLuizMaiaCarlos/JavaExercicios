import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public  abstract class Funcionario extends Pessoa {
	Double salario;
	String email;
	int pid;
	
	public Double getSalario() {
		return salario;
	}
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	public int getPid() {
		return this.pid;
	}
	void setPid(int pid) {
		this.pid = pid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void reajustarSalario(Double percentagem) {
		this.salario = this.salario*(1+percentagem);
		System.out.println("em funcionario");
	}
	void imprimirCartaoAniversario() {
		JOptionPane.showMessageDialog(null, "Feliz Aniversario funcionario"+this.getNome(),"Cartao de Aniversario",JOptionPane.INFORMATION_MESSAGE);
	}
}