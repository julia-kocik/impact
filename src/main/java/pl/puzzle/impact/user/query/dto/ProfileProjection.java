package pl.puzzle.impact.user.query.dto;

import com.querydsl.core.annotations.QueryProjection;

public class ProfileProjection {

    private final String username;
    private final String email;
    private final String password;
    private final boolean active;

    @QueryProjection
    public ProfileProjection(String username, String email, String password, boolean active) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.active = active;
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

    public boolean isActive() {
        return active;
    }
}
