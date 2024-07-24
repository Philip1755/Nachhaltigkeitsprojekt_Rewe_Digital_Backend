package de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.model.Project;
import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.model.Tags;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ProjectService {

    public List<Project> getAllProjects() {
        return ProjectService.importProjectsFromJSON();
    }

    public Project getProjectById(long id) {
        List<Project> projects = ProjectService.importProjectsFromJSON();
        Optional<Project> foundProject = projects
                .stream()
                .filter(project -> project.getId() == id)
                .findFirst();
        return foundProject.orElse(null);
    }

    public List<Project> getProjectsByTitle(String title) {
        List<Project> projects = ProjectService.importProjectsFromJSON();
        return projects
                .stream()
                .filter(project -> project
                        .getTitle()
                        .toLowerCase()
                        .contains(title.toLowerCase()))
                .toList();
    }

    public List<Project> getProjectsByDescription(String description) {
        List<Project> projects = ProjectService.importProjectsFromJSON();
        return projects
                .stream()
                .filter(project -> project
                        .getDescription()
                        .toLowerCase()
                        .contains(description.toLowerCase()))
                .toList();
    }

    public List<Project> getProjectsByOwner(String owner) {
        List<Project> projects = ProjectService.importProjectsFromJSON();
        return projects
                .stream()
                .filter(project -> project
                        .getOwner()
                        .toLowerCase()
                        .contains(owner.toLowerCase()))
                .toList();
    }

    public List<Project> getProjectsByTags(List<Integer> tags) {
        List<Project> projects = ProjectService.importProjectsFromJSON();
        return projects
                .stream()
                .filter(project -> project
                        .getTags()
                        .containsAll(Tags.convertIntegersToTags(tags)))
                .toList();
    }

    private static List<Project> importProjectsFromJSON() {
        String jsonPath = "src//main//resources//projects//allProjects.json";

        ObjectMapper objectMapper = new ObjectMapper();
        Set<Project> projects = new HashSet<>();

        try {
            projects = objectMapper.readValue(new File(jsonPath), new TypeReference<HashSet<Project>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return projects.stream().toList();
    }
}
