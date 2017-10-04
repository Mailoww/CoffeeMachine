import org.junit.Assert;
import org.junit.Test;

public class DrinkManagerTest {

    @Test
    public void shouldMakeCoffee(){
        Assert.assertEquals("C::", new DrinkManager().makeCoffee());
    }
}
