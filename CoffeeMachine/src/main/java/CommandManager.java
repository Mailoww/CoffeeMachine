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
        if(drink.isCoffee())
            return produce(drink, price, PRICE_COFFEE);
        else if(drink.isTea())
            return produce(drink, price, PRICE_TEA);
        else
            return produce(drink, price, PRICE_CHOCOLATE);
    }

    private String produce(Drink drink, double currentPrice, double expectedPrice) {
        if(currentPrice == expectedPrice)
            return DrinkManager.make(drink);
        else
            return DrinkManager.send("Il manque " + (expectedPrice - currentPrice) + "€");
    }
}
