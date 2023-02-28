package mx.badak.eva.api.serviceImpl;

import mx.badak.eva.api.exception.ResourceNotFound;
import mx.badak.eva.api.model.Question;
import mx.badak.eva.api.repository.LevelRepository;
import mx.badak.eva.api.repository.QuestionRepository;
import mx.badak.eva.api.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private LevelRepository levelRepository;

    @Override
    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getQuestionAll() {
        return questionRepository.getQuestionAll();
    }

    public Optional<Question> findById(Integer idQuestion) { return questionRepository.findById(idQuestion); }

    @Override
    public Question updateStatus(Integer idQuestion, Integer status) {
        return questionRepository.findById(idQuestion).map(level -> {
            level.setStatus(status);
            return questionRepository.save(level);
        }).orElseThrow(() -> new ResourceNotFound("idQuestion " + idQuestion + " not found"));
    }

}
