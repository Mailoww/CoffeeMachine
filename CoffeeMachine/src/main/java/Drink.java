
public class Drink {

    private final static String SEPARATOR_COMMAND = ":";

    private char drinkType;
    private int sugarNumber;

    public Drink(char drinkType) {
        this.drinkType = drinkType;
    }

    private Drink(char drinkType, int sugarNumber) {
        this(drinkType);
        this.sugarNumber = sugarNumber;
    }

    public static Drink create(char drinkType, int sugarNumber) {
        return new Drink(drinkType, sugarNumber);
    }

    public String getCommand() {
        String command = drinkType + SEPARATOR_COMMAND;

        if(sugarNumber == 0)
            command += addNoSugar();
        else if(sugarNumber <= 2)
            command += addSugar();

        return command;
    }

    private String addNoSugar(){
        return SEPARATOR_COMMAND;
    }

    private String addSugar(){
        return sugarNumber + SEPARATOR_COMMAND + "0";
    }

    public boolean hasValidParameters(int sugarNumberMinimum, int sugarNumberMaximum) {
        if(sugarNumber < sugarNumberMinimum || sugarNumber > sugarNumberMaximum)
            return false;
        return true;
    }
}
