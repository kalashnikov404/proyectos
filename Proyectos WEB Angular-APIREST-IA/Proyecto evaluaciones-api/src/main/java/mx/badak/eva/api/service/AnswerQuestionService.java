package mx.badak.eva.api.service;

import mx.badak.eva.api.model.AnswerQuestion;
import java.util.List;

public interface AnswerQuestionService {
    AnswerQuestion createAnswerQuestion(AnswerQuestion answerQuestion);
    List<AnswerQuestion> getAnswerQuestion(Integer idAnswerQuestion);
    public AnswerQuestion updateStatus(Integer idAnswerQuestion, Integer status);
}
