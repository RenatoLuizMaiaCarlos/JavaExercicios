import java.util.List;
import javax.swing.JOptionPane;
public final class Aluno extends Pessoa {
	private double media;
	private int faltas;
	public static enum Escolaridade{FUNDAMENTAL,MEDIO,SUPERIOR, NAO_INFORMADA};
	public static enum Situacao{APROVADO,REPROVADO,RECUPERACAO,OUTRO};
	private Escolaridade escolaridade;
	private Situacao situacao;
	private boolean trabalhaNoite;
	private Pais pai = new Pais();
	private Pais mae = new Pais();
	Pais getMae() {
		return mae;
	}
	void setMae(Pais mae) {
		this.mae = mae;
	}
	Pais getPais() {
		return pai;
	}
	void setPais(Pais pai) {
		this.pai = pai;
	}
	public Aluno(String nome ){
		super( nome);
	}
	public boolean getTrabalhaNoite() {
		return trabalhaNoite;
	}
	public void setTrabalhaNoite(boolean trabalhaNoite) {
		this.trabalhaNoite = trabalhaNoite;
	}
	public int getFaltas() {
		return faltas;
	}
	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}
	public Situacao getSituacao() {
		return situacao;
	}
	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	public Escolaridade getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}
	public double getMedia() {
		return media;
	}
	public void setMedia(double media) {
		this.media = media;
	}	
	public void calcularMedia(Aluno aluno) {
		double somatorioNotas = 0;
		int qtdNotas = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe quantidade de notas de "+aluno.getNome()+" para cadastro","Cadastro de notas",JOptionPane.INFORMATION_MESSAGE));
		double [] notas = new double[qtdNotas];
		String [] notasAux = new String[qtdNotas];
		for(int i=0;i<qtdNotas;i++) {
			notasAux[i] = JOptionPane.showInputDialog("Digite "+(i+1)+"º"+ " nota de "+aluno.getNome());
			notas[i] = Double.parseDouble(notasAux[i]);
			somatorioNotas = somatorioNotas + notas[i];
		}	
		aluno.setMedia(somatorioNotas/qtdNotas);
	}
	public double calcularMedia(List<Double> listNotas) {
		double auxSoma = 0;
		for(Double itensLista : listNotas) {
			auxSoma = auxSoma + itensLista;
		}
		return (auxSoma/listNotas.size());
	}
	public void imprimiCartaoAniversario() {
		JOptionPane.showMessageDialog(null, "Feliz Aniversario "+ this.getNome(),"Cartao de Aniversario",JOptionPane.INFORMATION_MESSAGE);
	}
}
