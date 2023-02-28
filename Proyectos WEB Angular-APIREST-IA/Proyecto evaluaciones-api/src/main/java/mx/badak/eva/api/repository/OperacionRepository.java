package mx.badak.eva.api.repository;

import mx.badak.eva.api.model.Operacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OperacionRepository extends JpaRepository<Operacion, Integer> {

    /*@Query(value = "SELECT * FROM question_answer WHERE id_question = ?1", nativeQuery = true)
    List<AnswerQuestion> getAnswerQuestion(Integer idQuestion);
*/
    /*@Query(value = "SELECT id, (SUM(numero_uno)+SUM(numero_dos)) AS Total from operacion WHERE id = ?1", nativeQuery = true)
    List<Operacion> findOperacionById(Integer idOperacion);
*/

    List<Operacion> findOperacionById(Integer idOperacion);

    Optional<Operacion> findById(Integer id);


}
