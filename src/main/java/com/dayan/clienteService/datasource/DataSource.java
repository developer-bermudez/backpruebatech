package com.dayan.clienteService.datasource;

import com.dayan.clienteService.model.Cliente;
import com.dayan.clienteService.model.TipoDeDocumento;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataSource {
    private List<Cliente> clientes;

    public DataSource() {

        clientes = new ArrayList<>();

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
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
