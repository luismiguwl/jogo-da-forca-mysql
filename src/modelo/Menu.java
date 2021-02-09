package modelo;

import java.util.Scanner;

public class Menu {

	public final String[] opcoes = { "Iniciar", "Adicionar palavras", "Atualizar palavras" };

	public void exibirMenu() {
		for (int i = 0; i < opcoes.length; i++) {
			System.out.println((i + 1) + ". " + opcoes[i]);
		}
	}

	public int solicitarOpcao() {
		while (true) {

			int opcao = 0;
			
			try {
				
				System.out.print("\nOpção selecionada: ");
				opcao = Integer.parseInt(entrada.next());

				if (opcao > opcoes.length || opcao < 1) {
					System.out.println("\nInforme um número entre 1 e " + opcoes.length);
					continue;
				}

			} catch (NumberFormatException i) {
				System.out.println("\nInforme um número inteiro");
				continue;
			}

			return opcao;
		}
	}

	public Scanner entrada = new Scanner(System.in);
}
