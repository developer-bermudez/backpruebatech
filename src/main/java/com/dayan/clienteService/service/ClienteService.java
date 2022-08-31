package com.dayan.clienteService.service;

import com.dayan.clienteService.datasource.DataSource;
import com.dayan.clienteService.model.Cliente;
import com.dayan.clienteService.model.TipoDeDocumento;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    DataSource dataSource;

    public ClienteService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Optional<Cliente> findClientByDocumento (String numeroDeDocumento, TipoDeDocumento tipoDeDocumento) {
        return dataSource.findClientByDocumento(numeroDeDocumento, tipoDeDocumento);
    }

    public boolean esUnClienteValido(String numeroDeDocumento){
        return dataSource.esUnClienteValido(numeroDeDocumento);
    }
}
