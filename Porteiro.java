import javax.swing.JOptionPane;

public class Porteiro extends Funcionario{
	public static enum Turno {DIURNO,NOTURNO}
	Turno turno;
	
	Turno getTurno() {
		return turno;
	}
	void setTurno(Turno turno) {
		this.turno = turno;
	}
	@override
	public void reajustarSalario(Double percentagem) {	
		int adicionalNoturno=(int) 0.15;
		System.out.println("em porteiro");
		if(this.turno.equals(Turno.NOTURNO)) {
			this.salario = this.salario*(1+adicionalNoturno);
		}else {
			super.reajustarSalario(percentagem);
		}
	}
	public void imprimiCartaoAniversario(){
		JOptionPane.showMessageDialog(null, "Feliz Aniversario " +this.getNome()	,"Cartao de Aniversario",JOptionPane.INFORMATION_MESSAGE);
	}
}
