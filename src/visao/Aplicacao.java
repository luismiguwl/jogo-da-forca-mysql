package visao;

import java.sql.SQLException;

import jdbc.AdicionarPalavras;
import jdbc.AtualizarPalavras;
import modelo.Menu;

public class Aplicacao {
	public static void main(String[] args) throws SQLException {
		Menu menu = new Menu();
		
		while (true) {
			menu.exibirMenu();
			int opcao = menu.solicitarOpcao();

			switch (opcao) {
				case 1:
					Controle.iniciarJogo();
					break;
				case 2:
					AdicionarPalavras.adicionar();
					break;
				case 3:
					AtualizarPalavras.adicionar();
					break;
			}
		}

	}
}
