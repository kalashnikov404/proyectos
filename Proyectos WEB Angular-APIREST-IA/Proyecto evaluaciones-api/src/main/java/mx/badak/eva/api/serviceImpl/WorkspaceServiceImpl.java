package mx.badak.eva.api.serviceImpl;

import mx.badak.eva.api.exception.ResourceNotFound;
import mx.badak.eva.api.repository.WorkspaceRepository;
import mx.badak.eva.api.service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class WorkspaceServiceImpl implements WorkspaceService {

    @Autowired
    private WorkspaceRepository workspaceRepository;

    @Override
    public mx.badak.eva.api.model.Workspace createWorkspace(mx.badak.eva.api.model.Workspace workspace) {

        return workspaceRepository.save(workspace);
    }

    @Override
    public List<mx.badak.eva.api.model.Workspace> getWorkspaceAll() {
        return workspaceRepository.getPersonAll();
    }



    @Override
    public void deleteWorkspace(Integer id) {

        workspaceRepository.deleteById(id);
    }



    @Override
    public mx.badak.eva.api.model.Workspace updateWorkspace(Integer id, Integer status) {
        return workspaceRepository.findById(id).map(workspaces -> {
            workspaces.setStatus(status);
            return workspaceRepository.save(workspaces);
        }).orElseThrow(() -> new ResourceNotFound("id workspace " + id + " not found"));
    }



    @Override
    public Optional<mx.badak.eva.api.model.Workspace> findById(Integer id) {
        return
                workspaceRepository.findById(id);
    }

    @Override
    public List<mx.badak.eva.api.model.Workspace> findByNameLike(String letter) {

        return  workspaceRepository.findByNameLike(letter);
    }



}
