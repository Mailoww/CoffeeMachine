/**
 * Created by lenovo_2 on 09/10/2017.
 */
public class CommandManager {

    private static final double PRICE_COFFEE = 0.6;
    private static final double PRICE_CHOCOLATE = 0.5;
    private static final double PRICE_TEA = 0.4;
    public static final String ERROR_CONTACT_COSTUMER_SERVICE = "Erreur - contacter le service client";
    private Drink drink;
    private double currentPrice;

    public static CommandManager create() {
        return new CommandManager();
    }

    public String make(Drink drink, double price) {
        this.drink = drink;
        this.currentPrice = price;
        if(drink.isCoffee())
            return produce(PRICE_COFFEE);
        else if(drink.isTea())
            return produce(PRICE_TEA);
        else if(drink.isChocolate())
            return produce(PRICE_CHOCOLATE);

        return DrinkManager.send(ERROR_CONTACT_COSTUMER_SERVICE);
    }

    private String produce(double expectedPrice) {
        if(currentPrice < expectedPrice)
            return DrinkManager.send("Il manque " + (expectedPrice - currentPrice) + "€");
        else
            return DrinkManager.make(drink);
    }
}
