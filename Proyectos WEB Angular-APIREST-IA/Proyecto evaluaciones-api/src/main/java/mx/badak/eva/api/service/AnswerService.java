package mx.badak.eva.api.service;

import mx.badak.eva.api.model.Answer;

import java.util.List;
import java.util.Optional;

public interface AnswerService {
    Answer createAnswer(Answer answer);
    Optional<Answer> findById(Integer idAnswer);

    List<Answer> getAnswerAll();
    public Answer updateStatus(Integer idAnswer, Integer status);
}
