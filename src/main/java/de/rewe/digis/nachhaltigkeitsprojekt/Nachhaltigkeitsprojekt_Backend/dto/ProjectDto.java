package de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDto {

    private String title;
    private String description;
    private String owner;
    /*
    private String[] tags;
    private String[] imageSrcs;
    */
    private String url;

}
