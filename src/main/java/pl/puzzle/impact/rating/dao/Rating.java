package pl.puzzle.impact.rating.dao;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.puzzle.impact.category.Category;
import pl.puzzle.impact.common.model.EntityType;
import pl.puzzle.impact.rating.dto.RatingCreationRequest;

import java.util.UUID;

import static jakarta.persistence.EnumType.STRING;
import static lombok.AccessLevel.PRIVATE;

@Builder
@Getter
@Entity
@Table(name = "rating")
@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor(access = PRIVATE)
class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @Enumerated(STRING)
    EntityType sourceType;
    UUID sourceId;

    UUID userId;

    @Embedded
    Category category;
    byte score;

    public Rating(RatingCreationRequest request) {
        this.sourceType = request.sourceType();
        this.sourceId = request.sourceId();
        this.userId = request.userId();
        this.category = request.category();
        this.score = request.value();
    }
}
