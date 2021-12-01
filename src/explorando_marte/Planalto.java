package explorando_marte;

import java.util.ArrayList;
import java.util.List;

public class Planalto {
	private int latitudeX;
	private int longitudeY;
	public List<Sonda> sondas = new ArrayList<Sonda>();
	
	public int getLatitudeX() {
		return latitudeX;
	}

	public int getLongitudeY() {
		return longitudeY;
	}
	
	public int contagemSondas() {
	  return sondas.size();
	}
	
	public List<Sonda> getSondas() {
		return sondas;
	}
	
	public Planalto(int latitudeX, int longitudeY) {
		this.latitudeX = latitudeX;
		this.longitudeY = longitudeY;
		this.limiteDeTamanho();
	}
	
	public void limiteDeTamanho() {
		if(latitudeX*longitudeY<=1) {
			throw new RuntimeException("Planalto pequeno demais, favor informar tamanho maior que 1x1");
		}
		
	}
	
	public boolean verificarSeEstaOcupado(Posicao p1) {
		for(Sonda s : sondas) {
			if(s.temPosicao(p1)) {
				return true;
			}
		}
		return false;
	}
	
	public void adicionarSonda (Sonda nomeSonda) {
		sondas.add(nomeSonda);
	}
	
}
