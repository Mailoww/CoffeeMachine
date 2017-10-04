import org.junit.Assert;
import org.junit.Test;

public class DrinkManagerTest {

    @Test
    public void shouldMakeCoffee(){
        Assert.assertEquals("C::", new DrinkManager().make(
                new Drink(DrinkManager.CHARACTER_FOR_COFFEE)));
    }

    @Test
    public void shouldMakeTea(){
        Assert.assertEquals("T::", new DrinkManager().make(
                new Drink(DrinkManager.CHARACTER_FOR_TEA)
        ));
    }

    @Test
    public void shouldMakeChocolate(){
        Assert.assertEquals("H::", new DrinkManager().make(
                new Drink(DrinkManager.CHARACTER_FOR_CHOCOLATE)
        ));
    }

    @Test
    public void shouldMakeCoffeeWithOneSugar(){
        Assert.assertEquals("C:1:0", new DrinkManager().makeCoffeeWithOneSugar());
    }
}
