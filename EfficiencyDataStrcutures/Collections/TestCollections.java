/*
 * Name:
 *  TestCollections.java
 *
 * Version:
 *  1.0
 *
 * Revisions:
 *  None
 */

import java.sql.Timestamp;
import java.util.*;

/**
 * This class is used for implementing testing functionality for different
 * types of Collections.
 *
 * @author Anuradha Bhave       ab5890
 * @author Himanshi Chetwani    hc9165
 */
public class TestCollections {
    long st, ed;
    Timestamp start, end;
    static final int upperLimit = 1000000;
    static final int colCount = 4;
    static Collection<Integer>[] collection = new Collection[colCount];
    Random random = new Random();

    /**
     * Test for removeAll()
     */
    void testRemoveAll() {
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        for (int index = 0; index < colCount; index++) {
            switch (index) {
                case 0:
                    System.out.println("Array List");
                    break;
                case 1:
                    System.out.println("Linked List");
                    break;
                case 2:
                    System.out.println("Tree Set");
                    break;
                case 3:
                    System.out.println("Hash Set");
                    break;
            }
            for (int index1 = 0; index1 < upperLimit / 4; index1++) {
                collection[index].removeAll(collection[index]);
            }
        }
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);
    }

    /**
     * Test for addAll()
     */
    void testAddAll() {
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        for (int index = 0; index < colCount; index++) {
            switch (index) {
                case 0:
                    System.out.println("Array List");
                    break;
                case 1:
                    System.out.println("Linked List");
                    break;
                case 2:
                    System.out.println("Tree Set");
                    break;
                case 3:
                    System.out.println("Hash Set");
                    break;
            }
            for (int index1 = 0; index1 < upperLimit / 4; index1++) {
                collection[index].addAll(collection[index]);
                System.out.println("The current Size is " +
                        collection[index].size());
            }
        }
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);
    }

    /**
     * Test for remove()
     */
    void testRemove() {
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        int looping = 1;
        for (int index = 0; index < colCount; index++) {
            switch (index) {
                case 0:
                    System.out.println("Array List");
                    break;
                case 1:
                    System.out.println("Linked List");
                    break;
                case 2:
                    System.out.println("Tree Set");
                    break;
                case 3:
                    System.out.println("Hash Set");
                    break;
            }
            for (int index1 = 0; index1 < upperLimit / colCount; index1++) {
                collection[index].remove(looping);
                System.out.println("Check if collection is empty yet " +
                        collection[index].isEmpty());
                looping++;
            }
        }
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);
    }

    /**
     * Test for add()
     */
    void testAdd() {
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        int looping = 1;
        for (int index = 0; index < colCount; index++) {
            switch (index) {
                case 0:
                    System.out.println("Array List");
                    break;
                case 1:
                    System.out.println("Linked List");
                    break;
                case 2:
                    System.out.println("Tree Set");
                    break;
                case 3:
                    System.out.println("Hash Set");
                    break;
            }
            for (int index1 = 0; index1 < upperLimit / colCount; index1++) {
                collection[index].add(looping);
                System.out.println("The current Size is " +
                        collection[index].size());
                System.out.println("The hashcode of " + collection[index] +
                        " is " + collection[index].hashCode());
                looping++;
            }
        }
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);
    }

    /**
     * Test for containsAll()
     */
    void testContainsAll() {
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        for (int index = 0; index < colCount; index++) {
            switch (index) {
                case 0:
                    System.out.println("Array List");
                    break;
                case 1:
                    System.out.println("Linked List");
                    break;
                case 2:
                    System.out.println("Tree Set");
                    break;
                case 3:
                    System.out.println("Hash Set");
                    break;
            }
            for (int index1 = 0; index1 < upperLimit / 4; index1++) {
                System.out.println("Check if the elements are contained in " +
                        "the collection");
                System.out.println(collection[index].containsAll
                        (collection[index]));

            }
        }
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);
    }

    /**
     * Method for printing the collections
     */
    void printCollections() {
        System.out.println("Array List : ");
        System.out.println(collection[0]);
        System.out.println("Linked List : ");
        System.out.println(collection[1]);
        System.out.println("Tree Set : ");
        System.out.println(collection[2]);
        System.out.println("Hash Set : ");
        System.out.println(collection[3]);
    }

    /**
     * Test for contains()
     */
    void testContains() {
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        for (int index = 0; index < colCount; index++) {
            switch (index) {
                case 0:
                    System.out.println("Array List");
                    break;
                case 1:
                    System.out.println("Linked List");
                    break;
                case 2:
                    System.out.println("Tree Set");
                    break;
                case 3:
                    System.out.println("Hash Set");
                    break;
            }
            for (int index1 = 0; index1 < upperLimit / colCount; index1++) {
                int temp = random.nextInt() % upperLimit;
                System.out.println(temp + "in the collection " +
                        collection[index].contains(temp));
            }
        }
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);

    }

    /**
     * Test for clearing all collections
     */
    void clearAllCollections() {
        for (int index = 0; index < colCount; index++) {
            collection[index].clear();
        }
    }






    /**
     * Test method that calls individual tests
     */
    void testAllCollections() {
        TestCollections testCollections = new TestCollections();
        collection[0] = new ArrayList<>();
        collection[1] = new LinkedList<>();
        collection[2] = new TreeSet<>();
        collection[3] = new HashSet<>();
        System.out.println("Add functionality");
        testCollections.testAdd();
        testCollections.printCollections();
        System.out.println("Add All functionality");
        testCollections.testAddAll();
        System.out.println("Remove All functionality");
        testCollections.testRemoveAll();
        testCollections.printCollections();
        System.out.println("Adding to test remove");
        testCollections.testAdd();
        System.out.println("Remove functionality");
        testCollections.testRemove();
        testCollections.printCollections();
        System.out.println("Contains functionality");
        testCollections.testContains();
        System.out.println("ContainsAll functionality");
        testCollections.testContainsAll();
        System.out.println("Clears All Collections functionality");
        testCollections.clearAllCollections();
        testCollections.printCollections();


    }

}
