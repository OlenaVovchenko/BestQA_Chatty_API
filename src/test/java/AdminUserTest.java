import org.junit.jupiter.api.BeforeEach;
import static user.UserRole.ADMIN;
import static user.UserRole.USER;

public class AdminUserTest extends BaseTest{
    protected String userId;

    @BeforeEach
    public void setUp(){
        setTokensAfterUserRegistration(USER);
        setTokensAfterUserRegistration(ADMIN);
        this.userId = getUserIdAfterRequest();
    }
}
