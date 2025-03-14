package pl.puzzle.impact.project.query;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import pl.puzzle.impact.common.BaseQueryDslQueryService;
import pl.puzzle.impact.project.query.dto.ImageProjection;
import pl.puzzle.impact.project.query.dto.QImageProjection;
import pl.puzzle.impact.project.QImage;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
class QueryDslImageQueryService extends BaseQueryDslQueryService implements ImageQueryService  {

    public static final QImage image = QImage.image;

    public QueryDslImageQueryService(EntityManager entityManager) {
        super(entityManager);
    }
    @Override
    public Optional<ImageProjection> getById(UUID imageId) {
        return Optional.ofNullable(queryFactory().select(new QImageProjection(
                image.projectId,
                image.imageUrl
        )).from(image).where(image.id.eq(imageId)).fetchOne());
    }

    @Override
    public List<ImageProjection> getImagesByProject(UUID projectId) {
        return queryFactory().select(new QImageProjection(
                image.projectId,
                image.imageUrl
        )).from(image).where(image.projectId.eq(projectId)).fetch();
    }
}
