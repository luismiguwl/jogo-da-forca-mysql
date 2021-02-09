package jdbc;

import java.util.List;
import java.util.Scanner;

public class AtualizarPalavras {
	private static DAO dao = new DAO();
	private static List<String> palavras = dao.obterListaDePalavras();
	
	public static void adicionar() {
		exibirListaDePalavras();
		int codigo = solicitarCodigoDaPalavra();
		String palavraSelecionada = getPalavraPorCodigo(codigo);
		System.out.println(palavraSelecionada);
	}
	
	private static void exibirListaDePalavras() {
		for (int i = 0; i < palavras.size(); i++) {
			System.out.println((i + 1) + ". " + palavras.get(i));
		}
	}

	private static int solicitarCodigoDaPalavra() {
		while (true) {
			
			int codigoDaPalavra = 0;

			try {
				
				System.out.print("\nInforme o código da palavra: ");
				codigoDaPalavra = Integer.parseInt(entrada.next());

				if (codigoDaPalavra > palavras.size() || codigoDaPalavra < 1) {
					System.out.println("\nInforme um número entre 1 e " + palavras.size());
					continue;
				}

			} catch (NumberFormatException i) {
				System.out.println("\nInforme um número inteiro");
				continue;
			}

			return codigoDaPalavra;
		}
	}

	private static String getPalavraPorCodigo(int codigo) {
		return palavras.get(codigo - 1);
	}

	private static Scanner entrada = new Scanner(System.in);

}
