package pl.puzzle.impact.project.query.dto;

import com.querydsl.core.annotations.QueryProjection;

import java.util.UUID;


public class ImageProjection {

    private final UUID projectId;
    private final String imageUrl;

    @QueryProjection
    public ImageProjection(UUID projectId, String imageUrl) {
        this.projectId = projectId;
        this.imageUrl = imageUrl;
    }

    public UUID getProjectId() {
        return projectId;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
