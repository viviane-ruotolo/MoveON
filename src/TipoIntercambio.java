
public class TipoIntercambio {

	// DECLARA��O DOS VETORES E MATRIZES DE DADOS

	public float ValorFinal[] = new float[8];
	// calcular o valor final atrav�s dos vetores
	// (0- 3) - high school 4 - F�rias (5-7) - Estudo e Trabalho
	public float meses[] = { 3000, 3000, 4000, 4000, 0, 3000, 3500, 4000 };
	public float meses2[] = { 6, 6, 11, 11, 1, 6, 8, 11 };

	public String Destinos[][] = new String[][] { { "DES1    ", "DES2    ", "DES3    ", "DES4    ", "DES5    " },
			{ "Vancouver (CAN)         ", "San Diego (EUA)         ", "Londres (ENG)           ",
					"Dublin (EIR)            ", "Sydney (AUS)            " },
			{ "             5500", "             7200", "            10200", "             7300",
					"             6900" } }; // VALOR INICIAL POR M�S

	public String HighSchool[][] = new String[][] { { "TP1     ", "TP2     ", "TP3     ", "TP4     " },
			{ "6 Meses     ", "6 Meses     ", "1 Ano       ", "1 Ano       " },
			{ "Sim       ", "N�o       ", "Sim       ", "N�o       " } };

	public String Ferias[] = { "TP5     ", "1 M�s       ", "N�o       " };

	public String EstudoTrabalho[][] = new String[][] { { "TP6     ", "TP7     ", "TP8     " },
			{ "6 Meses     ", "8 Meses     ", "1 Ano       " }, { "Sim       ", "Sim       ", "Sim       " } };

	// EXIBI��O DOS DADOS

	public void ExibirDestinos() {
		System.out.println("|-------------------------------------------------|");
		System.out.println("|                      DESTINOS                   |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("|                                                 |");
		System.out.printf("|%-8S%-20S%21s|%n", "C�DIGO ", "CIDADE (PA�S)", "VALOR MENSAL");
		for (int l = 0; l < 5; l++) {
			System.out.print("|");
			for (int c = 0; c < 3; c++) {
				System.out.print(Destinos[c][l]);
			}
			System.out.println("|");
		}
		System.out.println("|-------------------------------------------------|");
		System.out.println();
	}

	public void ExibirHighSchool(float mes) {
		System.out.println("|             HIGH SCHOOL (15 A 18 ANOS)          |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("|                                                 |");
		System.out.printf("|%-8S%-12S%-10S%19s|%n", "C�DIGO ", "TEMPO", "TRABALHO", "VALOR");
		for (int l = 0; l < 4; l++) {
			System.out.print("|");
			for (int c = 0; c < 3; c++) {
				System.out.print(HighSchool[c][l]);
			}
			ValorFinal[l] = (mes - meses[l]) * meses2[l];
			if (ValorFinal[l] < 0) {
				ValorFinal[l] = 0;
			}
			System.out.printf("%19.2f", ValorFinal[l]);
			System.out.println("|");
		}
		System.out.println("|-------------------------------------------------|");
		System.out.println();
	}

	public void ExibirFerias(float mes) {
		System.out.println("|      CURSO DE F�RIAS (A PARTIR DE 15 ANOS)      |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("|                                                 |");
		System.out.printf("|%-8S%-12S%-10S%19s|%n", "C�DIGO ", "TEMPO", "TRABALHO", "VALOR");
		System.out.print("|");
		for (int l = 0; l < 3; l++) {
			System.out.print(Ferias[l]);
		}
		ValorFinal[4] = (mes - meses[4]) * meses2[4];
		if (ValorFinal[4] < 0) {
			ValorFinal[4] = 0;
		}
		System.out.printf("%19.2f", ValorFinal[4]);
		System.out.println("|");
		System.out.println("|-------------------------------------------------|");
		System.out.println();
	}

	public void ExibirEstudoTrabalho(float mes) {
		System.out.println("|CURSO COM ESTUDO E TRABALHO (A PARTIR DE 18 ANOS)|");
		System.out.println("|-------------------------------------------------|");
		System.out.println("|                                                 |");
		System.out.printf("|%-8S%-12S%-10S%19s|%n", "C�DIGO ", "TEMPO", "TRABALHO", "VALOR");
		for (int l = 0; l < 3; l++) {
			System.out.print("|");
			for (int c = 0; c < 3; c++) {
				System.out.print(EstudoTrabalho[c][l]);
			}
			ValorFinal[l] = (mes - meses[l]) * meses2[l];
			//QUANDO N�O TEM UM DESTINO DEFINIDO, MES = 0 E O RESULTADO � NEGATIVO
			if (ValorFinal[l] < 0) {
				ValorFinal[l] = 0;
			}
			System.out.printf("%19.2f", ValorFinal[l]);
			System.out.println("|");
		}
		System.out.println("|-------------------------------------------------|");
	}

	public void RelatoriosIntercambios(float mes) {
		System.out.println("|-------------------------------------------------|");
		System.out.println("|        TIPOS DE INTERC�MBIOS DISPON�VEIS        |");
		System.out.println("|                                                 |");
		this.ExibirDestinos();
		this.ExibirHighSchool(mes);
		this.ExibirFerias(mes);
		this.ExibirEstudoTrabalho(mes);
		System.out.println("|    Os valores variam de acordo com o destino    |");
		System.out.println("|                                       escolhido |");
		System.out.println("|-------------------------------------------------|");
	}
}
