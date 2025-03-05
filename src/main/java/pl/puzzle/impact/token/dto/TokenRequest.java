package pl.puzzle.impact.token.dto;

import pl.puzzle.impact.token.TokenType;

import java.util.UUID;

public record TokenRequest(UUID userId, TokenType type) {}
