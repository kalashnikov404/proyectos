package mx.badak.eva.api.repository;


import mx.badak.eva.api.model.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LevelRepository extends JpaRepository<Level, Integer> {
    @Query(value = "SELECT * FROM level WHERE status=1", nativeQuery = true)
    List<Level> getLevelAll();

    @Query(value = "SELECT * FROM level WHERE name LIKE ?1%", nativeQuery = true)
    List<Level> getLevel(String string);





}
