package mx.badak.eva.api.serviceImpl;

import mx.badak.eva.api.exception.ResourceNotFound;
import mx.badak.eva.api.model.AnswerQuestion;
import mx.badak.eva.api.repository.QuestionRepository;
import mx.badak.eva.api.repository.AnswerQuestionRepository;
import mx.badak.eva.api.repository.AnswerRepository;
import mx.badak.eva.api.service.AnswerQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerQuestionServiceImpl implements AnswerQuestionService {
    @Autowired
    private AnswerQuestionRepository answerQuestionRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public AnswerQuestion createAnswerQuestion(AnswerQuestion answerQuestion) {
        answerQuestion.setStatus(1);
        return answerQuestionRepository.save(answerQuestion);
    }

    @Override
    public List<AnswerQuestion> getAnswerQuestion(Integer idAnswerQuestion) {
        return answerQuestionRepository.getAnswerQuestion(idAnswerQuestion);
    }

    @Override
    public AnswerQuestion updateStatus(Integer idAnswerQuestion, Integer status) {
        return answerQuestionRepository.findById(idAnswerQuestion).map(answerQuestion -> {
            answerQuestion.setStatus(status);
            return answerQuestionRepository.save(answerQuestion);
        }).orElseThrow(() -> new ResourceNotFound("idAnswerQuestion " + idAnswerQuestion + " not found"));
    }
}