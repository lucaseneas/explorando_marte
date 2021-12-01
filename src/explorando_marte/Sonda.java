package explorando_marte;

public class Sonda {
	private Planalto planalto;
	public Posicao posicao;
	private String nome;
	public PontosCardeais pontosCardeais;
	
	public Sonda() {
	}
	
	public Sonda(String nome) {		
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public boolean temPosicao(Posicao pos) {
		return posicao.verificarSePosicaoIgual(pos);
	}
	
	public void lancamento(Planalto planalto, int lancamentoLatitudeX , int lancamentoLongitudeY, char direcao) {
		pontosCardeais = converterCharEnum(direcao);
		posicao = new Posicao(lancamentoLatitudeX,lancamentoLongitudeY);
		if(!posicao.verificarSeEstaNoPlanalto(planalto)) {
			throw new RuntimeException("Posição esta fora do planalto informado");
		}
		if(planalto.verificarSeEstaOcupado(posicao)) {
			throw new RuntimeException("Essa posicão ja esta ocupado por outra sonda");
		}
		this.planalto = planalto; 
		planalto.adicionarSonda(this);
	}
	
	public String verificarSituacaoSonda() {
		return "Sonda "+nome+" esta pousada em marte, Coordenadas  "+posicao.toString()+ " em direção ao "+ pontosCardeais.toString();
	}
	
	public void realizarInstrucao(ComandosDirecao[] comando) {
		for(ComandosDirecao i : comando) {
			if(posicao == null || pontosCardeais == null) {
				throw new RuntimeException("Erro!");
			}
			switch (i) {
			case DIREITA: virarDireita(); break;
			case ESQUERDA: virarEsquerda(); break;
			case EM_FRENTE: andarParaFrente(); break;
			}
		}
	}

	public void virarEsquerda() {
		switch (pontosCardeais) {
		case LESTE: pontosCardeais = PontosCardeais.NORTE; break;
		case OESTE: pontosCardeais = PontosCardeais.SUL; break;
		case NORTE: pontosCardeais = PontosCardeais.OESTE; break;
		case SUL: pontosCardeais = PontosCardeais.LESTE; break;
		default: throw new RuntimeException("Erro!");
		}
	}
	public void virarDireita() {
		switch (pontosCardeais) {
		case LESTE: pontosCardeais = PontosCardeais.SUL; break;
		case OESTE: pontosCardeais = PontosCardeais.NORTE; break;
		case NORTE: pontosCardeais = PontosCardeais.LESTE; break;
		case SUL: pontosCardeais = PontosCardeais.OESTE; break;
		default: throw new RuntimeException("Erro!");
		}
	}
	public void andarParaFrente() {
		Posicao posicao2 = posicao.andarParaFrente(pontosCardeais);
		if(!posicao2.verificarSeEstaNoPlanalto(planalto)) {
			throw new RuntimeException("Posição esta fora do planalto informado");
		}
		if(planalto.verificarSeEstaOcupado(posicao2)) {
			throw new RuntimeException("As sondas colidiram na posição "+posicao2);
		}
		posicao = posicao2;
	}
	
	private static PontosCardeais converterCharEnum(char direcao) {		
		switch (direcao) {
			case 'N': return PontosCardeais.NORTE;
			case 'n': return PontosCardeais.NORTE;
			case 'O': return PontosCardeais.OESTE;
			case 'o': return PontosCardeais.OESTE;
			case 'S': return PontosCardeais.SUL;
			case 's': return PontosCardeais.SUL;
			case 'L': return PontosCardeais.LESTE;
			case 'l': return PontosCardeais.LESTE;
			default: throw new RuntimeException("Caracter informado não é reconhecido como direção " + direcao  + "!");
		}
	}
	
	
}