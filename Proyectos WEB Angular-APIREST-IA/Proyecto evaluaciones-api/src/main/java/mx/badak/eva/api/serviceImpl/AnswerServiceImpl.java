package mx.badak.eva.api.serviceImpl;

import mx.badak.eva.api.exception.ResourceNotFound;
import mx.badak.eva.api.model.Answer;
import mx.badak.eva.api.repository.AnswerRepository;
import mx.badak.eva.api.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    public Answer createAnswer(Answer answer){
        return answerRepository.save(answer);
    }
    @Override
    public Optional<Answer> findById(Integer idAnswer) { return answerRepository.findById(idAnswer); }

    @Override
    public List<Answer> getAnswerAll() {
        return answerRepository.getAnswerAll();
    }

    @Override
    public Answer updateStatus(Integer idAnswer, Integer status) {
        return answerRepository.findById(idAnswer).map(answer -> {
            answer.setStatus(status);
            return answerRepository.save(answer);
        }).orElseThrow(() -> new ResourceNotFound("idAnswer " + idAnswer + " not found"));
    }
}