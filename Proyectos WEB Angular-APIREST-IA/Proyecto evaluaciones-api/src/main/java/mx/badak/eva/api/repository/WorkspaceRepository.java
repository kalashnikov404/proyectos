package mx.badak.eva.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkspaceRepository extends JpaRepository<mx.badak.eva.api.model.Workspace, Integer> {


    mx.badak.eva.api.model.Workspace save(mx.badak.eva.api.model.Workspace workspace);


    @Query(value = "SELECT * FROM Workspace; ", nativeQuery = true)
    List<mx.badak.eva.api.model.Workspace> getPersonAll();

    @Query(value = "SELECT * FROM workspace WHERE name LIKE BINARY CONCAT('%',:letter,'%')", nativeQuery = true)
    List<mx.badak.eva.api.model.Workspace> findByNameLike(@Param("letter") String letter);



}
