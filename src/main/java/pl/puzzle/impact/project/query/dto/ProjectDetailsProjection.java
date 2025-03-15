package pl.puzzle.impact.project.query.dto;

import com.querydsl.core.annotations.QueryProjection;

import java.time.LocalDateTime;
import java.util.UUID;

public class ProjectDetailsProjection {

    private final UUID id;

    private final boolean isFeatured;

    private final String name;

    private final LocalDateTime startDate;

    private final LocalDateTime endDate;

    private final String description;

    @QueryProjection
    public ProjectDetailsProjection(UUID id, boolean isFeatured, String name, LocalDateTime startDate, LocalDateTime endDate, String description) {
        this.id = id;
        this.isFeatured = isFeatured;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public boolean isFeatured() {
        return isFeatured;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }
}
