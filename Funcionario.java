import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public  abstract class Funcionario extends Pessoa {
	Double salario;
	String email;
	int pid;
	int getPid() {
		return pid;
	}
	void setPid(int pid) {
		this.pid = pid;
	}
	String getEmail() {
		return email;
	}
	void setEmail(String email) {
		this.email = email;
	}
	Map<String,String> mapLoginsFuncionario = new HashMap<>();	
	Funcionario() {
		mapLoginsFuncionario.put("PROFESSOR", "25413");
		mapLoginsFuncionario.put("DIRETOR", "felicidade");
		mapLoginsFuncionario.put("SECRETARIA", "amor1000");
		mapLoginsFuncionario.put("COORDENADOR", "2018");
	}
	public void reajustarSalario(Double percentagem) {
		this.salario = this.salario*(1+percentagem);
		System.out.println("em funcionario");
	}
	void imprimirCartaoAniversario() {
		JOptionPane.showMessageDialog(null, "Feliz Aniversario funcionario"+this.getNome(),"Cartao de Aniversario",JOptionPane.INFORMATION_MESSAGE);
	}
}