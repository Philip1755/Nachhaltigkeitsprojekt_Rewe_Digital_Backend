package de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.model.Project;
import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.model.Tags;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    public Set<Project> getAllProjects() {
        return ProjectService.importProjectsFromJSON();
    }

    public Project getProjectById(long id) {
        Set<Project> projects = ProjectService.importProjectsFromJSON();
        Optional<Project> foundProject = projects.stream().filter(project -> project.getId() == id).findFirst();
        return foundProject.orElse(null);
    }

    public Set<Project> getProjectsByTitle(String title) {
        Set<Project> projects = ProjectService.importProjectsFromJSON();
        return projects.stream().filter(project -> project.getTitle().toLowerCase().contains(title.toLowerCase())).collect(Collectors.toSet());
    }

    public Set<Project> getProjectsByDescription(String description) {
        Set<Project> projects = ProjectService.importProjectsFromJSON();
        return projects.stream().filter(project -> project.getDescription().toLowerCase().contains(description.toLowerCase())).collect(Collectors.toSet());
    }

    public Set<Project> getProjectsByOwner(String owner) {
        Set<Project> projects = ProjectService.importProjectsFromJSON();
        return projects.stream().filter(project -> project.getOwner().toLowerCase().contains(owner.toLowerCase())).collect(Collectors.toSet());
    }

    public Set<Project> getProjectsByTags(Set<Tags> tags) {
        Set<Project> projects = ProjectService.importProjectsFromJSON();
        return projects.stream().filter(project -> project.getTags().containsAll(tags)).collect(Collectors.toSet());
    }

    private static Set<Project> importProjectsFromJSON() {
        String jsonPath = "src//main//resources//projects//allProjects.json";

        ObjectMapper objectMapper = new ObjectMapper();
        Set<Project> projects = new HashSet<>();

        try {
            projects = objectMapper.readValue(new File(jsonPath), new TypeReference<HashSet<Project>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }

        return projects;
    }
}
