package mx.badak.eva.api.controller;


import mx.badak.eva.api.model.CompanyCatalog;
import mx.badak.eva.api.serviceImpl.CompanyCatalogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@RequestMapping("/company")
public class CompanyCatalogController {

    @Autowired
    private CompanyCatalogServiceImpl companyService;



    @PostMapping("/createCompany")
    ResponseEntity<CompanyCatalog> createCompany(@RequestBody CompanyCatalog company){
        companyService.createCompany(company);
        return new ResponseEntity<>(company, HttpStatus.CREATED);
    }


    @GetMapping("/get")
    ResponseEntity<List<CompanyCatalog>> getCompanyAll(){
        return new ResponseEntity<>(companyService.getCompanyAll(), HttpStatus.OK);
    }



    @DeleteMapping("/delete")
    void deleteCompany(Integer idCompanyCatalog){
        companyService.deleteCompany(idCompanyCatalog);
    }




    @PutMapping("/{id}/{status}")
    public ResponseEntity<Integer> updateCompany(@PathVariable(value = "idCompanyCatalog") Integer idCompanyCatalog, @PathVariable(value = "status") Integer status) {
        try {
            companyService.updateCompany(idCompanyCatalog, status);
        } catch (Exception e) {
            return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(status, HttpStatus.OK);
    }


    @GetMapping("/get/{id}")
    ResponseEntity<Optional<CompanyCatalog>> findById(Integer idCompanyCatalog){
        return new ResponseEntity<>(companyService.findById(idCompanyCatalog), HttpStatus.OK);
    }





    @GetMapping("/get/{letter}")
    ResponseEntity<List<CompanyCatalog>> findByNameLike(String letter){
        return new ResponseEntity<>(companyService.findByNameLike(letter), HttpStatus.OK);
    }







}
