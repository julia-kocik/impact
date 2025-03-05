package pl.puzzle.impact.project;

import org.springframework.stereotype.Service;
import pl.puzzle.impact.project.dto.ProjectCreateRequest;
import java.util.UUID;

@Service
public class CreateProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectDetailsRepository projectDetailsRepository;
    private final CompanyProjectService companyProjectService;

    public CreateProjectService(ProjectRepository projectRepository, ProjectDetailsRepository projectDetailsRepository, CompanyProjectService companyProjectService) {
        this.projectRepository = projectRepository;
        this.projectDetailsRepository = projectDetailsRepository;
        this.companyProjectService = companyProjectService;
    }

    public Project createProject(ProjectCreateRequest projectCreateRequest, UUID companyId) {
        //check if company exists
        Project project = Project.createProject();
        projectRepository.save(project);
        companyProjectService.addCompanyToProject(companyId, project.getId());
        ProjectDetails projectDetails = ProjectDetails.createProjectDetails(projectCreateRequest, project.getId());
        projectDetailsRepository.save(projectDetails);
        return project;
    }
}
