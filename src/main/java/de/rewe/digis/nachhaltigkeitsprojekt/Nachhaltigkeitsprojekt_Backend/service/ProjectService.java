package de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.service;

import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.dto.ProjectDto;
import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.dto.mapper.ProjectDtoMapper;
import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.model.Project;
import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return ProjectDtoMapper.projectsToDtos(projectRepository.findAll());
    }

    public ProjectDto getProjectById(Long id) {
        return ProjectDtoMapper.projectToDto(projectRepository.findById(id).orElseThrow());
    }

    public List<ProjectDto> getProjectsByTitle(String title) {
        if (title == null) return new ArrayList<>();
        return ProjectDtoMapper.projectsToDtos(projectRepository.findAllByTitleContainingIgnoreCase(title));
    }

    public List<ProjectDto> getProjectsByDescription(String description) {
        if (description == null) return new ArrayList<>();
        return ProjectDtoMapper.projectsToDtos(projectRepository.findAllByDescriptionContainingIgnoreCase(description));
    }

    public List<ProjectDto> getProjectsByOwner(String owner) {
        if (owner == null) return new ArrayList<>();
        return ProjectDtoMapper.projectsToDtos(projectRepository.findAllByOwnerContainingIgnoreCase(owner));
    }


    public void deleteProjectById(Long id) {
        projectRepository.deleteById(id);
    }

}
