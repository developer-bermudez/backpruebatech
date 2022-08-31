package com.dayan.clienteService.datasource;

import com.dayan.clienteService.model.Cliente;
import com.dayan.clienteService.model.TipoDeDocumento;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DataSource {
    private List<Cliente> clientes;
    private List<Cliente> clientesValidos;

    public DataSource() {

        clientes = new ArrayList<>();
        clientesValidos = new ArrayList<>();

        clientes.add(new Cliente("Dayan","Jose","Bermudez",
                "Ortiz","33311122222", "las villas","Algarrobo",
                "1000111222", TipoDeDocumento.C));

        clientes.add(new Cliente("Alberto","Fernando","Rodriguez",
                "Ardila","111222333", "San Fernando","Santa Marta",
                "1333222111", TipoDeDocumento.P));

        clientes.add(new Cliente("Cesar","Humberto","Maiguel",
                "Cantillo","444555666", "Comuneros","El Copey",
                "1444555666", TipoDeDocumento.P));

        clientes.add(new Cliente("Victor","Mendinueta","Balaguera",
                "Ortiz","666777888", "Ciudad Equidad","Santa Marta",
                "1999000444", TipoDeDocumento.C));

        Cliente clienteValido = new Cliente("Prueba","Tecnica","NTT DATA",
                "Spring","000999888", "170","Bogotá",
                "23445322", TipoDeDocumento.C);

        clientes.add(clienteValido);
        clientesValidos.add(clienteValido);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public Optional<Cliente> findClientByDocumento (String numeroDeDocumento, TipoDeDocumento tipoDeDocumento) {
        for (Cliente client: clientes) {
            if(client.getNumeroDeDocumento().equals(numeroDeDocumento) &&
                    client.getTipoDeDocumento().equals(tipoDeDocumento)){
                return Optional.of(client);
            }
        }
        return Optional.empty();
    }

    public boolean esUnClienteValido(String numeroDeDocumento) {
        for (Cliente client: clientesValidos) {
            if(client.getNumeroDeDocumento().equals(numeroDeDocumento)){
                return true;
            }
        }
        return false;
    }

}
