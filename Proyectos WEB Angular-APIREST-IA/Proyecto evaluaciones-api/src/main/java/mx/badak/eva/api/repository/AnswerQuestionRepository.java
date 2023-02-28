package mx.badak.eva.api.repository;

import mx.badak.eva.api.model.AnswerQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerQuestionRepository extends JpaRepository<AnswerQuestion, Integer> {
    @Query(value = "SELECT * FROM question_answer WHERE id_question = ?1", nativeQuery = true)
    List<AnswerQuestion> getAnswerQuestion(Integer idQuestion);
}
