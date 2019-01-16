import javax.swing.JOptionPane;

public class Pais extends Pessoa {
	String cpf;
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	@Override
	public void imprimiCartaoAniversario() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Feliz Aniversario " +this.getNome(),"Cartao de Aniversario",JOptionPane.INFORMATION_MESSAGE);
	}

}
