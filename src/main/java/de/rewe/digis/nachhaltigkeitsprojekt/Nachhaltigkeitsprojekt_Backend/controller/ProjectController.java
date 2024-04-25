package de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.controller;

import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.dto.ProjectDto;
import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/all")
    public ResponseEntity<List<ProjectDto>> findAllProjects() {
        log.info("GET Request: All Projects");
        List<ProjectDto> projects = projectService.getAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ProjectDto> findProjectById(@PathVariable("id") Long id) {
        log.info("GET Request: Project Width ID: {}", id);
        ProjectDto projectDto = projectService.getProjectById(id);
        return new ResponseEntity<>(projectDto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addProject(@RequestBody ProjectDto projectDto) {
        log.info("POST Request: add Project");
        projectService.addProject(projectDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProjectById(@PathVariable("id") Long id) {
        log.info("DELETE Request: delete Project Width ID: {}", id);
        projectService.deleteProjectById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
