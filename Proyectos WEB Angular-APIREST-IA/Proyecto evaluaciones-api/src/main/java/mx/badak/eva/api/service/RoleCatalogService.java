package mx.badak.eva.api.service;

import mx.badak.eva.api.model.RoleCatalog;

import java.util.List;
import java.util.Optional;

public interface RoleCatalogService {

    RoleCatalog createRole(RoleCatalog role);

    List<RoleCatalog> getRoleAll();
    void deleteRole(Integer idRoleCatalog);

    public RoleCatalog updateRole(Integer idRoleCatalog, Integer status);

    Optional<RoleCatalog> findById(Integer idRoleCatalog);

    List<RoleCatalog> findByNameLike(String letter);




}
