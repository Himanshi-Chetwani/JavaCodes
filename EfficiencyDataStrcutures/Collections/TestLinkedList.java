/*
 * Name:
 *  TestLinkedList.java
 *
 * Version:
 *  1.0
 *
 * Revisions:
 *  None
 */

import java.sql.Timestamp;
import java.util.LinkedList;

/**
 * Class for checking methods specific to LinkedList
 */
public class TestLinkedList extends TestListInterface {
    long st, ed;
    Timestamp start, end;
    final static int UPPER_LIMIT = 1000000;

    /**
     * Test to add an element to the head and tail of a LinkedList
     *
     * @param linkedList input linked list
     * @param first      boolea set to true if adding to head, else false
     */
    void addFirstAndLast(LinkedList linkedList, boolean first) {
        int elementToCompare, elementAtPosition;
        if (first) {
            elementToCompare = (int) linkedList.getFirst();
            if (check(elementToCompare, (int) linkedList.get(0))) {
                System.out.println("Test: getFirst passed");
            }
            linkedList.addFirst(100);
            elementToCompare = (int) linkedList.get(0);
            elementAtPosition = (int) linkedList.getFirst();
        } else {
            elementToCompare = (int) linkedList.getLast();
            if (check(elementToCompare, (int) linkedList.getLast())) {
                System.out.println("Test: getLast passed");
            }
            linkedList.addLast(100);
            elementToCompare = (int) linkedList.get(linkedList.size() - 1);
            elementAtPosition = (int) linkedList.getLast();
        }
        checkFirstAndLastElements(elementAtPosition, elementToCompare, first);
    }

    /**
     * Helper function for addFirstLast, returns true if the two integers are
     * equal
     *
     * @param original value to be compared
     * @param updated  value to be compared with
     * @return true if equal
     */
    private boolean check(int original, int updated) {
        return original == updated;
    }

    /**
     * Helper functions for addFirstAndLast
     *
     * @param original first/last element before addition
     * @param updated  element after addition
     * @param first    boolean set to true if adding at head of linked list
     */
    private void checkFirstAndLastElements(int original, int updated,
                                           boolean first) {

        if (first) {
            if (check(original, updated)) {
                System.out.println("Test: addFirst passed");
            }
        } else {
            if (check(original, updated)) {
                System.out.println("Test: addLast passed");
            }
        }
    }

    /**
     * Test for addition of element at head and tail of linked list
     */
    void testLinkedList(LinkedList testObj) {
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        for (int i = 0; i <= UPPER_LIMIT; i++) {
            addFirstAndLast(testObj, true);
        }
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        for (int i = 0; i <= UPPER_LIMIT; i++) {
            addFirstAndLast(testObj, false);

        }
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);
    }

    /**
     * Testing all methods os linked list
     */
    void testAllLinkedListMethods() {
        LinkedList<Integer> testLinkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            testLinkedList.add(i);
        }
        testLinkedList(testLinkedList);

    }
}