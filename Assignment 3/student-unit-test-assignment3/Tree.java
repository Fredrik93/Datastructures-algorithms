import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Tree<Item extends Comparable<Item>> {

    // If the tree is empty, root is a null reference.

    private Node<Item> root = null;


    // A node of a tree contains a label, and optionally
    // references to the roots of its left and right subtrees,
    // which might be null if the subtrees are empty.

    public static class Node<Item> {





        public Node<Item> data = null;
        public Node<Item> left = null;
        public Node<Item> right = null;
        public Item el = null;


        // Will print out the binary node structure

        public void print() {
            print("", true);
        }




        private void print(String prefix, boolean isTail) {
            System.out.println(prefix + (isTail ? "└── " : "├── ") + el.toString());
            if (right != null) {
                right.print(prefix + (isTail ? "    " : "│   "), false);
            }
            if (left != null) {
                left.print(prefix + (isTail ? "    " : "│   "), true);
            }
        }
    }
    // For unit testing purposes

    public void setRoot(Node<Item> newRoot) {
        root = newRoot;
    }

    public Node<Item> getRoot() {
        return root;
    }

    // This method constructs the following
    // example tree with 5 in the root:
    //
    //   __5__
    //  /     \
    // /       \
    // 1       8
    //  \     /  \
    //  2    1    3
    //      / \
    //     5   7

    public static Tree<Integer> exampleTree() {
        Node<Integer> t = new Node<Integer>();
        t.el = 5;
        Node<Integer> t1 = new Node<Integer>();
        t.left = t1;
        t1.el = 1;
        Node<Integer> t2 = new Node<Integer>();
        t.right = t2;
        t2.el = 8;
        Node<Integer> t12 = new Node<Integer>();
        t1.right = t12;
        t12.el = 2;
        Node<Integer> t21 = new Node<Integer>();
        t2.left = t21;
        t21.el = 1;
        Node<Integer> t22 = new Node<Integer>();
        t2.right = t22;
        t22.el = 3;
        Node<Integer> t211 = new Node<Integer>();
        t21.left = t211;
        t211.el = 5;
        Node<Integer> t212 = new Node<Integer>();
        t21.right = t212;
        t212.el = 7;
        Tree<Integer> res = new Tree<Integer>();
        res.root = t;
        return res;
    }

    // This method constructs the following
    // example binary tree with 4 in the root:
    //
    //      __4__
    //     /     \
    //    /       \
    //   1         8
    //    \       / \
    //     2     6   9
    //          / \
    //          5 7
    public static Tree<Integer> exampleTreeBin() {
        Node<Integer> t = new Node<Integer>();
        t.el = 4;

        Node<Integer> t1 = new Node<Integer>();
        t.left = t1;
        t1.el = 1;

        Node<Integer> t2 = new Node<Integer>();
        t.right = t2;
        t2.el = 8;

        Node<Integer> t12 = new Node<Integer>();
        t1.right = t12;
        t12.el = 2;

        Node<Integer> t21 = new Node<Integer>();
        t2.left = t21;
        t21.el = 6;

        Node<Integer> t22 = new Node<Integer>();
        t2.right = t22;
        t22.el = 9;

        Node<Integer> t211 = new Node<Integer>();
        t21.left = t211;
        t211.el = 5;

        Node<Integer> t212 = new Node<Integer>();
        t21.right = t212;
        t212.el = 7;

        Tree<Integer> res = new Tree<Integer>();
        res.root = t;
        return res;
    }

    public int size() {
        return size(root);
    }

    private int size(Node<Item> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + size(node.left) + size(node.right);
        }
    }

    /**
     * Assignment 3 Question 7. Returns the nth element in Breadth First Search
     * (BFS) order
     * <p>
     * // * @param n the position
     *
     * @return the element found at the position
     */


    public Item nthBFS(int n) {
        Queue<Node<Item>> queue = new LinkedList();
        Node<Item> temp_node = root;


        if (temp_node == null) {
            throw new NullPointerException("empty tree");
        }

        for (int i = 0; i < n; i++) {


            if (n == 0) {
                return temp_node.el;
            }

            if (temp_node.left != null) {
                queue.add(temp_node.left);


            }
            if (temp_node.right != null) {
                queue.add(temp_node.right);


            }
            temp_node = queue.remove();


        }
        return temp_node.el;

    }
//

    /**
     * Hands on session 7, exercise 2. Prints the labels of the tree's nodes in
     * breadth first order (BFS)
     */
    public void printBFT() {
        throw new UnsupportedOperationException();
    }

    /**
     * Hands on session 7, exercise 1. Returns the n:th element in Depth First
     * Search
     *
     * @param n the node to find
     * @return the element in the n:th place
     * throw new UnsupportedOperationException();
     */
    public Item nthDFS(int n) {
        throw new UnsupportedOperationException();
    }

    /**
     * Assignment 3 Question 8. Prints the nodes of the tree in depth-first
     * order
     */
    public void printDFS() {
        System.out.println(toStringDFS());
    }


    /**
     * Creates a string according to DFS.
     * Made public for unit testing
     *
     * @return a string representation of the tree in DFS order
     */
    public String toStringDFS() {
        Stack<Node<Item>> stacks = new Stack<>();

        if (root == null) {
            throw new NullPointerException("Empty tree!");
        }


        stacks.push(root);
        Node<Item> current = root;
        String res = "";


        while (!stacks.isEmpty()) {

            current = stacks.pop();


            if (current.right != null) {
                stacks.push(current.right);
            }
            if (current.left != null) {
                stacks.push(current.left);


            }
            res += current.el.toString() + "\n";
        }
        return res;
    }
    /**
     * Assignment 3, Question 9. Insert i into a binary search tree
     *
     * @param i the Item to insert
     */
    public void insertBST(Item i) {
        Node node = new Node();
        node.el = i;

        if (root == null) {

            root = node;

            return;


        }
        Node currentNode = root;
        while (true) {

            if (Integer.parseInt(currentNode.el.toString()) < Integer.parseInt(i.toString())) {

                if (currentNode.right == null) {
                    currentNode.right = node;
                    return;

                }
                currentNode = currentNode.right;

            } else {

                if (currentNode.left == null) {
                    currentNode.left = node;
                    return;

                }
                currentNode = currentNode.left;
            }


        }
    }


    /**
     * Hands on session 7, exercise 3. Removes one item from a binary search
     * tree and then rearranges the nodes so that the tree after the item is
     * removed is still a binary search tree.
     *
     * @param i - the item to remove
     */
    public void removeBST(Item i) {

        // This method mainly calls deleteRec() 
        root = deleteRec(root, i);

    }

    /**
     * A recursive function to delete a new element in BST, assuming existing
     * tree is BST.
     *
     * @param root the current root node
     * @param i    the Item to delete
     * @return the new root node
     */
    private Node<Item> deleteRec(Node<Item> root, Item i) {/***  I'm sorry about the naming here. Within this method the "root"*  variable is not the same as this.root, but is instead the node that*  came from the outside. For clarity I should have renamed the*  invariable "currentRoot" or something.*//* Base Case: If the tree is empty and we havent found our Item */
        if (root == null) {
            throw new RuntimeException("Tried to delete an element that does not exist in the tree");
        }/* Otherwise, recur down the tree */
        if (i.compareTo(root.el) < 0) {
            root.left = deleteRec(root.left, i);
        } else if (i.compareTo(root.el) > 0) {
            root.right = deleteRec(root.right, i);
        }
        return root;
        // if el is same as root's el, then This is the node
        // to be deletedelse {
        // node with only one child or no childif (root.left == null) {return root.right;}
        // else if (root.right == null) {return root.left;}
        // node with two children: Get smallest
        // in the right subtree, the private method minvalue
        // is written below.root.el = minValue(root.right);
        // recursively delete the smallest in the right subtreeroot.right = deleteRec(root.right, root.el);}
        // return root;
    }

    /**
     * A method for visualization and debugging
     */
    public void printTree() {
        if (root != null) {
            root.print();
        }
    }


    public static void main(String[] args) {
        Tree<Integer> t = exampleTree();
        // System.out.println("Size: " + t.size());



        t.printTree();

       // System.out.println(t.nthBFS(2));


        t.insertBST(7);

        t.printTree();

    }
}
