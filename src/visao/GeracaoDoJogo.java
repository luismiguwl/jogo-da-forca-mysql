package visao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jdbc.DAO;
import modelo.Palavra;

public class GeracaoDoJogo {
	private char[] palavraSublinhada;
	private Palavra palavra;
	private DAO dao;

	public void sublinhar() {
		for (int i = 0; i < palavraSublinhada.length; i++) {
			if (palavraSublinhada[i] == ' ') {
				continue;
			}

			if (palavraSublinhada[i] == '-') {
				continue;
			}

			palavraSublinhada[i] = '_';
		}
	}

	public GeracaoDoJogo() {
		dao = new DAO();
		palavra = dao.gerarDados();
		palavraSublinhada = palavra.get().toCharArray();
		sublinhar();
	}

	public char[] getPalavraSublinhada() {
		return palavraSublinhada;
	}

	public String getWord() {
		return palavra.get();
	}

	public String getDica() {
		return palavra.getDica();
	}

}