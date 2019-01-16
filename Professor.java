import javax.swing.JOptionPane;

public class Professor extends Funcionario implements Autenticavel{
	String disciplina;
	String senha;
	
	public Professor() {};
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	String getDisciplina() {
		return disciplina;
	}

	void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	
	public boolean autentica(String usuario, String senha) {
		// TODO Auto-generated method stub
		boolean usuarioCorreto = false;	
		boolean senhaCorreta = false;	
		if(this.email.equals(usuario)){
			usuarioCorreto = true;
			if(this.senha.equals(senha)) {
				senhaCorreta=true;
			}
		}else {
			System.out.println("usuario incorreto");
		}
		
		return(usuarioCorreto &&senhaCorreta );
	}
	
	@Override
	public void imprimiCartaoAniversario() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Feliz Aniversario " +this.getNome(),"Cartao de Aniversario",JOptionPane.INFORMATION_MESSAGE);
	}

}
