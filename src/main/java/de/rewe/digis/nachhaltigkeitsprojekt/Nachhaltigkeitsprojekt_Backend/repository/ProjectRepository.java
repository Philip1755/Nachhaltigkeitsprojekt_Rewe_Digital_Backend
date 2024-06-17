package de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.repository;

import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.model.Project;
import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findAllByTitleContainingIgnoreCase(String title);

    List<Project> findAllByDescriptionContainingIgnoreCase(String description);

    List<Project> findAllByOwnerContainingIgnoreCase(String owner);

    List<Project> findAllByTagsContainingIgnoreCase(List<Tag> tags);

}