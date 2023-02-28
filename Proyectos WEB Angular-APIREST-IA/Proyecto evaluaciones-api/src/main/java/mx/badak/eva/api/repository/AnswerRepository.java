package mx.badak.eva.api.repository;

import mx.badak.eva.api.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    @Query(value = "SELECT * FROM answer WHERE status = 1", nativeQuery = true)
    List<Answer> getAnswerAll();
}
