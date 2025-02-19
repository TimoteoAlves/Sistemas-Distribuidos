package com.timoteo.project.service;

import com.timoteo.project.model.Project;
import com.timoteo.project.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Indica que esta classe é um serviço gerenciado pelo Spring
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    // Método para listar todos os projetos
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // Método para criar um projeto
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    // Método para atualizar um projeto
    public Project updateProject(Long id, Project projectDetails) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado com esse id " + id));

        project.setName(projectDetails.getName());
        project.setStartDate(projectDetails.getStartDate());
        project.setEndDate(projectDetails.getEndDate());
        project.setHours(projectDetails.getHours());
        project.setArtifact(projectDetails.getArtifact());

        return projectRepository.save(project);
    }

    // Método para deletar um projeto
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}