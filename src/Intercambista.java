import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Intercambista extends Super {

	private String cpf;
	private String dataNascimento;
	private String passaporte;
	private String codIntercambio;

	TipoIntercambio ti = new TipoIntercambio();

	Intercambista() {
		this("Não Informado", "DD/MM/AAAA", "AA000000", "Vazio", "Não Informado", "Destino", "Não Informado", 0);

	}

	Intercambista(String cpf, String dataNascimento, String passaporte, String codIntercambio, String nome,
			String cidade, String endereco, int codigo) {
		super(nome, cidade, endereco, codigo);
		this.setCpf(cpf);
		this.setDataNascimento(dataNascimento);
		this.setPassaporte(passaporte);
		this.setCodIntercambio(codIntercambio);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getPassaporte() {
		return passaporte;
	}

	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}

	public String getCodIntercambio() {
		return codIntercambio;
	}

	public void setCodIntercambio(String codIntercambio) {
		this.codIntercambio = codIntercambio;
	}

	@Override
	public void lerDados(String arquivo) {
		Scanner lString = new Scanner(System.in);
		float mes;
		int j;
		System.out.print("|Nome: ");
		this.setNome(lString.nextLine());
		System.out.print("|Endereço: ");
		this.setEndereco(lString.nextLine());
		System.out.print("|CPF: ");
		this.setCpf(lString.nextLine());
		System.out.print("|Data de nascimento (DD/MM/AAAA): ");
		this.setDataNascimento(lString.nextLine());
		System.out.print("|Passaporte: ");
		this.setPassaporte(lString.nextLine());
		ti.ExibirDestinos();
		System.out.print("|Código do Destino: ");
		this.setCidade(lString.nextLine());
		this.EscolhaIntercambio(mes = 0, j = 0);
	}

	public int CalcularIdade() {
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		String DataSistema = data.format(new Date());
		int ds, ms, as, d, m, a, df1, df2, idade;

		ds = Integer.parseInt(DataSistema.substring(0, 2));
		ms = Integer.parseInt(DataSistema.substring(3, 5));
		as = Integer.parseInt(DataSistema.substring(6));
		df2 = (as * 365) + (ms * 30) + ds;
		d = Integer.parseInt(this.getDataNascimento().substring(0, 2));
		m = Integer.parseInt(this.getDataNascimento().substring(3, 5));
		a = Integer.parseInt(this.getDataNascimento().substring(6));
		df1 = (a * 365) + (m * 30) + d;
		idade = (df2 - df1) / 365;
		return idade;
	}

	public void EscolhaIntercambio(float mes, int j) {
		// ATRIBUI À VARIÁVEL MES O VALOR MENSAL DO DESTINO ESCOLHIDO
		String vd = String.format("%-8S", this.getCidade());
		for (int l = 0; l < 5; l++) {
			if (ti.Destinos[0][l].equalsIgnoreCase(vd)) {
				mes = Float.parseFloat(ti.Destinos[2][l].substring(3));
			}
		}
		// VERIFICA SE O CÓDIGO DO DESTINO INFORMADO EXISTE
		if (this.ValidaCodigo(j)) {
			Scanner lString = new Scanner(System.in);
			System.out.println("|-------------------------------------------------|");
			System.out.println("|           INTERCÂMBIOS DISPONÍVEIS:             |");
			System.out.println("|-------------------------------------------------|");
			System.out.println("|                                                 |");
			if (this.CalcularIdade() == 18) {
				ti.ExibirHighSchool(mes);
				System.out.println();
				ti.ExibirFerias(mes);
				System.out.println();
				ti.ExibirEstudoTrabalho(mes);
				System.out.print("|Código do intercâmbio desejado: ");
				this.setCodIntercambio(lString.nextLine());
				this.ValidaIntercambio();
			} else if (this.CalcularIdade() >= 15 && this.CalcularIdade() <= 18) {
				ti.ExibirHighSchool(mes);
				System.out.println();
				ti.ExibirFerias(mes);
				System.out.print("|Código do intercâmbio desejado: ");
				this.setCodIntercambio(lString.nextLine());
				this.ValidaIntercambio();
			} else if (this.CalcularIdade() >= 18) {
				ti.ExibirFerias(mes);
				System.out.println();
				ti.ExibirEstudoTrabalho(mes);
				System.out.print("|Código do intercâmbio desejado: ");
				this.setCodIntercambio(lString.nextLine());
				this.ValidaIntercambio();
			} else if (this.CalcularIdade() < 15) {
				System.out.println("|       IDADE INFERIOR À MÍNIMA PERMITIDA         |");
				System.out.println("|                                                 |");
				System.out.println("|Não possuimos intercâmbios disponíveis no momento|");
				this.setCodIntercambio("IDADE INFERIOR À PERMITIDA");
			}
		} 
	}
	
	
	// VERIFICA SE O CÓDIGO DO DESTINO INFORMADO EXISTE
	public boolean ValidaCodigo(int j) {
		String vd = String.format("%-8S", this.getCidade());
		int k = 0;
		boolean validaCodigo = false;
		for (int l = 0; l < 5; l++) {
			if (ti.Destinos[0][l].equalsIgnoreCase(vd)) {
				k = 1;
				this.setCidade(ti.Destinos[1][l]);
				validaCodigo = true;
			} else if (k == 0 && l == 4) {
				j = 2;
				System.out.println("|-------------------------------------------------|");
				System.out.println("|           CÓDIGO DO DESTINO INVÁLIDO            |");
				System.out.println("|                                                 |");
				System.out.println("| Por favor, após o final da operação, altere os  |");
				System.out.println("|dados cadastrados e informe um destino válido    |");
				this.setCidade("CÓDIGO INVÁLIDO");
				this.setCodIntercambio("0");
			}
		}
		return validaCodigo;
	}
	
	// VERIFICA SE O CÓDIGO DO INTERCÂMBIO INFORMADO EXISTE
	public void ValidaIntercambio(){
		String vd = String.format("%-8S", this.getCodIntercambio());
		int cont=0;
		for (int l = 0; l < 4; l++) {
			if (!ti.HighSchool[0][l].equalsIgnoreCase(vd)) {
				cont++;
			}
		}
		if (!ti.Ferias[0].equalsIgnoreCase(vd)){
			cont++;
		}
		for (int l = 0; l<3; l++){
			if (!ti.EstudoTrabalho[0][l].equalsIgnoreCase(vd)){
				cont++;
			}
		}
		if (cont == 8){
			System.out.println("|-------------------------------------------------|");
			System.out.println("|         CÓDIGO DO INTERCÂMBIO INVÁLIDO          |");
			System.out.println("|                                                 |");
			System.out.println("| Por favor, após o final da operação, altere os  |");
			System.out.println("|dados cadastrados e informe um intercâmbio válido|");
			this.setCodIntercambio("CÓDIGO INVÁLIDO");
		}

	}

	@Override
	public void GravarArray() {
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		String DataSistema = data.format(new Date());
		String dados = String.format(
				"|%10S%n|CÓDIGO: %-5d %n|NOME: %-20S %n|PASSAPORTE: %-8S %n|ENDEREÇO: %-40S %n|CPF: %-11s %n|DATA DE NASCIMENTO: %-10s %n|DESTINO: %-15S %n|CÓDIGO DO INTERCÂMBIO: %-5S %n|IDADE: %-3d",
				DataSistema, this.getCodigo(), this.getNome(),this.getPassaporte() , this.getEndereco(), this.getCpf(),
				this.getDataNascimento(), this.getCidade(), this.getCodIntercambio(), this.CalcularIdade());
		this.array.add(dados);
	}

	public void exibirleitura(String arquivo, String nome, int QtLinhas) throws IOException {
		Scanner dado = new Scanner(System.in);
		System.out.println("|-------------------------------------------------|");
		System.out.println("|                     CADASTRO:                   |");
		System.out.println("|                  INTERCAMBISTA                  |");
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
		System.out.println();
	}

	public void ExibirIntercambista(String arquivo) throws IOException {
		File procurar = new File("MoveON- Intercambista (" + arquivo + ").txt");
		if (procurar.exists()) {
			System.out.println("|-------------------------------------------------|");
			System.out.println("|                  INTERCAMBISTAS                 |");
			System.out.println("|-------------------------------------------------|");
			FileReader leitf = new FileReader("MoveON- Intercambista (" + arquivo + ").txt");
			BufferedReader leitl = new BufferedReader(leitf);
			String linha = leitl.readLine();
			int cont =0;
			while (linha != null) {
				cont++;
				if (cont == 10) {
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
			System.out.println("|Não existem intercambistas cadastrados           |");
		}
		System.out.println("|-------------------------------------------------|");
		System.out.println();
	}
}
