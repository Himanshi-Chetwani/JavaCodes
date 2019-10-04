/*
 * Name:
 *  TestListInterface.java
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
 * This class tests all functions specific to lists
 */
public class TestListInterface extends TestCollections {
    long st, ed;
    Timestamp start, end;
    static final int upperLimit = 1000000;
    static final int colCount = 2;
    static List<Integer>[] lists = new List[colCount];
    Random random = new Random();

    /**
     * Test for removing element at particular position
     */
    void testRemoveAtIndex() {
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        for (int index = 0; index < colCount; index++) {
            int looping = upperLimit / colCount - 1;
            for (int index1 = 0; index1 < upperLimit / colCount; index1++) {
                lists[index].remove(looping);
                looping--;
            }
        }
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);
    }

    /**
     * Test for adding element at a particular position
     */
    void testAddAtIndex() {
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        for (int index = 0; index < colCount; index++) {
            int looping = 0;
            for (int index1 = 0; index1 < upperLimit / colCount; index1++) {
                lists[index].add(looping, looping);
                looping++;
            }
        }
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);
    }

    /**
     * Test for get()
     */
    void getListTest() {
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        for (int index = 0; index < colCount; index++) {
            int looping = 0;
            System.out.println("List Type : " + (index == 0 ? "Array List" :
                    "Linked List"));
            for (int index1 = 0; index1 < upperLimit / colCount; index1++) {
                System.out.println("The next element is " + lists[index].
                        get(looping));
                looping++;
            }
        }
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);
    }

    /**
     * Test for set()
     */
    void setListTest() {
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        for (int index = 0; index < colCount; index++) {
            int looping = 0;
            for (int index1 = 0; index1 < upperLimit / colCount; index1++) {
                System.out.println("List Type : " + (index == 0 ? "Array List" :
                        "Linked List"));
                System.out.println("The  element is being replaced  " +
                        lists[index].set(looping, random.nextInt() / upperLimit));
                looping++;
            }
        }
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);
    }

    /**
     * Method to print lists
     */
    void printLists() {
        System.out.println("Array List : ");
        System.out.println(lists[0]);
        System.out.println("Linked List : ");
        System.out.println(lists[1]);
    }

    /**
     * Test for addAll() at index
     */
    void testAddAllAtIndex() {
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        for (int index = 0; index < colCount; index++) {
            int looping = 0;
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
                lists[index].addAll(looping, lists[index]);
                looping++;
            }
        }
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);
    }

    /**
     * Test for lastIndex()
     */
    void getLastIndexOf() {
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        for (int index = 0; index < colCount; index++) {
            for (int index1 = 0; index1 < upperLimit / colCount; index1++) {
                int temp = random.nextInt() % upperLimit;
                System.out.println("Last occurance of " + temp + " is " +
                        lists[index].lastIndexOf(temp));
            }

        }
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);
    }

    /**
     * Test for firstIndexOf()
     */
    void getIndexOf() {
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        for (int index = 0; index < colCount; index++) {
            for (int index1 = 0; index1 < upperLimit / colCount; index1++) {
                int temp = random.nextInt() % upperLimit;
                System.out.println("First occurrence of " + temp + " is " +
                        lists[index].indexOf(temp));
            }

        }
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);
    }

    /**
     * Test method that calls individual tests
     */
    void testAllMethods() {
        TestListInterface testListInterface = new TestListInterface();
        lists[0] = new ArrayList<>();
        lists[1] = new LinkedList<>();
        System.out.println("Add content at index");
        testListInterface.testAddAtIndex();
        System.out.println("Remove content at index");
        testListInterface.testRemoveAtIndex();
        testListInterface.printLists();
        testListInterface.testAddAtIndex();
        System.out.println("Add collection at index");
        testListInterface.testAddAllAtIndex();
        testListInterface.printLists();
        System.out.println("Sorting functionality with and without Comparator");
        testListInterface.testSortCollections();
        System.out.println("Getting elements at index");
        testListInterface.getListTest();
        System.out.println("Setting elements at index");
        testListInterface.setListTest();
        testListInterface.printLists();
        System.out.println("Getting the last occurrence of an element in the " +
                "list");
        testListInterface.getLastIndexOf();
        System.out.println("Getting the first occurrence of an element in the" +
                "list");
        testListInterface.getIndexOf();

    }
    /**
     * Helper function for sort()
     *
     * @param sorted true if lists are sorted
     */
    void printSortResult(boolean sorted) {
        if (sorted) {
            System.out.println("Test: sort successful");
        }
    }

    /**
     * Compares two collection objects
     *
     * @param comapareList  list to compare
     * @param compareToList list to compare with
     * @return true if lists are equal
     */
    boolean checkSortCollections(Collection comapareList,
                                 Collection compareToList) {
        return comapareList.equals(compareToList);
    }
    void testSortCollections() {
        Collection firstSort, secondSort;
        start = new Timestamp(System.currentTimeMillis());
        start.getTime();
        for (int index = 0; index < colCount; index++) {
            for (int newind = 0; newind < upperLimit / colCount; newind++) {
                Collections.sort((List<Integer>) lists[index]);
                firstSort = lists[index];
                Collections.shuffle((List<Integer>) lists[index]);
                Collections.sort((List<Integer>) lists[index],
                        Comparator.comparingInt(o -> o));
                Collections.shuffle((List<Integer>) lists[index]);
                secondSort = lists[index];
                printSortResult(checkSortCollections(firstSort, secondSort));
            }
        }
        end = new Timestamp(System.currentTimeMillis());
        ed = end.getTime();
        System.out.println((ed - st) / 1000.0);
    }


}
