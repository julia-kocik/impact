package pl.puzzle.impact.rating.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface RatingRepository extends JpaRepository<Rating, UUID> {

    @Query("SELECT AVG(r.score) FROM Rating r WHERE r.sourceId = ?1")
    float getAverageRatingFor(UUID sourceId);
}
