package mx.badak.eva.api.serviceImpl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;


import mx.badak.eva.api.csv.CSVHelper2;
import mx.badak.eva.api.model.Candidate;
import mx.badak.eva.api.model.CompanyCatalog;
import mx.badak.eva.api.model.Person;
import mx.badak.eva.api.repository.CandidateRepository;
import mx.badak.eva.api.repository.CompanyCatalogRepository;
import mx.badak.eva.api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class CSVService {
    @Autowired
    PersonRepository personRepository;

    Person person;

    public void save(MultipartFile file) {
        try {

            List<Person> persons = CSVHelper2.csvToTutorials(file.getInputStream());
            personRepository.saveAll(persons);
           // personRepository.usersCSVToBD(persons);


        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }


    public ByteArrayInputStream load() {
        /*List<CompanyCatalog> companies = companyCatalogRepository.findAll();*/
        List<Person> persons = personRepository.findAll();

        //List<Candidate> candidates = candidateRepository.findAll();

        ByteArrayInputStream in = CSVHelper2.tutorialsToCSV(persons);

        return in;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

}