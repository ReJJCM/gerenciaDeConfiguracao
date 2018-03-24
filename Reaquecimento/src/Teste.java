
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class Teste {
	
	@Test
	public void testaCriarCliente(){
		Cliente cliente = new Cliente("Renata", 21,14,30);
		String expectedName = "Renata";
		
		assertEquals("Renata", cliente.getNome());
	}
	
	@Test
	public void atendeClienteFalhaSemClientes(){
		ArrayList<Cliente> clientes = new ArrayList<>();
		Caixa caixa = new Caixa(1);
		Cliente retorna = caixa.callNextCustomer(clientes, 1);
		
		assertEquals(retorna, null);
				
	}
	
	@Test
	public void atendeClienteFalhaCaixaOcupado(){
		ArrayList<Cliente> clientes = new ArrayList<>();
		Caixa caixa = new Caixa(1);
		caixa.setOcupado(true);
		Cliente cliente = new Cliente("Renata", 21,14,30);
		clientes.add(cliente);
		
		Cliente retorna = caixa.callNextCustomer(clientes, 1);
		
		assertEquals(retorna, null);
				
	}
	
	
	@Test
	public void atendeCliente(){
		ArrayList<Cliente> clientes = new ArrayList<>();
		Caixa caixa = new Caixa(1);
		caixa.setOcupado(false);
		Cliente cliente = new Cliente("Renata", 21,14,30);
		clientes.add(cliente);
		
		Cliente retorna = caixa.callNextCustomer(clientes, 1);
		
		assertEquals(retorna.getNome(), "Renata");
				
	}
		
	@Test
	public void atendeClienteIdoso()
	{
		ArrayList<Cliente> clientes = new ArrayList<>();
		Cliente clienteIdoso = new Cliente("Vinicius", 66, 5,30);
		clientes.add(clienteIdoso);
		Caixa caixa = new Caixa(1);
		Cliente retorno = caixa.callNextCustomer(clientes, 1);
		
		assertEquals(retorno.getNome(), clienteIdoso.getNome());
	}
	
}
