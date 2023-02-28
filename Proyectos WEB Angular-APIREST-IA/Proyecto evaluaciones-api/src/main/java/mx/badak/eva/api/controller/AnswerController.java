package mx.badak.eva.api.controller;

import mx.badak.eva.api.model.Answer;
import mx.badak.eva.api.serviceImpl.AnswerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    private AnswerServiceImpl answerService;

    @PostMapping("/create")
    ResponseEntity<Answer> createAnswer(@RequestBody Answer answer){
        answer.setStatus(1);
        answerService.createAnswer(answer);
        return new ResponseEntity<>(answer, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    ResponseEntity<List<Answer>> getAnswerAll(){
        return new ResponseEntity<>(answerService.getAnswerAll(), HttpStatus.OK);
    }

    @PutMapping("update/{id}/{status}")
    public ResponseEntity<Integer> updateStatus(@PathVariable(value = "idAnswer") Integer idLevel, @PathVariable(value = "status") Integer status) {
        try {
            answerService.updateStatus(idLevel, status);
        } catch (Exception e) {
            return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}