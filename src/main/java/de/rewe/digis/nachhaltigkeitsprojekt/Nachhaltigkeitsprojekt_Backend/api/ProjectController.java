package de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.api;

import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.model.Project;
import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ProjectController implements ProjectApi {

    private final ProjectService projectService;

    @Override
    public ResponseEntity<Project> addProject(@RequestBody Project projectDto) {
//        log.info("POST Request: add Project");
//        return ResponseEntity.ok(projectService.addProject(projectDto));
        return null;
    }

    @Override
    public ResponseEntity<List<Project>> findAllProjects() {
//        log.info("GET Request: All Projects");
//        return ResponseEntity.ok(projectService.getAllProjects());
        return null;
    }

    @Override
    public ResponseEntity<Project> findProjectById(@PathVariable Long id) {
//        log.info("GET Request: Project With ID: {}", id);
//        return ResponseEntity.ok(projectService.getProjectById(id));
        return null;
    }

    @Override
    public ResponseEntity<List<Project>> findAllProjectsByTitleAndDescriptionAndOwner(
            @RequestParam String searchQuery
    ) {
//        log.info("GET Request: All Projects By Title and Description and Owner");
//        Set<ProjectDto> result = new HashSet<>();
//        List<ProjectDto> titleList = projectService.getProjectsByTitle(searchQuery);
//        List<ProjectDto> descriptionList = projectService.getProjectsByDescription(searchQuery);
//        List<ProjectDto> ownerList = projectService.getProjectsByOwner(searchQuery);
//        result.addAll(titleList);
//        result.addAll(descriptionList);
//        result.addAll(ownerList);
//        return ResponseEntity.ok(result.stream().toList());
        return null;
    }

    @Override
    public ResponseEntity<?> deleteProjectById(@PathVariable Long id) {
        log.info("DELETE Request: delete Project With ID: {}", id);
//        projectService.deleteProjectById(id);
        return ResponseEntity.ok().build();
    }
}
