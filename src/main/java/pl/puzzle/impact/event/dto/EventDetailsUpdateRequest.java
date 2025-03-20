package pl.puzzle.impact.event.dto;

import java.time.LocalDateTime;

public record EventDetailsUpdateRequest(boolean isFeatured, String name, LocalDateTime startDate, LocalDateTime endDate, String description) {}
