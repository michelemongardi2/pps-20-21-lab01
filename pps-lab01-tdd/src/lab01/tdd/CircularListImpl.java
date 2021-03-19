package lab01.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList {

    private final List<Integer> circularList;
    private int indexList;

    public CircularListImpl(){
        this.circularList =  new ArrayList<>();
        this.indexList = -1;
    }

    @Override
    public void add(int element) {
        this.circularList.add(element);
    }

    @Override
    public int size() {
        return this.circularList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.circularList.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        indexList++;
        if(indexList >= circularList.size()) {
            indexList = 0;
        }
        return Optional.of(circularList.get(indexList));
    }

    @Override
    public Optional<Integer> previous() {
        indexList--;
        if(indexList < 0) {
            indexList = circularList.size() - 1;
        }
        return Optional.of(circularList.get(indexList));
    }

    @Override
    public void reset() {
        indexList = -1;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        for(int i = 0; i < circularList.size(); i++) {
            if(strategy.apply(this.next().get()))
                return Optional.of(circularList.get(indexList));
            }
        return Optional.empty();
    }

}
