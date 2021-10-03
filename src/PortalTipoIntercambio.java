import java.util.Scanner;

public class PortalTipoIntercambio {
	Homestay home = new Homestay();
	public  static int op;
	
	public void menuInt() {
		Scanner dado = new Scanner(System.in);
		System.out.println("|-------------------------------------------------|");
		System.out.println("|              PORTAL DOS INTERCÂMBIOS            |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("|Infome a opção desejada:                         |");
		System.out.println("|                                                 |");
		System.out.println("|[1] Consultar Destinos                           |");
		System.out.println("|[2] Relatório dos Intercâmbios                   |");
		System.out.println("|[3] Sair                                         |");
		System.out.println("|-------------------------------------------------|");
		op = dado.nextInt();
	}
	
	public void Reproduzir(){
		do {
			this.menuInt();
			switch (op) {
			case 1:
				home.inter.ti.ExibirDestinos();
				break;

			case 2:
				float mes = 0;
				home.inter.ti.RelatoriosIntercambios(mes);
				System.out.println();
				break;

			case 3:
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

		} while (op != 3);
	}
}
