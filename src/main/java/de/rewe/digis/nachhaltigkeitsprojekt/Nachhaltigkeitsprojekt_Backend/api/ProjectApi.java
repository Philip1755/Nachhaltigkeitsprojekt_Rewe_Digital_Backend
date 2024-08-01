package de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.api;

import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.model.Project;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProjectApi {

    @GetMapping("/projects")
    ResponseEntity<List<Project>> findAllProjects();

    @GetMapping("/projects/{id}")
    ResponseEntity<Project> findProjectsById(@PathVariable long id);

    @GetMapping("/projects/title/{title}")
    ResponseEntity<List<Project>> findProjectsByTitle(@PathVariable String title);

    @GetMapping("/projects/description/{description}")
    ResponseEntity<List<Project>> findProjectsByDescription(@PathVariable String description);

    @GetMapping("/projects/owner/{owner}")
    ResponseEntity<List<Project>> findProjectsByOwner(@PathVariable String owner);

    @GetMapping("projects/tags/{tags}")
    ResponseEntity<List<Project>> findProjectsByTags(@PathVariable List<Integer> tags);

}
