package de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.api;

import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.model.Project;
import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProjectController implements ProjectApi {

    private final ProjectService projectService;

    @Override
    public ResponseEntity<List<Project>> findAllProjects() {
        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Project> findProjectsById(long id) {
        return new ResponseEntity<>(projectService.getProjectById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Project>> findProjectsByTitle(String title) {
        return new ResponseEntity<>(projectService.getProjectsByTitle(title), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Project>> findProjectsByDescription(String description) {
        return new ResponseEntity<>(projectService.getProjectsByDescription(description), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Project>> findProjectsByOwner(String owner) {
        return new ResponseEntity<>(projectService.getProjectsByOwner(owner), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Project>> findProjectsByTags(List<Integer> tags) {
        return new ResponseEntity<>(projectService.getProjectsByTags(tags), HttpStatus.OK);
    }
}
