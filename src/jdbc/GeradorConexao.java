package jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GeradorConexao {
	public static Connection getConexao() {
		try {
			Properties prop = getProperties();
			
			String url = prop.getProperty("banco.url");
			String usuario = prop.getProperty("banco.usuario");
			String senha = prop.getProperty("banco.senha");
			
			return DriverManager.getConnection(url, usuario, senha);
		} catch (SQLException | IOException e) {

		}
		return null;
	}

	private static Properties getProperties() throws IOException {
		Properties prop = new Properties();
		String caminho = "/conexao.properties";
		prop.load(GeradorConexao.class.getResourceAsStream(caminho));
		return prop;
	}

}
