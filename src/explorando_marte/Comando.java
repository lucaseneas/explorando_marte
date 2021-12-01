package explorando_marte;

import java.util.ArrayList;

public class Comando {
	private String comando;
	
	public Comando (String comando) {
		this.comando = comando;
	}
	
	public ComandosDirecao[] capturarComando() {
		ArrayList<ComandosDirecao> listaComando = new ArrayList<ComandosDirecao>();
		
		for(char cmd: comando.toCharArray()) {
			switch (cmd) {
			case 'E': listaComando.add(ComandosDirecao.ESQUERDA); break;
			case 'e': listaComando.add(ComandosDirecao.ESQUERDA); break;
			case 'M': listaComando.add(ComandosDirecao.EM_FRENTE); break;
			case 'm': listaComando.add(ComandosDirecao.EM_FRENTE); break;
			case 'D': listaComando.add(ComandosDirecao.DIREITA); break;
			case 'd': listaComando.add(ComandosDirecao.DIREITA); break;
			default: throw new RuntimeException("Instrução informada inválida");
			}
		}
		
		return listaComando.toArray(new ComandosDirecao[listaComando.size()]);
	}
}
