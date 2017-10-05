public class DrinkManager {

    public static final String BASE_MESSAGE_FOR_SEND_MESSAGE = "M:";

    private static final double PRICE_COFFEE = 0.6;

    public static final char CHARACTER_FOR_COFFEE = 'C';
    public static final char CHARACTER_FOR_TEA = 'T';
    public static final char CHARACTER_FOR_CHOCOLATE = 'H';

    private final static int SUGAR_NUMBER_MINIMUM = 0;
    private final static int SUGAR_NUMBER_MAXIMUM = 2;

    public String command(Drink drink, double price) {
        if(price == PRICE_COFFEE)
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
