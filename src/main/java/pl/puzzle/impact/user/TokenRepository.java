package pl.puzzle.impact.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
interface TokenRepository extends JpaRepository<Token, UUID> {
    Optional<Token> findByTokenCode(String tokenCode);
}