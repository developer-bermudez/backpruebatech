package com.dayan.clienteService.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class DocumentoBuscado {

    @NotBlank (message = "debe ingresar un numero de documento")
    @Pattern(regexp = "[1-9][0-9]{7,9}", message = "el numero de documento debe tener de 8 a 10 digitos" +
            " y no debe tener letras, signos de puntuacion, etc.")
    private String numeroDeDocumento;

    @NotNull (message = "debe ingresar el tipo de documento a buscar")
    private TipoDeDocumento tipoDeDocumento;

    public DocumentoBuscado() {
    }

    public DocumentoBuscado(String numeroDeDocumento, TipoDeDocumento tipoDeDocumento) {
        this.numeroDeDocumento = numeroDeDocumento;
        this.tipoDeDocumento = tipoDeDocumento;
    }

    public String getNumeroDeDocumento() {
        return numeroDeDocumento;
    }

    public TipoDeDocumento getTipoDeDocumento() {
        return tipoDeDocumento;
    }
}
