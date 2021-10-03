import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PortalIntercambista {
	Homestay home = new Homestay();
	public static int op;

	public void menuInt() {
		Scanner dado = new Scanner(System.in);
		System.out.println("|-------------------------------------------------|");
		System.out.println("|              PORTAL DO INTERCAMBISTA            |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("|Infome a opção desejada:                         |");
		System.out.println("|                                                 |");
		System.out.println("|[1] Cadastrar                                    |");
		System.out.println("|[2] Alterar                                      |");
		System.out.println("|[3] Consultar                                    |");
		System.out.println("|[4] Excluir                                      |");
		System.out.println("|[5] Exibir Intercambistas do Sistema             |");
		System.out.println("|[6] Sair                                         |");
		System.out.println("|-------------------------------------------------|");
		op = dado.nextInt();
	}

	public void Reproduzir(String arquivo) throws IOException {
		String nome = String.format("MoveON- Intercambista (%s)", arquivo);
		int QtLinhas= 10;
		do {
			this.menuInt();
			switch (op) {
			case 1:
				home.inter.exibirleitura(arquivo, nome, QtLinhas);
				break;

			case 2:
				home.inter.AlterarDados(arquivo, nome, QtLinhas);
				break;

			case 3:
				home.inter.ConsultarDados(nome, QtLinhas);
				break;

			case 4:
				home.inter.ExcluirDados(nome, QtLinhas);
				break;

			case 5:
				home.inter.ExibirIntercambista(arquivo);
				break;

			case 6:
				System.out.println();
				System.out.println("|-------------------------------------------------|");
				System.out.println("|                 SAÍDA DO PORTAL                 |");
				System.out.println("|-------------------------------------------------|");
				System.out.println();
				break;

			default:
				System.out.println();
				System.out.println("|-------------------------------------------------|");
				System.out.println("|               CÓDIGO INVÁLIDO                   |");
				System.out.println("|-------------------------------------------------|");
			}

		} while (op != 6);
	}
}
