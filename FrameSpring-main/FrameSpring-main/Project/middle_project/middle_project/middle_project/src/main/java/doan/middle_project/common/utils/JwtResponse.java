package doan.middle_project.common.utils;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private String id;
    private String username;
    private String fullName;

    private List<String> roles;

    private String avatarImage;

//    public JwtResponse(String accessToken, String id, String username, String email, List<String> roles) {
//        this.token = accessToken;
//        this.id = id;
//        this.username = username;
//        this.email = email;
//        this.roles = roles;
//    }

    public JwtResponse(String accessToken, String id, String username, String fullName, List<String> roles,String avatarImage) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.fullName = fullName;
        this.roles = roles;
        this.avatarImage = avatarImage;
    }

    public JwtResponse(String id) {
        this.id = id;
    }

    public String getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(String avatarImage) {
        this.avatarImage = avatarImage;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }
}
