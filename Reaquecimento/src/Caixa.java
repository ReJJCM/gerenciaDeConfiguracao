import java.util.ArrayList;

public class Caixa {

	private int id;
	private boolean ocupado;
	private ArrayList<Cliente> filaClientes;

	public Caixa(int id) {
		this.id = id;
		this.ocupado = false;
		filaClientes = new ArrayList<Cliente>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public Cliente callNextCustomer(ArrayList<Cliente> clientes, int id) {
		Cliente pessoaMaisVelha = null;
		Cliente proximo = null;

		if (clientes.size() > 0)
		{
			if (ocupado == false) 
			{
				if (id <= 5) 
				{
						int count = 1;
					for (Cliente cliente : clientes)
					{
						if (cliente.getIdade() >= 65) 
						{
							if(count == 1){
								pessoaMaisVelha = cliente;
								count = 2;
							}

							if (!pessoaMaisVelha.equals(null)) 
							{
								if (cliente.getIdade() > pessoaMaisVelha.getIdade())
									pessoaMaisVelha = cliente;
								else if (cliente.getIdade() == pessoaMaisVelha.getIdade()
										&& cliente.getHora() >= pessoaMaisVelha.getIdade()
										&& cliente.getMinutos() >= pessoaMaisVelha.getMinutos())
									pessoaMaisVelha = cliente;
							} else 
							{
								pessoaMaisVelha = cliente;
							}

							ocupado = true;
							System.out.println("Caixa: " + id + "atendendo cliente " + pessoaMaisVelha.getNome());
							clientes.remove(pessoaMaisVelha);
							return pessoaMaisVelha;
							

						}
						else 
						{
							
							proximo = clientes.get(0);
							clientes.remove(0);
							ocupado = true;

							System.out.println("Caixa: " + id + "atendendo cliente " + proximo.getNome());
							return proximo;						}

					}
					
				} 
				

			}
			System.out.println("Caixa ocupado.");
			return null;

		}

		System.out.println("Sem clientes na fila.");
		return null;

	}

	public void liberaCaixa(int id) {
		ocupado = false;
		if (filaClientes.size() > 0) {
			Cliente clienteNoCaixa = new Cliente(callNextCustomer(filaClientes, this.id));
			System.out.println("Caixa: " + id + "atendendo cliente " + clienteNoCaixa.getNome());
		}

		else
			System.out.println("Sem clientes na fila");

	}

}
