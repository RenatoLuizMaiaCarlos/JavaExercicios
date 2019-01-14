import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
public class Escola {
	private List<Aluno> listAlunos = new ArrayList<Aluno>();
	List<Aluno> getListAlunos() {
		return listAlunos;
	}
	void setListAlunos(List<Aluno> listAlunos) {
		this.listAlunos = listAlunos;
	}
	public boolean login() {
		boolean statusLogin = false;
		String usuario = null;	
		usuario = JOptionPane.showInputDialog("Informe usuario").toUpperCase();
		switch(usuario) {
		case "PROFESSOR":
			Professor professor1 = new Professor();
			statusLogin = loginFuncionario(professor1,usuario);
			break;
		case "DIRETOR":
			Diretor diretor1 = new Diretor();
			statusLogin = loginFuncionario(diretor1,usuario);
			break;
		case "SECRETARIA":
			Secretario secretario1 = new Secretario();
			statusLogin = loginFuncionario(secretario1,usuario);
			break;
		}
		
		return statusLogin;
	}
	public void matricularAlunos() {
		
		boolean novoCadastro = false;
		do {
			String nome = JOptionPane.showInputDialog(null,"Nome do aluno","CADASTRO",JOptionPane.INFORMATION_MESSAGE);
			Aluno novoAluno = new Aluno(nome);
			cadastrarNovoALuno(novoAluno);
			//calcularMedia(novoAluno);
			//novoAluno.calcularMedia(novoAluno);
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
	private void cadastrarNovoALuno(Aluno novoAluno) {
		// TODO Auto-generated method stub
		
		//novoAluno.setNome(nome);
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
			novoAluno.setEscolaridade(Aluno.Escolaridade.NAO_INFORMADA);
			break;
		}
		String trabalhaNoiteAux = null;
		String faltasAux = null;
		trabalhaNoiteAux = JOptionPane.showInputDialog(null,novoAluno.getNome()+" Trabalha a noite? Digite sim ou nao","Trabalho",JOptionPane.INFORMATION_MESSAGE);
		novoAluno.setTrabalhaNoite(((trabalhaNoiteAux.equals("sim")) ? true:false));
		faltasAux = JOptionPane.showInputDialog(null,"Informe quantidade de faltas de "+novoAluno.getNome(),"Ausências",JOptionPane.INFORMATION_MESSAGE);
		novoAluno.setFaltas(Integer.parseInt(faltasAux)); 
	}
	boolean loginFuncionario(Funcionario funcionario,String usuario) {
		String senha = null;
		senha = JOptionPane.showInputDialog("Informe senha");
		boolean usuarioEncontrado=false;
		boolean senhaCorreta=false;
		for(Map.Entry<String,String> acesso : funcionario.mapLoginsFuncionario.entrySet()){
			if(acesso.getKey().equals(usuario)) {
				usuarioEncontrado = true;
				if(acesso.getValue().equals(senha)) {
					senhaCorreta = true;
				}else{
					System.out.println("senha invalida");
					 }
			}
		}
		return (usuarioEncontrado && senhaCorreta);
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
	/*private void calcularMedia(Aluno novoAluno) {
		// TODO Auto-generated method stub
		double somatorioNotas = 0;
		int qtdNotas = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe quantidade de notas de "+novoAluno.getNome()+" para cadastro","Cadastro de notas",JOptionPane.INFORMATION_MESSAGE));
		double [] notas = new double[qtdNotas];
		String [] notasAux = new String[qtdNotas];
		for(int i=0;i<qtdNotas;i++) {
			notasAux[i] = JOptionPane.showInputDialog("Digite "+(i+1)+"º"+ " nota de "+novoAluno.getNome());
			notas[i] = Double.parseDouble(notasAux[i]);
			somatorioNotas = somatorioNotas + notas[i];
		}	
		novoAluno.setMedia(somatorioNotas/qtdNotas);
	}*/
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