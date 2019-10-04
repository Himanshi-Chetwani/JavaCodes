/*
 * Name:
 *  IntegerLinkedList.java
 *
 * Version:
 *  1.0
 *
 * Revisions:
 *  None
 */

/**
 * This class implements a singly linked list
 *
 * @author Anuradha Bhave   ab5890
 * @author Himanshi Chetwani hc9165
 */
public class IntegerLinkedList extends IntegerStorageImplementation {
    private Node firstElement;

    /**
     * Add an element to the linked list
     *
     * @param o value of node to be added to the linked list
     * @return true when list is modified
     */
    public boolean add(int o) {
        if (firstElement == null) {
            addFirst(o);
        } else {
            Node tempElement = new Node();
            tempElement.data = o;
            Node counterElement = firstElement;
            while (counterElement.nextLink != null) {
                counterElement = counterElement.nextLink;
            }
            counterElement.nextLink = tempElement;
            size++;
        }

        return true;
    }

    /**
     * Add an element at a specific position in the list
     *
     * @param index   position in the list where element is added
     * @param element value of the element to be added to the list
     */
    public void add(int index, int element) {

        if (index >= size() && index > 0 && firstElement != null) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index == 0 || firstElement == null) {
            addFirst(element);
        } else {
            Node counterElement;
            Node tempElement;
            Node addNode = new Node();
            addNode.data = element;
            counterElement = firstElement;
            for (int loopVariable = 0; loopVariable < index - 1; loopVariable++) {
                counterElement = counterElement.nextLink;
            }
            tempElement = counterElement.nextLink;
            counterElement.nextLink = addNode;
            addNode.nextLink = tempElement;
            size++;
        }

    }

    /**
     * If list does not exist, create new list and add the first element to it
     *
     * @param value value of element added to list
     */
    private void addFirst(int value) {
        Node tempElement = new Node();
        tempElement.data = value;
        tempElement.nextLink = firstElement;
        firstElement = tempElement;
        size++;
    }

    /**
     * Clears the list of all its contents
     */
    @Override
    public void clear() {
        firstElement = null;
        size = 0;

    }

    /**
     * Checks if list contains an element
     *
     * @param o value to be checked
     * @return true if element is present in the list
     */
    @Override
    public boolean contains(int o) {
        Node isElementPresent;
        for (isElementPresent = firstElement; isElementPresent != null;
             isElementPresent =
                     isElementPresent.nextLink) {
            if (isElementPresent.data == o) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get an element at a specific position
     *
     * @param index index of the element to be returned
     * @return element at specified position
     */
    @Override
    public int get(int index) {
        Node elementToReturn = firstElement;
        for (int loopVariable = 0; loopVariable < index; loopVariable++) {
            elementToReturn = elementToReturn.nextLink;
        }
        return elementToReturn.data;
    }

    /**
     * Returns index of first occurrence of the element, or returns -1 if
     * element does not exist
     *
     * @param o element to search for
     * @return index of first occurrence of element
     */
    @Override
    public int indexOf(int o) {
        Node traverseElement;
        int counter = 0;
        for (traverseElement = firstElement; traverseElement != null;
             traverseElement = traverseElement.nextLink) {
            if (traverseElement.data == o) {
                return counter;
            } else {
                counter++;
            }
        }
        return -1;
    }

    /**
     * Returns index of last occurrence of the element, or -1 if element does
     * not exist
     *
     * @param o element to search for
     * @return index of last occurrence of element
     */
    @Override
    public int lastIndexOf(int o) {
        Node traverseElement;
        int counter = 0;
        int temp = -1;
        for (traverseElement = firstElement; traverseElement != null;
             traverseElement = traverseElement.nextLink) {
            if (traverseElement.data == o) {
                temp = counter;
            }
            counter++;
        }
        return temp;
    }

    /**
     * Remove element at specified index
     *
     * @param index position at which element is to be removed
     * @return element previously at specified position
     */
    @Override
    public int remove(int index) {
        if (index >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index == 0) {
            firstElement = firstElement.nextLink;
            size--;
        } else {
            Node dataToDelete = firstElement;
            Node tempElement;
            for (int loop = 0; loop < index - 1; loop++) {
                dataToDelete = dataToDelete.nextLink;
            }
            tempElement = dataToDelete.nextLink;
            dataToDelete.nextLink = tempElement.nextLink;
            size--;
        }
        return 0;
    }

    /**
     * Remove specified Integer
     *
     * @param o Integer to be removed
     * @return false
     */
    @Override
    public boolean remove(Integer o) {
        Node elementToDelete;
        elementToDelete = firstElement;
        if (elementToDelete.data == o) {
            firstElement = firstElement.nextLink;
            size--;
        } else {
            while (elementToDelete.nextLink.data != o) {
                elementToDelete = elementToDelete.nextLink;
            }
            elementToDelete.nextLink = elementToDelete.nextLink.nextLink;
            size--;
        }
        return false;
    }

    /**
     * Set index in the list to a specific value
     *
     * @param index   index in the list
     * @param element value which is changed
     * @return previous value at the index
     */
    @Override
    public int set(int index, int element) {
        if (index > size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node accessElement = firstElement;
        int returnOld;
        for (int loop = 0; loop < index; loop++) {
            accessElement = accessElement.nextLink;
        }
        returnOld = accessElement.data;
        accessElement.data = element;
        return returnOld;
    }


}
