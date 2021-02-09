package visao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controle {
	private static GeracaoDoJogo gerador;
	private static char[] palavraSublinhada;
	private static String palavraSelecionada;
	private static List<Character> caracteresInformados;

	private Controle() {
		gerador = new GeracaoDoJogo();
		palavraSublinhada = gerador.getPalavraSublinhada();
		palavraSelecionada = gerador.getWord();
		caracteresInformados = new ArrayList<>();
	}

	public static void iniciarJogo() {
		new Controle();
		int erros = 0;
		int chances = 5;

		System.out.println("Dica: " + gerador.getDica());

		while (true) {
			char letra = solicitarLetra();

			if (identificarLetraRepetida(letra)) {
				System.out.println("\nVocê já informou a letra " + letra);
				continue;
			}

			caracteresInformados.add(letra);

			if (verificarAcerto(letra)) {

				if (identificarFimDeJogo()) {
					System.out.println("Você venceu!");
					break;
				}

				System.out.println();
				System.out.println(palavraSublinhada);

			} else {
				erros++;

				if (erros == chances) {
					System.out.println("Você perdeu!");
					System.out.println("A palavra era " + palavraSelecionada);
					break;
				}

				System.out.println("\nERRO!");
				System.out.print("Você ainda tem " + (chances - erros));
				System.out.println(" chances");
			}

		}

		if (solicitarParada()) {
			System.out.println("---------------------------");
			return;
		}

		iniciarJogo();

	}

	private static char solicitarLetra() {
		System.out.print("\nInforme uma letra: ");
		char letra = entrada.next().charAt(0);

		return letra;
	}

	private static boolean identificarLetraRepetida(char letra) {
		return caracteresInformados.parallelStream().anyMatch(c -> c == letra);
	}

	private static boolean verificarAcerto(char letra) {
		letra = Character.toLowerCase(letra);
		boolean letraEncontrada = false;

		for (int i = 0; i < palavraSublinhada.length; i++) {
			if (letra == palavraSelecionada.toLowerCase().charAt(i)) {
				palavraSublinhada[i] = palavraSelecionada.charAt(i);
				letraEncontrada = true;
			}
		}

		return letraEncontrada;
	}

	private static boolean identificarFimDeJogo() {

		for (int i = 0; i < palavraSublinhada.length; i++) {
			if (palavraSublinhada[i] == '_') {
				return false;
			}
		}

		return true;
	}

	public static boolean solicitarParada() {
		while (true) {
			System.out.print("Deseja continuar jogando? (S/N): ");
			char resposta = entrada.next().charAt(0);

			if (Character.toLowerCase(resposta) == 's') {
				return false;
			} else if (Character.toLowerCase(resposta) == 'n') {
				return true;
			} else {
				System.out.print("\n'" + resposta + "' não é válido");
				System.out.println(". Informe S ou N!\n");
			}
		}
	}

	private static Scanner entrada = new Scanner(System.in);
}
