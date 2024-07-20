package user;

import com.github.javafaker.Faker;

public class UserDataRegistry {
    private static final Faker FAKER = new Faker();
    private static final String EMAIL = FAKER.internet().emailAddress();
    private static final String name = FAKER.name().firstName();
    private static final String surname = FAKER.name().lastName();
    private static final String PASSWORD = "1234hjkl";
    private static final String USER_ROLE = UserRole.USER.toString().toLowerCase();
    private static final String ADMIN_ROLE = UserRole.ADMIN.toString().toLowerCase();
    private static final String AVATAR_URL = "string";
    private static final String BIRTH_DATE = "2024-07-18T22:10:23.985Z";
    private static final String PHONE = "+55591098360";
    private static final String GENDER = "MALE";
    private static final String BACKGROUND_URL = "string";
    private static final boolean BLOCKED = true;

    private UserDataRegistry() {
    }

    public static AuthorizationUser getUserForLogin(){
        AuthorizationUser userForLogin = new AuthorizationUser();
        userForLogin.setEmail(EMAIL);
        userForLogin.setPassword(PASSWORD);

        return userForLogin;
    }

    public static AuthorizationUser getAdminRegistration(){
        return new AuthorizationUser(EMAIL, PASSWORD, PASSWORD, ADMIN_ROLE);
    }

    public static AuthorizationUser getUserRegistration(){
        return new AuthorizationUser(EMAIL, PASSWORD, PASSWORD, USER_ROLE);
    }

    public static User getUpdatedUser(){
        return new User(AVATAR_URL, name, surname, BIRTH_DATE, PHONE, GENDER, BACKGROUND_URL, BLOCKED);
    }
}
