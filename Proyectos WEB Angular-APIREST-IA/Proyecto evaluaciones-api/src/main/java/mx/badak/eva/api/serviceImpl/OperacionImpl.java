package mx.badak.eva.api.serviceImpl;

import mx.badak.eva.api.model.Operacion;
import mx.badak.eva.api.repository.OperacionRepository;
import mx.badak.eva.api.service.OperacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class OperacionImpl implements OperacionService {

    @Autowired
    private OperacionRepository operacionRepository;


    @Override
    public Operacion createOperacion(Operacion operacion) {

        return operacionRepository.save(operacion);
    }

    @Override
    public List<Operacion> findOperacionById(Integer idOperacion) {
        return operacionRepository.findOperacionById(idOperacion);
    }


}
