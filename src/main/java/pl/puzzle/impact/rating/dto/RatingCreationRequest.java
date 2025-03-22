package pl.puzzle.impact.rating.dto;

import pl.puzzle.impact.category.Category;
import pl.puzzle.impact.common.model.EntityType;

import java.util.UUID;

public record RatingCreationRequest(EntityType sourceType, UUID sourceId, UUID userId, Category category, byte value) {}
