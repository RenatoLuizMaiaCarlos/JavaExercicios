import javax.swing.JOptionPane;

public class Secretario extends Funcionario implements Autenticavel{
	
	String senha;
	
	String getSenha() {
		return senha;
	}
	
	void setSenha(String senha) {
		this.senha = senha;
	}
	Secretario(){};
	Secretario(int pid,String senha){
		this.pid= pid; 
		this.senha = senha;
	}
	
	@Override
	public void imprimiCartaoAniversario() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Feliz Aniversario " +this.getNome()	,"Cartao de Aniversario",JOptionPane.INFORMATION_MESSAGE);
	}
	
	@Override
	public boolean autentica(String usuario, String senha) {
		// TODO Auto-generated method stub
		boolean usuarioCorreto = false;	
		boolean senhaCorreta = false;	
		if(Integer.toString(pid).equals(usuario)){
			usuarioCorreto = true;
			if(this.senha.equals(senha)) {
				senhaCorreta=true;
			}
		}else {
			System.out.println("usuario incorreto");
		}
		
		return(usuarioCorreto &&senhaCorreta );
	}

}
