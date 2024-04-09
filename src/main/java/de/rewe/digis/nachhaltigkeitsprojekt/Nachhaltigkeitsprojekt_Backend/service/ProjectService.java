package de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.model.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Service
@EnableScheduling
public class ProjectService {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectService.class);

    private final List<Project> allProjects;

    private final ObjectMapper objectMapper;

    public ProjectService() {
        allProjects = new ArrayList<>();
        objectMapper = new ObjectMapper();
        LOG.info("Initialize Projects for the first time");
        initProjects();
    }

    public List<Project> getAllProjects() {
        if (getJsonFiles().length != allProjects.size()) {
            LOG.info("Re-Initialize Projects, due to different size between Json Files and Project List");
            initProjects();
        }

        return allProjects;
    }

    @Scheduled(fixedRate = 600000)
    private void initProjects() {
        LOG.info("Initialize Projects");
        allProjects.clear();
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
            LOG.error("Could not read the Json File");
            throw new RuntimeException(e);
        }
    }

    private File[] getJsonFiles() {
        File folder = new File("src/main/resources/projects");
        return folder.listFiles();
    }

}
