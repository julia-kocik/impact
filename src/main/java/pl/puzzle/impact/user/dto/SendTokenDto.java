package pl.puzzle.impact.user.dto;

import pl.puzzle.impact.user.TokenType;

public record SendTokenDto(String email, TokenType type) {
}
