import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PortalHomestay {
	Homestay home = new Homestay();
	public static int op;

	public void menuInt() {
		Scanner dado = new Scanner(System.in);
		System.out.println("|-------------------------------------------------|");
		System.out.println("|                PORTAL DO HOMESTAY               |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("|Infome a opção desejada:                         |");
		System.out.println("|                                                 |");
		System.out.println("|[1] Cadastrar                                    |");
		System.out.println("|[2] Alterar                                      |");
		System.out.println("|[3] Consultar                                    |");
		System.out.println("|[4] Excluir                                      |");
		System.out.println("|[5] Exibir Hommestays do Sistema                 |");
		System.out.println("|[6] Sair                                         |");
		System.out.println("|-------------------------------------------------|");
		op = dado.nextInt();
	}

	public void Reproduzir(String arquivo) throws IOException {
		String nome = String.format("MoveON- Homestay (%s)", arquivo);
		int QtLinhas = 7;
		do {
			this.menuInt();
			switch (op) {
			case 1:
				home.exibirleitura(arquivo, nome, QtLinhas);
				break;

			case 2:
				home.AlterarDados(arquivo, nome, QtLinhas);
				break;

			case 3:
				home.ConsultarDados(nome, QtLinhas);
				break;

			case 4:
				home.ExcluirDados(nome, QtLinhas);
				break;

			case 5:
				home.ExibirHomestay(arquivo);
				break;

			case 6:
				System.out.println();
				System.out.println("|-------------------------------------------------|");
				System.out.println("|                 SAÍDA DO PORTAL                 |");
				System.out.println("|-------------------------------------------------|");
				System.out.println();
				break;

			default:
				System.out.println("|-------------------------------------------------|");
				System.out.println("|               CÓDIGO INVÁLIDO                   |");
				System.out.println("|-------------------------------------------------|");
			}

		} while (op != 6);
	}

}
