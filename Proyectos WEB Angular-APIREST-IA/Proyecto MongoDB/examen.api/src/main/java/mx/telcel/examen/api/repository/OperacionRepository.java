package mx.telcel.examen.api.repository;

import mx.telcel.examen.api.model.Operacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OperacionRepository extends MongoRepository<Operacion, Integer> {
    /**
     *PersonaRolRepository
     * Referencia la manipulacion de la base de datos mediante metodos predefinidos
     * */

    List<Operacion> findByNombre(String nombre);

    Optional<Operacion> findById(Integer id);



}
