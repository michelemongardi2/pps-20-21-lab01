package lab01.tdd;

import java.util.Optional;

public abstract class AbstractFactory {
    public abstract SelectStrategy getSelectStrategy(String strategyType, Optional<Integer> number);
}
