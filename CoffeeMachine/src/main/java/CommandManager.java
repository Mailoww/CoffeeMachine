/**
 * Created by lenovo_2 on 09/10/2017.
 */
public class CommandManager {

    private static final double PRICE_COFFEE = 0.6;
    private static final double PRICE_CHOCOLATE = 0.5;
    private static final double PRICE_TEA = 0.4;

    public static CommandManager create() {
        return new CommandManager();
    }

    public String make(Drink drink, double price) {
        if(drink.isCoffee() && price == PRICE_COFFEE
                || drink.isTea() && price == PRICE_TEA
                || drink.isChocolate() && price == PRICE_CHOCOLATE)
            return DrinkManager.make(drink);
        return null;
    }
}
