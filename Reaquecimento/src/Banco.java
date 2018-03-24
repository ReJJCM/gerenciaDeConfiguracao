import java.util.ArrayList;

public class Banco {
private ArrayList<Cliente> clientes;
private ArrayList<Caixa> caixas;
private String nome;

public Banco(ArrayList<Cliente> clientes, ArrayList<Caixa> caixas, String nome)
{
	this.clientes = clientes;
	this.caixas = caixas;
	this.nome = nome;
}

public ArrayList<Cliente> getClientes() {
	return clientes;
}

public void setClientes(ArrayList<Cliente> clientes) {
	this.clientes = clientes;
}

public ArrayList<Caixa> getCaixas() {
	return caixas;
}

public void setCaixas(ArrayList<Caixa> caixas) {
	this.caixas = caixas;
}
}
