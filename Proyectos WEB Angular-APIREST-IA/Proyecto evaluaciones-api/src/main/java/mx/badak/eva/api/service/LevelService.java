package mx.badak.eva.api.service;

import mx.badak.eva.api.model.Level;

import java.util.List;
import java.util.Optional;

public interface LevelService {
    Level createLevel(Level level);
    List<Level> getLevelAll();
    List<Level> getLevel(String string);
    Optional<Level> findById(Integer idLevel);
    public Level updateStatus(Integer idLevel, Integer status);
}
