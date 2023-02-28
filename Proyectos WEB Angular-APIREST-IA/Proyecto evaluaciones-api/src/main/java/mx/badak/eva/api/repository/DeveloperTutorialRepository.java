package mx.badak.eva.api.repository;

import mx.badak.eva.api.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperTutorialRepository extends JpaRepository<Person, Integer>{
}