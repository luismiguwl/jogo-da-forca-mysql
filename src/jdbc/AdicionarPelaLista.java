package jdbc;

import java.util.Iterator;
import java.util.List;

import arquivo.Leitor;

public class AdicionarPelaLista {

	public static void main(String[] args) {
		List<String> palavras = Leitor.lerArquivo();
		DAO dao = new DAO();

		for (int i = 0; i < palavras.size(); i++) {
			String palavra = palavras.get(i).substring(0, palavras.get(i).indexOf("|")).trim();
			String dica = palavras.get(i).replace("|", "").trim().replace(palavra, "").trim();

			if (dao.obterListaDePalavras().stream().anyMatch(p -> p.equalsIgnoreCase(palavra))) {
				continue;
			}
			
			dao.incluir(palavra, dica);
		}
		
		dao.obterListaDePalavras().stream().forEach(System.out::println);
	}

}
