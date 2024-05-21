package de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.controller;

import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.dto.ProjectDto;
import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<ProjectDto> addProject(@RequestBody ProjectDto projectDto) {
        log.info("POST Request: add Project");
        return ResponseEntity.ok(projectService.addProject(projectDto));
    }

    @GetMapping
    public ResponseEntity<List<ProjectDto>> findAllProjects() {
        log.info("GET Request: All Projects");
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> findProjectById(@PathVariable Long id) {
        log.info("GET Request: Project With ID: {}", id);
        return ResponseEntity.ok(projectService.getProjectById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProjectById(@PathVariable Long id) {
        log.info("DELETE Request: delete Project With ID: {}", id);
        projectService.deleteProjectById(id);
        return ResponseEntity.ok().build();
    }
}
