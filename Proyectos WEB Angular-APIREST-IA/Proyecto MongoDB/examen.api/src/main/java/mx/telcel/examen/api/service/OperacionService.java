package mx.telcel.examen.api.service;

import mx.telcel.examen.api.model.Operacion;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public interface OperacionService {
 /**
  *PersonaRolService
  * Predefine los metodos a usar en la fase de implementación
  * */

 Operacion createOperacion(Operacion operacion);


 Optional<Operacion> findById(Integer id);





}
