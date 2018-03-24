//Renata Soria
// Fundamentos de Desenvolvimento de Software - Turma 168 - 2018/1 - Prof. Michael da Costa Mora


import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Cliente> listaClientes = new ArrayList();
		ArrayList<Caixa> caixas = new ArrayList();
		GregorianCalendar calendar = new GregorianCalendar();

		// Cria os caixas e adiciona na lista de caixas
		Caixa caixa1 = new Caixa(1);
		Caixa caixa2 = new Caixa(2);
		Caixa caixa3 = new Caixa(3);
		Caixa caixa4 = new Caixa(4);
		Caixa caixa5 = new Caixa(5);
		Caixa caixa6 = new Caixa(6);
		Caixa caixa7 = new Caixa(7);
		caixas.add(caixa1);
		caixas.add(caixa2);
		caixas.add(caixa3);
		caixas.add(caixa4);
		caixas.add(caixa5);
		caixas.add(caixa6);
		caixas.add(caixa7);

		Scanner ler = new Scanner(System.in);
		System.out.println("Digite o nome do Banco");
		String nomeBanco = ler.nextLine();

		Banco banco = new Banco(listaClientes, caixas, nomeBanco);
		int op = 0;

		do {

			System.out.println("0 - Sair");
			System.out.println("1 - Cadastrar Cliente");
			System.out.println("2 - Solicitar Cliente");
			System.out.println("3 - Liberar Caixa");

			op = ler.nextInt();

			switch (op) {
			case 1:
				System.out.println("Digite o nome do cliente");
				try {
					String nomePessoa = ler.nextLine();
					nomePessoa = ler.nextLine();
					System.out.println("Digite a idade do cliente");
					int idade = ler.nextInt();			
					int minutos = calendar.MINUTE;
					int hora = calendar.HOUR;
					Cliente cliente = new Cliente(nomePessoa, idade, hora, minutos);
					listaClientes.add(cliente);
				} catch (Exception ex) {
					throw new IllegalArgumentException("Parametros errados.");
				}

				System.out.println("Cliente criado com sucesso.");
				break;

			case 2:
				System.out.println("Digite o caixa que irá atender: ");
				int idCaixa = ler.nextInt();
				boolean chamado = false;
				for (Caixa caixa : caixas) {
					if (caixa.getId() == idCaixa) {
						Cliente retornado = caixa.callNextCustomer(listaClientes, idCaixa);
						if (retornado != null)
							chamado = true;

						break;
					}
				}
				break;
			case 3:
				System.out.println("Digite o id do caixa que você deseja liberar");
				int idCaixas = ler.nextInt();
				for (Caixa caixa : caixas) {
					if (caixa.getId() == idCaixas) {
						caixa.liberaCaixa(idCaixas);
						break;
					}
				}
				break;
			}
		} while (op != 0);
	}
}
