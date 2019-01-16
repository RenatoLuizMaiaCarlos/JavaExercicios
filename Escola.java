import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
public class Escola {
	
	private Diretor diretor;
	public Diretor getDiretor() {
		return diretor;
	}
	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}
	private List<Aluno> listAlunos = new ArrayList<Aluno>();
	List<Aluno> getListAlunos() {
		return listAlunos;
	}
	void setListAlunos(List<Aluno> listAlunos) {
		this.listAlunos = listAlunos;
	}
	
	private List<Professor> listProfessor = new ArrayList<Professor>();
	public List<Professor> getListProfessor() {
		return listProfessor;
	}
	public void setListProfessor(List<Professor> listProfessor) {
		this.listProfessor = listProfessor;
	}
	private List<Secretario> listSecretario = new ArrayList<Secretario>();
	public List<Secretario> getListSecretario() {
		return listSecretario;
	}
	public void setListSecretario(List<Secretario> listSecretario) {
		this.listSecretario = listSecretario;
	}
	public void inicializarListas() {
		for(int i=0;i<3;i++) {
			Aluno aluno = new Aluno();
			aluno.setNome("aluno"+(i+1));
			aluno.setIdade(i+1);
			aluno.setMatricula("MAT"+(i+1));
			aluno.setSenha(aluno.getNome()+(i+1));
			listAlunos.add(aluno);
			
			Professor professor = new Professor();
			professor.setNome("professor"+(i+1));
			professor.setIdade(i+1);
			professor.setEmail(professor.getNome()+(i+1)+"@accenture.com.br");
			professor.setSenha(professor.getNome()+(i+1));
			listProfessor.add(professor);
			
			Secretario secretario = new Secretario();
			secretario.setNome("secretario"+(i+1));
			secretario.setIdade(i+1);
			secretario.setPid(i+1);
			secretario.setSenha(secretario.getNome()+(i+1));
			listSecretario.add(secretario);
		}
	}
	public boolean verificarLogin() {
		String usuario = null;	
		String senha = null;
		usuario = JOptionPane.showInputDialog("Informe usuario");
		senha = JOptionPane.showInputDialog("Informe senha");
		for(Aluno itemAluno:listAlunos){	
			if(itemAluno.getMatricula().equals(usuario))return itemAluno.autentica(usuario, senha);	
		}
		for(Professor itemProfessor:listProfessor){	
			if(itemProfessor.getEmail().equals(usuario))return itemProfessor.autentica(usuario, senha);	
		}
		for(Secretario itemSecretario:listSecretario){	
			if(Integer.toString(itemSecretario.getPid()).equals(usuario))return itemSecretario.autentica(usuario, senha);	
		}
		return false;
	}
	
	public void matricularAlunos() {
		boolean novoCadastro = false;
		do {
			String nome = JOptionPane.showInputDialog(null,"Nome do aluno","CADASTRO",JOptionPane.INFORMATION_MESSAGE);
			Aluno novoAluno = new Aluno(nome);
			int idade = Integer.parseInt(JOptionPane.showInputDialog(null,"idade de " + novoAluno.getNome(),"IDADE",JOptionPane.INFORMATION_MESSAGE));
			novoAluno.setIdade(idade);
			String escolaridade = JOptionPane.showInputDialog(null,"escolaridade :1 - Fundamental, 2 - medio, 3 - superior","Grau de Instrução",JOptionPane.INFORMATION_MESSAGE);
			switch (escolaridade) {
			case "1":
				novoAluno.setEscolaridade(Aluno.Escolaridade.FUNDAMENTAL);
				break;
			case "2":
				novoAluno.setEscolaridade(Aluno.Escolaridade.MEDIO);
				break;
			case "3":
				novoAluno.setEscolaridade(Aluno.Escolaridade.SUPERIOR);
				break;
			default:
				novoAluno.setEscolaridade(Aluno.Escolaridade.OUTRO);
				break;
			}
			String trabalhaNoiteAux = null;
			String faltasAux = null;
			trabalhaNoiteAux = JOptionPane.showInputDialog(null,novoAluno.getNome()+" Trabalha a noite? Digite sim ou nao","Trabalho",JOptionPane.INFORMATION_MESSAGE);
			novoAluno.setTrabalhaNoite(((trabalhaNoiteAux.equals("sim")) ? true:false));
			faltasAux = JOptionPane.showInputDialog(null,"Informe quantidade de faltas de "+novoAluno.getNome(),"Ausências",JOptionPane.INFORMATION_MESSAGE);
			novoAluno.setFaltas(Integer.parseInt(faltasAux)); 
			int qtdNotas = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe quantidade de notas de "+novoAluno.getNome()+" para cadastro","Cadastro de notas",JOptionPane.INFORMATION_MESSAGE));
			List<Double> notas = new ArrayList<Double>();
			String auxNotas = null;
			for(int i=0;i<qtdNotas;i++) {
				auxNotas = JOptionPane.showInputDialog("Digite "+(i+1)+"º"+ " nota de "+novoAluno.getNome());
				notas.add(Double.parseDouble(auxNotas));
				System.out.println(notas.get(i));
			}	
			novoAluno.setMedia(novoAluno.calcularMedia(notas));
			calcularSituacao(novoAluno);
			String novoCadastroAux = JOptionPane.showInputDialog(null,"Cadastrar outro aluno ? (sim/nao)","Cadastrar ?",JOptionPane.INFORMATION_MESSAGE);
			novoCadastro = (novoCadastroAux.equals("sim"))? true:false;
			listAlunos.add(novoAluno);
		}while(novoCadastro);
	}
	private void calcularSituacao(Aluno novoAluno) {
		// TODO Auto-generated method stub
		if( novoAluno.getMedia() >= 7 && (novoAluno.getFaltas() < 3 || novoAluno.getTrabalhaNoite()) ) {
			novoAluno.setSituacao(Aluno.Situacao.APROVADO);
		}else if (novoAluno.getMedia() >= 9){
			novoAluno.setSituacao(Aluno.Situacao.APROVADO);
		}else if (novoAluno.getFaltas() < 10 && novoAluno.getMedia() >= 4) {
			novoAluno.setSituacao(Aluno.Situacao.RECUPERACAO);
		}else {
			novoAluno.setSituacao(Aluno.Situacao.REPROVADO);
		}
	}
	public void relatorio() {
		for(Aluno dadosAlunos: this.listAlunos){	
			String relatorio = "Nome: "+dadosAlunos.getNome(); 
			relatorio = relatorio + "\nIdade: "+dadosAlunos.getIdade();
			relatorio = relatorio + "\nEscolaridade: "+dadosAlunos.getEscolaridade();
			relatorio = relatorio + "\nMedia: "+dadosAlunos.getMedia();
			relatorio = relatorio + "\nSituacao: "+dadosAlunos.getSituacao();
			relatorio = relatorio + "\nFaltas: "+dadosAlunos.getFaltas();
			relatorio = relatorio + "\nTrabalhaANoite: "+dadosAlunos.getTrabalhaNoite();
			JOptionPane.showMessageDialog(null, relatorio,"RELATORIO", JOptionPane.PLAIN_MESSAGE);
		}
	}
}