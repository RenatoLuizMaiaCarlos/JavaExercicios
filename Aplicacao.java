import javax.swing.JOptionPane;

public class Aplicacao {
	  
	public static void main(String[] args) {
		
		Escola escola1 = new Escola ();
		escola1.inicializarListas();
		if(escola1.verificarLogin()) {
			escola1.matricularAlunos();
			escola1.relatorio();
		}else
			JOptionPane.showMessageDialog(null, "usu�rio sem acesso ao sistema");
	}
}
