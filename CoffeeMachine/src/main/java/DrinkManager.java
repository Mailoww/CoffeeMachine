public class DrinkManager {

    public static final String BASE_MESSAGE_FOR_SEND_MESSAGE = "M:";

    private static final double PRICE_COFFEE = 0.6;
    private static final double PRICE_TEA = 0.4;

    private final static int SUGAR_NUMBER_MINIMUM = 0;
    private final static int SUGAR_NUMBER_MAXIMUM = 2;

    private DrinkManager() {
    }

    public static DrinkManager create() {
        return new DrinkManager();
    }

    public String command(Drink drink, double price) {
        if(drink.isCoffee() && price == PRICE_COFFEE
                || drink.isTea() && price == PRICE_TEA)
            return make(drink);
        return null;
    }

    public String make(Drink drink) {
        if(parametersAreNotValid(drink))
            throw new IllegalArgumentException();

        return drink.getCommand();
    }

    private boolean parametersAreNotValid(Drink drink) {
        return !drink.hasValidParameters(SUGAR_NUMBER_MINIMUM, SUGAR_NUMBER_MAXIMUM);
    }

    public String send(String message) {
        return BASE_MESSAGE_FOR_SEND_MESSAGE + message;
    }
}
