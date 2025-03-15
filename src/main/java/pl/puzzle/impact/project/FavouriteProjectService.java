package pl.puzzle.impact.project;

import org.springframework.stereotype.Service;
import pl.puzzle.impact.common.exception.ErrorMessage;
import pl.puzzle.impact.common.exception.NotFoundException;
import pl.puzzle.impact.project.query.ProjectDetailsQueryService;

import java.util.UUID;

@Service
public class FavouriteProjectService {

    private final FavouriteProjectRepository favouriteProjectRepository;
    private final ProjectDetailsQueryService projectDetailsQueryService;

    public FavouriteProjectService(FavouriteProjectRepository favouriteProjectRepository, ProjectDetailsQueryService projectDetailsQueryService) {
        this.favouriteProjectRepository = favouriteProjectRepository;
        this.projectDetailsQueryService = projectDetailsQueryService;
    }

    public FavouriteProject addProjectToFavourites(UUID userId, UUID projectId) {
        projectDetailsQueryService.getById(projectId).orElseThrow(() -> new NotFoundException(ErrorMessage.PROJECT_NOT_FOUND));
        FavouriteProject favouriteProject = FavouriteProject.addProjectToFavourites(userId, projectId);
        return favouriteProjectRepository.save(favouriteProject);
    }

    public void deleteProjectFromFavourites(UUID id) {
        favouriteProjectRepository.deleteById(id);
    }
}
