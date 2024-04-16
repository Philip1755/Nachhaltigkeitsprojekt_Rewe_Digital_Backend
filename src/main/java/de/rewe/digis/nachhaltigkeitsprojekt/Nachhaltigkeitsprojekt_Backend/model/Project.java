package de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;

    @Column(name = "TITLE", length = 15)
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "OWNER", length = 15)
    private String owner;

    /*@Column(name = "TITLE")
    private String[] tags;

    @Column(name = "TITLE")
    private String[] imageSrcs;*/

    @Column(name = "URL", length = 150)
    private String url;

}
