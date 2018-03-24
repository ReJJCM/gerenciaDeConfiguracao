


import java.util.*;

public class Cliente {
	
	private String nome;
	private int idade;
	private int hora,minutos;
	
	public Cliente(String nome, int idade, int hora, int minutos) 
	{
		this.idade = idade;
		this.nome = nome;
		this.hora = hora;
		this.minutos = minutos;
	}
	
	public Cliente(Cliente cliente)
	{
		this.idade = cliente.idade;
		this.nome = cliente.nome;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public void horarioDeChegada(int hora, int minutos)
	{ 
		if(hora > 24 || hora < 1 || minutos > 60 || minutos < 0)
		{
			System.out.println("Digite um horário válido.");
		}
		else {
		this.hora = hora;
		this.minutos = minutos;
		}			
	}

	

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", idade=" + idade + "]";
	}

}
