import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
public class SistemaEscolarMetodos {
	static List<String> listNome = new ArrayList<String>();
	static List<String> listMedia = new ArrayList<String>();
	static List<String> listIdade = new ArrayList<String>();
	static List<String> listEscolaridade = new ArrayList<String>();
	public static enum escolaridade {FUNDAMENTAL,MEDIO,SUPERIOR}
	
	static boolean  repetir = false;
	static Map<String,String> mapLogins = new HashMap<>();
	static String usuario = null;
	static String senha = null;
	public static void main(String[] args) {
		usuariosPreCadastrados();
		if(login()) {
			entraProcessaArmazenaDadosAlunos();
		    relatorios();
		}else {
			JOptionPane.showMessageDialog(null,"FALHA DE LOGIN","AVISO",
			JOptionPane.INFORMATION_MESSAGE
			);
		}
	}
	public static void usuariosPreCadastrados() {
		mapLogins.put("PROFESSOR", "25413");
		mapLogins.put("DIRETOR", "felicidade");
		mapLogins.put("SECRETARIA", "amor1000");
		mapLogins.put("COORDENADOR", "2018");
	}
	public static boolean login() {
		boolean usuarioEncontrado=false;
		boolean senhaCorreta=false;
		usuario = JOptionPane.showInputDialog("Informe usuario").toUpperCase();
		senha = JOptionPane.showInputDialog("Informe senha");
		for(Map.Entry<String,String> acesso : mapLogins.entrySet()){
			if(acesso.getKey().equals(usuario)) {
				usuarioEncontrado = true;
				if(acesso.getValue().equals(senha)) {
					System.out.println("Login efetuado com sucesso");
					senhaCorreta = true;
				}else{
					System.out.println("senha invalida");
					 }
			}
		}
		return (usuarioEncontrado && senhaCorreta);
	}
	public static void entraProcessaArmazenaDadosAlunos() {
		String nomeAux = null;
		String escolaridadeAux = null;
		String idadeAux = null;
		String repetirAux = null;
		int qtdNotas = 0;
		double media = 0;
		do {
			nomeAux = JOptionPane.showInputDialog("Informe Nome do aluno");
			idadeAux = JOptionPane.showInputDialog("Informe idade do aluno");
			escolaridadeAux = JOptionPane.showInputDialog("Informe escolaridade");
			/*for(escolaridade e: escolaridade.values()){			
				if(e.equals(escolaridadeAux)) {
					escolaridadeCorreta= true;
					System.out.println(escolaridadeCorreta);
				}
			}
			if(escolaridadeCorreta)listEscolaridade.add(escolaridadeAux);
			else JOptionPane.showMessageDialog(null,"escolaridade errada","Aviso",JOptionPane.INFORMATION_MESSAGE);
			*/
			qtdNotas = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de notas"));
			int [] notas = new int[qtdNotas];
			String [] notasAux = new String[qtdNotas];	
			for(int i=0;i<qtdNotas;i++) {
				notasAux[i] = JOptionPane.showInputDialog("Digite nota "+(i+1)+" para "+nomeAux );
				notas[i] = Integer.parseInt(notasAux[i]);
				media = media + notas[i];
			}

			media = media/qtdNotas;
			listNome.add(nomeAux);
			listIdade.add(idadeAux);
			listMedia.add(""+media);
			listEscolaridade.add(escolaridadeAux.toUpperCase());
			repetirAux = JOptionPane.showInputDialog("Digitar dados para um novo aluno");
			repetir = (repetirAux.equals("sim"))? true:false;
		}while(repetir);
	}
	public static < E > void printArray( E[] inputArray ){
		   
	     // Imprime os elementos do array              
	     for ( E element : inputArray ){         
	       System.out.printf( "%s ", element ); 
	     } 
	}
	public static void relatorios() {
		for(int i=0;i<listNome.size();i++) {
			System.out.println(
			"nome: " + listNome.get(i) + 
			" idade: " +listIdade.get(i) + 
			" media: " + listMedia.get(i) + 
			" escolaridade: " + listEscolaridade.get(i)
			);
			JOptionPane.showMessageDialog(
					null,
					" nome: " + listNome.get(i) + 
					" idade: " +listIdade.get(i) + 
					" media: " + listMedia.get(i) + 
					" escolaridade: " + listEscolaridade.get(i),
					"RELATORIO", 
			        JOptionPane.INFORMATION_MESSAGE
			);
		}
	}
}