
public class Aplicacao {
	  
	public static void main(String[] args) {
		Escola escola1 = new Escola ();
		escola1.login();
		escola1.matricularAlunos();
		escola1.relatorio();
		Porteiro port1 = new Porteiro();
		Funcionario func1 = ((Funcionario)port1);
		func1.reajustarSalario(10.0);
	}
}
