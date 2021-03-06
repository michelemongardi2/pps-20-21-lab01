package lab01.tdd;

public class SelectMultipleOfStrategy implements SelectStrategy{

    private final int multipleOf;

    public SelectMultipleOfStrategy(int number){
        this.multipleOf = number;
    }

    @Override
    public boolean apply(int element) {
        return element % multipleOf == 0;
    }
}
