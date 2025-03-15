package pl.puzzle.impact.project.query;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import pl.puzzle.impact.common.BaseQueryDslQueryService;
import pl.puzzle.impact.project.QFavouriteProject;
import pl.puzzle.impact.project.QProjectDetails;
import pl.puzzle.impact.project.query.dto.ProjectDetailsProjection;
import pl.puzzle.impact.project.query.dto.QProjectDetailsProjection;

import java.util.List;
import java.util.UUID;

@Service
public class QueryDslFavouriteProjectQueryService extends BaseQueryDslQueryService implements FavouriteProjectQueryService {

    public static final QFavouriteProject favouriteProject = QFavouriteProject.favouriteProject;
    private static final QProjectDetails projectDetails = QProjectDetails.projectDetails;

    public QueryDslFavouriteProjectQueryService(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<ProjectDetailsProjection> getFavProjectsByUser(UUID userId) {
        return queryFactory().select(new QProjectDetailsProjection(
                        projectDetails.id,
                        projectDetails.isFeatured,
                        projectDetails.name,
                        projectDetails.startDate,
                        projectDetails.endDate,
                        projectDetails.description
                ))
                .from(favouriteProject)
                .join(projectDetails).on(favouriteProject.projectId.eq(projectDetails.id))
                .where(favouriteProject.userId.eq(userId))
                .fetch();
    }
}
