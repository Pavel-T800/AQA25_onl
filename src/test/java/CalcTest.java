import org.testng.Assert;
import org.testng.annotations.Test;

public class CalcTest extends BaseTest {
    @Test
    private void testSum() {
        Assert.assertEquals(calculator.div(6, 3), 3, "myMessage");
        counter++;
    }


}
