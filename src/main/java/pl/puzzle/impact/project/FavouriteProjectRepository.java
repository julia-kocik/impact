package pl.puzzle.impact.project;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FavouriteProjectRepository extends JpaRepository<pl.puzzle.impact.project.FavouriteProject, UUID> {}
