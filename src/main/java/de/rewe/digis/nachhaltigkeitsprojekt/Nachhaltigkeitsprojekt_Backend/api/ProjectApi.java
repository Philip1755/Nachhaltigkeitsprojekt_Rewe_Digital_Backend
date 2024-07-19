package de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.api;

import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.model.Project;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProjectApi {

    @PostMapping("/projects")
    ResponseEntity<Project> addProject(@RequestBody Project projectDto);

    @GetMapping("/projects")
    ResponseEntity<List<Project>> findAllProjects();

    @GetMapping("/projects/{id}")
    ResponseEntity<Project> findProjectById(@PathVariable Long id);

    @GetMapping("/projects/search")
    ResponseEntity<List<Project>> findAllProjectsByTitleAndDescriptionAndOwner(
            @RequestParam String searchQuery
    );

    @DeleteMapping("/projects/{id}")
    ResponseEntity<?> deleteProjectById(@PathVariable Long id);

}
