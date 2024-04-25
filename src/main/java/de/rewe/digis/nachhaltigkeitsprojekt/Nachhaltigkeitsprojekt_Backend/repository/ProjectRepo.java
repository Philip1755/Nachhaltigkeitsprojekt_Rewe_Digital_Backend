package de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.repository;

import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Long> {

}
