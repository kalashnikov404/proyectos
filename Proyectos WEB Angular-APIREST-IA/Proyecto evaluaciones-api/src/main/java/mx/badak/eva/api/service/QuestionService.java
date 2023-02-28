package mx.badak.eva.api.service;

import mx.badak.eva.api.model.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    Question createQuestion(Question question);
    List<Question> getQuestionAll();
    Optional<Question> findById(Integer idQuestion);
    public Question updateStatus(Integer idQuestion, Integer status);
}