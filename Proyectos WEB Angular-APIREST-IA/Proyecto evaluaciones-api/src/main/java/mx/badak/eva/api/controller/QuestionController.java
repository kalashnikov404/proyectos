package mx.badak.eva.api.controller;

import mx.badak.eva.api.model.Question;
import mx.badak.eva.api.serviceImpl.LevelServiceImpl;
import mx.badak.eva.api.serviceImpl.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionServiceImpl questionService;
    @Autowired
    private LevelServiceImpl levelService;



    @GetMapping("/get")
    ResponseEntity<List<Question>> getQuestionAll(){
        return new ResponseEntity<>(questionService.getQuestionAll(), HttpStatus.OK);
    }

    @PutMapping("update/{id}/{status}")
    public ResponseEntity<Integer> updateStatus(@PathVariable(value = "idQuestion") Integer idQuestion, @PathVariable(value = "status") Integer status) {
        try {
            questionService.updateStatus(idQuestion, status);
        } catch (Exception e) {
            return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

}