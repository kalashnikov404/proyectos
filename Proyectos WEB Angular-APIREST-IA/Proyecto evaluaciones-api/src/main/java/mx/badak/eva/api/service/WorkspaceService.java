package mx.badak.eva.api.service;

import mx.badak.eva.api.model.Workspace;

import java.util.List;
import java.util.Optional;

public interface WorkspaceService {


    Workspace createWorkspace(Workspace workspace);

    List<Workspace> getWorkspaceAll();
    void deleteWorkspace(Integer id);

    public Workspace updateWorkspace(Integer id, Integer status);

    Optional<Workspace> findById(Integer id);

    List<Workspace> findByNameLike(String letter);



}
