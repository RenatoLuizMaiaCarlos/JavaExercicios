import javax.swing.JOptionPane;

public class Secretario extends Funcionario {

	@Override
	public void imprimiCartaoAniversario() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Feliz Aniversario " +this.getNome()	,"Cartao de Aniversario",JOptionPane.INFORMATION_MESSAGE);
	}

}
