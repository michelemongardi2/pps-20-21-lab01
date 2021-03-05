import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {

    protected CircularList circularList;

    @BeforeEach
    void beforeEach(){
        circularList = new CircularListImpl();
    }


    private void addElemetsToTheList() {
        for(int i = 0; i < 10; i++){
            circularList.add((int) Math.random());
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
        assertEquals(10, circularList.size());
    }


    @Test
    void testTheListIsEmpty(){
        assertTrue(circularList.isEmpty());
        circularList.add(1);
        assertFalse(circularList.isEmpty());
    }

    @Test
    void testNextElementOfTheList(){
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        assertEquals(Optional.of(1), circularList.next());
        assertEquals(Optional.of(2), circularList.next());
        assertEquals(Optional.of(3), circularList.next());
        assertEquals(Optional.of(1), circularList.next());
    }

    @Test
    void testPreviousElementOfTheList(){
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        assertEquals(Optional.of(3), circularList.previous());
        assertEquals(Optional.of(2), circularList.previous());
        assertEquals(Optional.of(1), circularList.previous());
        assertEquals(Optional.of(3), circularList.previous());
    }

    @Test
    void testMixed(){
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        assertEquals(Optional.of(1), circularList.next());
        assertEquals(Optional.of(3), circularList.previous());
        assertEquals(Optional.of(1), circularList.next());
        assertEquals(Optional.of(3), circularList.previous());
        assertEquals(Optional.of(2), circularList.previous());
        assertEquals(Optional.of(3), circularList.next());
        assertEquals(Optional.of(2), circularList.previous());
        assertEquals(Optional.of(3), circularList.next());
        assertEquals(Optional.of(1), circularList.next());
    }

    @Test
    void testResetIndexList(){
        circularList.add(1);
        circularList.add(2);
        circularList.add(3);
        assertEquals(Optional.of(1), circularList.next());
        assertEquals(Optional.of(3), circularList.previous());
        assertEquals(Optional.of(1), circularList.next());
        assertEquals(Optional.of(3), circularList.previous());
        assertEquals(Optional.of(2), circularList.previous());
        circularList.reset();
        assertEquals(Optional.of(1), circularList.next());
        circularList.reset();
        assertEquals(Optional.of(3), circularList.previous());
    }
}
