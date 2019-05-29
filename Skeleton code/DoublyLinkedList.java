
class DoublyLinkedList<Item> {

    private int size = 0;
    private Node<Item> head;
    private Node<Item> tail;

    /**
     * Linked list node helper data type
     *
     * @param <Item>
     */
    private static class Node<Item> {

        Node<Item> next = null;
        Item el = null;
        Node<Item> prev = null;

    }

    /**
     * Public constructor
     */
    public DoublyLinkedList() {
        // add things in the constructor to create an empty linked list object.
    }

    public int size() {
        return size;
    }

    /**
     * Hands on 6, Exercise 1, Get element at index n from the list
     *
     * @param n the index of the element to get
     */
    public Item get(int n) {

        throw new UnsupportedOperationException();

    }

    /**
     * Hands on 6, Exercise 2, Insert element x at index n in the list
     *
     * @param n the index where we want to do the insertion
     * @param x the element to insert
     */
    public void insertAt(int n, Item x) {
        throw new UnsupportedOperationException();
    }

    /**
     * Hands on 6, Exercise 3, Remove the element at index n from the list
     *
     * @param n the index where we want to remove an element
     */
    public void removeAt(int n) {
        throw new UnsupportedOperationException();

    }

    /**
     * Hands on 6, Exercise 4, reverse the list
     *
     */
    public void reverse() {

        throw new UnsupportedOperationException();
    }

    /**
     * return whether the list is empty or not
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> l = new DoublyLinkedList<Integer>();

       // l.insertAt(0, 1);


    }
}
