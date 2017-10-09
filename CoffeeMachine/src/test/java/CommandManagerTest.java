import org.assertj.core.api.Assertions;
import org.junit.Test;

/**
 * Created by lenovo_2 on 09/10/2017.
 */
public class CommandManagerTest {

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
    public void should_have_a_coffee_when_costumer_give_the_exact_price() {
        Assertions.assertThat(CommandManager.create().make(
                Drink.create(Drink.CHARACTER_FOR_COFFEE, 2)
                , 0.6))
                .isEqualTo(COFFEE_WITH_TWO_SUGAR);
    }

    @Test
    public void should_have_a_tea_when_costumer_give_the_exact_price() {
        Assertions.assertThat(CommandManager.create().make(
                Drink.create(Drink.CHARACTER_FOR_TEA, 2)
                , 0.4))
                .isEqualTo(TEA_WITH_TWO_SUGAR);
    }

    @Test
    public void should_have_a_chocolate_when_costumer_give_the_exact_price() {
        Assertions.assertThat(CommandManager.create().make(
                Drink.create(Drink.CHARACTER_FOR_CHOCOLATE, 2)
                , 0.5))
                .isEqualTo(CHOCOLATE_WITH_TWO_SUGAR);
    }

    @Test
    public void should_not_have_a_coffee_if_the_price_is_not_enough() throws Exception {
        Assertions.assertThat(CommandManager.create().make(
                Drink.create(Drink.CHARACTER_FOR_COFFEE)
                , 0.3))
                .isNotEqualTo(COFFEE_WITHOUT_SUGAR)
                .isNotEqualTo(COFFEE_WITH_ONE_SUGAR)
                .isNotEqualTo(COFFEE_WITH_TWO_SUGAR);

    }

    @Test
    public void should_not_have_a_chocolate_if_the_price_is_not_enough() throws Exception {
        Assertions.assertThat(CommandManager.create().make(
                Drink.create(Drink.CHARACTER_FOR_CHOCOLATE)
                , 0.4))
                .isNotEqualTo(CHOCOLATE_WITHOUT_SUGAR)
                .isNotEqualTo(CHOCOLATE_WITH_ONE_SUGAR)
                .isNotEqualTo(CHOCOLATE_WITH_TWO_SUGAR);
    }

    @Test
    public void should_not_have_a_tea_if_the_price_is_not_enough() throws Exception {
        Assertions.assertThat(CommandManager.create().make(
                Drink.create(Drink.CHARACTER_FOR_TEA)
                , 0.2))
                .isNotEqualTo(TEA_WITHOUT_SUGAR)
                .isNotEqualTo(TEA_WITH_ONE_SUGAR)
                .isNotEqualTo(TEA_WITH_TWO_SUGAR);
    }

    @Test
    public void should_send_message_with_missing_amount_when_the_price_is_not_enough() throws Exception {
        Assertions.assertThat(CommandManager.create().make(
                Drink.create(Drink.CHARACTER_FOR_TEA)
                , 0.2))
                .isEqualTo("M:Il manque 0.2€");
    }
    @Test
    public void should_make_a_drink_when_larger_price() throws Exception {
        Assertions.assertThat(CommandManager.create().make(
                Drink.create(Drink.CHARACTER_FOR_TEA)
                , 0.6))
                .isEqualTo(TEA_WITHOUT_SUGAR);
    }
}
