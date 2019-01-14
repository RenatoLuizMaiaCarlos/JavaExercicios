import javax.swing.JOptionPane;

public class Diretor extends Funcionario{

	public void imprimiCartaoAniversario(){
		JOptionPane.showMessageDialog(null, "Feliz Aniversario " +this.getNome(),"Cartao de Aniversario",JOptionPane.INFORMATION_MESSAGE);
	}
}
