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
        Assert.assertEquals("C:1:0", new DrinkManager().make(
                new Drink(DrinkManager.CHARACTER_FOR_COFFEE, 1)
        ));
    }

    @Test
    public void shouldMakeTeaWithOneSugar(){
        Assert.assertEquals("T:1:0", new DrinkManager().make(
                new Drink(DrinkManager.CHARACTER_FOR_TEA, 1)
        ));
    }

    @Test
    public void shouldMakeChocolateWithOneSugar(){
        Assert.assertEquals("H:1:0", new DrinkManager().make(
                new Drink(DrinkManager.CHARACTER_FOR_CHOCOLATE, 1)
        ));
    }

    @Test
    public void shouldMakeDrinkWithTwoSugar(){
        Assert.assertEquals("H:2:0", new DrinkManager().make(
                new Drink(DrinkManager.CHARACTER_FOR_CHOCOLATE, 2)
        ));
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowExceptionMakeDrinkWithThreeSugar(){
        new DrinkManager().make(
                new Drink(DrinkManager.CHARACTER_FOR_CHOCOLATE, 3));
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowExceptionMakeDrinkWithNegativeNumberSugar(){
        new DrinkManager().make(
                new Drink(DrinkManager.CHARACTER_FOR_CHOCOLATE, -1));
    }

    @Test
    public void shouldSendAMessage(){
        String message = "Message test";
        Assert.assertEquals("M:" + message, new DrinkManager().send(message));
    }
}
