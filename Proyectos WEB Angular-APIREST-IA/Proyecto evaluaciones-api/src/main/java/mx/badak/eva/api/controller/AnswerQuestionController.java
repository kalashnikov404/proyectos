package mx.badak.eva.api.controller;

import mx.badak.eva.api.exception.ResourceNotFound;
import mx.badak.eva.api.model.AnswerQuestion;
import mx.badak.eva.api.serviceImpl.QuestionServiceImpl;
import mx.badak.eva.api.serviceImpl.AnswerQuestionServiceImpl;
import mx.badak.eva.api.serviceImpl.AnswerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RequestMapping("/respuestaPregunta")
public class AnswerQuestionController {
    @Autowired
    private AnswerQuestionServiceImpl answerQuestionService;
    @Autowired
    private QuestionServiceImpl questionService;
    @Autowired
    private AnswerServiceImpl answerService;

    @PostMapping("/create")
    ResponseEntity<AnswerQuestion> createAnswerQuestion(@RequestBody AnswerQuestion answerQuestion, Integer idQuestion, Integer idAnswer) {
        return answerService.findById(idAnswer).map(answer->{
            answerQuestion.setAnswer(answer);
            return questionService.findById(idQuestion).map(question->{
                answerQuestion.setQuestion(question);
                answerQuestionService.createAnswerQuestion(answerQuestion);
                return new ResponseEntity<>(answerQuestion, HttpStatus.CREATED);
            }).orElseThrow(() -> new ResourceNotFound("idQuestion" + idQuestion + "not found"));
        }).orElseThrow(() -> new ResourceNotFound("idAnswer" + idAnswer + "not found"));
    }

    @GetMapping("/get")
    ResponseEntity<List<AnswerQuestion>> getAnswerQuestion(Integer idQuestion){
        return new ResponseEntity<>(answerQuestionService.getAnswerQuestion(idQuestion), HttpStatus.OK);
    }
}