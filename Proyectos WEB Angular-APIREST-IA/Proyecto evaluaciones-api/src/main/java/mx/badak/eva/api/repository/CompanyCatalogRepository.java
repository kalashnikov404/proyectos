package mx.badak.eva.api.repository;


import mx.badak.eva.api.model.CompanyCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CompanyCatalogRepository extends JpaRepository<CompanyCatalog, Integer> {



    CompanyCatalog save(CompanyCatalog company);


    @Query(value = "SELECT * FROM company; ", nativeQuery = true)
    List<CompanyCatalog> getCompanyAll();

    @Query(value = "SELECT * FROM company WHERE name LIKE :letter%", nativeQuery = true)
    List<CompanyCatalog> findByNameLike(@Param("letter") String letter);

    Optional<CompanyCatalog> findById(Integer idCompanyCatalog);

}