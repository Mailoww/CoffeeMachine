import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

public class DrinkManagerTest {

    public static final String CHOCOLATE_WITH_TWO_SUGAR = "H:2:0";
    public static final String TEA_WITH_TWO_SUGAR = "T:2:0";
    public static final String COFFEE_WITH_TWO_SUGAR = "C:2:0";

    public static final String CHOCOLATE_WITH_ONE_SUGAR = "H:1:0";
    public static final String TEA_WITH_ONE_SUGAR = "T:1:0";
    public static final String COFFEE_WITH_ONE_SUGAR = "C:1:0";

    public static final String CHOCOLATE_WITHOUT_SUGAR = "H::";
    public static final String TEA_WITHOUT_SUGAR = "T::";
    public static final String COFFEE_WITHOUT_SUGAR = "C::";
    public static final String HOT_COFFEE_WITHOUT_SUGAR = "Ch::";

    public static final String HOT_COFFEE = "Ch::";
    public static final String HOT_CHOCOLATE = "Hh::";
    public static final String ORANGE_JUICE = "O::";

    @Test
    public void should_make_coffee() {
        Assert.assertEquals(COFFEE_WITHOUT_SUGAR, DrinkManager.create().make(
                Drink.create(Drink.CHARACTER_FOR_COFFEE)));
    }

    @Test
    public void should_make_tea() {
        Assert.assertEquals(TEA_WITHOUT_SUGAR, DrinkManager.create().make(
                Drink.create(Drink.CHARACTER_FOR_TEA)
        ));
    }

    @Test
    public void should_make_chocolate() {
        Assert.assertEquals(CHOCOLATE_WITHOUT_SUGAR, DrinkManager.create().make(
                Drink.create(Drink.CHARACTER_FOR_CHOCOLATE)
        ));
    }

    @Test
    public void should_make_coffee_with_one_sugar() {
        Assert.assertEquals(COFFEE_WITH_ONE_SUGAR, DrinkManager.create().make(
                Drink.create(Drink.CHARACTER_FOR_COFFEE, 1)
        ));
    }

    @Test
    public void should_make_tea_with_one_sugar() {
        Assert.assertEquals(TEA_WITH_ONE_SUGAR, DrinkManager.create().make(
                Drink.create(Drink.CHARACTER_FOR_TEA, 1)
        ));
    }

    @Test
    public void should_make_chocolate_with_one_sugar() {
        Assert.assertEquals(CHOCOLATE_WITH_ONE_SUGAR, DrinkManager.create().make(
                Drink.create(Drink.CHARACTER_FOR_CHOCOLATE, 1)
        ));
    }

    @Test
    public void should_make_drink_with_two_sugar() {
        Assert.assertEquals(CHOCOLATE_WITH_TWO_SUGAR, DrinkManager.create().make(
                Drink.create(Drink.CHARACTER_FOR_CHOCOLATE, 2)
        ));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_make_drink_with_three_sugar() {
        DrinkManager.create().make(
                Drink.create(Drink.CHARACTER_FOR_CHOCOLATE, 3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throw_exception_when_make_drink_with_negative_number_sugar() {
        DrinkManager.create().make(
                Drink.create(Drink.CHARACTER_FOR_CHOCOLATE, -1));
    }

    @Test
    public void should_send_a_message() {
        String message = "Message test";
        Assert.assertEquals("M:" + message, DrinkManager.create().send(message));
    }

    @Test
    public void should_make_a_hot_coffee() throws Exception {
        Assertions.assertThat(DrinkManager.create().make(
                Drink.create(Drink.CHARACTER_FOR_COFFEE, true)))
                .isEqualTo(HOT_COFFEE);
    }

    @Test
    public void should_make_a_hot_chocolate() throws Exception {
        Assertions.assertThat(DrinkManager.create().make(
                Drink.create(Drink.CHARACTER_FOR_CHOCOLATE, true)))
                .isEqualTo(HOT_CHOCOLATE);
    }

    @Test
    public void should_make_an_orange_juice() throws Exception {
        Assertions.assertThat(DrinkManager.create().make(
                Drink.create(Drink.CHARACTER_FOR_ORANGE_JUICE)))
                .isEqualTo(ORANGE_JUICE);
    }
}
