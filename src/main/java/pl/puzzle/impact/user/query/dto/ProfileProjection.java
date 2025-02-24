package pl.puzzle.impact.user.query.dto;

import com.querydsl.core.annotations.QueryProjection;

public class ProfileProjection {

    private final String username;
    private final String email;
    private final String password;

    @QueryProjection
    public ProfileProjection(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
