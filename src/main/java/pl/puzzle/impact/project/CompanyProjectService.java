package pl.puzzle.impact.project;

import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class CompanyProjectService {
    private final CompanyProjectRepository companyProjectRepository;

    public CompanyProjectService(CompanyProjectRepository companyProjectRepository) {
        this.companyProjectRepository = companyProjectRepository;
    }

    public void addCompanyToProject(UUID companyId, UUID projectId) {
        CompanyProject companyProject = CompanyProject.builder()
                .id(UUID.randomUUID())
                .companyId(companyId)
                .projectId(projectId)
                .build();
        companyProjectRepository.save(companyProject);
    }
}
