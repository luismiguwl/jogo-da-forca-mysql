package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import modelo.Palavra;

public class DAO {
	private static Connection conexao;

	static {
		conexao = getConexao();
	}

	private static Connection getConexao() {
		try {
			if (conexao != null && !conexao.isClosed()) {
				return conexao;
			}
		} catch (SQLException e) {

		}

		conexao = GeradorConexao.getConexao();
		return conexao;
	}

	private String obter(String dado, int id) throws SQLException {
		String SELECT = "SELECT linha FROM palavra_dica WHERE id = ?";

		SELECT = SELECT.replace("linha", dado + "_id");

		PreparedStatement stmt = conexao.prepareStatement(SELECT);
		stmt.setInt(1, id);

		ResultSet resultado = stmt.executeQuery();

		if (resultado.next()) {
			return resultado.getString(1);
		}

		stmt.close();
		resultado.close();

		return null;
	}

	public Palavra gerarDados() {
		try {
			int rangeMaximo = obterListaDePalavras().size();
			int idAleatorio = gerarNumeroAleatorio(rangeMaximo);

			while (idAleatorio == 0) {
				idAleatorio = gerarNumeroAleatorio(rangeMaximo);
			}

			String palavra = obter("palavra", idAleatorio);
			String dica = obter("dica", idAleatorio);

			return new Palavra(palavra, dica);
		} catch (SQLException e) {

		}

		return null;
	}

	public List<String> obterListaDePalavras() {
		try {
			String SELECT = "SELECT palavra_id FROM palavra_dica";

			PreparedStatement stmt = conexao.prepareStatement(SELECT);
			ResultSet resultado = stmt.executeQuery();

			List<String> palavras = new ArrayList<>();

			while (resultado.next()) {
				palavras.add(resultado.getString(1));
			}

			stmt.close();
			resultado.close();

			return palavras;
		} catch (SQLException e) {
		}

		return null;
	}

	private int gerarNumeroAleatorio(int maximo) {
		return new Random().nextInt(maximo);
	}

	public void fechar() {
		try {
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void incluir(String palavra, String dica) {
		try {
			String INSERT = "INSERT INTO palavra_dica (palavra_id, dica_id) VALUES (?, ?)";

			PreparedStatement stmt = conexao.prepareStatement(INSERT);
			stmt.setString(1, palavra);
			stmt.setString(2, dica);

			int linhasAfetadas = stmt.executeUpdate();

			if (linhasAfetadas > 0) {
				System.out.println("Linhas afetadas: " + linhasAfetadas);
			}

			stmt.close();
		} catch (Exception e) {

		}
	}

}
