package pl.puzzle.impact.event.dto;

import java.time.LocalDateTime;

public record EventCreateRequest(boolean isFeatured, String name, LocalDateTime startDate, LocalDateTime endDate, String description) {}
