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
    public void should_have_a_coffee_when_costumer_give_the_exact_price() {
        Assertions.assertThat(DrinkManager.create().command(
                Drink.create(Drink.CHARACTER_FOR_COFFEE, 2)
                , 0.6))
                .isEqualTo(COFFEE_WITH_TWO_SUGAR);
    }

    @Test
    public void should_have_a_tea_when_costumer_give_the_exact_price() {
        Assertions.assertThat(DrinkManager.create().command(
                Drink.create(Drink.CHARACTER_FOR_TEA, 2)
                , 0.4))
                .isEqualTo(TEA_WITH_TWO_SUGAR);
    }

    @Test
    public void should_have_a_chocolate_when_costumer_give_the_exact_price() {
        Assertions.assertThat(DrinkManager.create().command(
                Drink.create(Drink.CHARACTER_FOR_CHOCOLATE, 2)
                , 0.5))
                .isEqualTo(CHOCOLATE_WITH_TWO_SUGAR);
    }

    @Test
    public void should_not_have_a_coffee_if_the_price_is_not_enough() throws Exception {
        Assertions.assertThat(DrinkManager.create().command(
                Drink.create(Drink.CHARACTER_FOR_COFFEE)
                , 0.3))
                .isNotEqualTo(COFFEE_WITHOUT_SUGAR)
                .isNotEqualTo(COFFEE_WITH_ONE_SUGAR)
                .isNotEqualTo(COFFEE_WITH_TWO_SUGAR);

    }

    @Test
    public void should_not_have_a_chocolate_if_the_price_is_not_enough() throws Exception {
        Assertions.assertThat(DrinkManager.create().command(
                Drink.create(Drink.CHARACTER_FOR_CHOCOLATE)
                , 0.4))
                .isNotEqualTo(CHOCOLATE_WITHOUT_SUGAR)
                .isNotEqualTo(CHOCOLATE_WITH_ONE_SUGAR)
                .isNotEqualTo(CHOCOLATE_WITH_TWO_SUGAR);
    }

    @Test
    public void should_not_have_a_tea_if_the_price_is_not_enough() throws Exception {
        Assertions.assertThat(DrinkManager.create().command(
                Drink.create(Drink.CHARACTER_FOR_TEA)
                , 0.2))
                .isNotEqualTo(TEA_WITHOUT_SUGAR)
                .isNotEqualTo(TEA_WITH_ONE_SUGAR)
                .isNotEqualTo(TEA_WITH_TWO_SUGAR);
    }
}
