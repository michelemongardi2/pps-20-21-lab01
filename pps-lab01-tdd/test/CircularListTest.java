import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    private CircularList circularList;
    private static final int NUMBER_OF_ELEMENTS_TO_ADD = 3;
    private int[] localElementsAdded;

    @BeforeEach
    void beforeEach(){
        circularList = new CircularListImpl();
        localElementsAdded = new int[NUMBER_OF_ELEMENTS_TO_ADD];
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
}
