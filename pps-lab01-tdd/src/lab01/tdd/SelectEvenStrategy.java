package lab01.tdd;

public class SelectEvenStrategy implements SelectStrategy{

    @Override
    public boolean apply(int element) {
            return element % 2 == 0;
    }


}
