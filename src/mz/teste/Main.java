package mz.teste;

import java.util.Scanner;

import mz.mozcoin.textify.MozCoinTextify;
import mz.mozcoin.textify.interfaces.MozCoinTextifyInterface;

public class Main {

	public static void main(String[] args) {

		int contador = 0;

		String valor = "3,401.10";

		MozCoinTextify mozCoinTextify = new MozCoinTextify();
		mozCoinTextify.createListener(new MozCoinTextifyInterface() {

			@Override
			public void onSuccess(String valor) {
				System.out.println(valor);

			}

			@Override
			public void onError(String error, String valor) {
				System.err.println(error);

			}
		});

		mozCoinTextify.config.setAutoDot(true);
		mozCoinTextify.config.setDefaultLanguage(MozCoinTextify.PORTUGUESE);
		mozCoinTextify.convert(valor);

		/*
		 * do {
		 * System.out.println("Digite um valor");
		 * Scanner s = new Scanner(System.in);
		 * double val = s.nextDouble();
		 * mozCoinTextify.convert(val);
		 * ++contador;
		 * } while(contador <= 10);
		 */

	}

}
