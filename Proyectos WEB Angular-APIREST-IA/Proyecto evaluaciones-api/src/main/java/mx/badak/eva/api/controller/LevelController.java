package mx.badak.eva.api.controller;

import mx.badak.eva.api.model.Level;
import mx.badak.eva.api.serviceImpl.LevelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/level")
public class LevelController {
    @Autowired
    private LevelServiceImpl levelService;

    @PostMapping("/createLevel")
    ResponseEntity<Level> createLevel(@RequestBody Level level){
        level.setStatus(1);
        levelService.createLevel(level);
        return new ResponseEntity<>(level, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    ResponseEntity<List<Level>> getLevelAll(){
        return new ResponseEntity<>(levelService.getLevelAll(), HttpStatus.OK);
    }

    @GetMapping("/search")
    ResponseEntity<List<Level>> getLevel(String string){
        return new ResponseEntity<>(levelService.getLevel(string), HttpStatus.OK);
    }

    @PutMapping("update/{id}/{status}")
    public ResponseEntity<Integer> updateStatus(@PathVariable(value = "idLevel") Integer idLevel, @PathVariable(value = "status") Integer status) {
        try {
            levelService.updateStatus(idLevel, status);
        } catch (Exception e) {
            return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
