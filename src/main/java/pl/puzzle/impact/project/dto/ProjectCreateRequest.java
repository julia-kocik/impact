package pl.puzzle.impact.project.dto;

import java.time.LocalDateTime;

public record ProjectCreateRequest(boolean isFeatured, String name, LocalDateTime startDate, LocalDateTime endDate, String description) {}
