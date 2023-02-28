package mx.badak.eva.api.controller;


import mx.badak.eva.api.exception.ResourceNotFound;
import mx.badak.eva.api.model.Candidate;

import mx.badak.eva.api.serviceImpl.CandidateServiceImpl;
import mx.badak.eva.api.serviceImpl.CompanyCatalogServiceImpl;
import mx.badak.eva.api.serviceImpl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateServiceImpl candidateService;

    @Autowired
    private CompanyCatalogServiceImpl companyCatalogService;

    @Autowired
    private PersonServiceImpl personService;



    @PostMapping("/create")
    ResponseEntity<Candidate> createCandidate(@RequestBody Candidate candidate, Integer idPerson, Integer idCompanyCatalog) {
        return personService.findById(idPerson).map(person->{

            candidate.setPerson(person);

            return companyCatalogService.findById(idCompanyCatalog).map(companyCatalog->{
                candidate.setCompanyCatalog(companyCatalog);

                candidateService.createCandidate(candidate);
                return new ResponseEntity<>(candidate, HttpStatus.CREATED);

            }).orElseThrow(() -> new ResourceNotFound("idCompanyCatalog" + idCompanyCatalog + "not found"));
        }).orElseThrow(() -> new ResourceNotFound("idPerson" + idPerson + "not found"));
    }




    @GetMapping("/get")
    ResponseEntity<List<Candidate>> getCandidateAll(){
        return new ResponseEntity<>(candidateService.getCandidateAll(), HttpStatus.OK);
    }



    @DeleteMapping("/delete")
    void deleteCandidate(Integer idCandidate){
        candidateService.deleteCandidate(idCandidate);
    }




    @PutMapping("/{id}/{status}")
    public ResponseEntity<Integer> updateCandidate(@PathVariable(value = "idCandidate") Integer idCandidate, @PathVariable(value = "status") Integer status) {
        try {
            candidateService.updateCandidate(idCandidate, status);
        } catch (Exception e) {
            return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(status, HttpStatus.OK);
    }


    @GetMapping("/get/{id}")
    ResponseEntity<Optional<Candidate>> findById(Integer idCandidate){
        return new ResponseEntity<>(candidateService.findById(idCandidate), HttpStatus.OK);
    }





    @GetMapping("/get/{letter}")
    ResponseEntity<List<Candidate>> findByNameLike(String letter){
        return new ResponseEntity<>(candidateService.findByNameLike(letter), HttpStatus.OK);
    }





}

