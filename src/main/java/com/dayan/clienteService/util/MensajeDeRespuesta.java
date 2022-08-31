package com.dayan.clienteService.util;

import com.dayan.clienteService.model.Cliente;

public class MensajeDeRespuesta {
    private String mensaje;
    private Cliente cliente;

    private Integer exito;

    public MensajeDeRespuesta(String mensaje, Cliente cliente, Integer exito) {
        this.mensaje = mensaje;
        this.cliente = cliente;
        this.exito = exito;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getExito() {
        return exito;
    }

    public void setExito(Integer exito) {
        this.exito = exito;
    }
}
