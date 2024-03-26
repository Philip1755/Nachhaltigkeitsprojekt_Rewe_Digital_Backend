package de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.model.Project;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    @Getter
    private final List<Project> allProjects;

    private final ObjectMapper objectMapper;

    public ProjectService() {
        allProjects = new ArrayList<>();
        objectMapper = new ObjectMapper();
        initProjects();
    }

    private void initProjects() {
        File[] jsonFiles = getJsonFiles();

        for (File file : jsonFiles) {
            if (!file.isFile()) continue;
            allProjects.add(parseFileToProject(file));
        }
    }

    private Project parseFileToProject(File file) {
        try {
            String Json = Files.readString(file.toPath());
            return objectMapper.readValue(Json, Project.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private File[] getJsonFiles() {
        File folder = new File("src/main/resources/projects");
        return folder.listFiles();
    }

}
