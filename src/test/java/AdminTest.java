import org.junit.jupiter.api.BeforeEach;
import static user.UserRole.ADMIN;

public class AdminTest extends BaseTest {

    @BeforeEach
    public void setUp(){
        setTokensAfterUserRegistration(ADMIN);
    }
}
