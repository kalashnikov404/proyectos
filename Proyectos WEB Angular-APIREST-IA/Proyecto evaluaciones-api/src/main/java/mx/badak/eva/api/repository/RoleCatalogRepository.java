package mx.badak.eva.api.repository;

import mx.badak.eva.api.model.RoleCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RoleCatalogRepository extends JpaRepository<RoleCatalog, Integer> {


    RoleCatalog save(RoleCatalog role);


    @Query(value = "SELECT * FROM role_catalog; ", nativeQuery = true)
    List<RoleCatalog> getPersonAll();

    @Query(value = "SELECT * FROM Role WHERE name LIKE BINARY CONCAT('%',:letter,'%')", nativeQuery = true)
    List<RoleCatalog> findByNameLike(@Param("letter") String letter);



}
