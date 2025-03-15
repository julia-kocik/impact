package pl.puzzle.impact.project;

import org.springframework.stereotype.Service;
import pl.puzzle.impact.project.dto.ProjectCreateRequest;
import java.util.UUID;

@Service
public class CreateProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectDetailsRepository projectDetailsRepository;
    private final CompanyProjectService companyProjectService;
    private final ImageRepository imageRepository;

    public CreateProjectService(ProjectRepository projectRepository, ProjectDetailsRepository projectDetailsRepository, CompanyProjectService companyProjectService, ImageRepository imageRepository) {
        this.projectRepository = projectRepository;
        this.projectDetailsRepository = projectDetailsRepository;
        this.companyProjectService = companyProjectService;
        this.imageRepository = imageRepository;
    }

    public Project createProject(ProjectCreateRequest projectCreateRequest, UUID companyId) {
        //check if company exists
        Project project = Project.createProject();
        projectRepository.save(project);
        companyProjectService.addCompanyToProject(companyId, project.getId());
        ProjectDetails projectDetails = ProjectDetails.createProjectDetails(projectCreateRequest, project.getId());
        projectDetailsRepository.save(projectDetails);
        Image image = Image.createImage(project.getId());
        imageRepository.save(image);
        return project;
    }
}
