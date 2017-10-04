import org.junit.Assert;
import org.junit.Test;

public class DrinkManagerTest {

    @Test
    public void shouldMakeCoffee(){
        Assert.assertEquals("C::", new DrinkManager().makeCoffee());
    }

    @Test
    public void shouldMakeTea(){
        Assert.assertEquals("T::", new DrinkManager().makeTea());
    }

    @Test
    public void shouldMakeChocolate(){
        Assert.assertEquals("H::", new DrinkManager().makeChocolate());
    }

    @Test
    public void shouldMakeCoffeeWithOneSugar(){
        Assert.assertEquals("C:1:0", new DrinkManager().makeCoffeeWithOneSugar());
    }
}
