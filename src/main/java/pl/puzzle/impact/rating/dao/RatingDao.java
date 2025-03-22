package pl.puzzle.impact.rating.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.puzzle.impact.rating.dto.RatingCreationRequest;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RatingDao {

    private final RatingRepository repository;

    public UUID create(RatingCreationRequest request) {
        return repository.save(new Rating(request)).getId();
    }
}