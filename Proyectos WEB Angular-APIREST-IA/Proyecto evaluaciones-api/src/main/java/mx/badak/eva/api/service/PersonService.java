package mx.badak.eva.api.service;


import mx.badak.eva.api.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    Person createPerson(Person person);

    public Person createPersonCandidate(Person person);


    List<Person> getPersonAll();
    void deletePerson(Integer idPerson);

    public Person updatePerson(Integer idPerson, Integer status);

    Optional<Person> findById(Integer idPerson);

    List<Person> findByNameLike(String letter);

    List<Person> findByNameEmail(String letter);

    void usersCSVToBD(String name,String lastName, String motherLastName,String email,String company);
    /*
    Optional<Person> findByName(String name);
     */

}
