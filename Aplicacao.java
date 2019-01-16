import javax.swing.JOptionPane;

public class Aplicacao {
	  
	public static void main(String[] args) {
		
		Escola escola1 = new Escola ();
		escola1.inicializarListas();
		if(escola1.verificarLogin()) {
			escola1.matricularAlunos();
			escola1.relatorio();
		}else
			JOptionPane.showMessageDialog(null, "usuário sem acesso ao sistema");
	}
}
