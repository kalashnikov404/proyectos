package mx.badak.eva.api.repository;

import mx.badak.eva.api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    Person save(Person person);


    @Query(value = "SELECT * FROM person; ", nativeQuery = true)
    List<Person> getPersonAll();

    @Query(value = "SELECT * FROM person WHERE name LIKE :letter%", nativeQuery = true)
    List<Person> findByNameLike(@Param("letter") String letter);

    @Query(value = "SELECT * FROM person WHERE email LIKE :letter%", nativeQuery = true)
    List<Person> findByNameEmail(@Param("letter") String letter);
    @Query(value = "CALL INSERT_CANDIDATES_SP(:name,:lastName,:motherLastName,:email,:company);", nativeQuery = true)
    void usersCSVToBD(@Param("name")String name,
                        @Param("lastName") String lastName,
                        @Param("motherLastName") String motherLastName,
                        @Param("email") String email,
                        @Param("company") String company);


}
