package de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.model.dto.mapper;

import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.model.dto.ProjectDto;
import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.model.Image;
import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.model.Project;
import de.rewe.digis.nachhaltigkeitsprojekt.Nachhaltigkeitsprojekt_Backend.model.Tag;

import java.util.ArrayList;
import java.util.List;

public class ProjectDtoMapper {

    public static ProjectDto projectToDto(Project project) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setTitle(project.getTitle());
        projectDto.setDescription(project.getDescription());
        projectDto.setOwner(project.getOwner());
        projectDto.setUrl(project.getUrl());

        List<String> imageSrcs = new ArrayList<>();
        for (Image image : project.getImages()) {
            imageSrcs.add(image.getImageSrc());
        }

        List<String> tagNames = new ArrayList<>();
        for (Tag tag : project.getTags()) {
            tagNames.add(tag.getTagName());
        }

        projectDto.setImageSrcs(imageSrcs);
        projectDto.setTagNames(tagNames);

        return projectDto;
    }

    public static Project dtoToProject(ProjectDto projectDto) {
        Project project = new Project();
        project.setTitle(projectDto.getTitle());
        project.setDescription(projectDto.getDescription());
        project.setOwner(projectDto.getOwner());
        project.setUrl(projectDto.getUrl());

        List<Image> images = new ArrayList<>();
        for (String imageSrc : projectDto.getImageSrcs()) {
            Image image = new Image();
            image.setImageSrc(imageSrc);
            images.add(image);
        }

        List<Tag> tags = new ArrayList<>();
        for (String tagName : projectDto.getTagNames()) {
            Tag tag = new Tag();
            tag.setTagName(tagName);
            tags.add(tag);
        }

        project.setImages(images);
        project.setTags(tags);

        return project;
    }

    public static List<Project> dtosToProjects(List<ProjectDto> projectDtoSet) {
        return projectDtoSet.stream().map(ProjectDtoMapper::dtoToProject).toList();
    }

    public static List<ProjectDto> projectsToDtos(List<Project> projectSet) {
        return projectSet.stream().map(ProjectDtoMapper::projectToDto).toList();
    }
}
