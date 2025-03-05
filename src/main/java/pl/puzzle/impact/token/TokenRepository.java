package pl.puzzle.impact.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
interface TokenRepository extends JpaRepository<Token, UUID> {

    Optional<Token> findByTokenCodeAndType(String tokenCode, TokenType type);
}