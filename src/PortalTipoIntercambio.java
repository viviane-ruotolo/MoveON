import java.util.Scanner;

public class PortalTipoIntercambio {
	Homestay home = new Homestay();
	public  static int op;
	
	public void menuInt() {
		Scanner dado = new Scanner(System.in);
		System.out.println("|-------------------------------------------------|");
		System.out.println("|              PORTAL DOS INTERC�MBIOS            |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("|Infome a op��o desejada:                         |");
		System.out.println("|                                                 |");
		System.out.println("|[1] Consultar Destinos                           |");
		System.out.println("|[2] Relat�rio dos Interc�mbios                   |");
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
				System.out.println("|                 SA�DA DO PORTAL                 |");
				System.out.println("|-------------------------------------------------|");
				System.out.println();
				break;
				
			default:
				System.out.println("|-------------------------------------------------|");
				System.out.println("|               C�DIGO INV�LIDO                   |");
				System.out.println("|-------------------------------------------------|");
			}

		} while (op != 3);
	}
}
