import java.util.Date;
import java.util.Scanner;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Homestay extends Super {

	private int quantPessoas;
	private int intercambista;

	Intercambista inter = new Intercambista();

	Homestay() {
		this(0, 0, "Não Informado", "Não Informada", "Não Informado", 0);
	}

	Homestay(int intercambista, int quantPessoas, String nome, String cidade, String endereco, int codigo) {
		super(nome, cidade, endereco, codigo);
		this.setQuantPessoas(quantPessoas);
		this.setIntercambista(intercambista);
	}

	public int getQuantPessoas() {
		return quantPessoas;
	}

	public void setQuantPessoas(int quantPessoas) {
		this.quantPessoas = quantPessoas;
	}

	public int getIntercambista() {
		return intercambista;
	}

	public void setIntercambista(int i) {
		this.intercambista = i;
	}

	@Override
	public void lerDados(String arquivo) throws IOException {
		Scanner lString = new Scanner(System.in);
		Scanner dado = new Scanner(System.in);
		System.out.print("|Nome da família: ");
		this.setNome(lString.nextLine());
		inter.ti.ExibirDestinos();
		System.out.print("|Código da sua cidade: ");
		this.setCidade(lString.nextLine());
		this.ValidaCidade();
		System.out.print("|Endereço: ");
		this.setEndereco(lString.nextLine());
		System.out.print("|Quantidade de pessoas: ");
		this.setQuantPessoas(dado.nextInt());
		System.out.println();
		inter.ExibirIntercambista(arquivo);
		File procurar = new File(arquivo+").txt");
		if (!procurar.exists()){
			this.setIntercambista(0);
		} else{
			System.out.println();
			System.out.print("|Código do intercambista desejado: ");
			this.setIntercambista(dado.nextInt());
		}
	}

	// VERIFICAR SE O CÓDIGO DA CIDADE EXISTE
	// CASO EXISTA É SALVO O NOME E PAÍS RELACIONADO A ELA
	public void ValidaCidade() {
		String vd = String.format("%-8S", this.getCidade());
		int k = 0;
		for (int l = 0; l < 5; l++) {
			if (inter.ti.Destinos[0][l].equalsIgnoreCase(vd)) {
				k = 1;
				this.setCidade(inter.ti.Destinos[1][l]);
			} else if (k == 0 && l == 4) {
				this.setCidade("CÓDIGO INVÁLIDO");
				System.out.println("|-------------------------------------------------|");
				System.out.println("|            CÓDIGO DA CIDADE INVÁLIDO            |");
				System.out.println("|Por favor, após o final da operação, altere os   |");
				System.out.println("|dados cadastrados e informe uma cidade válida    |");
				System.out.println("|-------------------------------------------------|");
			}
		}
	}

	@Override
	public void GravarArray() {
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		String DataSistema = data.format(new Date());
		String dados = String.format(
				"|%10S%n|CÓDIGO: %-5d %n|NOME: %-20S %n|DESTINO: %-15S %n|ENDEREÇO: %-40S %n|QUANTIDADE DE PESSOAS: %-3d %n|CÓDIGO DO INTERCAMBISTA: %-5d",
				DataSistema, this.getCodigo(), this.getNome(), this.getCidade(), this.getEndereco(), this.getQuantPessoas(),
				this.getIntercambista());
		this.array.add(dados);
	}

	public void exibirleitura(String arquivo, String nome, int QtLinhas) throws IOException {
		Scanner dado = new Scanner(System.in);
		String dados;
		System.out.println("|-------------------------------------------------|");
		System.out.println("|                     CADASTRO:                   |");
		System.out.println("|                     HOMESTAY                    |");
		System.out.println("|-------------------------------------------------|");
		System.out.println("|Informe os dados abaixo:                         |");
		System.out.println("|                                                 |");
		this.lerDados(arquivo);
		File procurar = new File(nome + ".txt");
		if (procurar.exists()) {
			this.ProcurarTxt(nome, QtLinhas);
		}
		this.setCodigo((this.array.size()+1));
		procurar.delete();
		this.GravarArray();
		this.GravarTxt(nome, QtLinhas);
		System.out.println("|-------------------------------------------------|");
		System.out.println();	}

	public void ExibirHomestay(String arquivo) throws IOException {
		File procurar = new File("MoveON- Homestay (" + arquivo + ").txt");
		System.out.println();
		if (procurar.exists()) {
			System.out.println("|-------------------------------------------------|");
			System.out.println("|                     HOMESTAY                    |");
			System.out.println("|-------------------------------------------------|");
			FileReader leitf = new FileReader("MoveON- Homestay (" + arquivo + ").txt");
			BufferedReader leitl = new BufferedReader(leitf);
			String linha = leitl.readLine();
			int cont=0;
			while (linha != null) {
				cont++;
				if (cont == 7) {
					System.out.println(linha);
					System.out.println();
					cont = 0;
				} else {
					System.out.println(linha);
				}
				linha = leitl.readLine();
			}
			leitl.close();
		} else {
			System.out.println("|-------------------------------------------------|");
			System.out.println("|Não existem homestays cadastrados                |");
		}
		System.out.println("|-------------------------------------------------|");
		System.out.println();
	}
}
