import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.io.*;
import java.text.SimpleDateFormat;

public class Super {

	private String nome;
	private String cidade;
	private String endereco;
	private int codigo;
	public ArrayList<String> array = new ArrayList<String>();

	Super() {
		this("Não Informado", "CIDADE(PAÍS)", "Não Informado", 0);

	}

	Super(String nome, String cidade, String endereco, int codigo) {
		this.setNome(nome);
		this.setCidade(cidade);
		this.setEndereco(endereco);
		this.setCodigo(codigo);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void AlterarDados(String arquivo, String nome, int QtLinhas) throws IOException {
		String cod, cod2;
		Scanner lString = new Scanner(System.in);
		System.out.println("|-------------------------------------------------|");
		System.out.println("|               ALTERAÇÃO DE DADOS:               |");
		System.out.println("|-------------------------------------------------|");
		System.out.print("|INFORME O CÓDIGO: ");
		cod = lString.next();
		cod2 = String.format("%-6S%n", cod);
		System.out.println();
		int k = -1;
		File procurar = new File(nome + ".txt");
		if (procurar.exists()) {
			this.ProcurarTxt(nome, QtLinhas);
			for (int i = 0; i < this.array.size(); i++) {
				if (cod2.equals(this.array.get(i).substring(22, 30))) {
					this.array.remove(i);
					this.lerDados(arquivo);
					this.setCodigo((i+1));
					this.GravarArray();
					procurar.delete();
					this.GravarTxt(nome, QtLinhas);
					k = 1;
					// se i == this.array -1: percorrer todo o array
					// se k=0 -> não entrou no if
				} else if (i == this.array.size() - 1 && k == -1) {
					System.out.println("|-------------------------------------------------|");
					System.out.println("|               CÓDIGO INVÁLIDO                   |");
				}
			}
		} else {
			System.out.println("|-------------------------------------------------|");
			System.out.println("|          NÃO EXISTEM DADOS CADASTRADOS          |");
		}
		System.out.println("|-------------------------------------------------|");
		System.out.println();
	}

	public void ConsultarDados(String nome, int QtLinhas) throws IOException {
		String cod, cod2;
		Scanner lString = new Scanner(System.in);
		System.out.println("|-------------------------------------------------|");
		System.out.println("|                CONSULTA DE DADOS:               |");
		System.out.println("|-------------------------------------------------|");
		System.out.print("|INFORME O CÓDIGO: ");
		cod = lString.next();
		cod2 = String.format("%-6S%n", cod);
		System.out.println();
		int k = -1;
		File procurar = new File(nome + ".txt");
		if (procurar.exists()) {
			this.ProcurarTxt(nome, QtLinhas);
			for (int i = 0; i < this.array.size(); i++) {
				if (cod2.equals(this.array.get(i).substring(22, 30))) {
					System.out.println(this.array.get(i));
					k = 1;
				} else if (i == this.array.size() - 1 && k == -1) {
					System.out.println("|-------------------------------------------------|");
					System.out.println("|               CÓDIGO INVÁLIDO                   |");
				}
			}
			this.array.clear();
		} else {
			System.out.println("|-------------------------------------------------|");
			System.out.println("|          NÃO EXISTEM DADOS CADASTRADOS          |");
		}
		System.out.println("|-------------------------------------------------|");
		System.out.println();
	}

	public void ExcluirDados(String nome, int QtLinhas) throws IOException {
		String cod, cod2;
		Scanner lString = new Scanner(System.in);
		System.out.println("|-------------------------------------------------|");
		System.out.println("|                EXCLUSÃO DE DADOS:               |");
		System.out.println("|-------------------------------------------------|");
		System.out.print("|INFORME O CÓDIGO: ");
		cod = lString.next();
		cod2 = String.format("%-6S%n", cod);
		System.out.println();
		int k = -1;
		File procurar = new File(nome + ".txt");
		if (procurar.exists()) {
			this.ProcurarTxt(nome, QtLinhas);
			for (int i = 0; i < this.array.size(); i++) {
				if (cod2.equals(this.array.get(i).substring(22, 30))) {
					this.array.remove(i);
					procurar.delete();
					this.GravarTxt(nome, QtLinhas);
					System.out.println("|-------------------------------------------------|");
					System.out.println("|            DADOS EXCLUÍDOS COM SUCESSO          |");
					k = 1;
				} else if (i == this.array.size() - 1 && k == -1) {
					System.out.println("|-------------------------------------------------|");
					System.out.println("|               CÓDIGO INVÁLIDO                   |");
				}
			}
		} else {
			System.out.println("|-------------------------------------------------|");
			System.out.println("|          NÃO EXISTEM DADOS CADASTRADOS          |");
		}
		System.out.println("|-------------------------------------------------|");
		System.out.println();
	}

	// MÉTODOS NECESSÁRIOS NA CONSULTA, ALTERAÇÃO E EXCLUSÃO

	public void lerDados(String arquivo) throws IOException {
		Scanner lString = new Scanner(System.in);
		System.out.print("|Nome: ");
		this.setNome(lString.nextLine());
		System.out.print("|Cidade (PAÍS): ");
		this.setCidade(lString.nextLine());
		System.out.print("|Endereço: ");
		this.setEndereco(lString.nextLine());
	}

	public void exibirDados() {
		System.out.println("|NOME: " + this.getNome());
		System.out.println("|CIDADE: " + this.getCidade());
		System.out.println("|ENDEREÇO: " + this.getEndereco());
		System.out.println("|CÓDIGO: " + this.getCodigo());
	}

	public void GravarArray() {
		String dados = String.format("%-20S,%-20S,%30S", this.getNome(), this.getCidade(), this.getEndereco());
		this.array.add(dados);
	}

	// ABRIR E GRAVAR DADOS NO ARQUIVO TXT

	// METODO USADO NO GRAVAR TXT PARA LER O ARQUIVO Q JÁ EXISTE E GRAVAR NO
	// ARRAY, PARA GRAVAR NO NOVO TXT

	public void ProcurarTxt(String nome, int QtLinhas) throws IOException {
		FileReader leitf = new FileReader(nome + ".txt");
		BufferedReader leitl = new BufferedReader(leitf);
		String linha = leitl.readLine();
		String dados = "";
		int cont = 0;
		while (linha != null) {
			cont++;
			dados = String.format("%S%S%n", dados, linha);
			if (cont == QtLinhas) {
				this.array.add(dados);
				dados = "";
				cont = 0;
			} 
			linha = leitl.readLine();
		}
		leitl.close();
	}

	public void GravarTxt(String nome, int QtLinhas) throws IOException {
		File procurar = new File(nome + ".txt");
		if (procurar.exists()) {
			this.ProcurarTxt(nome, QtLinhas);
		}
		FileWriter gravf = new FileWriter(nome + ".txt");
		PrintWriter gravl = new PrintWriter(gravf);
		for (int i = 0; i < this.array.size(); i++) {
			gravl.printf(this.array.get(i));
		}
		gravf.close();
		this.array.clear();
	}

	public void ExcluirTxt(String arquivo2) {
		int contH = 0, contI = 0;
		File procurarInter = new File(
				"MoveON- Intercambista (" + arquivo2 + ").txt");
		File procurarHome = new File("MoveON- Homestay (" + arquivo2 + ").txt");
		if (procurarInter.exists()) {
			contH = 1;
			procurarInter.delete();
		}
		if (procurarHome.exists()) {
			contI = 1;
			procurarHome.delete();
		}
		if (contH == 1 || contI == 1) {
			System.out.println("|-------------------------------------------------|");
			System.out.println("|           ARQUIVO EXCLUÍDO COM SUCESSO          |");
			System.out.println("|-------------------------------------------------|");
		}
		if (contH == 0 && contI == 0) {
			System.out.println("|-------------------------------------------------|");
			System.out.println("|          O ARQUIVO INFORMADO NÃO EXISTE         |");
			System.out.println("|-------------------------------------------------|");
		}
		System.out.println();
	}

}
