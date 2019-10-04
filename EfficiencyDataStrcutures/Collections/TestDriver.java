/*
 * Name:
 *  Driver program for all tests
 *
 * Version:
 *  1.0
 *
 * Revisions:
 *  None
 */

/**
 * This class is a driver test class for all individual tests
 */
public class TestDriver {
    /**
     * The main method
     * @param args None
     */
    public static void main(String[] args) {
        TestCollections testCollections = new TestCollections();
        TestListInterface testList = new TestListInterface();
        TestLinkedList testLinkedList = new TestLinkedList();
        TestSetInterface testSetInterface = new TestSetInterface();
        System.out.println("Testing common functionality in collections");
        testCollections.testAllCollections();
        System.out.println("Testing  functionality in lists");
        testList.testAllMethods();
        System.out.println("Testing  functionality in linked lists");
        testLinkedList.testAllLinkedListMethods();
        System.out.println("Testing  functionality in sets");
        testSetInterface.testAllMethods();
    }
}
