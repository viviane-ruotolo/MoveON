import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GerenciamentoSistema {
	public static int op;
	public static String arquivo2 = "";
	Homestay home = new Homestay();

	public void menuInt() {
		Scanner dado = new Scanner(System.in);
		System.out.println("|-------------------------------------------------|");
		System.out.println("|            GERENCIAMENTO DO SISTEMA             |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("|Infome a op��o desejada:                         |");
		System.out.println("|                                                 |");
		System.out.println("|[1] Relat�rio de Dados do Arquivo                |");
		System.out.println("|[2] Alterar Descri��o do Arquivo                 |");
		System.out.println("|[3] Exibir Arquivos do Sistema                   |");
		System.out.println("|[4] Excluir Arquivo do Sistema                   |");
		System.out.println("|[5] Sair                                         |");
		System.out.println("|-------------------------------------------------|");
		op = dado.nextInt();
	}

	public void Reproduzir(String arquivo) throws IOException {
		Scanner dado = new Scanner(System.in);
		do {
			this.menuInt();
			switch (op) {
			case 1:
				System.out.println();
				System.out.println("|-------------------------------------------------|");
				System.out.println("|          RELAT�RIO DE DADOS CADASTRADOS         |");
				System.out.println("|                                                 |");
				if (arquivo.isEmpty()){
					System.out.println("|-------------------------------------------------|");
					System.out.println("|             ARQUIVO N�O ESPECIFICADO            |");
					System.out.println("|-------------------------------------------------|");
				} else{
					home.inter.ExibirIntercambista(this.arquivo(arquivo));
					home.ExibirHomestay(this.arquivo(arquivo));
				}
				System.out.println();
				break;

			case 2:
				System.out.println();
				System.out.println("|-------------------------------------------------|");
				System.out.print("|Informe a descri��o do arquivo: ");
				arquivo2 = dado.nextLine();
				arquivo = this.arquivo(arquivo);
				System.out.println();
				System.out.println("|-------------------------------------------------|");
				System.out.println("|            ARQUIVO ALTERADO COM SUCESSO         |");
				System.out.println("|-------------------------------------------------|");
				System.out.println();
				break;

			case 3:
				// EXIBIR ARQUIVOS DO SISTEMA
				File file = new File("./");
				String[] arquivos = file.list();
				System.out.println("|-------------------------------------------------|");
				System.out.println("|               ARQUIVOS DO SISTEMA               |");
				System.out.println("|-------------------------------------------------|");
				System.out.println();
				if (arquivos.length > 4) {
					for (int i = 4; i < arquivos.length - 1; i++) {
						System.out.println("|" + arquivos[i]);
					}

				} else {
					System.out.println("|-------------------------------------------------|");
					System.out.println("|         N�O EXISTEM ARQUIVOS NO SISTEMA         |");
				}
				System.out.println("|-------------------------------------------------|");
				System.out.println();
				break;

			case 4:
				System.out.println();
				System.out.println("|-------------------------------------------------|");
				System.out.println("|Informe a descri��o do arquivo que deseja excluir|");
				System.out.print("|");
				String excluir = dado.nextLine();
				arquivo = "";
				home.ExcluirTxt(excluir);
				break;

			case 5:
				System.out.println();
				System.out.println("|-------------------------------------------------|");
				System.out.println("|         SA�DA DO GERENCIAMENTO DO SISTEMA       |");
				System.out.println("|-------------------------------------------------|");
				System.out.println();
				break;

			default:
				System.out.println("|-------------------------------------------------|");
				System.out.println("|               C�DIGO INV�LIDO                   |");
				System.out.println("|-------------------------------------------------|");
				System.out.println();
			}

		} while (op != 5);
	}

	//m�todo que retorna o arquivo atualizado
	public String arquivo(String arquivo) {
		String arquivof;
		if (arquivo2.equalsIgnoreCase("")) {
			//arquivo2 � a descri��o inserida para alterar o arquivo
			arquivof = arquivo;
		} else {
			arquivof = arquivo2;
		}
		return arquivof;
	}

}
