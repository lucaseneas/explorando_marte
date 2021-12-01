package explorando_marte;

public class Posicao {
	private int latitudeX;
	private int longitudeY;
	
	public int getLatitudeX() {
		return latitudeX;
	}
	
	public int getLongitudeY() {
		return longitudeY;
	}
	
	public Posicao(int latitudeX, int longitudeY) {
		this.latitudeX = latitudeX;
		this.longitudeY = longitudeY;
	}
	
	public Posicao(Posicao outros) {
		this.latitudeX = outros.latitudeX;
		this.longitudeY = outros.longitudeY;
	}
	
	public boolean verificarSePosicaoIgual(Posicao outros) {
		return latitudeX == outros.latitudeX && longitudeY == outros.longitudeY;
	}
	
	public boolean verificarSeEstaNoPlanalto(Planalto planalto) {
		if(latitudeX < 0 || latitudeX > planalto.getLatitudeX() || longitudeY < 0 || longitudeY > planalto.getLongitudeY()) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public Posicao andarParaFrente(PontosCardeais pontosCardeais) {
		switch (pontosCardeais) {
		case NORTE: return new Posicao(latitudeX,longitudeY + 1);
		case LESTE: return new Posicao(latitudeX + 1,longitudeY);
		case SUL: return new Posicao(latitudeX,longitudeY - 1);
		case OESTE: return new Posicao(latitudeX - 1,longitudeY);
		default: throw new RuntimeException("Ocorreu um erro!");
		}
	}
	
	public String toString() {
		return "Latitude X: " +latitudeX+", Longitude Y: "+longitudeY;
	}
}
