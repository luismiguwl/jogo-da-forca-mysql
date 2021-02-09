package jdbc;

import java.util.List;
import java.util.Scanner;

public class AdicionarPalavras {

	private static DAO dao = new DAO();
	private static List<String> palavras = dao.obterListaDePalavras();

	public static void adicionar() {
		
		while (true) {
			String palavra = solicitarDado("Palavra");

			if (verificarDuplicidade(palavra)) {
				System.out.println("\nPalavra já existe!\n");
				continue;
			}

			String dica = solicitarDado("Dica");

			dao.incluir(palavra, dica);
			break;
		}

		if (!solicitarContinuidade()) {
			return;
		}
		
		adicionar();
	}

	private static String solicitarDado(String tipo) {
		System.out.print(tipo + ": ");
		String dado = entrada.nextLine();
		return dado;
	}

	private static boolean verificarDuplicidade(String palavra) {
		return palavras.stream().anyMatch(p -> p.equalsIgnoreCase(palavra));
	}

	private static boolean solicitarContinuidade() {

		while (true) {
			System.out.print("Deseja inserir mais uma palavra? (S/N): ");
			char resposta = entrada.next().charAt(0);

			resposta = Character.toLowerCase(resposta);

			if (resposta == 's') {
				return true;
			} else if (resposta == 'n') {
				return false;
			} else {
				System.out.println("\n'" + resposta + "' não é válido. Informe S ou N!\n");
			}
		}

	}

	private static Scanner entrada = new Scanner(System.in);

}
