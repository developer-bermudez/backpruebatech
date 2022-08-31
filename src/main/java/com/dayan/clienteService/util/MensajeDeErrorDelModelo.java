package com.dayan.clienteService.util;

import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public class MensajeDeErrorDelModelo {
    private String mensaje;
    private List<String> errores = new ArrayList<>();

    public MensajeDeErrorDelModelo() {
    }

    public MensajeDeErrorDelModelo(String mensaje, List<ObjectError> errores) {
        this.mensaje = mensaje;
        errores.forEach(error -> this.errores.add(error.getDefaultMessage()));
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<String> getErrores() {
        return errores;
    }

    public void setErrores(List<String> errores) {
        this.errores = errores;
    }
}
