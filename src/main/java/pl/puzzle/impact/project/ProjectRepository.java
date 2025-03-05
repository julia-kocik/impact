package pl.puzzle.impact.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
interface ProjectRepository extends JpaRepository<pl.puzzle.impact.project.Project, UUID> {}
