package mx.badak.eva.api.serviceImpl;

import mx.badak.eva.api.exception.ResourceNotFound;
import mx.badak.eva.api.model.RoleCatalog;
import mx.badak.eva.api.repository.RoleCatalogRepository;
import mx.badak.eva.api.service.RoleCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class RoleCatalogServiceImpl implements RoleCatalogService {

    @Autowired
    private RoleCatalogRepository roleRepository;

    @Override
    public RoleCatalog createRole(RoleCatalog role) {

        return roleRepository.save(role);
    }

    @Override
    public List<RoleCatalog> getRoleAll() {
        return roleRepository.getPersonAll();
    }


    @Override
    public void deleteRole(Integer idRoleCatalog) {

        roleRepository.deleteById(idRoleCatalog);

    }



    @Override
    public RoleCatalog updateRole(Integer idRoleCatalog, Integer status) {
        return roleRepository.findById(idRoleCatalog).map(roles -> {
            roles.setStatus(status);
            return roleRepository.save(roles);
        }).orElseThrow(() -> new ResourceNotFound("id role " + idRoleCatalog + " not found"));
    }



    @Override
    public Optional<RoleCatalog> findById(Integer idRoleCatalog) {
        return
                roleRepository.findById(idRoleCatalog);
    }

    @Override
    public List<RoleCatalog> findByNameLike(String letter) {

        return  roleRepository.findByNameLike(letter);
    }

}
