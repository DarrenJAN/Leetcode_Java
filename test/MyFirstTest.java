import com.company.Add_Digits;
import org.junit.Assert;
import org.junit.Test;

public class MyFirstTest {
    Add_Digits add = new Add_Digits();
    @Test
    public void firstTest() {
        Assert.assertEquals(4,add.addDigits(12));
    }
}