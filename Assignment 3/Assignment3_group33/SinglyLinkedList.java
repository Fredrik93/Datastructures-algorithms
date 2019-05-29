class SinglyLinkedList<Item> {
  private int size = 0;
  private ListNode<Item> header;

  public static class ListNode<Item> {
    public ListNode<Item> next = null;
    public Item el = null;
  }

  public SinglyLinkedList() {
    header = new ListNode<Item>();
  }

  public int size() {
    return size;
  }

  // Set function for unit testing purposes
  public void setList(ListNode<Item> list, int listSize) {
    header.next = list;
    size = listSize;
  }

  // Iterator class for unit testing purposes
  public Iterator<Item> getIterator() {
    return new Iterator<Item>(header);
  }
  // Iterator class for unit testing purposes
  public static class Iterator<Item> {
    private ListNode<Item> current;

    private Iterator(ListNode<Item> header) {
      current = header;
    }

    public Item next() {
      current = current.next;
      return current.el;
    }

    public boolean hasNext() {
      return current.next != null;
    }
  }

  public Item get(int n) {
    if (n > size()-1 || n < 0)
      throw new IllegalArgumentException("Index ouf of bounds");
    ListNode<Item> node = header.next;
    for (int i = 0; i < n; i++) {
      node = node.next;
    }
    return node.el;
  }

  // Insert element x at index n in the list
  public void insertAt(int n, Item x) {

    if (n > size() || n < 0)
      throw new IllegalArgumentException("Index ouf of bounds");
    ListNode<Item> node = header;
    ListNode<Item> temp = new ListNode<>();

    if (n == 0 && size == 0){
      size++;
      header.next = temp;
      temp.el = x;
      return;
    }

    for (int i = 0; i < n; i++ ){
      node = node.next;
    }

    temp = node.next;
    ListNode<Item> newNode = new ListNode<>();
    newNode.el = x;
    node.next = newNode;
    if (temp !=  null){
      newNode.next = temp;
    }

    size++;
  }

  // Remove the element at in dex n from the list
  public void removeAt(int n) {
    if (n > size()-1 || n < 0)
      throw new IllegalArgumentException("Index ouf of bounds");
    if (n == 0){
      header.next = header.next.next;
      size--;
      return;
    }

    ListNode<Item> node = header;

    for(int i = 0; i < n; i++){
      node = node.next;
    }

    node.next = node.next.next;
    size--;
  }

  // Reverse the list
  public void reverse() {

    if (size == 0 || size == 1)
      return;

    ListNode<Item> node = header.next;
    ListNode<Item> next = null;
    ListNode<Item> temp = null;

    while(node != null){
      next = node.next;
      node.next = temp;
      temp = node;
      node = next;
    }
    header.next = temp;

  }

  public String toString(){
//    String answer = "[";
    ListNode<Item> node = new ListNode<>();
    String i = node.el.toString();
    System.out.println(i);
//    while (node.next != null){
//      answer += node.next.el + ", ";
//    }
//    answer += " ]";
//    return answer;
    return i;
  }
  // Represent the contents of the list as a String
  /*
  public String toString() {
    StringBuilder res = new StringBuilder("{");
    if (size > 0) {
      res.append(firstEl.toString());
      for (int i = 1; i < size; ++i) {
        res.append(", ");
        res.append(el.toString());
      }
    }
    res.append("}");
    return res.toString();
  }*/

  public static void main(String[] args) {
//   SinglyLinkedList<Integer> l = new SinglyLinkedList<Integer>();
//    System.out.println(l.size());
//    l.insertAt(0, 0);
//    l.insertAt(0, 2);
//    l.insertAt(1, 48);
//    System.out.println(l.size());
//    System.out.println(l.toString());
//    l.toString();
  }
}
