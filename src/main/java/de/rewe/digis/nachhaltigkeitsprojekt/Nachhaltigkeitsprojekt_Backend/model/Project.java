package de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.model;

import lombok.*;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Project {
    private String title;
    private String description;
    private String owner;
    private String[] tags;
    private String[] imageSrcs;
    private String url;
}
