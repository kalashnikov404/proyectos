package mx.badak.eva.api.repository;

import mx.badak.eva.api.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    @Query(value = "SELECT * FROM question WHERE status = 1", nativeQuery = true)
    List<Question> getQuestionAll();
}
