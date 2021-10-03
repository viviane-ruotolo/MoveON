import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.io.*;

public class MoveOnMain {

	PortalIntercambista PInter = new PortalIntercambista();
	PortalHomestay PHome = new PortalHomestay();
	public static int op1;
	public static int op2;
	public static String arquivo;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PortalIntercambista PInter = new PortalIntercambista();
		PortalHomestay PHome = new PortalHomestay();
		PortalTipoIntercambio Pti = new PortalTipoIntercambio();
		GerenciamentoSistema Gs = new GerenciamentoSistema();
		MoveOnMain main = new MoveOnMain();
		Scanner dado = new Scanner(System.in);
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		String DataSistema = data.format(new Date());
		main.Logo();
		
		// RECEBE A DESCRI��O DO ARQUIVO QUE VAI DIFERENCI�-LOS
		System.out.print("|Informe a descri��o do arquivo: ");
		arquivo = dado.nextLine();
		System.out.println();
		do {
			main.Menu2();
			switch (op2) {
			case 1:
				PInter.Reproduzir(Gs.arquivo(arquivo));
				break;

			case 2:
				PHome.Reproduzir(Gs.arquivo(arquivo));
				break;

			case 3:
				Pti.Reproduzir();
				break;

			case 4:
				Gs.Reproduzir(arquivo);				
				break;

			case 5:
				System.out.println();
				System.out.println("|Dados cadastrados em: " + DataSistema + "                 |");
				System.out.println("|-------------------------------------------------|");
				System.out.println("|           FIM DA EXECU��O DO PROGRAMA           |");
				System.out.println("|-------------------------------------------------|");
				break;

			default:
				System.out.println("|-------------------------------------------------|");
				System.out.println("|               C�DIGO INV�LIDO                   |");
				System.out.println("|-------------------------------------------------|");
			}

		} while (op2 != 5);
	}

	public void Logo() {
		System.out.println("|-------------------------------------------------|");
		System.out.println("|                            ___                  |");
		System.out.println("|  |\\    //|  __         __ |   | |\\ |            |");
		System.out.println("|  | \\  // | |  | \\  // |__ |___| | \\|            |");
		System.out.println("|  |  \\//  | |__|  \\//  |__                       |");
		System.out.println("|                                                 |");
		System.out.println("|                      Created by: Viviane Ruotolo|");
		System.out.println("|                                                 |");
		System.out.println("|                                                 |");
		System.out.println("|	Uma ag�ncia de interc�mbios que oferece   |");
		System.out.println("|hospedagem 100% em Homestay (Casa de fam�lia) e  |");
		System.out.println("|qualidade no aperfei�oamento do ingl�s           |");
		System.out.println("|	Nossos pacotes incluem:                   |");
		System.out.println("| - Caf� da manh� e janta                         |");
		System.out.println("| - Passagem a�rea                                |");
		System.out.println("| - Aulas de ingl�s                               |");
		System.out.println("| - Exame de profici�ncia Cambridge               |");
		System.out.println("| - Taxa de matr�cula                             |");
		System.out.println("| - Material did�tico                             |");
		System.out.println("| - Assist�ncia m�dica                            |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("|                                                 |");

	}

	public void Menu2() {
		Scanner dado = new Scanner(System.in);
		System.out.println("|-------------------------------------------------|");
		System.out.println("|                        MENU                     |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("|Infome a op��o desejada:                         |");
		System.out.println("|                                                 |");
		System.out.println("|[1] Portal do Intercambista                      |");
		System.out.println("|[2] Portal do Homestay                           |");
		System.out.println("|[3] Portal dos Interc�mbios                      |");
		System.out.println("|[4] Gerenciamento do Sistema                     |");
		System.out.println("|[5] Sair                                         |");
		System.out.println("|-------------------------------------------------|");
		op2 = dado.nextInt();

	}
}

//1204 linhas
