package de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Project {

    private long id;
    private String title;
    private String description;
    private String owner;
    private String url;
    private Set<String> imageSources;
    private Set<Tags> tags;

}
