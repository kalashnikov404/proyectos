package mx.telcel.examen.api.controller;


import lombok.RequiredArgsConstructor;
import mx.telcel.examen.api.model.Operacion;

import mx.telcel.examen.api.serviceImpl.OperacionServiceImpl;
import mx.telcel.examen.api.serviceImpl.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static mx.telcel.examen.api.model.Operacion.SEQUENCE_NAME;

@RestController
@RequestMapping("/api-telcel")
@RequiredArgsConstructor
public class OperacionController {
    /**

     *Este es el Rest Controller que permite el acceso a las apis
     * Las mismas se encuentran distribuidas, de tal forma
     * que su nomenclatura hace referencia a cada accion
     *Este controlador hace referencia a la entidad Persona-Rol

     */

    //Inyeccion de servicios
    @Autowired
    private OperacionServiceImpl operacionService;
    @Autowired
    private SequenceGeneratorService service;


    //Crear Persona-Rol
    @PostMapping("/operacion")
    public Operacion createOperacion(@RequestBody Operacion operacion){
        //generate sequence
        operacion.setId(service.getSequenceNumber(SEQUENCE_NAME));


    return operacionService.createOperacion(operacion);
}







    //Obtener una persona y sus roles por su Id
    @GetMapping("operacion/{id}")
    ResponseEntity<Optional<Operacion>> findById(@PathVariable  Integer id){
        return new ResponseEntity<>(operacionService.findById(id), HttpStatus.OK);
    }






}
