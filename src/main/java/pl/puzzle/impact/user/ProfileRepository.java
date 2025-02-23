package pl.puzzle.impact.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
interface ProfileRepository extends JpaRepository<pl.puzzle.impact.user.Profile, UUID> {}
