public class DrinkManager {

    public static char CHARACTER_FOR_COFFEE = 'C';
    public static char CHARACTER_FOR_TEA = 'T';
    public static char CHARACTER_FOR_CHOCOLATE = 'H';

    public String make(Drink drink) {
        return drink.getCommand();
    }
}
