package lab01.tdd;

public class SelectEqualsStrategy implements SelectStrategy {

    private final int equalTo;

    public SelectEqualsStrategy(int number) {
        this.equalTo = number;
    }

    @Override
    public boolean apply(int element) {
        return element == equalTo;
    }
}
