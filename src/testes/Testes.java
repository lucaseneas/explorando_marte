package testes;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import explorando_marte.Comando;
import explorando_marte.ComandosDirecao;
import explorando_marte.Janela;
import explorando_marte.Planalto;
import explorando_marte.Program;
import explorando_marte.Sonda;

public class Testes {
	Planalto planalto = new Planalto(10, 10);
	
	@Test
	public void criarPlanalto() {
		Planalto planalto = new Planalto(2, 1);
	}
	
	@Test
	public void realizarLancamentoSonda1() {
		Sonda sonda1 = new Sonda("Teste"); 
		sonda1.lancamento(planalto, 5, 5,'L');
		ComandosDirecao[] listaComandos = new Comando("mMD").capturarComando();
		sonda1.realizarInstrucao(listaComandos);
		Janela janela = new Janela(planalto);
	}
	
	@Test
	public void realizarLancamentoSonda2() {
		Sonda sonda2 = new Sonda("Teste2"); 
		sonda2.lancamento(planalto, 3, 3,'N');
		ComandosDirecao[] listaComandos = new Comando("Md").capturarComando();
		sonda2.realizarInstrucao(listaComandos);
		Janela janela = new Janela(planalto);
	}
	
	@Test
	public void lancamentoForaDoPlanalto() {
		Sonda sonda1 = new Sonda("Teste"); 
		assertThrows(RuntimeException.class, () -> sonda1.lancamento(planalto, 20, 5,'L'));
	}
	
	@Test
	public void andarForaDoPlanalto() {
		Sonda sonda1 = new Sonda("Teste2"); 
		sonda1.lancamento(planalto, 3, 3,'N');
		ComandosDirecao[] listaComandos = new Comando("MMMMMMMMMMM").capturarComando();
		assertThrows(RuntimeException.class, () -> sonda1.realizarInstrucao(listaComandos));
	}
	
	@Test
	public void lancarDuasSondasNoMesmoLugar() {
		Sonda sonda1 = new Sonda("Teste"); 
		sonda1.lancamento(planalto, 3, 3,'L');

		Sonda sonda2 = new Sonda("Teste2"); 
		assertThrows(RuntimeException.class, () -> sonda2.lancamento(planalto, 3, 3,'L'));
	}
	
	@Test
	public void comandoInvalido() {
		try {
			Sonda sonda1 = new Sonda("Teste1"); 
			sonda1.lancamento(planalto, 3, 3,'N');
			ComandosDirecao[] listaComandos = new Comando("SZSZSZS").capturarComando();
			sonda1.realizarInstrucao(listaComandos);
			fail("Não ocrreu uma Exception");
		}
		catch(Exception ex) {}
	}
	
	@Test
	public void criarPlanaltoPequenoDemais() {
		try {
			Planalto planalto = new Planalto(1, 1);
			fail("Não ocorreu uma Exception");
		}
		catch(Exception ex){}
	}
	
	@Test
	public void colisaoDeSondas() {
		Sonda sonda1 = new Sonda("Teste"); 
		sonda1.lancamento(planalto, 2, 3,'N');
		
		Sonda sonda2 = new Sonda("Teste2"); 
		sonda2.lancamento(planalto, 1, 3,'L');
		ComandosDirecao[] listaComandos = new Comando("MM").capturarComando();
		assertThrows(RuntimeException.class, () -> sonda2.realizarInstrucao(listaComandos));
	}
	
	@Test
	public void nomeDeSondaMaiorQueOPrevisto() {
		try{
			String nomeSonda = "12345678";
			Program.Limitador(nomeSonda);
			fail("Não ocorreu uma Exception");
		}
		catch(Exception ex) {}
	}
}
