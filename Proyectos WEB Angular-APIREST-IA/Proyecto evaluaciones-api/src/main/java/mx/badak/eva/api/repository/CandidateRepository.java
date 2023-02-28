package mx.badak.eva.api.repository;

import mx.badak.eva.api.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {


    Candidate save(Candidate candidate);
    @Query(value = "SELECT * FROM candidate; ", nativeQuery = true)
    List<Candidate> getCandidateAll();

    @Query(value = "SELECT * FROM candidate WHERE name LIKE :letter%", nativeQuery = true)
    List<Candidate> findByNameLike(@Param("letter") String letter);


}
