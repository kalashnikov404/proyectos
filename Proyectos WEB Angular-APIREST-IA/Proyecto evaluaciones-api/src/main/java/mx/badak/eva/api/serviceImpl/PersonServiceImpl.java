package mx.badak.eva.api.serviceImpl;


import mx.badak.eva.api.exception.ResourceNotFound;
import mx.badak.eva.api.model.Level;
import mx.badak.eva.api.model.Person;
import mx.badak.eva.api.repository.PersonRepository;
import mx.badak.eva.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    static int min = 20;
    static int max = 1000;

    static int idRandom = (int)Math.floor(Math.random()*(max-min+1)+min);


    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person createPerson(Person person) {

        return personRepository.save(person);
    }

    @Override
    public Person createPersonCandidate(Person person) {
        return personRepository.save(person);
    }


    @Override
    public List<Person> getPersonAll() {
        return personRepository.getPersonAll();
    }



    @Override
    public void deletePerson(Integer idPerson) {

        personRepository.deleteById(idPerson);
    }



    @Override
    public Person updatePerson(Integer idPerson, Integer status) {
        return personRepository.findById(idPerson).map(person -> {
            person.setStatus(status);
            return personRepository.save(person);
        }).orElseThrow(() -> new ResourceNotFound("idPerson " + idPerson + " not found"));
    }



    @Override
    public Optional<Person> findById(Integer idPerson) {
        return
                personRepository.findById(idPerson);
    }

    @Override
    public List<Person> findByNameLike(String letter) {

        return  personRepository.findByNameLike(letter);
    }


    @Override
    public List<Person> findByNameEmail(String letter) {

        return  personRepository.findByNameLike(letter);
    }

    @Override
    public void usersCSVToBD(String name, String lastName, String motherLastName, String email, String company) {
        personRepository.usersCSVToBD(name, lastName, motherLastName, email, company);
    }

   /* @Override
    public void usersCSVToBD(Person person) {
        personRepository.usersCSVToBD(person.getName(),person.getLastName(),person.getMotherLastName(),
                person.getEmail(),person.getCompanyName());
    }*/


}