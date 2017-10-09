
public class Drink {

    public static final char CHARACTER_FOR_COFFEE = 'C';
    public static final char CHARACTER_FOR_TEA = 'T';
    public static final char CHARACTER_FOR_CHOCOLATE = 'H';
    public static final char CHARACTER_FOR_ORANGE_JUICE = 'O';

    private final static String SEPARATOR_COMMAND = ":";

    private char drinkType;
    private int sugarNumber;
    private boolean isHotDrink;

    private Drink(char drinkType) {
        this.drinkType = drinkType;
    }

    private Drink(char drinkType, int sugarNumber) {
        this(drinkType);
        this.sugarNumber = sugarNumber;
    }

    public Drink(char drinkType, boolean isHotDrink) {
        this(drinkType);
        this.isHotDrink = isHotDrink;
    }

    public static Drink create(char drinkType, boolean isHotDrink) {
        return new Drink(drinkType, isHotDrink);
    }

    public static Drink create(char drinkType, int sugarNumber) {
        return new Drink(drinkType, sugarNumber);
    }

    public static Drink create(char drinkType) {
        return new Drink(drinkType);
    }

    public String getCommand() {
        String command = "" + drinkType;
        if(isHotDrink)
            command += "h";
        command += SEPARATOR_COMMAND;

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

    public boolean isCoffee() {
        return drinkType == CHARACTER_FOR_COFFEE;
    }

    public boolean isTea() {
        return drinkType == CHARACTER_FOR_TEA;
    }

    public boolean isChocolate() {
        return drinkType == CHARACTER_FOR_CHOCOLATE;
    }
}
