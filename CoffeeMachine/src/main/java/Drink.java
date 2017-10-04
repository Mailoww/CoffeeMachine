
public class Drink {

    private char drinkType;

    public Drink(char drinkType) {
        this.drinkType = drinkType;
    }

    public String getCommand() {
        return drinkType + "::";
    }
}
