package lab01.tdd;

import java.util.Optional;

public class SelectStrategyFactory extends AbstractFactory{
    @Override
    public SelectStrategy getSelectStrategy(String strategyType, Optional<Integer> number) {
        switch (strategyType){
            case "Even":
                return element -> element % 2 == 0;
            case "Multiple_Of":
                return element -> element % number.get() == 0;
            case "Equals":
                return element -> element == number.get();
        }
        return null;
    }
}
