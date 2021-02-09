package arquivo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class Leitor {

    public static List<String> lerArquivo() {

        String linha;
        String destino = "Palavras da forca.txt";
        List<String> lista = new ArrayList<>();

        try {
            BufferedReader lerArq = new BufferedReader(new InputStreamReader(new FileInputStream(destino), "UTF-8"));

            linha = lerArq.readLine();

            while (linha != null) {
                lista.add(linha);
//                System.out.println(linha.trim());
                linha = lerArq.readLine();
            }

            lerArq.close();

        } catch (Exception e) {
            System.out.println("Arquivo não encontrado");
        }

        return lista;
    }

    public static String removerAcentos(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

}
