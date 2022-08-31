package com.dayan.clienteService.rest;

import com.dayan.clienteService.model.Cliente;
import com.dayan.clienteService.model.DocumentoBuscado;
import com.dayan.clienteService.service.ClienteService;
import com.dayan.clienteService.util.MensajeDeErrorDelModelo;
import com.dayan.clienteService.util.MensajeDeRespuesta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping ("/cliente")
@CrossOrigin ("http://localhost:4200")
public class ClienteRest {

    private final static Logger logger = LoggerFactory.getLogger(ClienteRest.class);

    @Autowired
    ClienteService clienteService;

    @PostMapping (consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getClienteByDocumento (@RequestBody @Valid DocumentoBuscado documentoBuscado,
                                                    BindingResult bindingResult) {
        try {
            if(bindingResult.hasErrors()) {
                logger.info("Bad_Request recibida, los datos ingresados no son validos");
                return new ResponseEntity(new MensajeDeErrorDelModelo("Los datos ingresados no son validos",
                        bindingResult.getAllErrors()), HttpStatus.BAD_REQUEST);
            }

            Optional<Cliente> cliente = clienteService.findClientByDocumento(documentoBuscado.getNumeroDeDocumento(),
                    documentoBuscado.getTipoDeDocumento());

            if (!cliente.isEmpty()) {
                if(!clienteService.esUnClienteValido(documentoBuscado.getNumeroDeDocumento())){
                    return new ResponseEntity(new MensajeDeRespuesta("el cliente a buscar no es un cliente valido",
                            null,2),HttpStatus.OK);
                }
                return new ResponseEntity(new MensajeDeRespuesta("Peticion exitosa", cliente.get(), 1), HttpStatus.OK);
            }
        } catch (Exception exception) {
            logger.error(exception.getMessage());
            return new ResponseEntity(new MensajeDeRespuesta(exception.getMessage(), null,0),HttpStatus.INTERNAL_SERVER_ERROR);
        }

        logger.info("los datos ingresados no corresponden a ningun cliente");
        return new ResponseEntity(new MensajeDeRespuesta("Los datos ingresados no corresponden a " +
                "ningun usuario",null,0), HttpStatus.OK);
    }
}
