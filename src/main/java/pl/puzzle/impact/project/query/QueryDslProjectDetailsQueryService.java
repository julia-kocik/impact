package pl.puzzle.impact.project.query;

import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Service;
import pl.puzzle.impact.common.BaseQueryDslQueryService;
import pl.puzzle.impact.project.CompanyProjectService;
import pl.puzzle.impact.project.QCompanyProject;
import pl.puzzle.impact.project.QProjectDetails;
import pl.puzzle.impact.project.query.dto.ProjectDetailsProjection;
import pl.puzzle.impact.project.query.dto.QProjectDetailsProjection;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class QueryDslProjectDetailsQueryService extends BaseQueryDslQueryService implements ProjectDetailsQueryService {

    private static final QProjectDetails projectDetails = QProjectDetails.projectDetails;
    private static final QCompanyProject companyProject = QCompanyProject.companyProject;

    QueryDslProjectDetailsQueryService(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public List<ProjectDetailsProjection> getAllProjects() {
        return queryFactory().select(new QProjectDetailsProjection(
                        projectDetails.isFeatured,
                        projectDetails.name,
                        projectDetails.startDate,
                        projectDetails.endDate,
                        projectDetails.description
                ))
                .from(projectDetails)
                .fetch();
    }

    @Override
    public Optional<ProjectDetailsProjection> getById(UUID projectId) {
        return Optional.ofNullable(queryFactory().select(new QProjectDetailsProjection(
                        projectDetails.isFeatured,
                        projectDetails.name,
                        projectDetails.startDate,
                        projectDetails.endDate,
                        projectDetails.description
                ))
                .from(projectDetails)
                .where(projectDetails.id.eq(projectId))
                .fetchOne());
    }

    @Override
    public List<ProjectDetailsProjection> getProjectsByCompanyId(UUID companyId) {
        return queryFactory().select(new QProjectDetailsProjection(
                        projectDetails.isFeatured,
                        projectDetails.name,
                        projectDetails.startDate,
                        projectDetails.endDate,
                        projectDetails.description
                ))
                .from(companyProject)
                .join(projectDetails).on(companyProject.projectId.eq(projectDetails.id))
                .where(companyProject.companyId.eq(companyId))
                .fetch();
    }


}
