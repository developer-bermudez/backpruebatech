package com.dayan.clienteService.model;

public class Cliente {
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono;
    private String direccion;
    private String ciudadDeResidencia;
    private String numeroDeDocumento;
    private TipoDeDocumento tipoDeDocumento;

    public Cliente() {
        numeroDeDocumento = "";
    }

    public Cliente(String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
                   String telefono, String direccion, String ciudadDeResidencia, String numeroDeDocumento,
                   TipoDeDocumento tipoDeDocumento) {
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ciudadDeResidencia = ciudadDeResidencia;
        this.numeroDeDocumento = numeroDeDocumento;
        this.tipoDeDocumento = tipoDeDocumento;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudadDeResidencia() {
        return ciudadDeResidencia;
    }

    public String getNumeroDeDocumento() {
        return numeroDeDocumento;
    }

    public TipoDeDocumento getTipoDeDocumento() {
        return tipoDeDocumento;
    }
}
