package com.dayan.clienteService.service;

import com.dayan.clienteService.datasource.DataSource;
import com.dayan.clienteService.model.Cliente;
import com.dayan.clienteService.model.TipoDeDocumento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    DataSource dataSource;

    public Cliente getClientByDocumento (String numeroDeDocumento, TipoDeDocumento tipoDeDocumento) {
        List<Cliente> clientes = dataSource.getClientes();
        for (Cliente client: clientes) {
            if(client.getNumeroDeDocumento().equals(numeroDeDocumento) &&
                client.getTipoDeDocumento().equals(tipoDeDocumento)){
                return client;
            }
        }
        return null;
    }
}
