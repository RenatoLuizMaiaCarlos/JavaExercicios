import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class SorteioMegaSena {
	public enum tipoAposta {MEGASENA, QUINA, LOTOFACIL};
	final static String EMPRESA = "LOTERIAS DA CAIXA";
	static int []inputData = new int[6];
	static int []sorteio = new int[6];
	static int acertos = 0;
	@SuppressWarnings("null")
	public static void main(String[] args) { 
		Date d = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");	
		System.out.println(EMPRESA + "\nSorteio " + Aplicacao.tipoAposta.MEGASENA + "\nDATA "+simple.format(d));	
		System.out.println("****************");
		Scanner entrada = new Scanner(System.in);
		Random aleatorio = new Random();	
		for(int i=0;i<inputData.length;i++) {
			inputData[i] = entrada.nextInt();
			int n  = aleatorio.nextInt(60) + 1;
			while(haRepeticao(n)) {
				n  = aleatorio.nextInt(60);
			}
			sorteio[i] = n;
			System.out.println("numero sorteado " +sorteio[i]);
		}
	}
	
	public static boolean haRepeticao(int dezena) {
		for (int x = 0; x < sorteio.length; x++) {	
			if (sorteio[x] == dezena)
				return true;			
		}		
		return false;				
	}
}
