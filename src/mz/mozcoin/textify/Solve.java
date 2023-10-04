package mz.mozcoin.textify;

public class Solve {

    protected static String resolvePossiveisFalhas(String valor) {

        valor = valor.contains("e um mil") ? valor : valor.replace("um mil", "mil");
        valor = valor.replace("cento meticais", "cem meticais");
        valor = valor.replace("cento mil", "cem mil");
        valor = valor.replace("ões meticais", "ões de meticais");
        valor = valor.replace("ão meticais", "ão de meticais");
        valor = valor.replace("zero meticais e ", "");

        for (String palavra : Palavras.expt[1]) {
            // System.out.println(val + " e mil");
            if (valor.contains(palavra + " e mil")) {
                // System.out.println("infelizmente");
                valor = valor.replace(palavra + " e mil", palavra + " mil");
            }

        }

        for (String palavra : Palavras.expt[2]) {
            // System.out.println(val + " e mil");
            if (valor.contains(palavra + " e mil")) {
                // System.out.println("infelizmente");
                valor = valor.replace(palavra + " e mil", palavra + " mil");
            }

        }

        return valor.length() > 0
                ? valor.replaceFirst(valor.substring(0, 1), valor.substring(0, 1).toUpperCase())
                : valor;
    }

}
