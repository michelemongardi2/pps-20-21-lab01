import lab01.tdd.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;
    private static final int NUMBER_OF_ELEMENTS_TO_ADD = 3;
    private int[] localElementsAdded;
    private SelectStrategyFactory selectStrategyFactory;
    private static final String EVEN = "Even";
    private static final String MULTIPLE_OF = "Multiple_Of";
    private static final String EQUALS = "Equals";

    @BeforeEach
    void beforeEach(){
        circularList = new CircularListImpl();
        localElementsAdded = new int[NUMBER_OF_ELEMENTS_TO_ADD];
        selectStrategyFactory = new SelectStrategyFactory();
    }

    private void addElemetsToTheList() {
        for(int i = 0; i < NUMBER_OF_ELEMENTS_TO_ADD; i++){
            localElementsAdded[i] = (int) Math.random();
            circularList.add(localElementsAdded[i]);
        }
    }

    @Test
    void testAddAnElementToTheList(){
        assertTrue(circularList.isEmpty());
        circularList.add(1);
        assertFalse(circularList.isEmpty());
    }

    @Test
    void testSizeOfTheList(){
        assertTrue(circularList.isEmpty());
        addElemetsToTheList();
        assertEquals(NUMBER_OF_ELEMENTS_TO_ADD, circularList.size());
    }


    @Test
    void testTheListIsEmpty(){
        assertTrue(circularList.isEmpty());
        circularList.add(1);
        assertFalse(circularList.isEmpty());
    }

    @Test
    void testNextElementOfTheList(){
        addElemetsToTheList();
        assertEquals(localElementsAdded[0], circularList.next().get());
        assertEquals(localElementsAdded[1], circularList.next().get());
        assertEquals(localElementsAdded[2], circularList.next().get());
        assertEquals(localElementsAdded[0], circularList.next().get());
    }


    @Test
    void testPreviousElementOfTheList(){
        addElemetsToTheList();
        assertEquals(localElementsAdded[2], circularList.previous().get());
        assertEquals(localElementsAdded[1], circularList.previous().get());
        assertEquals(localElementsAdded[0], circularList.previous().get());
        assertEquals(localElementsAdded[2], circularList.previous().get());
    }

    @Test
    void testNextPreviousMixed(){
        addElemetsToTheList();
        assertEquals(localElementsAdded[0], circularList.next().get());
        assertEquals(localElementsAdded[2], circularList.previous().get());
        assertEquals(localElementsAdded[0], circularList.next().get());
        assertEquals(localElementsAdded[2], circularList.previous().get());
        assertEquals(localElementsAdded[1], circularList.previous().get());
        assertEquals(localElementsAdded[2], circularList.next().get());
        assertEquals(localElementsAdded[1], circularList.previous().get());
        assertEquals(localElementsAdded[2], circularList.next().get());
        assertEquals(localElementsAdded[0], circularList.next().get());
    }

    @Test
    void testResetIndexList(){
        addElemetsToTheList();
        assertEquals(localElementsAdded[0], circularList.next().get());
        assertEquals(localElementsAdded[2], circularList.previous().get());
        assertEquals(localElementsAdded[0], circularList.next().get());
        assertEquals(localElementsAdded[2], circularList.previous().get());
        assertEquals(localElementsAdded[1], circularList.previous().get());
        circularList.reset();
        assertEquals(localElementsAdded[0], circularList.next().get());
        circularList.reset();
        assertEquals(localElementsAdded[2], circularList.previous().get());
    }


    private void populateSimpleList() {
        for(int i = 1; i <= 10; i++){
            circularList.add(i);
        }
    }

    @Test
    void testEvenStrategy(){
        populateSimpleList();
        SelectStrategy selectStrategy = selectStrategyFactory.getSelectStrategy(EVEN, Optional.empty());
        assertEquals(2 , circularList.next(selectStrategy).get());
    }

    @Test
    void testMultipleOfStrategy(){
        populateSimpleList();
        SelectStrategy selectStrategy = selectStrategyFactory.getSelectStrategy(MULTIPLE_OF, Optional.of(2));
        assertEquals(2, circularList.next(selectStrategy).get());
        assertEquals(4, circularList.next(selectStrategy).get());
        assertEquals(6, circularList.next(selectStrategy).get());
    }

    @Test
    void testEqualsStrategy(){
        populateSimpleList();
        SelectStrategy selectStrategy = selectStrategyFactory.getSelectStrategy(EQUALS, Optional.of(4));
        assertEquals(4, circularList.next(selectStrategy).get());
        assertEquals(4, circularList.next(selectStrategy).get());
    }

    @Test
    void testNextWithStrategyNoMatch(){
        populateSimpleList();
        SelectStrategy selectStrategy = selectStrategyFactory.getSelectStrategy(EQUALS, Optional.of(20));
        assertEquals(Optional.empty(), circularList.next(selectStrategy));
    }
}