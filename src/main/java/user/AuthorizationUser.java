package user;

import java.util.Objects;

public class AuthorizationUser {
    private String email;
    private String password;
    private String newPassword;
    private String confirmPassword;
    private String role;

    public AuthorizationUser() {
    }

    public AuthorizationUser(String password, String newPassword) {
        this.password = password;
        this.newPassword = newPassword;

    }

    public AuthorizationUser(String email, String password, String confirmPassword, String role) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorizationUser authorizationUser = (AuthorizationUser) o;
        return email.equals(authorizationUser.email) && password.equals(authorizationUser.password)
                && confirmPassword.equals(authorizationUser.confirmPassword)
                && role.equals(authorizationUser.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, confirmPassword, role);
    }


    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
