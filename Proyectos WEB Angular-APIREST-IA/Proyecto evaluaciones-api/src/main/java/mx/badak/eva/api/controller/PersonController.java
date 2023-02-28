package mx.badak.eva.api.controller;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import mx.badak.eva.api.csv.ResponseMessage;
import mx.badak.eva.api.model.Candidate;
import mx.badak.eva.api.model.Person;
import mx.badak.eva.api.serviceImpl.PersonServiceImpl;
import org.springframework.batch.item.util.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.FileUrlResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.unit.DataSize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;


@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonServiceImpl personService;


    @PostMapping("/createPerson")
    ResponseEntity<Person> createPerson(@RequestBody Person person){
        personService.createPerson(person);


        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @PostMapping("/createPersonCandidate")
    ResponseEntity<Person> createPersonCandidate(@RequestBody Person person){

        personService.createPerson(person);


        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }


    @GetMapping("/get")
    ResponseEntity<List<Person>> getPersonAll(){
        return new ResponseEntity<>(personService.getPersonAll(), HttpStatus.OK);
    }



    @DeleteMapping("/delete")
    void deletePerson(Integer idPerson){
        personService.deletePerson(idPerson);
    }




    @PutMapping("/{id}/{status}")
    public ResponseEntity<Integer> updatePerson(@PathVariable(value = "idPerson") Integer idPerson, @PathVariable(value = "status") Integer status) {
        try {
            personService.updatePerson(idPerson, status);
        } catch (Exception e) {
            return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(status, HttpStatus.OK);
    }


    @GetMapping("/get/{id}")
    ResponseEntity<Optional<Person>> findById(Integer idPerson){
        return new ResponseEntity<>(personService.findById(idPerson), HttpStatus.OK);
    }





    @GetMapping("/get/{letter}")
    ResponseEntity<List<Person>> findByNameLike(String letter){
        return new ResponseEntity<>(personService.findByNameLike(letter), HttpStatus.OK);
    }

    @PostMapping("/csv")
    ResponseEntity<Person> csvToPerson(@RequestParam("file") MultipartFile file) throws IOException {
        String message = "";

        String line = "";


            final String delimiter = ",";
            Person person = new Person();
            try
            {


                InputStream inputStream = file.getInputStream();
                BufferedReader bufferReader =   new BufferedReader(new InputStreamReader(inputStream));


                while ((line = bufferReader.readLine()) != null){
                    String[] token = line.split(delimiter);


                    personService.usersCSVToBD(token[0],token[1],token[2],token[3],token[4]);
                }
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }


        return new ResponseEntity<>(HttpStatus.OK);
    }


}


