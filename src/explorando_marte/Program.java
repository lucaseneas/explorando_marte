package explorando_marte;

import java.util.Scanner;
import static java.lang.System.in;

public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(in);
		
		try {
			
			//Criação do Planalto
			
				System.out.print("Informe as dimensões do planalto: \nLatitude X: ");
				int latitudeX = scanner.nextInt();
				System.out.print("Longitude Y: ");
				int longitudeY = scanner.nextInt();
				Planalto planalto = new Planalto(latitudeX, longitudeY);

			//Criação e Lançamento da Primeira Sonda
			
				System.out.print("\nInforme o nome da Primeira sonda(Obs.: No maximo 7 caracteres): ");
				scanner.nextLine();
				String nomeSonda = scanner.nextLine();
				Limitador(nomeSonda);
				
				System.out.print("Informe a localização que a primeira sonda sera lançada  \nLatitude X: ");
				int lancamentoLatitudeX = scanner.nextInt();
				
				System.out.print("Longitude Y: ");
				int lancamentoLongitudeY = scanner.nextInt();
				
				System.out.print("Informe a direção da sonda(Norte = N, Sul = S, Leste = L, Oeste = O: ");
				char pontosCardeais = scanner.next().charAt(0);
				
				Sonda sonda1 = new Sonda(nomeSonda); 
				
				sonda1.lancamento(planalto, lancamentoLatitudeX, lancamentoLongitudeY, pontosCardeais);
				System.out.println(sonda1.verificarSituacaoSonda());
				System.out.println("Informe os comandos para a sonda "+ sonda1.getNome() +" Ex: DMLMEMLMM onde E = Virar para a esquerda D = Virar para a direita e M = Mover em linha reta: ");
				scanner.nextLine();
				String comandos = scanner.nextLine();
				ComandosDirecao[] listaComandos = new Comando(comandos).capturarComando();
				sonda1.realizarInstrucao(listaComandos);
			
			//Criação e Lançamento da Segunda Sonda

				System.out.print("\nInforme o nome da Segunda sonda(Obs.: No maximo 7 caracteres): ");
				nomeSonda = scanner.nextLine();
				Limitador(nomeSonda);
				
				System.out.print("Informe a localização que a Segunda sonda sera lançada  \nLatitude X: ");
				lancamentoLatitudeX = scanner.nextInt();
				
				System.out.print("Longitude Y: ");
				lancamentoLongitudeY = scanner.nextInt();
				
				System.out.print("Informe a direção da sonda(Norte = N, Sul = S, Leste = L, Oeste = O: ");
				pontosCardeais = scanner.next().charAt(0);
				
				Sonda sonda2 = new Sonda(nomeSonda); 
				
				sonda2.lancamento(planalto, lancamentoLatitudeX, lancamentoLongitudeY, pontosCardeais);
				System.out.println(sonda2.verificarSituacaoSonda());
				System.out.println("Informe os comandos para a sonda "+ sonda2.getNome() +" Ex: DMLMEMLMM onde E = Virar para a esquerda D = Virar para a direita e M = Mover em linha reta: ");
				scanner.nextLine();
				comandos = scanner.nextLine();
					
				listaComandos = new Comando(comandos).capturarComando();
				sonda2.realizarInstrucao(listaComandos);
				
			//Resultado
			
				System.out.println("\n"+sonda1.verificarSituacaoSonda());
				System.out.println("\n"+sonda2.verificarSituacaoSonda());
				
				Janela janela = new Janela(planalto);
			
		}
		catch(Exception ex) {
			System.out.print("Ocorreu um Erro "+ex);
		}
	}
	
	public static void Limitador(String nome) {
		 final int valorMaximo = 7;
		 if(nome.length() > valorMaximo) {
			throw new RuntimeException("O nome informado contem mais de 7 caracteres!");
		 }
	}

}
