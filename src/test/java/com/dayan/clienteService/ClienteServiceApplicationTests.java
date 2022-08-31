package com.dayan.clienteService;

import com.dayan.clienteService.datasource.DataSource;
import com.dayan.clienteService.model.Cliente;
import com.dayan.clienteService.model.TipoDeDocumento;
import com.dayan.clienteService.service.ClienteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class ClienteServiceApplicationTests {

	@Mock
	private DataSource dataSource = new DataSource();

	private ClienteService clienteService;

	String numeroDeDocumento = "23445322";

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		clienteService = new ClienteService(dataSource);

		Cliente cliente = new Cliente("Prueba",
				"Tecnica",
				"NTT DATA",
				"Spring",
				"000999888",
				"170",
				"Bogotá",
				"23445322",
				TipoDeDocumento.C);

		Mockito.when(dataSource.findClientByDocumento(numeroDeDocumento,TipoDeDocumento.C))
				.thenReturn(Optional.of(cliente));
	}

	@Test
	void PruebaClienteService() {

		Optional<Cliente> cliente;

		cliente = clienteService.findClientByDocumento(numeroDeDocumento,
				TipoDeDocumento.C);
		Assertions.assertEquals(cliente.get().getNumeroDeDocumento(),numeroDeDocumento,"Esta bien");
	}

}
