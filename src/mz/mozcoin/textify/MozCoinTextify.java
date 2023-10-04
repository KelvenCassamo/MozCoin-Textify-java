package mz.mozcoin.textify;

import mz.mozcoin.textify.interfaces.MozCoinTextifyInterface;

public class MozCoinTextify {
	public Config config = null;
	private String[][] ex = Palavras.expt;
	public static final int PORTUGUESE = 0;
	public static final int ENGLISH = 1;

	private MozCoinTextifyInterface mozCoinInterface = null;

	public MozCoinTextify(Config config) {
		this.config = config;
		config.setDefaultLanguage(PORTUGUESE);
	}

	public MozCoinTextify(Config config, int idioma) {
		this.config = config;
		config.setDefaultLanguage(idioma);
	}

	public MozCoinTextify() {
		config = new Config();
		config.setDefaultLanguage(PORTUGUESE);

	}

	public void createListener(MozCoinTextifyInterface mozCoinInterface) {
		this.mozCoinInterface = mozCoinInterface;
	}

	private void setSuccess(String valor) {
		if (this.mozCoinInterface != null) {
			this.mozCoinInterface.onSuccess(valor);
		}
	}

	private void setError(String error, String valor) {
		if (this.mozCoinInterface != null) {
			this.mozCoinInterface.onError(error, valor);
		}
	}

	public void convert(String valor) {
		valor = valor.replaceAll(",", "");
		if (config.getDefaultLanguage() == 0) {
			convertToPortuguese(valor);
		} else if (config.getDefaultLanguage() == 1) {
			convertToEnglish(valor);
		} else {
			setError("Idioma inválido.", "");
		}
	}

	private void convertToPortuguese(String valor) {
		double cond = Double.parseDouble(valor);
		if (cond >= 0) {

			String[] sep = String.valueOf(valor).split("\\.");

			int meticais = Integer.parseInt(sep[0]);
			int centavos = sep.length == 2 ? Integer.parseInt(sep[1]) : 0;
			System.out.println(valor);

			String result = extensoValor(meticais) + " " + (meticais == 1 ? "metical" : "meticais");

			if (centavos > 0) {

				result += " e " + extensoValor(centavos) + " " + (centavos == 1 ? "centavo" : "centavos");

			}

			if (String.valueOf(valor).isEmpty()) {
				setError("Campo vazio.", "");
			} else {
				setSuccess(Solve.resolvePossiveisFalhas(applyConfig(result)));
			}
		} else {
			setError("Número inválido. O valor inserido não satisfaz a condição valor >= 0 ",
					String.valueOf(valor));
		}
	}

	private void convertToEnglish(String valor) {

	}

	private String applyConfig(String valor) {
		valor = config.isAutoDotEnabled() ? valor + "." : valor;

		return valor;
	}

	private String extensoValor(int valor) {

		String e = "e";
		String $ = "metical";
		String d = "centavo";
		String separador = " ";

		if (valor < 20) {
			// Vou pegar os valores da primeira linha onde o numero de colunas nao excede à
			// 19
			// System.out.println(ex[0][valor]);
			return ex[0][valor];
		} else if (valor < 100) {

			int dezena = valor / 10;

			int unidade = valor % 10;
			// System.out.println(unidade);
			String extenso = ex[1][dezena - 1];

			if (unidade != 0) {

				extenso += separador + e + separador + ex[0][unidade];
				// System.out.println(separador + e + separador + ex[0][unidade]);
			}
			// System.out.println(extenso);
			return extenso;
		} else if (valor < 1000) {
			int centena = valor / 100;
			int resto = valor % 100;
			String extenso = ex[2][centena - 0];
			if (resto != 0) {
				extenso += separador + e + separador + extensoValor(resto);
			}
			// System.out.println(extenso);
			return extenso;
		} else {
			int exp = (int) (Math.log(valor) / Math.log(1000));
			int base = (int) Math.pow(1000, exp);
			int unidade = valor / base;
			int resto = valor % base;
			String representa = ex[3][exp - 1];

			if (String.valueOf(valor).length() == 7) {
				if (Integer.parseInt(String.valueOf(valor).substring(0, 1)) > 1) {
					representa = ex[3][exp - 1].replace("ão", "ões");
				} else if (!ex[3][exp - 1].startsWith("um")) {
					representa = "um " + ex[3][exp - 1];
				}
			} else if (String.valueOf(valor).length() == 8) {
				if (Integer.parseInt(String.valueOf(valor).substring(0, 2)) >= 10) {
					representa = ex[3][exp - 1].replace("ão", "ões");
				} else if (!ex[3][exp - 1].startsWith("um")) {
					representa = "um " + ex[3][exp - 1];
				}
			} else if (String.valueOf(valor).length() == 9) {
				if (Integer.parseInt(String.valueOf(valor).substring(0, 3)) >= 100) {
					representa = ex[3][exp - 1].replace("ão", "ões");
				} else if (!ex[3][exp - 1].startsWith("um")) {
					representa = "um " + ex[3][exp - 1];
				}
			} else if (String.valueOf(valor).length() == 10) {
				if (Integer.parseInt(String.valueOf(valor).substring(0, 4)) >= 100) {
					representa = ex[3][exp - 1].replace("ão", "ões");
				} else if (!ex[3][exp - 1].startsWith("um")) {
					representa = "um " + ex[3][exp - 1];
				}
			}
			String extenso = extensoValor(unidade) + separador + representa;
			if (resto != 0) {
				// System.out.println(resto);
				extenso += separador + e + separador + extensoValor(resto);
			} // .replace("ão", "ões")

			return extenso;
		}
	}

}

/*
 * #
 * ## ## ######## ######### ######### ########## ### # #
 * # # # # # # # # # # ### # # #
 * # # # # # # # # # # ### # # #
 * # # # # # # # # # ### # # #
 * # # # # # # # # ### # # #
 * # # # # # # # # ### # # #
 * # # ######## ######### ########## ########## ### # #
 * 
 */
