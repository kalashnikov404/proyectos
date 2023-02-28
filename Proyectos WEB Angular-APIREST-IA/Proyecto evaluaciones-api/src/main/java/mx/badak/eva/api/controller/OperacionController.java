package mx.badak.eva.api.controller;



import mx.badak.eva.api.model.Operacion;
import mx.badak.eva.api.service.OperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-eglobal")
public class OperacionController {
    @Autowired
    private OperacionService operacionService;


    @PostMapping("/operacion")
    ResponseEntity<Operacion> createOperacion(@RequestBody Operacion operacion){
        operacionService.createOperacion(operacion);

        return new ResponseEntity<>(operacion, HttpStatus.CREATED);
    }

    @GetMapping("/operacion/{id}")
    ResponseEntity<List<Operacion>> getOperacion(Integer idOperacion){
        return new ResponseEntity<>(operacionService.findOperacionById(idOperacion), HttpStatus.OK);
    }



}