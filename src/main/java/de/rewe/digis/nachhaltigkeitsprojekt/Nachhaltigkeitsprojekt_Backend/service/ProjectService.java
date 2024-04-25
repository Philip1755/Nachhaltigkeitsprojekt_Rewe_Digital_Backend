package de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.service;

import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.dto.ProjectDto;
import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.model.Project;
import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.repository.ProjectRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableScheduling
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepo projectRepo;

    public void addProject(ProjectDto projectDto) {
        projectRepo.save(dtoToProject(projectDto));
    }

    public List<ProjectDto> getAllProjects() {
        List<Project> projects = projectRepo.findAll();
        return projects.stream().map(this::projectToDto).toList();
    }

    public ProjectDto getProjectById(Long id) {
        Project project = projectRepo.findById(id).orElseThrow();
        return projectToDto(project);
    }

    public void deleteProjectById(Long id) {
        projectRepo.deleteById(id);
    }

    private ProjectDto projectToDto(Project project) {
        return ProjectDto.builder()
                .title(project.getTitle())
                .description(project.getDescription())
                .owner(project.getOwner())
                .url(project.getUrl())
                .build();
    }

    private Project dtoToProject(ProjectDto projectDto) {
        return Project.builder()
                .title(projectDto.getTitle())
                .description(projectDto.getDescription())
                .owner(projectDto.getOwner())
                .url(projectDto.getUrl())
                .build();
    }
}
