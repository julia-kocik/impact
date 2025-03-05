package pl.puzzle.impact.project;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.puzzle.impact.project.dto.ProjectCreateRequest;
import pl.puzzle.impact.project.dto.ProjectDetailsUpdateRequest;

import java.time.LocalDateTime;
import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "project_details")
@NoArgsConstructor(access = PRIVATE, force = true)
@AllArgsConstructor(access = PRIVATE)
@Builder
@Getter
public class ProjectDetails {

    @Id
    private UUID id;

    private boolean isFeatured;

    private String name;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private String description;

    static ProjectDetails createProjectDetails(ProjectCreateRequest projectCreateRequest, UUID projectId) {
        return ProjectDetails.builder()
                .id(projectId)
                .isFeatured(projectCreateRequest.isFeatured())
                .name(projectCreateRequest.name())
                .startDate(projectCreateRequest.startDate())
                .endDate(projectCreateRequest.endDate())
                .description(projectCreateRequest.description())
                .build();
    }

    void updateProjectDetails(ProjectDetailsUpdateRequest projectDetailsUpdateRequest) {
        this.isFeatured = projectDetailsUpdateRequest.isFeatured();
        this.name = projectDetailsUpdateRequest.name();
        this.startDate = projectDetailsUpdateRequest.startDate();
        this.endDate = projectDetailsUpdateRequest.endDate();
        this.description = projectDetailsUpdateRequest.description();
    }

}
