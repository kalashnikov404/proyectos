package mx.telcel.examen.api.serviceImpl;

import mx.telcel.examen.api.model.Operacion;
import mx.telcel.examen.api.repository.OperacionRepository;
import mx.telcel.examen.api.service.OperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class OperacionServiceImpl implements OperacionService {

    /**
     *PersonaRolServiceImpl
     * Define concretamente la estructura de cada metodo destinado a la
     * conglomeración de los endpoints
     * */

    @Autowired
    private OperacionRepository operacionRepository;



    @Override
    public Operacion createOperacion(Operacion operacion) {
       return operacionRepository.save(operacion);
    }



    @Override
    public Optional<Operacion> findById(Integer id) {
            return operacionRepository.findById(id);

    }



}
