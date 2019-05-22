import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestTest {

    @Test
    public void TestMethod() {
        assertThat(1, equalTo(1));
    }
}
