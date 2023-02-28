package mx.badak.eva.api.service;


import mx.badak.eva.api.model.Operacion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface OperacionService {

    Operacion createOperacion(Operacion operacion);
    List<Operacion> findOperacionById(Integer idOperacion);




}
