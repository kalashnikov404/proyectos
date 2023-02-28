package mx.badak.eva.api.serviceImpl;

import mx.badak.eva.api.exception.ResourceNotFound;
import mx.badak.eva.api.model.Level;
import mx.badak.eva.api.repository.LevelRepository;
import mx.badak.eva.api.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LevelServiceImpl implements LevelService {
    @Autowired
    private LevelRepository levelRepository;

    @Override
    public Level createLevel(Level level) {
        return levelRepository.save(level);
    }

    @Override
    public List<Level> getLevelAll() {
        return levelRepository.getLevelAll();
    }

    @Override
    public List<Level> getLevel(String string) {
        return levelRepository.getLevel(string);
    }

    @Override
    public Optional<Level> findById(Integer idLevel) { return levelRepository.findById(idLevel); }

    @Override
    public Level updateStatus(Integer idLevel, Integer status) {
        return levelRepository.findById(idLevel).map(level -> {
            level.setStatus(status);
            return levelRepository.save(level);
        }).orElseThrow(() -> new ResourceNotFound("idLevel " + idLevel + " not found"));
    }
}