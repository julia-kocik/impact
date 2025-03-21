package pl.puzzle.impact.rating.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.puzzle.impact.category.Category;
import pl.puzzle.impact.rating.dto.RatingCreationRequest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static pl.puzzle.impact.category.CategoryType.INCLUSION;
import static pl.puzzle.impact.common.model.EntityType.PROJECT;

@SpringBootTest
class RatingDaoTest {

    private final RatingRepository repository;
    private final RatingDao ratingDao;

    @Autowired
    public RatingDaoTest(RatingRepository repository, RatingDao ratingDao) {
        this.repository = repository;
        this.ratingDao = ratingDao;
    }

    @Test
    void SavedRating() {
        var request = new RatingCreationRequest(PROJECT, UUID.randomUUID(), UUID.randomUUID(),
                Category.valueOf(INCLUSION), (byte) 1);

        var id = ratingDao.create(request);

        assertTrue(repository.findById(id).isPresent());
    }
}