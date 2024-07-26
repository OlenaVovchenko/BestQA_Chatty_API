package user;

import com.github.javafaker.Faker;

public class UserDataRegistry {
    private static final Faker FAKER = new Faker();
    private static final String NAME = FAKER.name().firstName();
    private static final String SURNAME = FAKER.name().lastName();
    private static final String PASSWORD = "1234hjkl";
    private static final String NEWPASSWORD = "1234hjkl1";
    private static final String USER_ROLE = UserRole.USER.toString().toLowerCase();
    private static final String ADMIN_ROLE = UserRole.ADMIN.toString().toLowerCase();
    private static final String AVATAR_URL = "string";
    private static final String BIRTH_DATE = "2000-07-18T22:10:23.985Z";
    private static final String PHONE = "+55591098360";
    private static final String GENDER = "MALE";
    private static final String BACKGROUND_URL = "string";
    private static final boolean BLOCKED = true;


    private UserDataRegistry() {
    }

    public static AuthorizationUser getUserForLogin(AuthorizationUser authUser) {
        AuthorizationUser userForLogin = new AuthorizationUser();
        userForLogin.setEmail(authUser.getEmail());
        userForLogin.setPassword(authUser.getPassword());

        return userForLogin;
    }

    public static AuthorizationUser getAdminRegistration() {
        return new AuthorizationUser(FAKER.internet().emailAddress(), PASSWORD, PASSWORD, ADMIN_ROLE);
    }

    public static AuthorizationUser getUserRegistration() {
        return new AuthorizationUser(FAKER.internet().emailAddress(), PASSWORD, PASSWORD, USER_ROLE);
    }

    public static User getUpdatedUser(String registeredEmail) {
        return new User(registeredEmail, AVATAR_URL, NAME, SURNAME, BIRTH_DATE, PHONE, GENDER,
                BACKGROUND_URL, BLOCKED);
    }

    public static AuthorizationUser getUpdatedPassword() {
        return new AuthorizationUser(PASSWORD, NEWPASSWORD);

    }

    public  static  User getInvalidUser(){
        return new User(null, null, NAME, SURNAME, null, "", GENDER, BACKGROUND_URL, BLOCKED);
    }

}
