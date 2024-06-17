package de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.api;

import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.model.dto.ProjectDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProjectApi {

    @PostMapping("/projects")
    ResponseEntity<ProjectDto> addProject(@RequestBody ProjectDto projectDto);

    @GetMapping("/projects")
    ResponseEntity<List<ProjectDto>> findAllProjects();

    @GetMapping("/projects/{id}")
    ResponseEntity<ProjectDto> findProjectById(@PathVariable Long id);

    @GetMapping("/projects/search")
    ResponseEntity<List<ProjectDto>> findAllProjectsByTitleAndDescriptionAndOwner(
            @RequestParam String searchQuery
    );

    @DeleteMapping("/projects/{id}")
    ResponseEntity<?> deleteProjectById(@PathVariable Long id);

}
