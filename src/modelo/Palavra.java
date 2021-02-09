package modelo;

public class Palavra {
	private String dica;
	private String palavra;
	
	public Palavra(String palavra, String dica) {
		this.palavra = palavra;
		this.dica = dica;
	}

	public String getDica() {
		return dica;
	}
	
	public String get() {
		return palavra;
	}
	
	@Override
	public String toString() {
		return get() + " - " + getDica();
	}

}
