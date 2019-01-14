import javax.swing.JOptionPane;

public class Professor extends Funcionario{
	String disciplina;
	
	String getDisciplina() {
		return disciplina;
	}

	void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	@Override
	public void imprimiCartaoAniversario() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Feliz Aniversario " +this.getNome(),"Cartao de Aniversario",JOptionPane.INFORMATION_MESSAGE);
	}
	
	

}
