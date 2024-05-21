package de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.service;

import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.dto.ProjectDto;
import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.dto.mapper.ProjectDtoMapper;
import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.model.Project;
import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectDto addProject(ProjectDto projectDto) {
        Project p = projectRepository.save(ProjectDtoMapper.dtoToProject(projectDto));
        return ProjectDtoMapper.projectToDto(p);
    }

    public List<ProjectDto> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return ProjectDtoMapper.projectsToDtos(projects);
    }

    public ProjectDto getProjectById(Long id) {
        Project project = projectRepository.findById(id).orElseThrow();
        return ProjectDtoMapper.projectToDto(project);
    }

    public void deleteProjectById(Long id) {
        projectRepository.deleteById(id);
    }

}
